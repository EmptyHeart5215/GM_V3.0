package com.dykj.GSM.model.zhihuizhongxin;



import com.dykj.GSM.model.BaseModel;

/**
 * 指挥中心-网格员消息
 * 
 */
public class Message extends BaseModel {
	
	
	 /**
	 * 用户姓名
	 */
	 private String userName ;
	 /**
	 * 用户CODE
	 */
	 private String userCode ;
	 /**
	 * 手机号
	 */
	 private String userPhone ;
	 /**
	 * 消息
	 */
     private String message ;
     /**
 	 * 发送时间
 	 */
     private String sendTime ;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSendTime() {
		return sendTime;
	}
	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

     
}
