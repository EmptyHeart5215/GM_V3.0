package com.dykj.GSM.mapper.event.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.event.mapperinterf.EContradictMapper;
import com.dykj.GSM.model.event.EContradict;

public class EContradictMapperImpl extends BaseEventMapperImpl<EContradict> implements EContradictMapper {
	public List<Map<String, Object>> mapqueryWanJiePage() {
		return this.getSqlSession().selectList(getSqlName("mapqueryWanJiePage"));
	}
}