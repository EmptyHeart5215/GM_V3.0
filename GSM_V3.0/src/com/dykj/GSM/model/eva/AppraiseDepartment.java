package com.dykj.GSM.model.eva;

import java.math.BigDecimal;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.eva.mapperinterf.AppraiseDepartmentMapper")
public class AppraiseDepartment extends BaseModel {
	/**
	 * 考核对象
	 */
	private String gridCode;
	/**
	 * 年份
	 */
	private Integer year;
	/**
	 * 月份
	 */
	private Integer month;
	/**
	 * 矛盾总得分
	 */
	private BigDecimal contradictScore;
	/**
	 * 事件总得分
	 */
	private BigDecimal eventScore;

	/**
	 * 满意度扣分
	 */
	private BigDecimal manyiKoufenContradict;
	/**
	 * 满意度扣分
	 */
	private BigDecimal manyiKoufenEvent;
	/**
	 * 返工扣分
	 */
	private BigDecimal dubanKoufenContradict;
	/**
	 * 返工扣分
	 */
	private BigDecimal dubanKoufenEvent;
	/**
	 * 晚办扣分
	 */
	private BigDecimal lateKoufenContradict;
	/**
	 * 晚办扣分
	 */
	private BigDecimal lateKoufenEvent;
	/**
	 * 矛盾公式
	 */
	private String gongShiContradict;
	/**
	 * 事件公式
	 */
	private String gongShiEvent;

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public BigDecimal getContradictScore() {
		return contradictScore;
	}

	public void setContradictScore(BigDecimal contradictScore) {
		this.contradictScore = contradictScore;
	}

	public BigDecimal getEventScore() {
		return eventScore;
	}

	public void setEventScore(BigDecimal eventScore) {
		this.eventScore = eventScore;
	}

	public BigDecimal getManyiKoufenContradict() {
		return manyiKoufenContradict;
	}

	public void setManyiKoufenContradict(BigDecimal manyiKoufenContradict) {
		this.manyiKoufenContradict = manyiKoufenContradict;
	}

	public BigDecimal getManyiKoufenEvent() {
		return manyiKoufenEvent;
	}

	public void setManyiKoufenEvent(BigDecimal manyiKoufenEvent) {
		this.manyiKoufenEvent = manyiKoufenEvent;
	}

	public BigDecimal getDubanKoufenContradict() {
		return dubanKoufenContradict;
	}

	public void setDubanKoufenContradict(BigDecimal dubanKoufenContradict) {
		this.dubanKoufenContradict = dubanKoufenContradict;
	}

	public BigDecimal getDubanKoufenEvent() {
		return dubanKoufenEvent;
	}

	public void setDubanKoufenEvent(BigDecimal dubanKoufenEvent) {
		this.dubanKoufenEvent = dubanKoufenEvent;
	}

	public BigDecimal getLateKoufenContradict() {
		return lateKoufenContradict;
	}

	public void setLateKoufenContradict(BigDecimal lateKoufenContradict) {
		this.lateKoufenContradict = lateKoufenContradict;
	}

	public BigDecimal getLateKoufenEvent() {
		return lateKoufenEvent;
	}

	public void setLateKoufenEvent(BigDecimal lateKoufenEvent) {
		this.lateKoufenEvent = lateKoufenEvent;
	}

	public String getGongShiContradict() {
		return gongShiContradict;
	}

	public void setGongShiContradict(String gongShiContradict) {
		this.gongShiContradict = gongShiContradict;
	}

	public String getGongShiEvent() {
		return gongShiEvent;
	}

	public void setGongShiEvent(String gongShiEvent) {
		this.gongShiEvent = gongShiEvent;
	}

}
