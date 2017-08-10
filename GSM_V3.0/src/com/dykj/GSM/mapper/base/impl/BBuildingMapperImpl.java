package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BBuildingMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BBuilding;

public class BBuildingMapperImpl extends BaseMapperImpl<BBuilding, String> implements BBuildingMapper {
	@Override
	public List<Map<String, Object>> Charts(BBuilding args) {
		return this.getSqlSession().selectList(getSqlName("Charts"), args);
	}

	@Override
	public List<Map<String, Object>> queryNameTreeBy(String gridCode) {
		return this.getSqlSession().selectList(getSqlName("queryNameTreeBy"), gridCode);
	}

	@Override
	public List<Map<String, Object>> mapbpersonCharts(String code) {
		return this.getSqlSession().selectList(getSqlName("mapbpersonCharts"), code);
	}

	@Override
	public List<Map<String, Object>> queryLpb(String code) {
		return this.getSqlSession().selectList(getSqlName("queryLpb"), code);
	}

	/**
	 * 带参数的，查询分页
	 */
	@Override
	public Page<BBuilding> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		String clazzName = getTClassName();
		sidx = clazzName + "." + sidx;
		PageHelper.startPage(pageNum, size, sidx + " " + sord);
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryMapParamPage"), param);
		return PageHelper.endPage(results);
	}

}