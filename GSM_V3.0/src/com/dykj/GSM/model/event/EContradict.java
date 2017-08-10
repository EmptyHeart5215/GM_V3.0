package com.dykj.GSM.model.event;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.event.mapperinterf.EContradictMapper")
public class EContradict extends BaseEvent {

	/**
	 * 发生规模
	 */
	@NotBlank
	private String codeEventGuimo;

	/**
	 * 涉及人数
	 */
	@NotNull
	@Max(9999)
	@Min(1)
	private Integer personCount;
	/**
	 * 主要当事人证件代码
	 */
	/*
	 * private String codeDangShiRenIdType;
	 */
	/**
	 * 主要当事人证件号码
	 */
	@NotBlank
	private String dangShiRenId;
	/**
	 * 主要当事人证件性别
	 */
	@NotBlank
	private String dangShiRenSex;
	/**
	 * 主要当事人学历
	 */
	private String codeXueLi;
	/**
	 * 主要当事人人员类别
	 */
	@NotBlank
	private String codeEventRenYuanType;
	/**
	 * 主要当事人民族
	 */
	@NotBlank
	private String codeNation;
	/**
	 * 主要当事人居住详址
	 */
	@NotBlank
	private String dangShiRenAddress;
	/**
	 * 主要当事人电话
	 */
	@NotBlank
	private String dangShiRenPhone;
	/**
	 * 主要当事人
	 */
	@NotBlank
	private String dangShiRenName;

	public String getCodeEventGuimo() {
		return codeEventGuimo;
	}

	public void setCodeEventGuimo(String codeEventGuimo) {
		this.codeEventGuimo = codeEventGuimo;
	}

	public Integer getPersonCount() {
		return personCount;
	}

	public void setPersonCount(Integer personCount) {
		this.personCount = personCount;
	}

	public String getDangShiRenId() {
		return dangShiRenId;
	}

	public void setDangShiRenId(String dangShiRenId) {
		this.dangShiRenId = dangShiRenId;
	}

	public String getDangShiRenSex() {
		return dangShiRenSex;
	}

	public void setDangShiRenSex(String dangShiRenSex) {
		this.dangShiRenSex = dangShiRenSex;
	}

	public String getCodeXueLi() {
		return codeXueLi;
	}

	public void setCodeXueLi(String codeXueLi) {
		this.codeXueLi = codeXueLi;
	}

	public String getCodeEventRenYuanType() {
		return codeEventRenYuanType;
	}

	public void setCodeEventRenYuanType(String codeEventRenYuanType) {
		this.codeEventRenYuanType = codeEventRenYuanType;
	}

	public String getDangShiRenAddress() {
		return dangShiRenAddress;
	}

	public void setDangShiRenAddress(String dangShiRenAddress) {
		this.dangShiRenAddress = dangShiRenAddress;
	}

	public String getDangShiRenName() {
		return dangShiRenName;
	}

	public void setDangShiRenName(String dangShiRenName) {
		this.dangShiRenName = dangShiRenName;
	}

	public String getCodeNation() {
		return codeNation;
	}

	public void setCodeNation(String codeNation) {
		this.codeNation = codeNation;
	}

	public String getDangShiRenPhone() {
		return dangShiRenPhone;
	}

	public void setDangShiRenPhone(String dangShiRenPhone) {
		this.dangShiRenPhone = dangShiRenPhone;
	}

}
