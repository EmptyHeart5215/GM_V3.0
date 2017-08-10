package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerBfKongChaoMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerBfKongChao;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.service.base.BPerBfKongChaoService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerBfKongChaoServiceImpl implements BPerBfKongChaoService {
	@Autowired
	private BPerBfKongChaoMapperImpl bPerBfKongChaoMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerBfKongChao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerBfKongChaoMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerBfKongChaoMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfKongChao(true);
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
	public int update(BPerBfKongChao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerBfKongChaoMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerBfKongChaoMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerBfKongChaoMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfKongChao(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerBfKongChao queryByKey(String primaryKey) {
		return bPerBfKongChaoMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerBfKongChao> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfKongChao> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfKongChao> queryTListParam(BPerBfKongChao param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerBfKongChao> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerBfKongChao param) {
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
	public BPerBfKongChao queryByPersonCode(String personCode) {
		return bPerBfKongChaoMapperImpl.queryByPersonCode(personCode);
	}
}
