package com.dykj.GSM.mapper.sys.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysRegionMapper;
import com.dykj.GSM.model.sys.SysRegion;

public class SysRegionMapperImpl extends BaseMapperImpl<SysRegion, String> implements SysRegionMapper {
	@Override
	public List<Map<String, Object>> queryTree(Map map) {
		List<Map<String, Object>> list = this.getSqlSession().selectList(getSqlName("queryTree"), map);
		return list;
	}

	/**
	 * codes的形式以,号隔开的，如1,2,3,4
	 * 
	 * @param codes
	 * @return
	 */
	public List<SysRegion> queryListByCodes(List<String> list) {
		return this.getSqlSession().selectList(getSqlName("queryListByCodes"), list);
	}
}
