package com.dykj.GSM.model.base;

import java.math.BigDecimal;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 帮扶人群中的低保户
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerBfDiBaoMapper")
public class BPerBfDiBao extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 低保证号码
	 */
	@NotBlank
	private String lowProtectNum;
	/**
	 * 发证时间
	 */
	@NotBlank
	private String sendDate;
	/**
	 * 是否五保户
	 */
	private Boolean isFiveProtect;
	/**
	 * 保障人口
	 */
	@Min(0)
	private Integer guarantee;
	/**
	 * 户月保障金额
	 */
	@Min(0)
	private BigDecimal monthGuarantee;
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

	public String getLowProtectNum() {
		return lowProtectNum;
	}

	public void setLowProtectNum(String lowProtectNum) {
		this.lowProtectNum = lowProtectNum;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}

	public Boolean getIsFiveProtect() {
		return isFiveProtect;
	}

	public void setIsFiveProtect(Boolean isFiveProtect) {
		this.isFiveProtect = isFiveProtect;
	}

	public Integer getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(Integer guarantee) {
		this.guarantee = guarantee;
	}

	public BigDecimal getMonthGuarantee() {
		return monthGuarantee;
	}

	public void setMonthGuarantee(BigDecimal monthGuarantee) {
		this.monthGuarantee = monthGuarantee;
	}
}
