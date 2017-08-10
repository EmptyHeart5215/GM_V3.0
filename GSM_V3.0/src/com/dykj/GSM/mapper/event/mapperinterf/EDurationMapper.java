package com.dykj.GSM.mapper.event.mapperinterf;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.event.EDuration;

public interface EDurationMapper extends IBaseMapper<EDuration, String> {

	public EDuration queryOneByWfEntry(Long entryId);
}