package com.dykj.GSM.model.sys;

import javax.persistence.Transient;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 系统设置-设备管理表
 * 
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysGpsDeviceMapper")
public class SysGpsDevice extends BaseModel {
	/**
	 * 设备名称
	 */
	private String gpsName;
	/**
	 * 设备IMEI
	 */
	private String gpsImei;
	/**
	 * 手机卡号
	 */
	private String gpsSimno;
	/**
	 * 绑定code
	 */
	private String gpsUsercode;
	/**
	 * 设备位置时间
	 */
	private String gpsPositionTime;
	/**
	 * 设备位置信息
	 */
	private String gpsPositionMsg;
	/**
	 * 设备状态,0或者1
	 */
	private int gpsState;

	/**
	 * 设备状态显示名称
	 */

	private String gpsStateString;
	/**
	 * 真实姓名
	 */

	private String realName;
	@Transient
	private String date1;
	@Transient
	private String date2;

	@Transient
	private SysUser user;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setGpsStateString(String gpsStateString) {
		this.gpsStateString = gpsStateString;
	}

	public String getGpsStateString() {

		return gpsStateString;
	}

	public int getGpsState() {
		return gpsState;
	}

	public void setGpsState(int gpsState) {
		this.gpsState = gpsState;
	}

	public String getGpsName() {
		return gpsName;
	}

	public void setGpsName(String gpsName) {
		this.gpsName = gpsName;
	}

	public String getGpsImei() {
		return gpsImei;
	}

	public void setGpsImei(String gpsImei) {
		this.gpsImei = gpsImei;
	}

	public String getGpsSimno() {
		return gpsSimno;
	}

	public void setGpsSimno(String gpsSimno) {
		this.gpsSimno = gpsSimno;
	}

	public String getGpsUsercode() {
		return gpsUsercode;
	}

	public void setGpsUsercode(String gpsUsercode) {
		this.gpsUsercode = gpsUsercode;
	}

	public String getGpsPositionTime() {
		return gpsPositionTime;
	}

	public void setGpsPositionTime(String gpsPositionTime) {
		this.gpsPositionTime = gpsPositionTime;
	}

	public String getGpsPositionMsg() {
		return gpsPositionMsg;
	}

	public void setGpsPositionMsg(String gpsPositionMsg) {
		this.gpsPositionMsg = gpsPositionMsg;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public SysUser getUser() {
		return user;
	}

	public void setUser(SysUser user) {
		this.user = user;
	}

}
