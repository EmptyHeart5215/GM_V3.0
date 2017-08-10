package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerTSXingShiMapper")
public class BPerTSXingShi extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 是否累犯
	 */
	@NotNull
	private Boolean isLeiFan;
	/**
	 * 原罪名
	 */
	@NotBlank
	private String codeZuiMing;
	/**
	 * 原判刑期
	 */
	@NotBlank
	private String xingQi;
	/**
	 * 服刑场所
	 */
	@NotBlank
	private String fuXingPlace;
	/**
	 * 释放日期
	 */
	@NotBlank
	private String shiFangDate;
	/**
	 * 危险性评估类型
	 */
	@NotBlank
	private String codeBangJiaoType;
	/**
	 * 衔接日期
	 */
	@NotBlank
	private String xianJieDate;
	/**
	 * 衔接情况
	 */
	@NotBlank
	private String codeXianJieRemark;
	/**
	 * 安置日期
	 */
	@NotBlank
	private String anZhiDate;
	/**
	 * 安置情况
	 */
	@NotBlank
	private String codeAnZhiRemark;
	/**
	 * 未安置原因
	 */
	private String weiAnZhiReason;
	/**
	 * 帮教情况
	 */
	private String helpRemark;
	/**
	 * 是否重新犯罪
	 */
	@NotNull
	private Boolean isAgainFanZui;
	/**
	 * 重新犯罪罪名
	 */
	private String againZuiMing;
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

	public Boolean getIsLeiFan() {
		return isLeiFan;
	}

	public void setIsLeiFan(Boolean isLeiFan) {
		this.isLeiFan = isLeiFan;
	}

	public String getCodeZuiMing() {
		return codeZuiMing;
	}

	public void setCodeZuiMing(String codeZuiMing) {
		this.codeZuiMing = codeZuiMing;
	}

	public String getXingQi() {
		return xingQi;
	}

	public void setXingQi(String xingQi) {
		this.xingQi = xingQi;
	}

	public String getFuXingPlace() {
		return fuXingPlace;
	}

	public void setFuXingPlace(String fuXingPlace) {
		this.fuXingPlace = fuXingPlace;
	}

	public String getShiFangDate() {
		return shiFangDate;
	}

	public void setShiFangDate(String shiFangDate) {
		this.shiFangDate = shiFangDate;
	}

	public String getCodeBangJiaoType() {
		return codeBangJiaoType;
	}

	public void setCodeBangJiaoType(String codeBangJiaoType) {
		this.codeBangJiaoType = codeBangJiaoType;
	}

	public String getXianJieDate() {
		return xianJieDate;
	}

	public void setXianJieDate(String xianJieDate) {
		this.xianJieDate = xianJieDate;
	}

	public String getAnZhiDate() {
		return anZhiDate;
	}

	public void setAnZhiDate(String anZhiDate) {
		this.anZhiDate = anZhiDate;
	}

	public String getCodeXianJieRemark() {
		return codeXianJieRemark;
	}

	public void setCodeXianJieRemark(String codeXianJieRemark) {
		this.codeXianJieRemark = codeXianJieRemark;
	}

	public String getCodeAnZhiRemark() {
		return codeAnZhiRemark;
	}

	public void setCodeAnZhiRemark(String codeAnZhiRemark) {
		this.codeAnZhiRemark = codeAnZhiRemark;
	}

	public String getWeiAnZhiReason() {
		return weiAnZhiReason;
	}

	public void setWeiAnZhiReason(String weiAnZhiReason) {
		this.weiAnZhiReason = weiAnZhiReason;
	}

	public String getHelpRemark() {
		return helpRemark;
	}

	public void setHelpRemark(String helpRemark) {
		this.helpRemark = helpRemark;
	}

	public Boolean getIsAgainFanZui() {
		return isAgainFanZui;
	}

	public void setIsAgainFanZui(Boolean isAgainFanZui) {
		this.isAgainFanZui = isAgainFanZui;
	}

	public String getAgainZuiMing() {
		return againZuiMing;
	}

	public void setAgainZuiMing(String againZuiMing) {
		this.againZuiMing = againZuiMing;
	}
}
