package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerLiuShouMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerLiuShou;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerLiuShouService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerLiuShouServiceImpl implements BPerLiuShouService {
	@Autowired
	private BPerLiuShouMapperImpl bPerLiuShouMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerLiuShou entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerLiuShouMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerLiuShouMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfLiuShou(true);
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
	public int update(BPerLiuShou entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerLiuShouMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	public Page<BPerLiuShou> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerLiuShou> page = bPerLiuShouMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerLiuShou.class, "codeLiuShouType");
		return page;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerLiuShouMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerLiuShouMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfLiuShou(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerLiuShou queryByKey(String primaryKey) {
		return bPerLiuShouMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerLiuShou> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerLiuShou> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerLiuShou> queryTListParam(BPerLiuShou param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerLiuShou> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerLiuShou param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerLiuShouMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerLiuShou queryByPersonCode(String personCode) throws Exception {
		BPerLiuShou liushou = bPerLiuShouMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(liushou, BPerLiuShou.class, "codeHealth,codeLiuShouType,codeLiuShouRelation,codeMemberHealth");
		return liushou;
	}
}
