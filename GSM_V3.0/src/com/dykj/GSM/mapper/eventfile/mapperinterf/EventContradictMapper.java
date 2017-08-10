package com.dykj.GSM.mapper.eventfile.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.eventfile.EventActivities;
import com.dykj.GSM.model.eventfile.EventContradict;

public interface EventContradictMapper extends IBaseMapper<EventContradict, String>{ 
	public List<Map<String, Object>> Charts(EventContradict args);
}
