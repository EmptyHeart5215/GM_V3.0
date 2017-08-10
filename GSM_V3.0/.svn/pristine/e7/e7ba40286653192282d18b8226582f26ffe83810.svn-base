package com.dykj.GSM.model.base;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月18日 上午10:22:39
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:资源人群
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerZiYuanMapper")
public class BPerZiYuan extends BaseModel {
	/**
	 * 关联的人的code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 资源类型
	 */
	@NotBlank
	private String codePerResources;
	/**
	 * 职称
	 */
	private String titles;
	/**
	 * 资格证号
	 */
	private String certificate;
	/**
	 * 参加社会组织 （团体）名称
	 */
	private String workcompany;
	/**
	 * 职务
	 */
	private String duty;
	/**
	 * 加入时间
	 */
	private String inDate;
	@Transient
	private BPerson person;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getCodePerResources() {
		return codePerResources;
	}

	public void setCodePerResources(String codePerResources) {
		this.codePerResources = codePerResources;
	}

	public String getTitles() {
		return titles;
	}

	public void setTitles(String titles) {
		this.titles = titles;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getWorkcompany() {
		return workcompany;
	}

	public void setWorkcompany(String workcompany) {
		this.workcompany = workcompany;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
