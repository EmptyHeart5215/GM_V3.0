package com.dykj.GSM.model.base;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BRoadConvenientMapper")
public class BRoadConvenient extends BaseModel {
	/**
	 * 所属辖区或部门  
	 */
	private String gridCode ;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 线路类型 
	 */
	private String codeLineType; 
	/**
	 * 隶属单位名称
	 */
	private String unitName;
	/**
	 * 隶属单位详址
	 */
	private String unitAddress;
	/**
	 * 隶属单位联系方式
	 */
	private String unitPhone;
    /**
     * 隶属单位负责人姓名
     */
	private String unitManager;
    /**
     * 隶属单位负责人联系方式
     */
	private String unitManagerPhone;
    /**
     * 管辖单位名称 
     */
	private String controlUnitName;
    /**
     * 管辖单位详址
     */
	private String controlUnitAddress;
    /**
     * 管辖单位联系方式 
     */
	private String controlUnitPhone;
    /**
     * 分管治保负责人姓名 
     */
	private String chargeManager;
    /**
     * 分管治保负责人联系方式 
     */
	private String chargeManagerPhone;
    /**
     * 治安隐患情况 
     */
	private String securityDanger;
    /**
     * 治安隐患等级 
     */
	private String codeSecurityLevel ;
	public String getGridCode() {
		return gridCode;
	}
	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCodeLineType() {
		return codeLineType;
	}
	public void setCodeLineType(String codeLineType) {
		this.codeLineType = codeLineType;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public String getUnitAddress() {
		return unitAddress;
	}
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
	}
	public String getUnitPhone() {
		return unitPhone;
	}
	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}
	public String getUnitManager() {
		return unitManager;
	}
	public void setUnitManager(String unitManager) {
		this.unitManager = unitManager;
	}
	public String getUnitManagerPhone() {
		return unitManagerPhone;
	}
	public void setUnitManagerPhone(String unitManagerPhone) {
		this.unitManagerPhone = unitManagerPhone;
	}
	public String getControlUnitName() {
		return controlUnitName;
	}
	public void setControlUnitName(String controlUnitName) {
		this.controlUnitName = controlUnitName;
	}
	public String getControlUnitAddress() {
		return controlUnitAddress;
	}
	public void setControlUnitAddress(String controlUnitAddress) {
		this.controlUnitAddress = controlUnitAddress;
	}
	public String getControlUnitPhone() {
		return controlUnitPhone;
	}
	public void setControlUnitPhone(String controlUnitPhone) {
		this.controlUnitPhone = controlUnitPhone;
	}
	public String getChargeManager() {
		return chargeManager;
	}
	public void setChargeManager(String chargeManager) {
		this.chargeManager = chargeManager;
	}
	public String getChargeManagerPhone() {
		return chargeManagerPhone;
	}
	public void setChargeManagerPhone(String chargeManagerPhone) {
		this.chargeManagerPhone = chargeManagerPhone;
	}
	public String getSecurityDanger() {
		return securityDanger;
	}
	public void setSecurityDanger(String securityDanger) {
		this.securityDanger = securityDanger;
	}
	public String getCodeSecurityLevel() {
		return codeSecurityLevel;
	}
	public void setCodeSecurityLevel(String codeSecurityLevel) {
		this.codeSecurityLevel = codeSecurityLevel;
	}
	
	
}
