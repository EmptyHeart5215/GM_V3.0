package com.dykj.GSM.mapper.event.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.event.mapperinterf.EEventMapper;
import com.dykj.GSM.model.event.EEvent;

public class EEventMapperImpl extends BaseEventMapperImpl<EEvent> implements EEventMapper {
	public List<Map<String, Object>> mapqueryWanJiePage(EEvent args) {
		return this.getSqlSession().selectList(getSqlName("mapqueryWanJiePage"),args);
	}
}