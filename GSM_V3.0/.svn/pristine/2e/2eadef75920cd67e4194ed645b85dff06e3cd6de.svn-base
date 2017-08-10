package com.dykj.GSM.mapper.eventfile.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eventfile.mapperinterf.EventSignificantVisitsMapper;
import com.dykj.GSM.model.eventfile.EventKeyPlace;
import com.dykj.GSM.model.eventfile.EventSignificantVisits;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-27 16:05:38
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class EventSignificantVisitsMapperImpl extends BaseMapperImpl<EventSignificantVisits,String> implements EventSignificantVisitsMapper{
	@Override
	public List<Map<String, Object>> Charts(EventSignificantVisits args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
}