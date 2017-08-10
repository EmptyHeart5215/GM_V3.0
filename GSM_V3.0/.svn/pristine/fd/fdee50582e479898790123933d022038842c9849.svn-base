package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerQingShaoNianMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerQingShaoNian;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerQingShaoNianService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerQingShaoNianServiceImpl implements BPerQingShaoNianService {
	@Autowired
	private BPerQingShaoNianMapperImpl bPerQingShaoNianMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerQingShaoNian entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerQingShaoNianMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerQingShaoNianMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setQingShaoNian(true);
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
	public int update(BPerQingShaoNian entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerQingShaoNianMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	public Page<BPerQingShaoNian> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerQingShaoNian> page = bPerQingShaoNianMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerQingShaoNian.class, "codeQsnType,codeJiaTingSituation");
		return page;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerQingShaoNianMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerQingShaoNianMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setQingShaoNian(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerQingShaoNian queryByKey(String primaryKey) {
		return bPerQingShaoNianMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerQingShaoNian> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerQingShaoNian> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerQingShaoNian> queryTListParam(BPerQingShaoNian param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerQingShaoNian> queryByParamPage(int pageNum, int size, String sidx, String sord,
			BPerQingShaoNian param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerQingShaoNianMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerQingShaoNian queryByPersonCode(String personCode) throws Exception {
		BPerQingShaoNian zhongdianqingshaonian = bPerQingShaoNianMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(zhongdianqingshaonian, BPerQingShaoNian.class, "codeQsnType,codeJiaTingSituation,codeJianHuRelation,codeBangFuType");
		return zhongdianqingshaonian;
	}
}
