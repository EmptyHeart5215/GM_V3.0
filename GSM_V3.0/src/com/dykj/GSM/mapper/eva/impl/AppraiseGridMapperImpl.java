package com.dykj.GSM.mapper.eva.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eva.mapperinterf.AppraiseGridMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.eva.AppraiseGrid;

public class AppraiseGridMapperImpl extends BaseMapperImpl<AppraiseGrid, String> implements AppraiseGridMapper {
	@Override
	public int insertBySelect(Map<String, Object> map) {
		int rows = this.getSqlSession().insert(getSqlName("insertBySelect"), map);
		return rows;
	}

	@Override
	public Page<AppraiseGrid> queryByMapPage(int pageNum, int size, String sidx, String sord, Map param) {

		PageHelper.startPage(pageNum, size, "g.grid_total_name asc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryByMapPage"), param);
		return PageHelper.endPage(results);
	}

	@Override
	public int deleteByYearAndMonth(Map<String, Object> map) {

		return this.getSqlSession().delete(getSqlName("deleteByYearAndMonth"), map);
	}

	/* 
	 * 统计
	 */
	@Override
	public Page<AppraiseGrid> queryStatisticsPage(int pageNum, int size, String sidx, String sord, Map param) {
		PageHelper.startPage(pageNum, size, "");
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryStatisticsPage"), param);
		return PageHelper.endPage(results);
	}

	/**
	 * @param params
	 * @return
	 */
	@Override
	public List<Map<String, Object>> staticForIndex(Map<String, Object> params) {
		// 得到结果
		List<Map<String, Object>> results = this.getSqlSession().selectList(getSqlName("staticForIndex"), params);
		return results;
	}
}
