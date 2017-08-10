package com.dykj.GSM.model.sys;

import javax.validation.constraints.NotNull;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysLegalDateMapper")
public class SysLegalDate extends BaseModel {
	/**
	 * 年份
	 */
	@NotNull
	private Integer year;
	/**
	 * 休息日，用逗号分隔，如：01,02
	 */

	private String legalDay;
	/**
	 * 月份
	 */
	@NotNull
	private Integer month;
	/**
	 * 工作日，日，用逗号分隔，如：01,02
	 */
	private String workDay;
	/**
	 * 休息日天数
	 */
	@NotNull
	private Integer legalCount;
	/**
	 * 工作日天数
	 */
	@NotNull
	private Integer workCount;

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLegalDay() {
		return legalDay;
	}

	public void setLegalDay(String legalDay) {
		this.legalDay = legalDay;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getWorkDay() {
		return workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public Integer getLegalCount() {
		return legalCount;
	}

	public void setLegalCount(Integer legalCount) {
		this.legalCount = legalCount;
	}

	public Integer getWorkCount() {
		return workCount;
	}

	public void setWorkCount(Integer workCount) {
		this.workCount = workCount;
	}

}
