package com.dykj.GSM.model.event;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.model.BaseModel;

public class BaseEvent extends BaseModel {

	/**
	 * 事件流里边的矛盾联动化解
	 */
	public final static int FLOW_TYPE_MAODUN = 0;
	/**
	 * 事件流里边的事件
	 */
	public final static int FLOW_TYPE_SHIJIAN = 1;

	/**
	 * 事件编号
	 */
	private String eventNum;
	/**
	 * 流类型
	 */
	private Integer flowType;

	/**
	 * wfEntry的ID
	 */
	private Long wfEntry;
	/**
	 * 事件类型
	 */
	@NotBlank
	private String codeEventType;

	/**
	 * 所属辖区或网格
	 */
	@NotBlank
	@Length(min = 20, max = 20)
	private String gridCode;

	/**
	 * 事件名称
	 */
	@NotBlank
	private String eventTitle;
	/**
	 * 事件来源
	 */
	@NotBlank
	private String codeEventFrom;

	/**
	 * 事件地点
	 */
	@NotBlank
	private String eventAddress;
	/**
	 * 地图位置
	 */
	@NotBlank
	private String position;
	/**
	 * 发生时间
	 */
	@NotBlank
	private String eventDate;
	/**
	 * 事件详情
	 */
	@NotBlank
	private String description;

	/**
	 * 建议
	 */
	private String opinion;

	/**
	 * 图片
	 */
	private String img;

	/**
	 * 登记人
	 */
	@Transient
	private String createName;
	/**
	 * 登记人电话
	 */
	@Transient
	private String createUserPhone;
	/**
	 * 登记时间
	 */
	@Transient
	private String createDateStr;

	/**
	 * 办理部门
	 */
	@Transient
	private String banLiDepartment;

	/**
	 * 办结时间
	 */
	@Transient
	private String banJieDate;
	/**
	 * 事件状态
	 */
	@Transient
	private String stepName;
	/**
	 * 事件办理时限
	 */
	@Transient
	private String timeLimit;
	/**
	 * 开始办理时间
	 */
	@Transient
	private String startDate;
	/**
	 * 事件预警灯
	 */
	@Transient
	private String alertLight;
	/**
	 * 是否是指挥中心取消不办的事件，默认值为false，在指挥中心取消不办的时候设置为true
	 */
	private Boolean isCancel = false;

	/**
	 * 注销时间字符串
	 */
	@Transient
	private String cancelDateStr;
	/**
	 * 事件办理类型，根据isCancel属性来赋值
	 */
	@Transient
	private String banLiTypeStr;
	/**
	 * 事件所处步骤id
	 */
	@Transient
	private int stepId;
	/**
	 * 流程entry id
	 */
	@Transient
	private String entryId;

	/**
	 * 事件办理时间
	 */
	@Transient
	private String banLiDate;

	/**
	 * 是否督办,默认false，如果进行督办操作，就需要更新event表
	 */
	private Boolean isDuBan = false;

	/**
	 * 督办部门
	 */
	@Transient
	private String duBanDepartmentStr;
	/**
	 * 办结类型，只有0，1，2 ，4三个值，分别代表0代表没有办结，1，2，3分别代表中心办结/自办自结/部门办结，在办结的时候，更新event表
	 */
	private int banJieType = 0;

	@Transient
	private OsStep step;

	public String getBanLiDepartment() {
		return banLiDepartment;
	}

	public void setBanLiDepartment(String banLiDepartment) {
		this.banLiDepartment = banLiDepartment;
	}

	public String getBanJieDate() {
		return banJieDate;
	}

	public void setBanJieDate(String banJieDate) {
		this.banJieDate = banJieDate;
	}

	public int getStepId() {
		return stepId;
	}

	public void setStepId(int stepId) {
		this.stepId = stepId;
	}

	public String getEntryId() {
		return entryId;
	}

	public void setEntryId(String entryId) {
		this.entryId = entryId;
	}

	public String getBanLiTypeStr() {
		if (isCancel) {
			return "注销";
		}
		return "办理";
	}

	public void setBanLiTypeStr(String banLiTypeStr) {
		this.banLiTypeStr = banLiTypeStr;
	}

	public String getCodeEventType() {
		return codeEventType;
	}

	public void setCodeEventType(String codeEventType) {
		this.codeEventType = codeEventType;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}

	public String getCodeEventFrom() {
		return codeEventFrom;
	}

	public void setCodeEventFrom(String codeEventFrom) {
		this.codeEventFrom = codeEventFrom;
	}

	public String getEventAddress() {
		return eventAddress;
	}

	public void setEventAddress(String eventAddress) {
		this.eventAddress = eventAddress;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCreateName() {
		return createName;
	}

	public void setCreateName(String createName) {
		this.createName = createName;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getFlowType() {
		return flowType;
	}

	public void setFlowType(Integer flowType) {
		this.flowType = flowType;
	}

	public String getEventNum() {
		return eventNum;
	}

	public void setEventNum(String eventNum) {
		this.eventNum = eventNum;
	}

	public String getStepName() {
		return stepName;
	}

	public void setStepName(String stepName) {
		this.stepName = stepName;
	}

	public String getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(String timeLimit) {
		this.timeLimit = timeLimit;
	}

	public String getAlertLight() {
		return alertLight;
	}

	public void setAlertLight(String alertLight) {
		this.alertLight = alertLight;
	}

	public Boolean getIsCancel() {
		return isCancel;
	}

	public void setIsCancel(Boolean isCancel) {
		this.isCancel = isCancel;
	}

	public String getBanLiDate() {
		return banLiDate;
	}

	public void setBanLiDate(String banLiDate) {
		this.banLiDate = banLiDate;
	}

	public Boolean getIsDuBan() {
		return isDuBan;
	}

	public void setIsDuBan(Boolean isDuBan) {
		this.isDuBan = isDuBan;
	}

	public int getBanJieType() {
		return banJieType;
	}

	public void setBanJieType(int banJieType) {
		this.banJieType = banJieType;
	}

	public String getCreateUserPhone() {
		return createUserPhone;
	}

	public void setCreateUserPhone(String createUserPhone) {
		this.createUserPhone = createUserPhone;
	}

	public String getCreateDateStr() {
		return createDateStr;
	}

	public void setCreateDateStr(String createDateStr) {
		this.createDateStr = createDateStr;
	}

	public String getCancelDateStr() {
		return cancelDateStr;
	}

	public void setCancelDateStr(String cancelDateStr) {
		this.cancelDateStr = cancelDateStr;
	}

	public String getDuBanDepartmentStr() {
		return duBanDepartmentStr;
	}

	public void setDuBanDepartmentStr(String duBanDepartmentStr) {
		this.duBanDepartmentStr = duBanDepartmentStr;
	}

	public Long getWfEntry() {
		return wfEntry;
	}

	public void setWfEntry(Long wfEntry) {
		this.wfEntry = wfEntry;
	}

	public OsStep getStep() {
		return step;
	}

	public void setStep(OsStep step) {
		this.step = step;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
}
