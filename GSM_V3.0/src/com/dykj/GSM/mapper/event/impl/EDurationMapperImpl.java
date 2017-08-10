package com.dykj.GSM.mapper.event.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.event.mapperinterf.EDurationMapper;
import com.dykj.GSM.model.event.EDuration;

public class EDurationMapperImpl extends BaseMapperImpl<EDuration, String> implements EDurationMapper {

	/**
	 * @param entryId
	 * @return
	 */
	@Override
	public EDuration queryOneByWfEntry(Long entryId) {
		return this.getSqlSession().selectOne(getSqlName("queryOneByWfEntry"), entryId);
	}

}