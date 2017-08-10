package com.dykj.GSM.model.sys;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysSeatGridMapper")
public class SysSeatGrid extends BaseModel {
	/**
	 * 网格名称
	 */
	private String name;
	/**
	 * 行政区划(网格)代码
	 */
	private String cityCode;
	/**
	 * 网格管理员
	 */
	private String managerName;
	/**
	 * 辖区地址
	 */
	private String address;
	/**
	 * 网格管理员电话
	 */
	private String managerPhone;
	/**
	 * 网格助理员
	 */
	private String assistant;
	/**
	 * 网格助理员职务
	 */
	private String assistantDuty;
	/**
	 * 网格助理员电话
	 */
	private String assistantPhone;
	/**
	 * 网格助理员照片
	 */
	private String assistantPhoto;
	/**
	 * 地图坐标
	 */
	private String position;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 辖区图片
	 */
	private String seatPicture;
	/**
	 * 管理员照片
	 */
	private String managerPhoto;
	/**
	 * 父辖区code
	 */
	private String parentCode;
	/**
	 * 四级辖区名称
	 */
	private String fourName;
	/**
	 * 判断是否是部门
	 */
	private Boolean flagDepartment;
	/**
	 * 网格全称
	 */
	private String gridTotalName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getManagerPhone() {
		return managerPhone;
	}

	public void setManagerPhone(String managerPhone) {
		this.managerPhone = managerPhone;
	}

	public String getAssistant() {
		return assistant;
	}

	public void setAssistant(String assistant) {
		this.assistant = assistant;
	}

	public String getAssistantDuty() {
		return assistantDuty;
	}

	public void setAssistantDuty(String assistantDuty) {
		this.assistantDuty = assistantDuty;
	}

	public String getAssistantPhone() {
		return assistantPhone;
	}

	public void setAssistantPhone(String assistantPhone) {
		this.assistantPhone = assistantPhone;
	}

	public String getAssistantPhoto() {
		return assistantPhoto;
	}

	public void setAssistantPhoto(String assistantPhoto) {
		this.assistantPhoto = assistantPhoto;
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

	public String getSeatPicture() {
		return seatPicture;
	}

	public void setSeatPicture(String seatPicture) {
		this.seatPicture = seatPicture;
	}

	public String getManagerPhoto() {
		return managerPhoto;
	}

	public void setManagerPhoto(String managerPhoto) {
		this.managerPhoto = managerPhoto;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getFourName() {
		return fourName;
	}

	public void setFourName(String fourName) {
		this.fourName = fourName;
	}

	public Boolean getFlagDepartment() {
		return flagDepartment;
	}

	public void setFlagDepartment(Boolean flagDepartment) {
		this.flagDepartment = flagDepartment;
	}

	public String getGridTotalName() {
		return gridTotalName;
	}

	public void setGridTotalName(String gridTotalName) {
		this.gridTotalName = gridTotalName;
	}

}
