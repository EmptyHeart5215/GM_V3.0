package com.dykj.GSM.model.partybuilding;

import java.util.Date;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.partybuilding.mapperinterf.PartyOrganizationalifeMapper")
public class PartyOrganizationalife extends BaseModel {

	/**
	 * 部门code
	 */
	private String departmentCode;

	/**
	 * 网格code
	 */
	private String gridCode;

	/**
	 * 活动主题
	 */
	private String titleName;

	/**
	 * 开始时间
	 */
	private String beginTime;

	/**
	 * 结束时间
	 */
	private String endTime;

	/**
	 * 活动内容
	 */
	private String contents;
	/**
	 * 地图定位
	 */
	private String position;

	/**
	 * 活动负责人或召集人
	 */
	private String responsibleName;

	/**
	 * 参加活动的人员范围
	 */
	private String responsibleRange;

	/**
	 * 组织方参加活动人数
	 */
	private String orgPersons;

	/**
	 * 党员参与人数
	 */
	private String massesPersons;

	/**
	 * 添加文件
	 */
	private String addFile;

	/**
	 * 活动开展情况
	 */
	private String responsibleSituation;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 活动地点
	 */
	private String responsibleLocation;

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getResponsibleName() {
		return responsibleName;
	}

	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}

	public String getResponsibleRange() {
		return responsibleRange;
	}

	public void setResponsibleRange(String responsibleRange) {
		this.responsibleRange = responsibleRange;
	}

	public String getOrgPersons() {
		return orgPersons;
	}

	public void setOrgPersons(String orgPersons) {
		this.orgPersons = orgPersons;
	}

	public String getMassesPersons() {
		return massesPersons;
	}

	public void setMassesPersons(String massesPersons) {
		this.massesPersons = massesPersons;
	}

	public String getAddFile() {
		return addFile;
	}

	public void setAddFile(String addFile) {
		this.addFile = addFile;
	}

	public String getResponsibleSituation() {
		return responsibleSituation;
	}

	public void setResponsibleSituation(String responsibleSituation) {
		this.responsibleSituation = responsibleSituation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsibleLocation() {
		return responsibleLocation;
	}

	public void setResponsibleLocation(String responsibleLocation) {
		this.responsibleLocation = responsibleLocation;
	}

}
