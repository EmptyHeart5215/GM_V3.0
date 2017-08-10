package com.dykj.GSM.model.imessage;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年6月22日 下午1:43:27 修改人： 修改日期： 类说明:用作存储通讯箱消息记录，数据库真实删除
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.imessage.mapperinterf.MessageStackMapper")
public class MessageStack extends BaseModel {

	/**
	 * 消息总个数
	 */
	private String msgTotalNum;
	/**
	 * 发送消息人姓名（或登录名称）
	 */
	private String sendMsgUserName;
	/**
	 * 发送消息人code主键
	 */
	private String sendMsgUserCode;
	/**
	 * 发送消息数量
	 */
	private String sendMsgNum;

	public String getMsgTotalNum() {
		return msgTotalNum;
	}

	public void setMsgTotalNum(String msgTotalNum) {
		this.msgTotalNum = msgTotalNum;
	}

	public String getSendMsgUserName() {
		return sendMsgUserName;
	}

	public void setSendMsgUserName(String sendMsgUserName) {
		this.sendMsgUserName = sendMsgUserName;
	}

	public String getSendMsgUserCode() {
		return sendMsgUserCode;
	}

	public void setSendMsgUserCode(String sendMsgUserCode) {
		this.sendMsgUserCode = sendMsgUserCode;
	}

	public String getSendMsgNum() {
		return sendMsgNum;
	}

	public void setSendMsgNum(String sendMsgNum) {
		this.sendMsgNum = sendMsgNum;
	}

}
