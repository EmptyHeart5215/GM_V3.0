package com.dykj.GSM.model.base;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BFieldsMapper")
public class BFields extends BaseModel {
	/**
	 * 名称
	 */
	private String gridCode;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 所属分类
	 */
	private String codeBelongType;
	/**
	 * 编号
	 */
	private String fieldsCode;
	/**
	 * 地点
	 */
	private String address;
	/**
	 * 面积
	 */
	private String area;
	/**
	 * 范围界限
	 */
	private String range;
	/**
	 * 主管或所属单位
	 */
	private String belong;
	/**
	 * 单位负责人姓名
	 */
	private String belongMan;
	/**
	 * 单位负责人职务
	 */
	private String belongDuty;
	/**
	 * 单位负责人电话
	 */
	private String belongPhone;
	/**
	 * 管理责任人姓名
	 */
	private String manageMan;
	/**
	 * 管理责任人职务
	 */
	private String manageDuty;
	/**
	 * 管理责任人电话
	 */
	private String managePhone;
	/**
	 * 管理人员人数
	 */
	private String manageManNum;
	/**
	 * 其他附属设施
	 */
	private String otherBelong;
	/**
	 * 网格联系人
	 */
	private String gridName;
	/**
	 * 网格联系人职务
	 */
	private String gridDuty;
	/**
	 * 网格联系人电话
	 */
	private String gridPhone;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 地图定位
	 */
	private String position;

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

	public String getCodeBelongType() {
		return codeBelongType;
	}

	public void setCodeBelongType(String codeBelongType) {
		this.codeBelongType = codeBelongType;
	}

	public String getFieldsCode() {
		return fieldsCode;
	}

	public void setFieldsCode(String fieldsCode) {
		this.fieldsCode = fieldsCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	public String getBelong() {
		return belong;
	}

	public void setBelong(String belong) {
		this.belong = belong;
	}

	public String getBelongMan() {
		return belongMan;
	}

	public void setBelongMan(String belongMan) {
		this.belongMan = belongMan;
	}

	public String getBelongDuty() {
		return belongDuty;
	}

	public void setBelongDuty(String belongDuty) {
		this.belongDuty = belongDuty;
	}

	public String getBelongPhone() {
		return belongPhone;
	}

	public void setBelongPhone(String belongPhone) {
		this.belongPhone = belongPhone;
	}

	public String getManageMan() {
		return manageMan;
	}

	public void setManageMan(String manageMan) {
		this.manageMan = manageMan;
	}

	public String getManageDuty() {
		return manageDuty;
	}

	public void setManageDuty(String manageDuty) {
		this.manageDuty = manageDuty;
	}

	public String getManagePhone() {
		return managePhone;
	}

	public void setManagePhone(String managePhone) {
		this.managePhone = managePhone;
	}

	public String getManageManNum() {
		return manageManNum;
	}

	public void setManageManNum(String manageManNum) {
		this.manageManNum = manageManNum;
	}

	public String getOtherBelong() {
		return otherBelong;
	}

	public void setOtherBelong(String otherBelong) {
		this.otherBelong = otherBelong;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public String getGridDuty() {
		return gridDuty;
	}

	public void setGridDuty(String gridDuty) {
		this.gridDuty = gridDuty;
	}

	public String getGridPhone() {
		return gridPhone;
	}

	public void setGridPhone(String gridPhone) {
		this.gridPhone = gridPhone;
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

}
