package com.dykj.GSM.mapper.event.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.model.event.EContradict;

public interface EContradictMapper extends IBaseEventMpper<EContradict> {
	public List<Map<String, Object>> mapqueryWanJiePage();
}