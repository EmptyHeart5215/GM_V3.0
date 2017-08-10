package com.dykj.GSM.model.base;

import java.math.BigDecimal;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerLiuShouMapper")
public class BPerLiuShou extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 是否人户一致
	 */
	@NotNull
	private Boolean isRenHuYiZhi;
	/**
	 * 健康状况
	 */
	private String codeHealth;
	/**
	 * 个人年收入
	 */
	private BigDecimal geRenIncome;
	/**
	 * 留守人员类型
	 */
	@NotBlank
	private String codeLiuShouType;
	/**
	 * 家庭主要成员
	 */
	@NotBlank
	private String zhuYaoMember;
	/**
	 * 与留守人员关系
	 */
	@NotBlank
	private String codeLiuShouRelation;
	/**
	 * 家庭主要成员身份证号
	 */
	@NotBlank
	private String memberCid;
	/**
	 * 家庭主要成员健康状况
	 */
	private String codeMemberHealth;
	/**
	 * 家庭主要成员联系电话
	 */
	@NotBlank
	private String memberPhone;
	/**
	 * 家庭主要成员工作详细地址
	 */
	private String memberWorkAddress;
	/**
	 * 家庭年收入
	 */
	private String homeIncome;
	/**
	 * 困难及诉求
	 */
	private String kuNanRemark;
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

	public Boolean getIsRenHuYiZhi() {
		return isRenHuYiZhi;
	}

	public void setIsRenHuYiZhi(Boolean isRenHuYiZhi) {
		this.isRenHuYiZhi = isRenHuYiZhi;
	}

	public BigDecimal getGeRenIncome() {
		return geRenIncome;
	}

	public void setGeRenIncome(BigDecimal geRenIncome) {
		this.geRenIncome = geRenIncome;
	}

	public String getCodeLiuShouType() {
		return codeLiuShouType;
	}

	public void setCodeLiuShouType(String codeLiuShouType) {
		this.codeLiuShouType = codeLiuShouType;
	}

	public String getZhuYaoMember() {
		return zhuYaoMember;
	}

	public void setZhuYaoMember(String zhuYaoMember) {
		this.zhuYaoMember = zhuYaoMember;
	}

	public String getCodeLiuShouRelation() {
		return codeLiuShouRelation;
	}

	public void setCodeLiuShouRelation(String codeLiuShouRelation) {
		this.codeLiuShouRelation = codeLiuShouRelation;
	}

	public String getMemberCid() {
		return memberCid;
	}

	public void setMemberCid(String memberCid) {
		this.memberCid = memberCid;
	}

	public String getCodeHealth() {
		return codeHealth;
	}

	public void setCodeHealth(String codeHealth) {
		this.codeHealth = codeHealth;
	}

	public String getMemberPhone() {
		return memberPhone;
	}

	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}

	public String getMemberWorkAddress() {
		return memberWorkAddress;
	}

	public void setMemberWorkAddress(String memberWorkAddress) {
		this.memberWorkAddress = memberWorkAddress;
	}

	public String getHomeIncome() {
		return homeIncome;
	}

	public void setHomeIncome(String homeIncome) {
		this.homeIncome = homeIncome;
	}

	public String getKuNanRemark() {
		return kuNanRemark;
	}

	public void setKuNanRemark(String kuNanRemark) {
		this.kuNanRemark = kuNanRemark;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}

	public String getCodeMemberHealth() {
		return codeMemberHealth;
	}

	public void setCodeMemberHealth(String codeMemberHealth) {
		this.codeMemberHealth = codeMemberHealth;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
