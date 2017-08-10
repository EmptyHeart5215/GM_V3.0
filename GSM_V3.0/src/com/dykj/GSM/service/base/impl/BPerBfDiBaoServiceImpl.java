package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerBfDiBaoMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerBfDiBao;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.service.base.BPerBfDiBaoService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerBfDiBaoServiceImpl implements BPerBfDiBaoService {
	@Autowired
	private BPerBfDiBaoMapperImpl bPerBfDiBaoMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerBfDiBao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerBfDiBaoMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerBfDiBaoMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfDiBao(true);
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
	public int update(BPerBfDiBao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerBfDiBaoMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerBfDiBaoMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerBfDiBaoMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfDiBao(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerBfDiBao queryByKey(String primaryKey) {
		return bPerBfDiBaoMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerBfDiBao> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfDiBao> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfDiBao> queryTListParam(BPerBfDiBao param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerBfDiBao> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerBfDiBao param) {
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
	public BPerBfDiBao queryByPersonCode(String personCode) {
		return bPerBfDiBaoMapperImpl.queryByPersonCode(personCode);
	}
}
