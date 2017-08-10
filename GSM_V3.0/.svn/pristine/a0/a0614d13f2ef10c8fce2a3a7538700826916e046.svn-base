package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerTSJiaoZhengMapper")
public class BPerTSJiaoZheng extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 社区矫正人员编号
	 */
	@NotBlank
	private String rectifyNum;
	/**
	 * 原羁押场所
	 */
	private String jiYaPlace;
	/**
	 * 矫正类别
	 */
	@NotBlank
	private String codeRectifyType;
	/**
	 * 案件类别
	 */
	@NotBlank
	private String codeAnJianType;
	/**
	 * 具体罪名
	 */
	@NotBlank
	private String zuiMing;
	/**
	 * 原判刑期
	 */
	private String xingQi;
	/**
	 * 原判刑开始日期
	 */
	private String xingQiBeginDate;
	/**
	 * 原判刑结束日期
	 */
	private String xingQiEndDate;
	/**
	 * 矫正开始日期
	 */
	@NotBlank
	private String rectifyBeginDate;
	/**
	 * 矫正结束日期
	 */
	@NotBlank
	private String rectifyEndDate;
	/**
	 * 接收方武
	 */
	@NotBlank
	private String codeJieShouType;
	/**
	 * “四史”情况,可多选
	 */
	private String codeSiShi;
	/**
	 * 是否累惯犯
	 */
	private Boolean isGuanFan;
	/**
	 * “三涉”情况,可多选
	 */
	private String codeSanShe;
	/**
	 * 是否建立矫正小组
	 */
	@NotNull
	private Boolean isBuildGroup;
	/**
	 * 矫正小组人员组成情况,可多选
	 */
	@NotBlank
	private String codeGroupSituation;
	/**
	 * 矫正解除（终止）类型
	 */
	private String codeJieChuType;
	/**
	 * 是否有脱管
	 */
	@NotNull
	private Boolean isTuoGuan;
	/**
	 * 脱管原因
	 */
	private String tuoGuanReason;
	/**
	 * 检察监督脱管情况
	 */
	private String jianTuoRemark;
	/**
	 * 脱管纠正情况
	 */
	private String tuoJiaoRemark;
	/**
	 * 是否有漏管
	 */
	@NotNull
	private Boolean isLouGuan;
	/**
	 * 漏管原因
	 */
	private String louGuanReason;
	/**
	 * 检察监督漏管情况
	 */
	private String jianLouRemark;
	/**
	 * 漏管纠正情况
	 */
	private String louJiuRemark;
	/**
	 * 奖惩情况
	 */
	private String jiangChengRemark;
	/**
	 * 刑罚变更执行情况
	 */
	private String xingBianZhiRemark;
	/**
	 * 是否重新犯罪
	 */
	@NotNull
	private Boolean isChongFan;
	/**
	 * 重新犯罪名称
	 */
	private String chongFanName;
	@Transient
	private BPerson person;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getRectifyNum() {
		return rectifyNum;
	}

	public void setRectifyNum(String rectifyNum) {
		this.rectifyNum = rectifyNum;
	}

	public String getJiYaPlace() {
		return jiYaPlace;
	}

	public void setJiYaPlace(String jiYaPlace) {
		this.jiYaPlace = jiYaPlace;
	}

	public String getCodeRectifyType() {
		return codeRectifyType;
	}

	public void setCodeRectifyType(String codeRectifyType) {
		this.codeRectifyType = codeRectifyType;
	}

	public String getCodeAnJianType() {
		return codeAnJianType;
	}

	public void setCodeAnJianType(String codeAnJianType) {
		this.codeAnJianType = codeAnJianType;
	}

	public String getZuiMing() {
		return zuiMing;
	}

	public void setZuiMing(String zuiMing) {
		this.zuiMing = zuiMing;
	}

	public String getXingQi() {
		return xingQi;
	}

	public void setXingQi(String xingQi) {
		this.xingQi = xingQi;
	}

	public String getXingQiBeginDate() {
		return xingQiBeginDate;
	}

	public void setXingQiBeginDate(String xingQiBeginDate) {
		this.xingQiBeginDate = xingQiBeginDate;
	}

	public String getXingQiEndDate() {
		return xingQiEndDate;
	}

	public void setXingQiEndDate(String xingQiEndDate) {
		this.xingQiEndDate = xingQiEndDate;
	}

	public String getRectifyBeginDate() {
		return rectifyBeginDate;
	}

	public void setRectifyBeginDate(String rectifyBeginDate) {
		this.rectifyBeginDate = rectifyBeginDate;
	}

	public String getRectifyEndDate() {
		return rectifyEndDate;
	}

	public void setRectifyEndDate(String rectifyEndDate) {
		this.rectifyEndDate = rectifyEndDate;
	}

	public String getCodeJieShouType() {
		return codeJieShouType;
	}

	public void setCodeJieShouType(String codeJieShouType) {
		this.codeJieShouType = codeJieShouType;
	}

	public String getCodeSiShi() {
		return codeSiShi;
	}

	public void setCodeSiShi(String codeSiShi) {
		this.codeSiShi = codeSiShi;
	}

	public Boolean getIsGuanFan() {
		return isGuanFan;
	}

	public void setIsGuanFan(Boolean isGuanFan) {
		this.isGuanFan = isGuanFan;
	}

	public String getCodeSanShe() {
		return codeSanShe;
	}

	public void setCodeSanShe(String codeSanShe) {
		this.codeSanShe = codeSanShe;
	}

	public Boolean getIsBuildGroup() {
		return isBuildGroup;
	}

	public void setIsBuildGroup(Boolean isBuildGroup) {
		this.isBuildGroup = isBuildGroup;
	}

	public String getCodeGroupSituation() {
		return codeGroupSituation;
	}

	public void setCodeGroupSituation(String codeGroupSituation) {
		this.codeGroupSituation = codeGroupSituation;
	}

	public String getCodeJieChuType() {
		return codeJieChuType;
	}

	public void setCodeJieChuType(String codeJieChuType) {
		this.codeJieChuType = codeJieChuType;
	}

	public Boolean getIsTuoGuan() {
		return isTuoGuan;
	}

	public void setIsTuoGuan(Boolean isTuoGuan) {
		this.isTuoGuan = isTuoGuan;
	}

	public String getTuoGuanReason() {
		return tuoGuanReason;
	}

	public void setTuoGuanReason(String tuoGuanReason) {
		this.tuoGuanReason = tuoGuanReason;
	}

	public String getTuoJiaoRemark() {
		return tuoJiaoRemark;
	}

	public void setTuoJiaoRemark(String tuoJiaoRemark) {
		this.tuoJiaoRemark = tuoJiaoRemark;
	}

	public Boolean getIsLouGuan() {
		return isLouGuan;
	}

	public void setIsLouGuan(Boolean isLouGuan) {
		this.isLouGuan = isLouGuan;
	}

	public String getLouGuanReason() {
		return louGuanReason;
	}

	public void setLouGuanReason(String louGuanReason) {
		this.louGuanReason = louGuanReason;
	}

	public String getJianLouRemark() {
		return jianLouRemark;
	}

	public void setJianLouRemark(String jianLouRemark) {
		this.jianLouRemark = jianLouRemark;
	}

	public String getLouJiuRemark() {
		return louJiuRemark;
	}

	public void setLouJiuRemark(String louJiuRemark) {
		this.louJiuRemark = louJiuRemark;
	}

	public String getJiangChengRemark() {
		return jiangChengRemark;
	}

	public void setJiangChengRemark(String jiangChengRemark) {
		this.jiangChengRemark = jiangChengRemark;
	}

	public String getXingBianZhiRemark() {
		return xingBianZhiRemark;
	}

	public void setXingBianZhiRemark(String xingBianZhiRemark) {
		this.xingBianZhiRemark = xingBianZhiRemark;
	}

	public Boolean getIsChongFan() {
		return isChongFan;
	}

	public void setIsChongFan(Boolean isChongFan) {
		this.isChongFan = isChongFan;
	}

	public String getChongFanName() {
		return chongFanName;
	}

	public void setChongFanName(String chongFanName) {
		this.chongFanName = chongFanName;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}

	public String getJianTuoRemark() {
		return jianTuoRemark;
	}

	public void setJianTuoRemark(String jianTuoRemark) {
		this.jianTuoRemark = jianTuoRemark;
	}
}
