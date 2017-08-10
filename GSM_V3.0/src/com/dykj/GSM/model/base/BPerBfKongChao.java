package com.dykj.GSM.model.base;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * 
 * @description 帮扶人群中的空巢老人
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerBfKongChaoMapper")
public class BPerBfKongChao extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 年龄
	 */
	@Min(50)
	@Max(120)
	private Integer age;
	/**
	 * 子女去向
	 */
	private String childGo;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getChildGo() {
		return childGo;
	}

	public void setChildGo(String childGo) {
		this.childGo = childGo;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}
}
