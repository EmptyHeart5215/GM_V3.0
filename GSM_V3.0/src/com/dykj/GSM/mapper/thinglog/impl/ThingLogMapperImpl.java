package com.dykj.GSM.mapper.thinglog.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.thinglog.mapperinterf.ThingLogMapper;
import com.dykj.GSM.model.thinglog.ThingLog;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月25日 上午8:40:38
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class ThingLogMapperImpl extends BaseMapperImpl<ThingLog, String> implements ThingLogMapper {

	@Override
	public ThingLog statisticLogQuestion(ThingLog thingLog) {
		return this.getSqlSession().selectOne(getSqlName("statisticLogQuestion"), thingLog);
	}

	/* (non-Javadoc)
	 * @see com.dykj.GSM.mapper.thinglog.mapperinterf.ThingLogMapper#queryAutoGirgInfo(com.dykj.GSM.model.thinglog.ThingLog)
	 */
	@Override
	public ThingLog queryAutoGirgInfo(ThingLog thingLog) {
		return this.getSqlSession().selectOne(getSqlName("queryAutoGirgInfo"), thingLog);
	}

}
