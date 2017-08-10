package com.dykj.GSM.mapper.sys.impl;

import java.util.HashMap;
import java.util.Map;




import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysLogMapper;
import com.dykj.GSM.model.sys.Log;

public class SysLogMapperImpl extends BaseMapperImpl<Log, String> implements SysLogMapper {

	@Override
	public Map<String, Object> queryByCode(String code, String name) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("code", code);
		map.put("name", name);
		return this.getSqlSession().selectOne(getSqlName("queryByCode"), map);
	}
}
