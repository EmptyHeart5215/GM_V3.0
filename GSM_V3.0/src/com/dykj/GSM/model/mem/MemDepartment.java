package com.dykj.GSM.model.mem;

import javax.persistence.Transient;

import com.dykj.GSM.model.BaseModel;

/**
 * 考核评价-部门考核
 * 
 */
public class MemDepartment extends BaseModel {
	
	
	/**
	 * 考核对象
	 */
	private String nameDepartment;
	/**
	 * 按时办结率
	 */
	private String delayreduceScore;
	/**
	 * 返工率
	 */
	private String havenotreduceScore;
	/**
	 * 群众满意度
	 */
	private String pleasereduceScore;

	/**
	 * 总分
	 */
	private String sumScore;

	public String getNameDepartment() {
		return nameDepartment;
	}

	public void setNameDepartment(String nameDepartment) {
		this.nameDepartment = nameDepartment;
	}

	public String getDelayreduceScore() {
		return delayreduceScore;
	}

	public void setDelayreduceScore(String delayreduceScore) {
		this.delayreduceScore = delayreduceScore;
	}

	public String getHavenotreduceScore() {
		return havenotreduceScore;
	}

	public void setHavenotreduceScore(String havenotreduceScore) {
		this.havenotreduceScore = havenotreduceScore;
	}

	public String getPleasereduceScore() {
		return pleasereduceScore;
	}

	public void setPleasereduceScore(String pleasereduceScore) {
		this.pleasereduceScore = pleasereduceScore;
	}

	public String getSumScore() {
		return sumScore;
	}

	public void setSumScore(String sumScore) {
		this.sumScore = sumScore;
	}

}
