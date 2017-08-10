package com.dykj.GSM.model.base;

import java.math.BigDecimal;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月17日 下午3:55:45
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:五保户
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerBfWuBaoMapper")
public class BPerBfWuBao extends BaseModel {
	/**
	 * 人口基本信息关联code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 五保证号码
	 */
	@NotBlank
	private String numberFive;
	/**
	 * 保证人口
	 */
	@Min(0)
	private Integer guarantee;
	/**
	 * 户月保障金额
	 */
	@Min(0)
	private BigDecimal monthGuarantee;
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

	public String getNumberFive() {
		return numberFive;
	}

	public void setNumberFive(String numberFive) {
		this.numberFive = numberFive;
	}

	public Integer getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(Integer guarantee) {
		this.guarantee = guarantee;
	}

	public BigDecimal getMonthGuarantee() {
		return monthGuarantee;
	}

	public void setMonthGuarantee(BigDecimal monthGuarantee) {
		this.monthGuarantee = monthGuarantee;
	}

	public String getBangFuRemark() {
		return bangFuRemark;
	}

	public void setBangFuRemark(String bangFuRemark) {
		this.bangFuRemark = bangFuRemark;
	}
}
