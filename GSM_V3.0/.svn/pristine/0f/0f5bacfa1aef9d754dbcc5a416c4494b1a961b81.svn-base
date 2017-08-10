package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.base.impl.BBuildingMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BBuilding;
import com.dykj.GSM.service.base.BBuildingService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class BBuildingServiceImpl implements BBuildingService {
	@Autowired
	private BBuildingMapperImpl bBuildingMapperImpl;

	@Override
	public int insert(BBuilding entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bBuildingMapperImpl.insert(entity);
	}

	/*
	 * 新增或修改
	 */
	@Override
	public int update(BBuilding entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bBuildingMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bBuildingMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BBuilding queryByKey(String primaryKey) {
		return bBuildingMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BBuilding> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BBuilding> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BBuilding> queryTListParam(BBuilding param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BBuilding> queryByParamPage(int pageNum, int size, String sidx, String sord, BBuilding param) {
		return bBuildingMapperImpl.queryByParamPage(pageNum, size, sidx, sord, param);
	}

	@Override
	public Page<BBuilding> queryByMapParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> m) {
		return bBuildingMapperImpl.queryByMapParamPage(pageNum, size, sidx, sord, m);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bBuildingMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BBuilding args) {
		return bBuildingMapperImpl.Charts(args);
	}

	@Override
	public List<Map<String, Object>> queryNameTreeBy(String gridCode) {
		return bBuildingMapperImpl.queryNameTreeBy(gridCode);
	}

	@Override
	public List<Map<String, Object>> mapbpersonCharts(String code) {
		return bBuildingMapperImpl.mapbpersonCharts(code);
	}

	@Override
	public List<Map<String, Object>> queryLpb(String code) {
		return bBuildingMapperImpl.queryLpb(code);
	}

}
