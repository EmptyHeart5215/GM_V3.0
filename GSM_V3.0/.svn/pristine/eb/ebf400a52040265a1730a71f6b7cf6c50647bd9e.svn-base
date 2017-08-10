package com.dykj.GSM.imessage;

import cn.jpush.api.common.connection.HttpProxy;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.utils.Preconditions;
import cn.jpush.api.common.resp.ResponseWrapper;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年6月21日 下午1:57:11
* 修改人：
* 修改日期：
* 类说明:
*/
public class MessageClient extends BaseClient{
	
	private String messagePath;

	public MessageClient(String appkey, String masterSecret) {
		this(appkey,masterSecret,null,JMessageConfig.getInstance());
	}



	/**
	 * @param appkey
	 * @param masterSecret
	 * @param proxy
	 * @param config
	 */
	public MessageClient(String appkey, String masterSecret, HttpProxy proxy, JMessageConfig config) {
		super(appkey, masterSecret, proxy, config);
		this.messagePath = (String) config.get(JMessageConfig.MESSAGE_PATH);
	}
	
	public SendMessageResult sendMessage(MessagePayload payload)throws APIConnectionException,APIRequestException{
		Preconditions.checkArgument(!(null==payload), "消息有效负载不应该为空!");
		ResponseWrapper response = _httpClient.sendPost(_baseUrl+messagePath, payload.toString());
		return SendMessageResult.fromResponse(response, SendMessageResult.class);
		
	}

}
