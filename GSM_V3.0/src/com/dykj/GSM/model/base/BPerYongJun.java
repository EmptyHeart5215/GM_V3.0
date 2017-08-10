package com.dykj.GSM.model.base;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月18日 上午8:47:13
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:拥军优抚
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerYongJunMapper")
public class BPerYongJun extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 类别
	 */
	@NotBlank
	private String codeSamc;
	/**
	 * 是否置业
	 */
	private Boolean isHousePurchasing;
	/**
	 * 入伍时间
	 */
	private String enlistDate;
	/**
	 * 退伍时间
	 */
	private String veteransDate;
	/**
	 * 优抚证号码
	 */
	private String specialPermitNum;
	/**
	 * 发证日期
	 */
	private String sendDate;
	/**
	 * 帮扶人员
	 */
	private String bangFuName;
	/**
	 * 帮扶人联系方式
	 */
	private String bangFuPhone;
	/**
	 * 优抚情况
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

	public String getCodeSamc() {
		return codeSamc;
	}

	public void setCodeSamc(String codeSamc) {
		this.codeSamc = codeSamc;
	}

	public Boolean getIsHousePurchasing() {
		return isHousePurchasing;
	}

	public void setIsHousePurchasing(Boolean isHousePurchasing) {
		this.isHousePurchasing = isHousePurchasing;
	}

	public String getEnlistDate() {
		return enlistDate;
	}

	public void setEnlistDate(String enlistDate) {
		this.enlistDate = enlistDate;
	}

	public String getVeteransDate() {
		return veteransDate;
	}

	public void setVeteransDate(String veteransDate) {
		this.veteransDate = veteransDate;
	}

	public String getSpecialPermitNum() {
		return specialPermitNum;
	}

	public void setSpecialPermitNum(String specialPermitNum) {
		this.specialPermitNum = specialPermitNum;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
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

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
