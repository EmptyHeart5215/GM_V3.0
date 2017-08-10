package com.dykj.GSM.model.partybuilding;

import javax.persistence.Transient;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysSeatThird;

/**
 * 党组织管理
 * 
 * @author Administrator
 *
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.partybuilding.mapperinterf.PartyOrganizationManagerMapper")
public class PartyOrganizationManager extends BaseModel {

	/**
	 * 辖区主键
	 */
	private String gridCode;
	/**
	 * 组织名称
	 */
	private String organizaName;
	/**
	 * 书记姓名
	 */
	private String secretaryName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 工作电话
	 */
	private String phone;
	/**
	 * 手机号码
	 */
	private String mobile;
	/**
	 * 身份证号
	 */
	private String cid;
	/**
	 * 党组织类型
	 */
	private String codePartyOrganizationType;
	/**
	 * 地图定位
	 */
	private String position;

	@Transient
	private SysSeatThird seatThird;

	@Transient
	private SysSeatFour seatFour;

	@Transient
	private String address;

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getOrganizaName() {
		return organizaName;
	}

	public void setOrganizaName(String organizaName) {
		this.organizaName = organizaName;
	}

	public String getSecretaryName() {
		return secretaryName;
	}

	public void setSecretaryName(String secretaryName) {
		this.secretaryName = secretaryName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCodePartyOrganizationType() {
		return codePartyOrganizationType;
	}

	public void setCodePartyOrganizationType(String codePartyOrganizationType) {
		this.codePartyOrganizationType = codePartyOrganizationType;
	}

	public SysSeatThird getSeatThird() {
		return seatThird;
	}

	public void setSeatThird(SysSeatThird seatThird) {
		this.seatThird = seatThird;
	}

	public SysSeatFour getSeatFour() {
		return seatFour;
	}

	public void setSeatFour(SysSeatFour seatFour) {
		this.seatFour = seatFour;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
