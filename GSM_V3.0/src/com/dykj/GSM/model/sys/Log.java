package com.dykj.GSM.model.sys;

import java.io.Serializable;
import java.util.Date;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;


/**
 * 日志记录POJO
 * @author HotStrong
 *
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysLogMapper")
public class Log extends BaseModel implements Serializable{
	
	/**
	 * 操作之前
	 */
	private String beforLog;
	
	/**
	 * 操作之后
	 */
	private String afterLog;
	
	/**
	 * 操作
	 */
	private String operation;
	
	/**
	 * 数据CODE
	 */
	private String shuJu;
	
	/**
	 * 数据CODE
	 */
	private String shuJuType;
	/**
	 * 用户userIp
	 */
	private String userIp;
	/**
	 * 用户userAdr
	 */
	private String userAddress;

	public String getBeforLog() {
		return beforLog;
	}

	public void setBeforLog(String beforLog) {
		this.beforLog = beforLog;
	}

	public String getAfterLog() {
		return afterLog;
	}

	public void setAfterLog(String afterLog) {
		this.afterLog = afterLog;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getShuJu() {
		return shuJu;
	}

	public void setShuJu(String shuJu) {
		this.shuJu = shuJu;
	}

	public String getShuJuType() {
		return shuJuType;
	}

	public void setShuJuType(String shuJuType) {
		this.shuJuType = shuJuType;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
}
