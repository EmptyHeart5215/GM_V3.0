package com.dykj.GSM.mapper.event.mapperinterf;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.event.EDelay;

public interface EDelayMapper extends IBaseMapper<EDelay, String> {

	public EDelay queryOneByWfEntry(Long entryId);
}