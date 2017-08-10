package com.dykj.GSM.model.base;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 帮扶人群中的特困学生
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerBfTeKunShengMapper")
public class BPerBfTeKunSheng extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 年级
	 */
	@NotBlank
	private String codeGrade;
	/**
	 * 就读学校
	 */
	@NotBlank
	private String schoolName;
	/**
	 * 是否低保户
	 */
	@NotNull
	private Boolean isDiBao;
	/**
	 * 帮扶情况
	 */
	private String bangFuRemark;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getCodeGrade() {
		return codeGrade;
	}

	public void setCodeGrade(String codeGrade) {
		this.codeGrade = codeGrade;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Boolean getIsDiBao() {
		return isDiBao;
	}

	public void setIsDiBao(Boolean isDiBao) {
		this.isDiBao = isDiBao;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}
}
