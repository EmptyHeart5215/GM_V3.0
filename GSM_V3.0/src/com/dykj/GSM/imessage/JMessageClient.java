package com.dykj.GSM.imessage;

import cn.jpush.api.common.connection.HttpProxy;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年6月21日 上午11:22:25 修改人： 修改日期： 类说明:
 */
public class JMessageClient {

	private MessageClient _messageClient;
	private int _sendVersion;

	public JMessageClient(String appkey, String masterSecret) {
		this(appkey, masterSecret, null, JMessageConfig.getInstance());
	}

	public JMessageClient(String appkey, String masterSecret, int maxRetryTimes) {
		this(appkey, masterSecret, null, JMessageConfig.getInstance().setMaxRetryTimes(maxRetryTimes));
	}

	public JMessageClient(String appkey, String masterSecret, HttpProxy proxy) {
		this(appkey, masterSecret, proxy, JMessageConfig.getInstance());
	}

	public JMessageClient(String appkey, String masterSecret, String hostname) {
		this(appkey, masterSecret, null, JMessageConfig.getInstance().setApiHostName(hostname));
	}

	public JMessageClient(String appkey, String masterSecret, HttpProxy proxy, JMessageConfig config) {
		_messageClient = new MessageClient(appkey, masterSecret, proxy, config);
		_sendVersion = (Integer) config.get(JMessageConfig.SEND_VERSION);
	}

	/**
	 * Send message
	 * 
	 * @param version
	 *            Current version is 1
	 * @param targetType
	 *            Group or single
	 * @param targetId
	 *            The message receiver
	 * @param fromType
	 *            Only support admin now
	 * @param fromId
	 *            Sender
	 * @param messageType
	 *            Only support text now
	 * @param messageBody
	 *            A MessageBody instance
	 * @return
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
	public SendMessageResult sendMessage(Integer version, String targetType, String targetId, String fromType,
			String fromId, String messageType, MessageBody messageBody)
			throws APIConnectionException, APIRequestException {
		MessagePayload payload = MessagePayload.newBuilder().setVersion(version).setTargetType(targetType)
				.setTargetId(targetId).setFromType(fromType).setFromId(fromId).setMessageType(messageType)
				.setMessageBody(messageBody).build();
		return _messageClient.sendMessage(payload);
	}

	/**
	 * Send single text message by admin
	 * 
	 * @param targetId
	 * @param fromId
	 * @param body
	 * @return
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
	public SendMessageResult sendSingleTextByAdmin(String targetId, String fromId, MessageBody body)
			throws APIConnectionException, APIRequestException {
		return sendMessage(_sendVersion, "single", targetId, "admin", fromId, "text", body);
	}

	/**
	 * Send group text message by admin
	 * 
	 * @param targetId
	 * @param fromId
	 * @param body
	 * @return
	 * @throws APIConnectionException
	 * @throws APIRequestException
	 */
	public SendMessageResult sendGroupTextByAdmin(String targetId, String fromId, MessageBody body)
			throws APIConnectionException, APIRequestException {
		return sendMessage(_sendVersion, "group", targetId, "admin", fromId, "text", body);
	}

}
