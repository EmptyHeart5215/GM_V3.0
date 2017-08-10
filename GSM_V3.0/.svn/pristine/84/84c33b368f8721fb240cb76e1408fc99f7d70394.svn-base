package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerBfJiuZhuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerBfJiuZhu;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.service.base.BPerBfJiuZhuService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerBfJiuZhuServiceImpl implements BPerBfJiuZhuService {
	@Autowired
	private BPerBfJiuZhuMapperImpl bPerBfJiuZhuMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerBfJiuZhu entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerBfJiuZhuMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerBfJiuZhuMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfJiuZhu(true);
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
	public int update(BPerBfJiuZhu entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerBfJiuZhuMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerBfJiuZhuMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerBfJiuZhuMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfJiuZhu(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerBfJiuZhu queryByKey(String primaryKey) {
		return bPerBfJiuZhuMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerBfJiuZhu> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfJiuZhu> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfJiuZhu> queryTListParam(BPerBfJiuZhu param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerBfJiuZhu> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerBfJiuZhu param) {
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
	 */
	@Override
	public BPerBfJiuZhu queryByPersonCode(String personCode) {
		return bPerBfJiuZhuMapperImpl.queryByPersonCode(personCode);
	}
}
