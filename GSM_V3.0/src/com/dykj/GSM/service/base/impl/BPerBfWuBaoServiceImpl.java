package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerBfWuBaoMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerBfWuBao;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.service.base.BPerBfWuBaoService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerBfWuBaoServiceImpl implements BPerBfWuBaoService {
	@Autowired
	private BPerBfWuBaoMapperImpl bPerBfWuBaoMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerBfWuBao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerBfWuBaoMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerBfWuBaoMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfWuBao(true);
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
	public int update(BPerBfWuBao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerBfWuBaoMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerBfWuBaoMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerBfWuBaoMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfWuBao(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerBfWuBao queryByKey(String primaryKey) {
		return bPerBfWuBaoMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerBfWuBao> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfWuBao> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfWuBao> queryTListParam(BPerBfWuBao param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerBfWuBao> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerBfWuBao param) {
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
	public BPerBfWuBao queryByPersonCode(String personCode) {
		return bPerBfWuBaoMapperImpl.queryByPersonCode(personCode);
	}
}
