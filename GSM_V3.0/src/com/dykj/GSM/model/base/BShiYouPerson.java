package com.dykj.GSM.model.base;

import com.dykj.GSM.model.BaseModel;

/**
 * 实有人口表
 * 
 */
public class BShiYouPerson extends BaseModel {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String codeSex;
	/**
	 * 证件号码
	 */
	private String cid;
	/**
	 * 年龄
	 */
	private String age;
	/**
	 * 民族
	 */
	private String codeNation;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 人户状态
	 */
	private String codeHouseHoldType;
	/**
	 * 管理类型
	 */
	private String codeManageType;
	/**
	 * 婚姻状况
	 */
	private String nameMarriage;
	/**
	 * 户籍地
	 */
	private String residenceAddress;
	/**
	 * 现住址
	 */
	private String nameHealth;
	/**
	 * 工作单位
	 */
	private String workAddress;
	/**
	 * 流入时间
	 */
	private String inflowDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCodeSex() {
		return codeSex;
	}

	public void setCodeSex(String codeSex) {
		this.codeSex = codeSex;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getCodeNation() {
		return codeNation;
	}

	public void setCodeNation(String codeNation) {
		this.codeNation = codeNation;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCodeHouseHoldType() {
		return codeHouseHoldType;
	}

	public void setCodeHouseHoldType(String codeHouseHoldType) {
		this.codeHouseHoldType = codeHouseHoldType;
	}

	public String getCodeManageType() {
		return codeManageType;
	}

	public void setCodeManageType(String codeManageType) {
		this.codeManageType = codeManageType;
	}

	public String getNameMarriage() {
		return nameMarriage;
	}

	public void setNameMarriage(String nameMarriage) {
		this.nameMarriage = nameMarriage;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getNameHealth() {
		return nameHealth;
	}

	public void setNameHealth(String nameHealth) {
		this.nameHealth = nameHealth;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getInflowDate() {
		return inflowDate;
	}

	public void setInflowDate(String inflowDate) {
		this.inflowDate = inflowDate;
	}

}
