package com.dykj.GSM.model.base;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 帮扶人群中的社会救助
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerBfJiuZhuMapper")
public class BPerBfJiuZhu extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 是否重大疾病
	 */
	@NotNull
	private Boolean isMajorDiseases;
	/**
	 * 疾病名称
	 */
	@NotBlank
	private String disease;
	/**
	 * 救助时间
	 */
	private String assistDate;
	/**
	 * 救助金额
	 */
	private BigDecimal assistAmount;
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

	public Boolean getIsMajorDiseases() {
		return isMajorDiseases;
	}

	public void setIsMajorDiseases(Boolean isMajorDiseases) {
		this.isMajorDiseases = isMajorDiseases;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getAssistDate() {
		return assistDate;
	}

	public void setAssistDate(String assistDate) {
		this.assistDate = assistDate;
	}

	public BigDecimal getAssistAmount() {
		return assistAmount;
	}

	public void setAssistAmount(BigDecimal assistAmount) {
		this.assistAmount = assistAmount;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}
}
