package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BBuildingMapperImpl;
import com.dykj.GSM.mapper.base.impl.BUnitMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BUnit;
import com.dykj.GSM.service.base.BUnitService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BUnitServiceImpl implements BUnitService {
	@Autowired
	private BUnitMapperImpl bUnitMapperImpl;
	@Autowired
	private BBuildingMapperImpl bBuildingMapperImpl;

	@Override
	public int insert(BUnit entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		entity.setGridCode(bBuildingMapperImpl.queryByKey(entity.getBuildCode()).getGridCode());
		return bUnitMapperImpl.insert(entity);
	}

	/*
	 * 新增或修改
	 */
	public int update(BUnit entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bUnitMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bUnitMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BUnit queryByKey(String primaryKey) {
		return bUnitMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BUnit> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BUnit> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BUnit> queryTListParam(BUnit param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BUnit> queryByParamPage(int pageNum, int size, String sidx, String sord, BUnit param) {
		return bUnitMapperImpl.queryByParamPage(pageNum, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bUnitMapperImpl.deleteBatch(list);
	}
}
