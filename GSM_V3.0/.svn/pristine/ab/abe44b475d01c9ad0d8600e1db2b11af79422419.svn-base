package com.dykj.GSM.mapper.eventfile.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eventfile.mapperinterf.EventKeyPlaceMapper;
import com.dykj.GSM.model.eventfile.EventInformation;
import com.dykj.GSM.model.eventfile.EventKeyPlace;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-28 08:40:21
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class EventKeyPlaceMapperImpl extends BaseMapperImpl<EventKeyPlace,String> implements EventKeyPlaceMapper{
	@Override
	public List<Map<String, Object>> Charts(EventKeyPlace args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
}