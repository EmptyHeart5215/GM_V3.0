package com.dykj.GSM.service.eventfile;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.service.IBaseService;
import com.dykj.GSM.model.eventfile.EventContradict;
import com.dykj.GSM.model.eventfile.EventHarmSafe;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-27 17:13:38
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface EventHarmSafeService extends IBaseService<EventHarmSafe, String>{
	public List<Map<String, Object>> Charts(EventHarmSafe args);
}