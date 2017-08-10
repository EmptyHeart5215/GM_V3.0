package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerZiYuanMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerZiYuan;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerZiYuanService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerZiYuanServiceImpl implements BPerZiYuanService {
	@Autowired
	private BPerZiYuanMapperImpl bPerZiYuanMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerZiYuan entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerZiYuanMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerZiYuanMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setZiYuan(true);
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
	public int update(BPerZiYuan entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerZiYuanMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerZiYuanMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerZiYuanMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setZhiYuan(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerZiYuan queryByKey(String primaryKey) {
		return bPerZiYuanMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerZiYuan> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerZiYuan> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerZiYuan> queryTListParam(BPerZiYuan param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerZiYuan> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerZiYuan param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerZiYuanMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override 
	public BPerZiYuan queryByPersonCode(String personCode)throws Exception {
		BPerZiYuan ziyuan = bPerZiYuanMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(ziyuan, BPerZiYuan.class, "codePerResources");
		return ziyuan;
	}

	public Page<BPerZiYuan> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		Page<BPerZiYuan> page = bPerZiYuanMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		try {
			dicValueInputService.inputDicValue(page, BPerZiYuan.class, "codeInflowReason");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
}
