package com.dykj.GSM.model.event;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 王海红
 * @description 记录某件事办理需要的时间
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.event.mapperinterf.EDurationMapper")
public class EDuration extends BaseModel {
	/**
	 * 事件的code
	 */
	private String eventCode;
	/**
	 * 步骤
	 */
	private Integer stepId;
	/**
	 * action id
	 */
	private Integer actionId;
	/**
	 * 实例id
	 */
	private Long entryId;
	/**
	 * 天数
	 */
	private Integer duration;

	public String getEventCode() {
		return eventCode;
	}

	public void setEventCode(String eventCode) {
		this.eventCode = eventCode;
	}

	public Integer getStepId() {
		return stepId;
	}

	public void setStepId(Integer stepId) {
		this.stepId = stepId;
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
