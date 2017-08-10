package com.dykj.GSM.model.emergencyscheduling;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 应急预案
 * 
 * @author wangmingyuan
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.emergencyscheduling.mapperinterf.EmergencyPlanMapper")
public class EmergencyPlan extends BaseModel {
	/**
	 * 所属辖区
	 */
	@NotBlank
	private String gridCode;
	/**
	 * 预案名称
	 */
	@NotBlank
	private String emergencyName;
	/**
	 * 预案类型（字典表）
	 */
	@NotBlank
	private String codePlanType;
	/**
	 * 预案说明
	 */
	@NotBlank
	private String emergencyContent;
	/**
	 * 文件code
	 */
	private String materialFile;
	/**
	 * 应急预案内容
	 */
	private String materialContent;
	/**
	 * 资料类型
	 */
	private String codeMaterialType;
	/**
	 * 队伍code
	 */
	private String teamCode;
	/**
	 * 场所code
	 */
	private String placeCode;
	
	private String placeGridTotalName;
	/**
	 * 物资code
	 */
	private String suppliesCode;
	
	public String getGridCode() {
		return gridCode;
	}
	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}
	public String getEmergencyName() {
		return emergencyName;
	}
	public void setEmergencyName(String emergencyName) {
		this.emergencyName = emergencyName;
	}
	public String getCodePlanType() {
		return codePlanType;
	}
	public void setCodePlanType(String codePlanType) {
		this.codePlanType = codePlanType;
	}
	public String getEmergencyContent() {
		return emergencyContent;
	}
	public void setEmergencyContent(String emergencyContent) {
		this.emergencyContent = emergencyContent;
	}
	public String getMaterialFile() {
		return materialFile;
	}
	public void setMaterialFile(String materialFile) {
		this.materialFile = materialFile;
	}
	public String getMaterialContent() {
		return materialContent;
	}
	public void setMaterialContent(String materialContent) {
		this.materialContent = materialContent;
	}
	public String getCodeMaterialType() {
		return codeMaterialType;
	}
	public void setCodeMaterialType(String codeMaterialType) {
		this.codeMaterialType = codeMaterialType;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
	public String getPlaceGridTotalName() {
		return placeGridTotalName;
	}
	public void setPlaceGridTotalName(String placeGridTotalName) {
		this.placeGridTotalName = placeGridTotalName;
	}
	public String getSuppliesCode() {
		return suppliesCode;
	}
	public void setSuppliesCode(String suppliesCode) {
		this.suppliesCode = suppliesCode;
	}
	
	
}
