package com.dykj.GSM.mapper.eventfile.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eventfile.mapperinterf.EventContradictMapper;
import com.dykj.GSM.model.eventfile.EventActivities;
import com.dykj.GSM.model.eventfile.EventContradict;

public class EventContradictMapperImpl extends BaseMapperImpl<EventContradict, String> implements EventContradictMapper {
	@Override
	public List<Map<String, Object>> Charts(EventContradict args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
}
