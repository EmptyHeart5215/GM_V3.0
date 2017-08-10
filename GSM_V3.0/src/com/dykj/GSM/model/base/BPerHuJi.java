package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月3日 下午4:16:44
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:户籍人员信息
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerHuJiMapper")
public class BPerHuJi extends BaseModel {
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
	 * 户口编号
	 */
	@NotBlank
	private String huCode;
	/**
	 * 户主公民身份证号
	 */
	private String huZhuCid;
	/**
	 * 户主姓名
	 */
	private String huZhuName;
	/**
	 * 与户主关系
	 */
	@NotBlank
	private String codeOwnerRelation;
	/**
	 * 户主联系电话
	 */
	private String huZhuContact;
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

	public String getHuCode() {
		return huCode;
	}

	public void setHuCode(String huCode) {
		this.huCode = huCode;
	}

	public String getHuZhuCid() {
		return huZhuCid;
	}

	public void setHuZhuCid(String huZhuCid) {
		this.huZhuCid = huZhuCid;
	}

	public String getHuZhuName() {
		return huZhuName;
	}

	public void setHuZhuName(String huZhuName) {
		this.huZhuName = huZhuName;
	}

	public String getCodeOwnerRelation() {
		return codeOwnerRelation;
	}

	public void setCodeOwnerRelation(String codeOwnerRelation) {
		this.codeOwnerRelation = codeOwnerRelation;
	}

	public String getHuZhuContact() {
		return huZhuContact;
	}

	public void setHuZhuContact(String huZhuContact) {
		this.huZhuContact = huZhuContact;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
