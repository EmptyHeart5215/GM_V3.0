package com.dykj.GSM.model.event;

import javax.persistence.Transient;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.event.mapperinterf.EOpinionMapper")
public class EOpinion extends BaseModel {
	/**
	 * entry id
	 */
	private Long entryId;
	/**
	 * action id，
	 */
	private String actionId;
	/**
	 * action name,属于冗余字段，用于显示
	 */
	@Transient
	private String actionName;
	/**
	 * 这个步骤要转给的人，用于处理过程的 转给**，原项目中的caller
	 */
	private String toPersonCode;
	/**
	 * 这个步骤要转给的人，用于处理过程的 转给**，原项目中的caller的名字
	 */
	@Transient
	private String toPersonName;
	/**
	 * 就是创建人 的名子
	 */
	@Transient
	private String callerName;
	/**
	 * 意见
	 */
	private String opinion;
	/**
	 * 满意程度
	 */
	private String codeAppraise;
	/**
	 * 满意程度
	 */
	@Transient
	private String appraiseStr;

	public Long getEntryId() {
		return entryId;
	}

	public void setEntryId(Long entryId) {
		this.entryId = entryId;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getToPersonCode() {
		return toPersonCode;
	}

	public void setToPersonCode(String toPersonCode) {
		this.toPersonCode = toPersonCode;
	}

	public String getToPersonName() {
		return toPersonName;
	}

	public void setToPersonName(String toPersonName) {
		this.toPersonName = toPersonName;
	}

	public String getCallerName() {
		return callerName;
	}

	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getCodeAppraise() {
		return codeAppraise;
	}

	public void setCodeAppraise(String codeAppraise) {
		this.codeAppraise = codeAppraise;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getAppraiseStr() {
		return appraiseStr;
	}

	public void setAppraiseStr(String appraiseStr) {
		this.appraiseStr = appraiseStr;
	}

}
