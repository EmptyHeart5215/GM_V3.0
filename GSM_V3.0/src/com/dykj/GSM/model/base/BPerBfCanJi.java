package com.dykj.GSM.model.base;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 帮扶人群中的残疾
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerBfCanJiMapper")
public class BPerBfCanJi extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 残疾证号
	 */
	@NotBlank
	private String num;
	/**
	 * 发证时间
	 */
	private String sendDate;
	/**
	 * 类别
	 */
	@NotBlank
	private String codeDisableType;
	/**
	 * 残疾等级
	 */
	@NotBlank
	private String codeDisableLevel;
	/**
	 * 帮扶情况
	 */
	private String bangFuRemark;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getCodeDisableType() {
		return codeDisableType;
	}

	public void setCodeDisableType(String codeDisableType) {
		this.codeDisableType = codeDisableType;
	}

	public String getCodeDisableLevel() {
		return codeDisableLevel;
	}

	public void setCodeDisableLevel(String codeDisableLevel) {
		this.codeDisableLevel = codeDisableLevel;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}
}
