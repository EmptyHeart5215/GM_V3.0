package com.dykj.GSM.model.base;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerTSXieJiaoMapper")
public class BPerTSXieJiao extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 邪教名称
	 */
	@NotBlank
	private String xieJiaoName;
	/**
	 * 开始时间
	 */
	@NotBlank
	private String beginDate;
	/**
	 * 练功原因
	 */
	@NotBlank
	private String reason;
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
	 * 帮扶情况
	 */
	private String bangFuRemark;
	/**
	 * 现实表现
	 */
	private String performance;
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

	public String getXieJiaoName() {
		return xieJiaoName;
	}

	public void setXieJiaoName(String xieJiaoName) {
		this.xieJiaoName = xieJiaoName;
	}

	public String getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}

	public String getPerformance() {
		return performance;
	}

	public void setPerformance(String performance) {
		this.performance = performance;
	}
}
