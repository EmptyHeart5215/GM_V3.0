package com.dykj.GSM.mapper.event.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.event.mapperinterf.EDelayMapper;
import com.dykj.GSM.model.event.EDelay;

public class EDelayMapperImpl extends BaseMapperImpl<EDelay, String> implements EDelayMapper {

	/**
	 * 得到上一条意见
	 * 
	 * @param entryId
	 * @return
	 */
	@Override
	public EDelay queryOneByWfEntry(Long entryId) {
		return this.getSqlSession().selectOne(getSqlName("queryOneByWfEntry"), entryId);
	}

}