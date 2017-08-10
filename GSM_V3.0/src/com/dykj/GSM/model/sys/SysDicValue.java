package com.dykj.GSM.model.sys;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 字典值表
 * 
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysDicValueMapper")
public class SysDicValue extends BaseModel {
	/**
	 * 字典值名称
	 */
	@NotBlank
	private String dicValue;
	/**
	 * 从属字典code
	 */
	@NotBlank
	private String dicCode;
	/**
	 * 父节点code
	 */
	private String parentCode;
	/**
	 * 全名，主要用于有树形结构的字典
	 */
	private String totalName;

	public String getDicValue() {
		return dicValue;
	}

	public void setDicValue(String dicValue) {
		this.dicValue = dicValue;
	}

	public String getDicCode() {
		return dicCode;
	}

	public void setDicCode(String dicCode) {
		this.dicCode = dicCode;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getTotalName() {
		return totalName;
	}

	public void setTotalName(String totalName) {
		this.totalName = totalName;
	}
}
