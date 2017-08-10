package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerBfCanJiMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerBfCanJi;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerTSJingShen;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerBfCanJiService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerBfCanJiServiceImpl implements BPerBfCanJiService {
	@Autowired
	private BPerBfCanJiMapperImpl bPerBfCanJiMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BPerBfCanJi entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerBfCanJiMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerBfCanJiMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfCanJi(true);
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
	public int update(BPerBfCanJi entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerBfCanJiMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerBfCanJiMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerBfCanJiMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfCanJi(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerBfCanJi queryByKey(String primaryKey) {
		return bPerBfCanJiMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerBfCanJi> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfCanJi> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfCanJi> queryTListParam(BPerBfCanJi param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerBfCanJi> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerBfCanJi param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return 0;
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerBfCanJi queryByPersonCode(String personCode) throws Exception {
		BPerBfCanJi canji = bPerBfCanJiMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(canji, BPerBfCanJi.class, "codeDisableType,codeDisableLevel");
		return canji;
	}
}
