package com.dykj.GSM.mapper.eventfile.impl;


import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eventfile.mapperinterf.EventActivitiesMapper;
import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.model.eventfile.EventActivities;

public class EventActivitiesMapperImpl extends BaseMapperImpl<EventActivities, String> implements EventActivitiesMapper {
	@Override
	public List<Map<String, Object>> Charts(EventActivities args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
}
