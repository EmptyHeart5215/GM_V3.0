package com.dykj.GSM.mapper.eva.impl;

import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eva.mapperinterf.AppraiseCommunityMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.eva.AppraiseCommunity;

public class AppraiseCommunityMapperImpl extends BaseMapperImpl<AppraiseCommunity, String> implements
		AppraiseCommunityMapper {
	@Override
	public int insertBySelect(Map<String, Object> map) {
		int rows = this.getSqlSession().insert(getSqlName("insertBySelect"), map);
		return rows;
	}

	@Override
	public Page<AppraiseCommunity> queryByMapPage(int pageNum, int size, String sidx, String sord, Map param) {

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
	public Page<AppraiseCommunity> queryStatisticsPage(int pageNum, int size, String sidx, String sord, Map param) {
		PageHelper.startPage(pageNum, size, "");
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryStatisticsPage"), param);
		return PageHelper.endPage(results);
	}
}