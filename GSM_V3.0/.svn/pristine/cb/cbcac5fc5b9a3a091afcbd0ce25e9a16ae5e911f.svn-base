package com.dykj.GSM.imessage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonObject;

import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年6月21日 下午4:23:56
* 修改人：
* 修改日期：
* 类说明:
*/
public class TestSendMessage {
	
	 private static Logger LOG = LoggerFactory.getLogger(TestSendMessage.class);
	private MessageClient messageClient = null;
	
	private static final String appKey = " 49ee82d39fec8d4b2da47f0c";  
    private static final String masterSecret = "f819fffc2bd11709ef9c9f69 ";  
	
	@Test
    public void testSendMessage() {
        JMessageClient jMessageClient = new JMessageClient(appKey, masterSecret,3);
        PushPayload payload = buildPushObject_all_all_alert();
        MessageBody body = MessageBody.text("Hello");
        /**
         * version Current version is 1
         * Group or single
         * The message receiver
         * Only support admin now
         */
        try {
			SendMessageResult result = jMessageClient.sendMessage(3, "single", "ddwsz", "admin", "", "text", body);
		} catch (APIConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIRequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static PushPayload buildPushObject_all_all_alert() {
        return PushPayload.messageAll("iiiiiiiiiiiiiiiiiiiii");
    }
	
	/*public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("alias1"))
                .setNotification(Notification.alert(ALERT))
                .build();
    }*/

}
