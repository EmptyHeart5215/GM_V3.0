package com.dykj.GSM.model.sys;

import com.dykj.GSM.model.BaseModel;

public class SysSeatFirst extends BaseModel {
	/**
	 * 辖区名
	 */
	private String name;
	/**
	 * 城市编码
	 */
	private String cityCode;
	/**
	 * 管理员名称
	 */
	private String managerName;
	/**
	 * 辖区地址
	 */
	private String address;
	/**
	 * 管理员联系电话
	 */
	private String managerPhone;
	/**
	 * 管理员地址
	 */
	private String managerAddress;
	/**
	 * 管理员职责
	 */
	private String managerDuty;
	/**
	 * 管理员单位
	 */
	private String managerCompany;

	/**
	 * 管理员照片
	 */
	private String managerPhoto;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 地图坐标
	 */
	private String position;

	/**
	 * 辖区图片
	 */
	private String seatPicture;

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

	public String getManagerAddress() {
		return managerAddress;
	}

	public void setManagerAddress(String managerAddress) {
		this.managerAddress = managerAddress;
	}

	public String getManagerDuty() {
		return managerDuty;
	}

	public void setManagerDuty(String managerDuty) {
		this.managerDuty = managerDuty;
	}

	public String getManagerCompany() {
		return managerCompany;
	}

	public void setManagerCompany(String managerCompany) {
		this.managerCompany = managerCompany;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
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

}
