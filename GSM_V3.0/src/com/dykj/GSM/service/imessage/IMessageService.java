package com.dykj.GSM.service.imessage;

import com.dykj.GSM.model.imessage.IMessage;
import com.dykj.GSM.service.IBaseService;

import java.util.List;


/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-06-29 13:57:24
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface IMessageService extends IBaseService<IMessage, String>{
	
	/**
	 * 查询当前十分钟之内的聊天记录
	 * @param message
	 * @return
	 */
	public List<IMessage> queryMessageTenMini(IMessage message);

}