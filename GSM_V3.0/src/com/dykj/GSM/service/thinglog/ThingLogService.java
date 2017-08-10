package com.dykj.GSM.service.thinglog;

import com.dykj.GSM.model.thinglog.ThingLog;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月25日 上午8:28:33
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface ThingLogService extends IBaseService<ThingLog,String>{
	
	public ThingLog statisticLogQuestion(ThingLog thingLog);
	
	/**
	 * 自动获取网格员姓名及联系电话
	 * @param thingLog
	 * @return
	 */
	public ThingLog queryAutoGirgInfo(ThingLog thingLog);

}
