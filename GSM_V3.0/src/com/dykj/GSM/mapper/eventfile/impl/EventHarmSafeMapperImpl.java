package com.dykj.GSM.mapper.eventfile.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.eventfile.mapperinterf.EventHarmSafeMapper;
import com.dykj.GSM.model.eventfile.EventContradict;
import com.dykj.GSM.model.eventfile.EventHarmSafe;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-27 17:13:38
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class EventHarmSafeMapperImpl extends BaseMapperImpl<EventHarmSafe,String> implements EventHarmSafeMapper{
	@Override
	public List<Map<String, Object>> Charts(EventHarmSafe args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
}