package com.dykj.GSM.model.partybuilding;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 党员管理总实体对象
 * 其中：所有党员（allparty）、直管党员（straightparty），在职党员（inparty），退休党员（retiredparty），
 * 困难党员（difficultparty），志愿者党员（volunteersparty）均采用该model对象
 * 
 * @author Administrator
 *
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.partybuilding.mapperinterf.PartyMemberManagerMapper")
public class PartyMemberManager extends BaseModel {

	/**
	 * 网格主键
	 */
	private String gridCode;
	/**
	 * 人主键
	 */
	private String personCode;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 证件编号
	 */
	private String cid;
	/**
	 * 户籍地
	 */
	private String residenceAddress;
	/**
	 * 当前住址
	 */
	private String address;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 手机
	 */
	private String tel;
	/**
	 * 入党时间
	 */
	private String inPartyDate;
	/**
	 * 党员类型
	 */
	private String codePartyType;
	/**
	 * 是否为困难党员
	 */
	private String codeIsDiffcutPart;
	/**
	 * 民族
	 */
	private String codeNation;
	/**
	 * 政治面貌
	 */
	private String codePolitical;
	/**
	 * 文化程度
	 */
	private String codeEducation;
	/**
	 * 婚姻状况
	 */
	private String codeMarriage;
	/**
	 * 地图定位
	 */
	private String position;

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getResidenceAddress() {
		return residenceAddress;
	}

	public void setResidenceAddress(String residenceAddress) {
		this.residenceAddress = residenceAddress;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getInPartyDate() {
		return inPartyDate;
	}

	public void setInPartyDate(String inPartyDate) {
		this.inPartyDate = inPartyDate;
	}

	public String getCodePartyType() {
		return codePartyType;
	}

	public void setCodePartyType(String codePartyType) {
		this.codePartyType = codePartyType;
	}

	public String getCodeIsDiffcutPart() {
		return codeIsDiffcutPart;
	}

	public void setCodeIsDiffcutPart(String codeIsDiffcutPart) {
		this.codeIsDiffcutPart = codeIsDiffcutPart;
	}

	public String getCodeNation() {
		return codeNation;
	}

	public void setCodeNation(String codeNation) {
		this.codeNation = codeNation;
	}

	public String getCodePolitical() {
		return codePolitical;
	}

	public void setCodePolitical(String codePolitical) {
		this.codePolitical = codePolitical;
	}

	public String getCodeEducation() {
		return codeEducation;
	}

	public void setCodeEducation(String codeEducation) {
		this.codeEducation = codeEducation;
	}

	public String getCodeMarriage() {
		return codeMarriage;
	}

	public void setCodeMarriage(String codeMarriage) {
		this.codeMarriage = codeMarriage;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
