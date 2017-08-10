package com.dykj.GSM.mapper.sys.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysEvaSetMapper;
import com.dykj.GSM.model.sys.SysEvaSet;

public class SysEvaSetMapperImpl extends BaseMapperImpl<SysEvaSet, String> implements SysEvaSetMapper {
	@Override
	public SysEvaSet queryOne() {
		return this.getSqlSession().selectOne(getSqlName("queryOne"));
	}

	@Override
	public int deleteAll() {
		return this.getSqlSession().update(getSqlName("deleteAll"));
	}
}
