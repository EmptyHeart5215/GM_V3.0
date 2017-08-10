package com.dykj.GSM.model.base;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 城市部件表
 * 
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPartsMapper")
public class BParts extends BaseModel {
	/**
	 * 所属辖区或部门
	 */
	@NotBlank
	private String gridCode;
	/**
	 * 部件名称
	 */
	@NotBlank
	private String name;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 类型
	 */
	private String codeBigType;
	/**
	 * 权属单位
	 */
	private String belong;
	/**
	 * 权属单位负责人
	 */
	private String belongMan;
	/**
	 * 权属单位负责人职务
	 */
	private String belongDuty;
	/**
	 * 权属单位负责人电话
	 */
	private String belongPhone;
	/**
	 * 养护单位
	 */
	private String care;
	/**
	 * 养护单位负责人职务
	 */
	private String careDuty;
	/**
	 * 养护单位负责人
	 */
	private String careMan;
	/**
	 * 养护单位负责人电话
	 */
	private String carePhone;
	/**
	 * 部件状态
	 */
	private String codePartsStatus;
	/**
	 * 管理单位负责人职务
	 */
	private String enterpriseDuty;
	/**
	 * 管理单位负责人
	 */
	private String enterpriseMan;
	/**
	 * 管理单位
	 */
	private String enterpriseManage;
	/**
	 * 管理单位负责人电话
	 */
	private String enterprisePhone;
	/**
	 * 网格联系人
	 */
	private String gridContacts;
	/**
	 * 网格联系人职务
	 */
	private String gridContactsDuty;
	/**
	 * 网格联系人电话
	 */
	private String gridContactsPhone;
	/**
	 * 部件编码
	 */
	private String partsCode;
	/**
	 * 部件图片
	 */
	private String picture;
	/**
	 * 地图定位
	 */
	@NotBlank
	private String position;
	/**
	 * 小类
	 */
	private String codeSmallType;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getBelongDuty() {
		return belongDuty;
	}

	public void setBelongDuty(String belongDuty) {
		this.belongDuty = belongDuty;
	}

	public String getBelongMan() {
		return belongMan;
	}

	public void setBelongMan(String belongMan) {
		this.belongMan = belongMan;
	}

	public String getBelongPhone() {
		return belongPhone;
	}

	public void setBelongPhone(String belongPhone) {
		this.belongPhone = belongPhone;
	}

	public String getCare() {
		return care;
	}

	public void setCare(String care) {
		this.care = care;
	}

	public String getCareDuty() {
		return careDuty;
	}

	public void setCareDuty(String careDuty) {
		this.careDuty = careDuty;
	}

	public String getCareMan() {
		return careMan;
	}

	public void setCareMan(String careMan) {
		this.careMan = careMan;
	}

	public String getCarePhone() {
		return carePhone;
	}

	public void setCarePhone(String carePhone) {
		this.carePhone = carePhone;
	}

	public String getEnterpriseDuty() {
		return enterpriseDuty;
	}

	public void setEnterpriseDuty(String enterpriseDuty) {
		this.enterpriseDuty = enterpriseDuty;
	}

	public String getEnterpriseMan() {
		return enterpriseMan;
	}

	public void setEnterpriseMan(String enterpriseMan) {
		this.enterpriseMan = enterpriseMan;
	}

	public String getEnterpriseManage() {
		return enterpriseManage;
	}

	public void setEnterpriseManage(String enterpriseManage) {
		this.enterpriseManage = enterpriseManage;
	}

	public String getEnterprisePhone() {
		return enterprisePhone;
	}

	public void setEnterprisePhone(String enterprisePhone) {
		this.enterprisePhone = enterprisePhone;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getGridContacts() {
		return gridContacts;
	}

	public void setGridContacts(String gridContacts) {
		this.gridContacts = gridContacts;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPartsCode() {
		return partsCode;
	}

	public void setPartsCode(String partsCode) {
		this.partsCode = partsCode;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCodePartsStatus() {
		return codePartsStatus;
	}

	public void setCodePartsStatus(String codePartsStatus) {
		this.codePartsStatus = codePartsStatus;
	}

	public String getGridContactsDuty() {
		return gridContactsDuty;
	}

	public void setGridContactsDuty(String gridContactsDuty) {
		this.gridContactsDuty = gridContactsDuty;
	}

	public String getGridContactsPhone() {
		return gridContactsPhone;
	}

	public void setGridContactsPhone(String gridContactsPhone) {
		this.gridContactsPhone = gridContactsPhone;
	}

	public String getCodeBigType() {
		return codeBigType;
	}

	public void setCodeBigType(String codeBigType) {
		this.codeBigType = codeBigType;
	}

	public String getCodeSmallType() {
		return codeSmallType;
	}

	public void setCodeSmallType(String codeSmallType) {
		this.codeSmallType = codeSmallType;
	}
	
}
