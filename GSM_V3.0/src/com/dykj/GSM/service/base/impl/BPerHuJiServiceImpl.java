package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerHuJiMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerHuJi;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerHuJiService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerHuJiServiceImpl implements BPerHuJiService {
	@Autowired
	private BPerHuJiMapperImpl bPerHuJiMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerHuJi entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerHuJiMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerHuJiMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setLiuDong(true);
			fushu.setPersonCode(entity.getPersonCode());
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有插入成功");
		}
		return i;
	}

	/*
	 * 新增或修改
	 */
	public int update(BPerHuJi entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerHuJiMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerHuJiMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerHuJiMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setLiuDong(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerHuJi queryByKey(String primaryKey) {
		return bPerHuJiMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerHuJi> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerHuJi> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerHuJi> queryTListParam(BPerHuJi param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<BPerHuJi> queryByMapParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> param)
			throws Exception {
		Page<BPerHuJi> page = bPerHuJiMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerHuJi.class, "codeHouseholdStatus,codeOwnerRelation");
		return page;
	}

	@Override
	public Page<BPerHuJi> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerHuJi param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerHuJiMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询户籍人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerHuJi queryByPersonCode(String personCode) throws Exception {
		BPerHuJi huji= bPerHuJiMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(huji, BPerHuJi.class, "codeOwnerRelation");
		return huji;
	}
}
