package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月3日 下午2:58:04
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:流动人口表
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerLiuDongMapper")
public class BPerLiuDong extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 流入原因
	 */
	@NotBlank
	private String codeInflowReason;
	/**
	 * 办证的类型
	 */
	private String codeIdType;
	/**
	 * 证件号码
	 */
	private String cid;
	/**
	 * 登记日期
	 */
	private String registDate;
	/**
	 * 证件到期日期
	 */
	private String endDate;
	/**
	 * 住所类型
	 */
	@NotBlank
	private String codeZhuSuoType;
	/**
	 * 是否重点关注人员
	 */
	@NotNull
	private Boolean isGuanZhu;
	@Transient
	private BPerson person;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getCodeInflowReason() {
		return codeInflowReason;
	}

	public void setCodeInflowReason(String codeInflowReason) {
		this.codeInflowReason = codeInflowReason;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getRegistDate() {
		return registDate;
	}

	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCodeZhuSuoType() {
		return codeZhuSuoType;
	}

	public void setCodeZhuSuoType(String codeZhuSuoType) {
		this.codeZhuSuoType = codeZhuSuoType;
	}

	public Boolean getIsGuanZhu() {
		return isGuanZhu;
	}

	public void setIsGuanZhu(Boolean isGuanZhu) {
		this.isGuanZhu = isGuanZhu;
	}

	public String getCodeIdType() {
		return codeIdType;
	}

	public void setCodeIdType(String codeIdType) {
		this.codeIdType = codeIdType;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
