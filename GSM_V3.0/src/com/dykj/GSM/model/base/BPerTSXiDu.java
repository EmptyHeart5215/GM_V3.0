package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 特殊人群中的吸毒
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerTSXiDuMapper")
public class BPerTSXiDu extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 初次发现日期
	 */
	@NotBlank
	private String firstDate;
	/**
	 * 管控情况
	 */
	@NotBlank
	private String codeGuanKong;
	/**
	 * 管控人姓名
	 */
	@NotBlank
	private String guanKongName;
	/**
	 * 管控人联系方式
	 */
	@NotBlank
	private String guanKongPhone;
	/**
	 * 帮扶情况
	 */
	private String bangFuRemark;
	/**
	 * 帮扶人姓名
	 */
	@NotBlank
	private String bangFuName;
	/**
	 * 帮扶人联系方式
	 */
	@NotBlank
	private String bangFuPhone;
	/**
	 * 有无犯罪史
	 */
	@NotNull
	private Boolean isFanZui;
	/**
	 * 犯罪情况
	 */
	private String fanZuiRemark;
	/**
	 * 吸毒原因
	 */
	private String codeXiDuReason;
	/**
	 * 吸毒后果
	 */
	private String codeXiDuEffect;
	@Transient
	private BPerson person;

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getFirstDate() {
		return firstDate;
	}

	public void setFirstDate(String firstDate) {
		this.firstDate = firstDate;
	}

	public String getCodeGuanKong() {
		return codeGuanKong;
	}

	public void setCodeGuanKong(String codeGuanKong) {
		this.codeGuanKong = codeGuanKong;
	}

	public String getGuanKongName() {
		return guanKongName;
	}

	public void setGuanKongName(String guanKongName) {
		this.guanKongName = guanKongName;
	}

	public String getGuanKongPhone() {
		return guanKongPhone;
	}

	public void setGuanKongPhone(String guanKongPhone) {
		this.guanKongPhone = guanKongPhone;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}

	public String getBangFuName() {
		return bangFuName;
	}

	public void setBangFuName(String bangFuName) {
		this.bangFuName = bangFuName;
	}

	public String getBangFuPhone() {
		return bangFuPhone;
	}

	public void setBangFuPhone(String bangFuPhone) {
		this.bangFuPhone = bangFuPhone;
	}

	public Boolean getIsFanZui() {
		return isFanZui;
	}

	public void setIsFanZui(Boolean isFanZui) {
		this.isFanZui = isFanZui;
	}

	public String getFanZuiRemark() {
		return fanZuiRemark;
	}

	public void setFanZuiRemark(String fanZuiRemark) {
		this.fanZuiRemark = fanZuiRemark;
	}

	public String getCodeXiDuReason() {
		return codeXiDuReason;
	}

	public void setCodeXiDuReason(String codeXiDuReason) {
		this.codeXiDuReason = codeXiDuReason;
	}

	public String getCodeXiDuEffect() {
		return codeXiDuEffect;
	}

	public void setCodeXiDuEffect(String codeXiDuEffect) {
		this.codeXiDuEffect = codeXiDuEffect;
	}
}
