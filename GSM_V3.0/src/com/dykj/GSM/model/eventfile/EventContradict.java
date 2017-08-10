package com.dykj.GSM.model.eventfile;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.eventfile.mapperinterf.EventContradictMapper")
public class EventContradict extends BaseModel {

	/**
	 * 所属辖区或网格
	 */
	@NotBlank
	private String gridCode ;

	/**
	 * 编号
	 */
	@NotBlank
	private String id ;

	/**
	 * 网格编码
	 */
	@NotBlank
	private String gridNum ;

	/**
	 * 矛盾纠纷级别
	 */
	@NotBlank
	private String codeEventType;

	/**
	 * 排查时间
	 */
	@NotBlank
	private String contradictionsDate;

	/**
	 * 完成时限
	 */
	@NotBlank
	private String resolveDate;

	/**
	 * 是否为重大矛盾纠纷
	 */
	private String contradictions;

	/**
	 * 纠纷当事人情况
	 */
	private String contradictionsParty;

	/**
	 * 涉及人数
	 */
	private String contradictionsPersons;

	/**
	 * 主要问题
	 */
	private String contradictionsSituation;

	/**
	 * 收集人
	 */
	private String takeName;

	/**
	 * 稳控负责人
	 */
	private String stabilityName;

	/**
	 * 采取措施
	 */
	private String stabilityMeasure;

	/**
	 * 责任部门
	 */
	private String problemUnit;

	/**
	 * 负责人
	 */
	private String problemName;

	/**
	 * 问题化解情况
	 */
	private String problemResolution;

	/**
	 * 群众反馈意见
	 */
	private String feedBake;

	/**
	 * 督办单位
	 */
	private String supervisionDuty;

	/**
	 * 督办人
	 */
	private String supervisionPerson;

	/**
	 * 地图定位
	 */
	private String position;

	/**
	 * 登记时间
	 */
	private String registerDate;

	/**
	 * 备注
	 */
	private String mrmark;

	/**
	 * 矛盾图片
	 */
	private String contradictPhoto;

	
	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGridNum() {
		return gridNum;
	}

	public void setGridNum(String gridNum) {
		this.gridNum = gridNum;
	}

	public String getCodeEventType() {
		return codeEventType;
	}

	public void setCodeEventType(String codeEventType) {
		this.codeEventType = codeEventType;
	}

	public String getContradictionsDate() {
		return contradictionsDate;
	}

	public void setContradictionsDate(String contradictionsDate) {
		this.contradictionsDate = contradictionsDate;
	}

	public String getContradictions() {
		return contradictions;
	}

	public void setContradictions(String contradictions) {
		this.contradictions = contradictions;
	}

	public String getContradictionsParty() {
		return contradictionsParty;
	}

	public void setContradictionsParty(String contradictionsParty) {
		this.contradictionsParty = contradictionsParty;
	}

	public String getContradictionsPersons() {
		return contradictionsPersons;
	}

	public void setContradictionsPersons(String contradictionsPersons) {
		this.contradictionsPersons = contradictionsPersons;
	}

	public String getContradictionsSituation() {
		return contradictionsSituation;
	}

	public void setContradictionsSituation(String contradictionsSituation) {
		this.contradictionsSituation = contradictionsSituation;
	}

	public String getTakeName() {
		return takeName;
	}

	public void setTakeName(String takeName) {
		this.takeName = takeName;
	}

	public String getStabilityName() {
		return stabilityName;
	}

	public void setStabilityName(String stabilityName) {
		this.stabilityName = stabilityName;
	}

	public String getStabilityMeasure() {
		return stabilityMeasure;
	}

	public void setStabilityMeasure(String stabilityMeasure) {
		this.stabilityMeasure = stabilityMeasure;
	}

	public String getProblemUnit() {
		return problemUnit;
	}

	public void setProblemUnit(String problemUnit) {
		this.problemUnit = problemUnit;
	}

	public String getProblemName() {
		return problemName;
	}

	public void setProblemName(String problemName) {
		this.problemName = problemName;
	}

	public String getProblemResolution() {
		return problemResolution;
	}

	public void setProblemResolution(String problemResolution) {
		this.problemResolution = problemResolution;
	}

	public String getFeedBake() {
		return feedBake;
	}

	public void setFeedBake(String feedBake) {
		this.feedBake = feedBake;
	}

	public String getSupervisionDuty() {
		return supervisionDuty;
	}

	public void setSupervisionDuty(String supervisionDuty) {
		this.supervisionDuty = supervisionDuty;
	}

	public String getSupervisionPerson() {
		return supervisionPerson;
	}

	public void setSupervisionPerson(String supervisionPerson) {
		this.supervisionPerson = supervisionPerson;
	}

	public String getResolveDate() {
		return resolveDate;
	}

	public void setResolveDate(String resolveDate) {
		this.resolveDate = resolveDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

	public String getMrmark() {
		return mrmark;
	}

	public void setMrmark(String mrmark) {
		this.mrmark = mrmark;
	}

	public String getContradictPhoto() {
		return contradictPhoto;
	}

	public void setContradictPhoto(String contradictPhoto) {
		this.contradictPhoto = contradictPhoto;
	}
	

}
