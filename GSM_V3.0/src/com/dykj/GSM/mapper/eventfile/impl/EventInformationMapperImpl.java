package com.dykj.GSM.mapper.eventfile.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eventfile.mapperinterf.EventInformationMapper;
import com.dykj.GSM.model.eventfile.EventHarmSafe;
import com.dykj.GSM.model.eventfile.EventInformation;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-27 16:38:59
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class EventInformationMapperImpl extends BaseMapperImpl<EventInformation,String> implements EventInformationMapper{
	@Override
	public List<Map<String, Object>> Charts(EventInformation args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
}