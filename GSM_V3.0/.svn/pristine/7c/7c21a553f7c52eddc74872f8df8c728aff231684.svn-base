package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BHouseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.BaseModel;
import com.dykj.GSM.model.base.BHouse;

public class BHouseMapperImpl extends BaseMapperImpl<BHouse, String> implements BHouseMapper {
	@Override
	public List<Map<String, Object>> Charts(BHouse args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
	public Page<BHouse> queryZongHePage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "b_house.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryZongHePage"), args);
		return PageHelper.endPage(results);
	}
}