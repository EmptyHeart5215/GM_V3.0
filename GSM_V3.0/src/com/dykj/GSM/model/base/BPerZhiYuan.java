package com.dykj.GSM.model.base;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月18日 上午10:22:19
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:志愿者
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerZhiYuanMapper")
public class BPerZhiYuan extends BaseModel {
	/**
	 * 关联的人的code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 类别
	 */
	@NotBlank
	private String codeVolunteerType;
	@Transient
	private BPerson person;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getCodeVolunteerType() {
		return codeVolunteerType;
	}

	public void setCodeVolunteerType(String codeVolunteerType) {
		this.codeVolunteerType = codeVolunteerType;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
