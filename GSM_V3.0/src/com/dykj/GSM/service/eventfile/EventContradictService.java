package com.dykj.GSM.service.eventfile;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.model.eventfile.EventActivities;
import com.dykj.GSM.model.eventfile.EventContradict;
import com.dykj.GSM.service.IBaseService;

public interface EventContradictService extends IBaseService<EventContradict,String> {
	public List<Map<String, Object>> Charts(EventContradict args);
}
