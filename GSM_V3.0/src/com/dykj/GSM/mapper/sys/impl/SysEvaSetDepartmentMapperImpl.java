package com.dykj.GSM.mapper.sys.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysEvaSetDepartmentMapper;
import com.dykj.GSM.model.sys.SysEvaSetDepartment;

public class SysEvaSetDepartmentMapperImpl extends BaseMapperImpl<SysEvaSetDepartment, String> implements
		SysEvaSetDepartmentMapper {
	@Override
	public SysEvaSetDepartment queryOne() {
		return this.getSqlSession().selectOne(getSqlName("queryOne"));
	}

	@Override
	public int deleteAll() {
		return this.getSqlSession().update(getSqlName("deleteAll"));
	}
}
