package com.dykj.GSM.model.eventfile;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.eventfile.mapperinterf.EventInformationMapper")
public class EventInformation extends BaseModel {
	/**
	 * 所属辖区或网格
	 */
	
	private String gridCode;

	/**
	 * 编号
	 */
	
	private String numbers = "";

	/**
	 * 网格编码
	 */
	
	private String gridNum = "";

	/**
	 * 案件编号
	 */
	
	private String alarmNo;

	/**
	 * 案件名称
	 */
	
	private String eventName;

	/**
	 * 案发时间
	 */
	
	private String time;

	/**
	 * 案发地点及部位
	 */
	
	private String theSite;

	/**
	 * 定位
	 */
	
	private String position;

	/**
	 * 涉案当事人
	 */
	
	private String caseParty;

	/**
	 * 当事人住址
	 */
	
	private String partyAddress;

	/**
	 * 简要案情
	 */
	
	private String briefCase;

	/**
	 * 报警时间
	 */
	
	private String policeTime;

	/**
	 * 出警人员
	 */
	
	private String policePerson;

	/**
	 * 处置情况及结果
	 */
	
	private String dealWith;

	/**
	 * 结案时间
	 */
	
	private String closedDate;

	/**
	 * 登记时间
	 */
	private String registerDate;

	/**
	 * 备注
	 */
	private String rmark;

	

	

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getGridNum() {
		return gridNum;
	}

	public void setGridNum(String gridNum) {
		this.gridNum = gridNum;
	}

	public String getAlarmNo() {
		return alarmNo;
	}

	public void setAlarmNo(String alarmNo) {
		this.alarmNo = alarmNo;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTheSite() {
		return theSite;
	}

	public void setTheSite(String theSite) {
		this.theSite = theSite;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCaseParty() {
		return caseParty;
	}

	public void setCaseParty(String caseParty) {
		this.caseParty = caseParty;
	}

	public String getPartyAddress() {
		return partyAddress;
	}

	public void setPartyAddress(String partyAddress) {
		this.partyAddress = partyAddress;
	}

	public String getBriefCase() {
		return briefCase;
	}

	public void setBriefCase(String briefCase) {
		this.briefCase = briefCase;
	}

	public String getPoliceTime() {
		return policeTime;
	}

	public void setPoliceTime(String policeTime) {
		this.policeTime = policeTime;
	}

	public String getPolicePerson() {
		return policePerson;
	}

	public void setPolicePerson(String policePerson) {
		this.policePerson = policePerson;
	}

	public String getDealWith() {
		return dealWith;
	}

	public void setDealWith(String dealWith) {
		this.dealWith = dealWith;
	}

	public String getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(String closedDate) {
		this.closedDate = closedDate;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getRmark() {
		return rmark;
	}

	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

}
