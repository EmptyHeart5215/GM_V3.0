package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 特殊人群中的艾滋病
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerTSAiZiMapper")
public class BPerTSAiZi extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 感染途径
	 */
	@NotBlank
	private String codeGanRanRoute;
	/**
	 * 是否有违法犯罪史
	 */
	@NotNull
	private Boolean isFanZui;
	/**
	 * 违法犯罪情况
	 */
	private String fanZuiRemark;
	/**
	 * 案件类别
	 */
	private String codeAnJianType;
	/**
	 * 关注类型
	 */
	@NotBlank
	private String codeGuanZhuType;
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
	 * 收治情况
	 */
	private String codeShouZhiSituation;
	/**
	 * 牧治机构名称
	 */
	private String shouZhiJiGou;
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

	public String getCodeGanRanRoute() {
		return codeGanRanRoute;
	}

	public void setCodeGanRanRoute(String codeGanRanRoute) {
		this.codeGanRanRoute = codeGanRanRoute;
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

	public String getCodeAnJianType() {
		return codeAnJianType;
	}

	public void setCodeAnJianType(String codeAnJianType) {
		this.codeAnJianType = codeAnJianType;
	}

	public String getCodeGuanZhuType() {
		return codeGuanZhuType;
	}

	public void setCodeGuanZhuType(String codeGuanZhuType) {
		this.codeGuanZhuType = codeGuanZhuType;
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

	public String getCodeShouZhiSituation() {
		return codeShouZhiSituation;
	}

	public void setCodeShouZhiSituation(String codeShouZhiSituation) {
		this.codeShouZhiSituation = codeShouZhiSituation;
	}

	public String getShouZhiJiGou() {
		return shouZhiJiGou;
	}

	public void setShouZhiJiGou(String shouZhiJiGou) {
		this.shouZhiJiGou = shouZhiJiGou;
	}
}
