package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BPartsMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BParts;

public class BPartsMapperImpl extends BaseMapperImpl<BParts, String> implements BPartsMapper {
	@Override
	public List<Map<String, Object>> Charts(BParts args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}

	@Override
	public Page<BParts> queryZongHePage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "b_parts.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryZongHePage"), args);
		return PageHelper.endPage(results);
	
	}
}
