package com.dykj.GSM.model.zongzhitraining;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.zongzhitraining.mapperinterf.AppraisalManagementMapper")
public class AppraisalManagement extends BaseModel {

	/**
	 * 考核名称
	 */
	private String appraisalName;
	/**
	 * 考核人
	 */
	private String appraisalPerson;
	/**
	 * 被考核人
	 */
	private String byAppraisalPerson;
	/**
	 * 考核成绩
	 */
	private String appraisalResults;
	/**
	 * 考核内容
	 */
	private String appraisalContent;
	/**
	 * 考核时间
	 */
	private String appraisalDate;

	public String getAppraisalName() {
		return appraisalName;
	}

	public void setAppraisalName(String appraisalName) {
		this.appraisalName = appraisalName;
	}

	public String getAppraisalPerson() {
		return appraisalPerson;
	}

	public void setAppraisalPerson(String appraisalPerson) {
		this.appraisalPerson = appraisalPerson;
	}

	public String getByAppraisalPerson() {
		return byAppraisalPerson;
	}

	public void setByAppraisalPerson(String byAppraisalPerson) {
		this.byAppraisalPerson = byAppraisalPerson;
	}

	public String getAppraisalResults() {
		return appraisalResults;
	}

	public void setAppraisalResults(String appraisalResults) {
		this.appraisalResults = appraisalResults;
	}

	public String getAppraisalContent() {
		return appraisalContent;
	}

	public void setAppraisalContent(String appraisalContent) {
		this.appraisalContent = appraisalContent;
	}

	public String getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(String appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

}
