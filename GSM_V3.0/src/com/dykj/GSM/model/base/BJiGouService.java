package com.dykj.GSM.model.base;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BJiGouServiceMapper")
public class BJiGouService extends BaseModel {
	/**
	 * 服务对象类型
	 */
	private String codeServiceType;
	/**
	 * 机构code
	 */
	private String jiGouCode;
	@Transient
	private BJiGou jiGou;
	/**
	 * 服务事件
	 */
	@NotBlank
	private String serviceEvent;

	/**
	 * 服务对象
	 */
	@NotBlank
	private String serviceDuiXiang;
	/**
	 * 服务人数
	 */
	private String serviceNum;

	/**
	 * 服务时间
	 */
	private String serviceTime;

	/**
	 * 服务地点
	 */
	private String sevieceAddress;
	/**
	 * 具体服务信息
	 */
	private String serviceDescription;
	/**
	 * 地图定位
	 */
	private String position;
	/**
	 * 服务范围
	 */
	private String personScope;
	@Transient
	private List<Object> peoples = new ArrayList<Object>();

	public String getServiceTime() {
		return serviceTime;
	}

	public void setServiceTime(String serviceTime) {
		this.serviceTime = serviceTime;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPersonScope() {
		return personScope;
	}

	public void setPersonScope(String personScope) {
		this.personScope = personScope;
	}

	public String getCodeServiceType() {
		return codeServiceType;
	}

	public void setCodeServiceType(String codeServiceType) {
		this.codeServiceType = codeServiceType;
	}

	public String getServiceEvent() {
		return serviceEvent;
	}

	public void setServiceEvent(String serviceEvent) {
		this.serviceEvent = serviceEvent;
	}

	public String getServiceDuiXiang() {
		return serviceDuiXiang;
	}

	public void setServiceDuiXiang(String serviceDuiXiang) {
		this.serviceDuiXiang = serviceDuiXiang;
	}

	public String getServiceNum() {
		return serviceNum;
	}

	public void setServiceNum(String serviceNum) {
		this.serviceNum = serviceNum;
	}

	public String getSevieceAddress() {
		return sevieceAddress;
	}

	public void setSevieceAddress(String sevieceAddress) {
		this.sevieceAddress = sevieceAddress;
	}

	public String getJiGouCode() {
		return jiGouCode;
	}

	public void setJiGouCode(String jiGouCode) {
		this.jiGouCode = jiGouCode;
	}

	public BJiGou getJiGou() {
		return jiGou;
	}

	public void setJiGou(BJiGou jiGou) {
		this.jiGou = jiGou;
	}

	public List<Object> getPeoples() {
		return peoples;
	}

	public void setPeoples(List<Object> peoples) {
		this.peoples = peoples;
	}

}
