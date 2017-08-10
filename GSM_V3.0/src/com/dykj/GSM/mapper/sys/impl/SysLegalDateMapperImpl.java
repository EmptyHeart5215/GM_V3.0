package com.dykj.GSM.mapper.sys.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysLegalDateMapper;
import com.dykj.GSM.model.sys.SysLegalDate;

public class SysLegalDateMapperImpl extends BaseMapperImpl<SysLegalDate, String> implements SysLegalDateMapper {
	@Override
	public SysLegalDate queryByYearAndMonth(Map param) {
		return this.getSqlSession().selectOne(getSqlName("queryByYearAndMonth"), param);
	}

	@Override
	public List<SysLegalDate> queryLegalDateAfterNow(Map param) {
		return this.getSqlSession().selectList(getSqlName("queryLegalDateAfterNow"), param);
	}

}
