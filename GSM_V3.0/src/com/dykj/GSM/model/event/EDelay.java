package com.dykj.GSM.model.event;

import java.util.Date;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.event.mapperinterf.EDelayMapper")
public class EDelay extends BaseModel {
	/**
	 * 事件code
	 */
	private String eventCode;
	/**
	 * action id
	 */
	private Integer actionId;
	/**
	 * entryId
	 */
	private Long entryId;
	/**
	 * duedate-statrDate的工作日值
	 */
	private Integer dayCount;
	/**
	 * 在申请延时之前的所需工作日时长
	 */
	private Integer dayCountHistory;
	/**
	 * 部门办理步骤的开始时间
	 */
	private Date startDate;
	/**
	 * os_currentstep表中的duedate字段
	 */
	private Date dueDate;

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	public Integer getDayCountHistory() {
		return dayCountHistory;
	}

	public void setDayCountHistory(Integer dayCountHistory) {
		this.dayCountHistory = dayCountHistory;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

}
