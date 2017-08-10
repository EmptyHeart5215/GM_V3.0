package com.dykj.GSM.mapper.eventfile.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.eventfile.EventKeyPlace;
import com.dykj.GSM.model.eventfile.EventSignificantVisits;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-27 16:05:38
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface EventSignificantVisitsMapper extends IBaseMapper<EventSignificantVisits, String>{
	public List<Map<String, Object>> Charts(EventSignificantVisits args);
}