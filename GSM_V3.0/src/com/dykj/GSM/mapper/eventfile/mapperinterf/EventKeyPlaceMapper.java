package com.dykj.GSM.mapper.eventfile.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.eventfile.EventInformation;
import com.dykj.GSM.model.eventfile.EventKeyPlace;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-28 08:40:21
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface EventKeyPlaceMapper extends IBaseMapper<EventKeyPlace, String>{
	public List<Map<String, Object>> Charts(EventKeyPlace args);
}