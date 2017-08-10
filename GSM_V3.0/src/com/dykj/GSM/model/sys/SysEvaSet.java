package com.dykj.GSM.model.sys;

import javax.validation.constraints.NotNull;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysEvaSetMapper")
public class SysEvaSet extends BaseModel {
	// 默认的设置事项有三个，矛盾、事件、民情日志，每项设有基础分，实行扣分制，最低零分。矛盾和事件每月默认分别最少上报8篇，少一篇扣1分，多报不加分。如果有亮红灯情况，每次出现红灯扣1分
	// 民情日志每天都要写，少一篇扣1分，
	// 巡查走访每月最少走访80户，少一户扣1分，每天上午最少走访60分钟，下午最少走访70分钟，时长不够扣1分，（一天最多扣2分）

	/**
	 * 是否将矛盾计入
	 */
	@NotNull
	private Boolean isContradict;
	/**
	 * 是否将事件计入
	 */
	@NotNull
	private Boolean isEvent;
	/**
	 * 是否将民情日志计入
	 */
	@NotNull
	private Boolean isLog;
	/**
	 * 是否将巡查走访计入
	 */
	@NotNull
	private Boolean isXunCha;
	/**
	 * 矛盾基础分
	 */
	private Integer contradictBaseScore;
	/**
	 * 事件基础分
	 */
	private Integer eventBaseScore;
	/**
	 * 日志基础分
	 */
	private Integer logBaseScore;

	/**
	 * 走访基础分
	 */
	private Integer zouFangBaseScore;

	/**
	 * 每月最少多少篇
	 */
	private Integer leastContradict;

	/**
	 * 每少一篇矛盾扣分
	 */
	private Integer lessKouFenContradict;

	/**
	 * 晚一次扣分
	 */
	private Integer lateKouFenContradict;
	/**
	 * 每月最少多少篇
	 */
	private Integer leastEvent;

	/**
	 * 每少一篇事件扣分
	 */
	private Integer lessKouFenEvent;
	/**
	 * 晚一次扣分
	 */
	private Integer lateKouFenEvent;

	/**
	 * 日志最少
	 */
	// private Integer leastLog;

	/**
	 * 每少一篇日志扣分
	 */
	private Integer lessKouFenLog;

	/**
	 * 每月走访户数
	 */
	private Integer leastZouFangHu;
	/**
	 * 每少一走访一户扣分
	 */
	private Integer lessKouFenZouFangHu;
	/**
	 * 每天上午最少走访时间，分钟
	 */
	private Integer leastZouFangAm;
	/**
	 * 每天上午最少走访时间，分钟
	 */
	private Integer leastZouFangPm;

	/**
	 * 时间不够扣分
	 */
	private Integer lessTimeKouFen;

	public Boolean getIsContradict() {
		return isContradict;
	}

	public void setIsContradict(Boolean isContradict) {
		this.isContradict = isContradict;
	}

	public Boolean getIsEvent() {
		return isEvent;
	}

	public void setIsEvent(Boolean isEvent) {
		this.isEvent = isEvent;
	}

	public Boolean getIsLog() {
		return isLog;
	}

	public void setIsLog(Boolean isLog) {
		this.isLog = isLog;
	}

	public Boolean getIsXunCha() {
		return isXunCha;
	}

	public void setIsXunCha(Boolean isXunCha) {
		this.isXunCha = isXunCha;
	}

	public Integer getContradictBaseScore() {
		return contradictBaseScore;
	}

	public void setContradictBaseScore(Integer contradictBaseScore) {
		this.contradictBaseScore = contradictBaseScore;
	}

	public Integer getEventBaseScore() {
		return eventBaseScore;
	}

	public void setEventBaseScore(Integer eventBaseScore) {
		this.eventBaseScore = eventBaseScore;
	}

	public Integer getLogBaseScore() {
		return logBaseScore;
	}

	public void setLogBaseScore(Integer logBaseScore) {
		this.logBaseScore = logBaseScore;
	}

	public Integer getLeastContradict() {
		return leastContradict;
	}

	public void setLeastContradict(Integer leastContradict) {
		this.leastContradict = leastContradict;
	}

	public Integer getLessKouFenContradict() {
		return lessKouFenContradict;
	}

	public void setLessKouFenContradict(Integer lessKouFenContradict) {
		this.lessKouFenContradict = lessKouFenContradict;
	}

	public Integer getLateKouFenContradict() {
		return lateKouFenContradict;
	}

	public void setLateKouFenContradict(Integer lateKouFenContradict) {
		this.lateKouFenContradict = lateKouFenContradict;
	}

	public Integer getLeastEvent() {
		return leastEvent;
	}

	public void setLeastEvent(Integer leastEvent) {
		this.leastEvent = leastEvent;
	}

	public Integer getLessKouFenEvent() {
		return lessKouFenEvent;
	}

	public void setLessKouFenEvent(Integer lessKouFenEvent) {
		this.lessKouFenEvent = lessKouFenEvent;
	}

	public Integer getLateKouFenEvent() {
		return lateKouFenEvent;
	}

	public void setLateKouFenEvent(Integer lateKouFenEvent) {
		this.lateKouFenEvent = lateKouFenEvent;
	}

	public Integer getLessKouFenLog() {
		return lessKouFenLog;
	}

	public void setLessKouFenLog(Integer lessKouFenLog) {
		this.lessKouFenLog = lessKouFenLog;
	}

	public Integer getLeastZouFangAm() {
		return leastZouFangAm;
	}

	public void setLeastZouFangAm(Integer leastZouFangAm) {
		this.leastZouFangAm = leastZouFangAm;
	}

	public Integer getLeastZouFangPm() {
		return leastZouFangPm;
	}

	public void setLeastZouFangPm(Integer leastZouFangPm) {
		this.leastZouFangPm = leastZouFangPm;
	}

	public Integer getLessTimeKouFen() {
		return lessTimeKouFen;
	}

	public void setLessTimeKouFen(Integer lessTimeKouFen) {
		this.lessTimeKouFen = lessTimeKouFen;
	}

	public Integer getLeastZouFangHu() {
		return leastZouFangHu;
	}

	public void setLeastZouFangHu(Integer leastZouFangHu) {
		this.leastZouFangHu = leastZouFangHu;
	}

	public Integer getLessKouFenZouFangHu() {
		return lessKouFenZouFangHu;
	}

	public void setLessKouFenZouFangHu(Integer lessKouFenZouFangHu) {
		this.lessKouFenZouFangHu = lessKouFenZouFangHu;
	}

	public Integer getZouFangBaseScore() {
		return zouFangBaseScore;
	}

	public void setZouFangBaseScore(Integer zouFangBaseScore) {
		this.zouFangBaseScore = zouFangBaseScore;
	}

}
