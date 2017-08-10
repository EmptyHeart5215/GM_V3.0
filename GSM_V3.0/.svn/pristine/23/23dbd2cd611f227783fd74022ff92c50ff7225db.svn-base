package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 重点青少年
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerQingShaoNianMapper")
public class BPerQingShaoNian extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 人员类型
	 */
	@NotBlank
	private String codeQsnType;
	/**
	 * 家庭情况
	 */
	@NotBlank
	private String codeJiaTingSituation;
	/**
	 * 监护人公民身份号码
	 */
	@NotBlank
	private String jianHuCid;
	/**
	 * 监护人姓名
	 */
	@NotBlank
	private String jianHuName;
	/**
	 * 与监护人关系
	 */
	@NotBlank
	private String codeJianHuRelation;
	/**
	 * 监护人联系方式
	 */
	@NotBlank
	private String jianHuPhone;
	/**
	 * 监护人居住详址
	 */
	@NotBlank
	private String jianHuAddress;
	/**
	 * 是否违法犯罪
	 */
	@NotNull
	private Boolean isFanZui;
	/**
	 * 违法犯罪情况
	 */
	private String fanZuiRemark;
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
	 * 帮扶手段
	 */
	@NotBlank
	private String codeBangFuType;
	/**
	 * 帮扶情况
	 */
	private String bangFuRemark;
	@Transient
	private BPerson person;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getCodeQsnType() {
		return codeQsnType;
	}

	public void setCodeQsnType(String codeQsnType) {
		this.codeQsnType = codeQsnType;
	}

	public String getCodeJiaTingSituation() {
		return codeJiaTingSituation;
	}

	public void setCodeJiaTingSituation(String codeJiaTingSituation) {
		this.codeJiaTingSituation = codeJiaTingSituation;
	}

	public String getJianHuCid() {
		return jianHuCid;
	}

	public void setJianHuCid(String jianHuCid) {
		this.jianHuCid = jianHuCid;
	}

	public String getJianHuName() {
		return jianHuName;
	}

	public void setJianHuName(String jianHuName) {
		this.jianHuName = jianHuName;
	}

	public String getCodeJianHuRelation() {
		return codeJianHuRelation;
	}

	public void setCodeJianHuRelation(String codeJianHuRelation) {
		this.codeJianHuRelation = codeJianHuRelation;
	}

	public String getJianHuPhone() {
		return jianHuPhone;
	}

	public void setJianHuPhone(String jianHuPhone) {
		this.jianHuPhone = jianHuPhone;
	}

	public String getJianHuAddress() {
		return jianHuAddress;
	}

	public void setJianHuAddress(String jianHuAddress) {
		this.jianHuAddress = jianHuAddress;
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

	public String getCodeBangFuType() {
		return codeBangFuType;
	}

	public void setCodeBangFuType(String codeBangFuType) {
		this.codeBangFuType = codeBangFuType;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
