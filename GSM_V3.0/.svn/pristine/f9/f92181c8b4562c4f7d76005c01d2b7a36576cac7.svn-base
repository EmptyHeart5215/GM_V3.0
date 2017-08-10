package com.dykj.GSM.model.base;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月17日 下午5:14:10
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:困难职工
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerBfKunNanZhiGongMapper")
public class BPerBfKunNanZhiGong extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 情况说明
	 */
	@NotBlank
	private String description;
	/**
	 * 帮扶情况
	 */
	private String bangFuRemark;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}
}
