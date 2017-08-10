package com.dykj.GSM.imessage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dykj.GSM.model.imessage.IMessage;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import net.sf.json.JSONObject;

public class JPush {
	
	protected static final Logger LOG = LoggerFactory.getLogger(JPush.class);

    // demo App defined in resources/jpush-api.conf 
	private static final String appKey = "881c3a884e16f67e47ac206b";
	private static final String masterSecret = "615f7a327f398c5aa832e5dc";
	
	
	/*private static final String appKey = "49ee82d39fec8d4b2da47f0c";
	private static final String masterSecret = "f819fffc2bd11709ef9c9f69";*/
	
	/*public static final String TITLE = "aaa";
	public static final String ALERT = "test";
    public static final String MSG_CONTENT = "我要吃旺旺碎碎冰3";
    public static final String REGISTRATION_ID = "18071adc030d39c6a28";
    public static final String TAG = "我要吃旺旺碎碎冰4";
   */
	 public static JPushClient jpushClient = null;
	
	public static int testSendPushs(IMessage message) {
	    // HttpProxy proxy = new HttpProxy("localhost", 3128);
	    // Can use this https proxy: https://github.com/Exa-Networks/exaproxy
        
		jpushClient = new JPushClient(masterSecret, appKey, 3);
		PushPayload payload = sendMsg(message);
        
        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result ------00000-0-0-------------" + result.getResponseCode());
            return result.getResponseCode();
            
        } catch (APIConnectionException e) {
            LOG.error("Connection error. Should retry later. ", e);
            return 500;
        } catch (APIRequestException e) {
            LOG.error("Error response from JPush server. Should review and fix it. ", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
            LOG.info("Msg ID: " + e.getMsgId());
            LOG.info("Msg ID: " + e.getMessage());
            return 500;
        }
	}
	
	
	public static void testSendPush(String currentOwner, String eventTitle) {
		// HttpProxy proxy = new HttpProxy("localhost", 3128);
		// Can use this https proxy: https://github.com/Exa-Networks/exaproxy
		JPushClient jpushClient = new JPushClient(masterSecret, appKey, 3);

		PushPayload payload = buildPushEvent(currentOwner, eventTitle);

		try {
			PushResult result = jpushClient.sendPush(payload);
			LOG.info("Got result - " + result);

		} catch (APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);

		} catch (APIRequestException e) {
			LOG.error("Error response from JPush server. Should review and fix it. ", e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
		}
	}
	//•快捷地构建推送对象：所有平台，所有设备，内容为 ALERT 的通知。
	/*public static PushPayload buildPushObject_all_all_alert() {
	    return PushPayload.alertAll(ALERT);
	}*/
	//•构建推送对象：所有平台，推送目标是别名为 "alias1"，通知内容为 ALERT。
   /* public static PushPayload buildPushObject_all_alias_alert() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias("12345678"))
                .setNotification(Notification.alert(ALERT))
                .build();
    }*/
    //•构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE
   /* public static PushPayload buildPushObject_android_tag_alertWithTitle() {
        return PushPayload.newBuilder()
                .setPlatform(Platform.android())
.setAudience(Audience.tag("1"))
                .setNotification(Notification.android(ALERT, TITLE, null))
                .build();
    }*/
    
  //•构建推送对象：平台是 Android，目标是 tag 为 "tag1" 的设备，内容是 Android 通知 ALERT，并且标题为 TITLE
    public static PushPayload sendMsg(IMessage message){ 
    	String alias = message.getUserCode();
    	System.out.println(alias+"===========================================");
    	Map<String, String> map = new HashMap<String,String>();
    	map.put("text", message.getText());
    	map.put("userName", message.getUserName());
    	map.put("sendUserCode", message.getSendUserCode());
    	Collection<String> strings = new ArrayList<String>();
    	String msg = message.getText();
    	System.out.println(msg.toString()); 
    /*	strings.add("1104a89792a90f072c0");
    	strings.add("160a3797c804442279c");
    	strings.add("13065ffa4e094a10a6d");
    	strings.add("18071adc030d39c6a28");
    	strings.add("100d855909470497a6f");*/
    	//strings.add("18071adc030ca005e5a");
        return PushPayload.newBuilder().setPlatform(Platform.android())
       //.setAudience(Audience.tag("JPush"))
        .setAudience(Audience.registrationId(strings))
      .setAudience(Audience.alias(alias))
         //.setAudience(Audience.alias("7F8B407ABDA246F89E7109BF5755E5AD"))
       .setPlatform(Platform.android())
       .setNotification(Notification.android(message.getOriginalText(), message.getUserName(), map))
       .setMessage(getMessage(message))
       .build();
    }
    
    public static Message getMessage(IMessage message){
    	Map<String, String> map = new HashMap<String,String>();
    	Date date1 = new Date();    
    	SimpleDateFormat SimpleDateFormat = new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
    	String dates = SimpleDateFormat.format(date1);
    	map.put("userName", message.getUserName());
    	map.put("text", message.getText());
    	map.put("sendUserCode", message.getSendUserCode());
    	map.put("createDate", dates);
    	String json = JSONObject.fromObject(map).toString();
    	
    	return Message.content(json);
    }
    
    public static String getMessageAlert(IMessage message){
    	Map<String, String> map = new HashMap<String,String>();
    	map.put("sendMsgUser", message.getUserName());
    	map.put("msg", message.getText());
    	String json = JSONObject.fromObject(map).toString();
    	return json;
    }

	public static PushPayload buildPushEvent(String currentOwner, String eventTitle) {
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag(currentOwner))
				.setNotification(Notification.android(eventTitle, "北戴河智慧网格待办事件提醒", null)).build();
	}
	
	public static PushPayload myTestSend(String name, String text) {
		return PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.tag("881c3a884e16f67e47ac206b"))
				.setNotification(Notification.android(text, name, null)).build();
	}
	
}
