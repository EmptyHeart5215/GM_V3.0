package com.dykj.GSM.model.base;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 特殊人群中的精神病
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerTSJingShenMapper")
public class BPerTSJingShen extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 家庭经济状况
	 */
	private String codeJingJiSituation;
	/**
	 * 是否纳入低保
	 */
	@NotNull
	private Boolean isDiBao;
	/**
	 * 监护人公民身份号码
	 */
	private String jianHuCid;
	/**
	 * 监护人姓名
	 */
	@NotBlank
	private String jianHuName;
	/**
	 * 监护人联系方式
	 */
	@NotBlank
	private String jianHuPhone;
	/**
	 * 初次发病日期
	 */
	private String firstIllDate;
	/**
	 * 目前诊断类型
	 */
	@NotBlank
	private String codeZhenDuanType;
	/**
	 * 有无肇事肇祸史
	 */
	@NotNull
	private Boolean isZhaoShi;
	/**
	 * 肇事肇祸次数
	 */
	private BigDecimal zhaoShiCount;
	/**
	 * 上次肇事肇祸日期
	 */
	private String lastZhaoShiDate;
	/**
	 * 目前危险性评估等级
	 */
	@NotBlank
	private String codeWeiXianClasses;
	/**
	 * 治疗情况
	 */
	@NotBlank
	private String codeZhiLiaoSituation;
	/**
	 * 治疗医院名称
	 */
	private String yiYuanName;
	/**
	 * 实施住院治疗原因 可多选
	 */
	private String codeZhuYuanReason;
	/**
	 * 接收康复训练机构名称
	 */
	private String jiGouName;
	/**
	 * 参与管理人员 可多选
	 */
	private String codeManagePeople;
	/**
	 * 帮扶情况 可多选
	 */
	private String codeBangFuSituation;
	@Transient
	private BPerson person;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getCodeJingJiSituation() {
		return codeJingJiSituation;
	}

	public void setCodeJingJiSituation(String codeJingJiSituation) {
		this.codeJingJiSituation = codeJingJiSituation;
	}

	public Boolean getIsDiBao() {
		return isDiBao;
	}

	public void setIsDiBao(Boolean isDiBao) {
		this.isDiBao = isDiBao;
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

	public String getJianHuPhone() {
		return jianHuPhone;
	}

	public void setJianHuPhone(String jianHuPhone) {
		this.jianHuPhone = jianHuPhone;
	}

	public String getFirstIllDate() {
		return firstIllDate;
	}

	public void setFirstIllDate(String firstIllDate) {
		this.firstIllDate = firstIllDate;
	}

	public String getCodeZhenDuanType() {
		return codeZhenDuanType;
	}

	public void setCodeZhenDuanType(String codeZhenDuanType) {
		this.codeZhenDuanType = codeZhenDuanType;
	}

	public Boolean getIsZhaoShi() {
		return isZhaoShi;
	}

	public void setIsZhaoShi(Boolean isZhaoShi) {
		this.isZhaoShi = isZhaoShi;
	}

	public BigDecimal getZhaoShiCount() {
		return zhaoShiCount;
	}

	public void setZhaoShiCount(BigDecimal zhaoShiCount) {
		this.zhaoShiCount = zhaoShiCount;
	}

	public String getLastZhaoShiDate() {
		return lastZhaoShiDate;
	}

	public void setLastZhaoShiDate(String lastZhaoShiDate) {
		this.lastZhaoShiDate = lastZhaoShiDate;
	}

	public String getCodeWeiXianClasses() {
		return codeWeiXianClasses;
	}

	public void setCodeWeiXianClasses(String codeWeiXianClasses) {
		this.codeWeiXianClasses = codeWeiXianClasses;
	}

	public String getCodeZhiLiaoSituation() {
		return codeZhiLiaoSituation;
	}

	public void setCodeZhiLiaoSituation(String codeZhiLiaoSituation) {
		this.codeZhiLiaoSituation = codeZhiLiaoSituation;
	}

	public String getYiYuanName() {
		return yiYuanName;
	}

	public void setYiYuanName(String yiYuanName) {
		this.yiYuanName = yiYuanName;
	}

	public String getCodeZhuYuanReason() {
		return codeZhuYuanReason;
	}

	public void setCodeZhuYuanReason(String codeZhuYuanReason) {
		this.codeZhuYuanReason = codeZhuYuanReason;
	}

	public String getJiGouName() {
		return jiGouName;
	}

	public void setJiGouName(String jiGouName) {
		this.jiGouName = jiGouName;
	}

	public String getCodeManagePeople() {
		return codeManagePeople;
	}

	public void setCodeManagePeople(String codeManagePeople) {
		this.codeManagePeople = codeManagePeople;
	}

	public String getCodeBangFuSituation() {
		return codeBangFuSituation;
	}

	public void setCodeBangFuSituation(String codeBangFuSituation) {
		this.codeBangFuSituation = codeBangFuSituation;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
