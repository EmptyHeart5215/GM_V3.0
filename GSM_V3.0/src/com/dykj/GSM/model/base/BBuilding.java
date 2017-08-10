package com.dykj.GSM.model.base;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BBuildingMapper")
public class BBuilding extends BaseModel {
	/**
	 * 所属辖区
	 */
	@NotBlank
	private String gridCode;
	/**
	 * 楼栋名称
	 */
	@NotBlank
	private String buildName;
	/**
	 * 楼栋号
	 */
	@NotBlank
	private String buildNum;
	/**
	 * 楼栋长
	 */
	@NotBlank
	private String buildManager;
	/**
	 * 楼栋长电话
	 */
	private String buildManagerPhone;
	/**
	 * 楼栋长照片
	 */
	private String buildManagerPhoto;
	/**
	 * 楼栋属性
	 */
	private String codeBuildNature;
	/**
	 * 楼栋类型
	 */
	private String codeBuildType;
	/**
	 * 建筑图片
	 */
	private String buildPicture;
	/**
	 * 描边
	 */
	@NotBlank
	private String position;
	/**
	 * 描述
	 */
	private String description;

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getBuildNum() {
		return buildNum;
	}

	public void setBuildNum(String buildNum) {
		this.buildNum = buildNum;
	}

	public String getBuildManager() {
		return buildManager;
	}

	public void setBuildManager(String buildManager) {
		this.buildManager = buildManager;
	}

	public String getBuildManagerPhone() {
		return buildManagerPhone;
	}

	public void setBuildManagerPhone(String buildManagerPhone) {
		this.buildManagerPhone = buildManagerPhone;
	}

	public String getBuildManagerPhoto() {
		return buildManagerPhoto;
	}

	public void setBuildManagerPhoto(String buildManagerPhoto) {
		this.buildManagerPhoto = buildManagerPhoto;
	}

	public String getCodeBuildNature() {
		return codeBuildNature;
	}

	public void setCodeBuildNature(String codeBuildNature) {
		this.codeBuildNature = codeBuildNature;
	}

	public String getCodeBuildType() {
		return codeBuildType;
	}

	public void setCodeBuildType(String codeBuildType) {
		this.codeBuildType = codeBuildType;
	}

	public String getBuildPicture() {
		return buildPicture;
	}

	public void setBuildPicture(String buildPicture) {
		this.buildPicture = buildPicture;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
