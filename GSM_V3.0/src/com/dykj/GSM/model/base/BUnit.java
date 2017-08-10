package com.dykj.GSM.model.base;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BUnitMapper")
public class BUnit extends BaseModel {
	/**
	 * 单元名称
	 */
	@NotBlank
	private String name;
	/**
	 * 所属楼栋
	 */
	@NotBlank
	private String buildCode;
	/**
	 * 所属网格
	 */
	private String gridCode;
	/**
	 * 所属楼栋名称
	 */
	@Transient
	private String buildName;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 登记时间
	 */
	private String registerDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuildCode() {
		return buildCode;
	}

	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
}
