package com.dykj.GSM.model.emergencyscheduling;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 应急物资
 * 
 * @authory wangmingyuan
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.emergencyscheduling.mapperinterf.EmergencySuppliesMapper")
public class EmergencySupplies extends BaseModel {
	/**
	 * 所属辖区
	 */
	@NotBlank
	private String gridCode;
	/**
	 * 物资存放地址
	 */
	@NotBlank
	private String suppliesStoreAddress;
	/**
	 * 物资负责人
	 */
	@NotBlank
	private String suppliesprincipal;
	/**
	 * 物资负责人联系电话
	 */
	@NotBlank
	private String suppliesPhone;
	/**
	 * 物资数量
	 */
	@NotBlank
	private String suppliesNum;
	/**
	 * 物资类型（字典表）
	 */
	@NotBlank
	private String codeSuppliesType;
	/**
	 * 物资状态(字典表)
	 */
	@NotBlank
	private String codeSuppliesState;
	/**
	 * 物资名称
	 */
	@NotBlank
	private String suppliesName;
	/**
	 * 地图定位
	 */
	@NotBlank
	private String position;

	public String getSuppliesStoreAddress() {
		return suppliesStoreAddress;
	}

	public void setSuppliesStoreAddress(String suppliesStoreAddress) {
		this.suppliesStoreAddress = suppliesStoreAddress;
	}

	public String getSuppliesprincipal() {
		return suppliesprincipal;
	}

	public void setSuppliesprincipal(String suppliesprincipal) {
		this.suppliesprincipal = suppliesprincipal;
	}

	public String getSuppliesPhone() {
		return suppliesPhone;
	}

	public void setSuppliesPhone(String suppliesPhone) {
		this.suppliesPhone = suppliesPhone;
	}

	public String getSuppliesNum() {
		return suppliesNum;
	}

	public void setSuppliesNum(String suppliesNum) {
		this.suppliesNum = suppliesNum;
	}

	public String getCodeSuppliesType() {
		return codeSuppliesType;
	}

	public void setCodeSuppliesType(String codeSuppliesType) {
		this.codeSuppliesType = codeSuppliesType;
	}

	public String getCodeSuppliesState() {
		return codeSuppliesState;
	}

	public void setCodeSuppliesState(String codeSuppliesState) {
		this.codeSuppliesState = codeSuppliesState;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getSuppliesName() {
		return suppliesName;
	}

	public void setSuppliesName(String suppliesName) {
		this.suppliesName = suppliesName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
