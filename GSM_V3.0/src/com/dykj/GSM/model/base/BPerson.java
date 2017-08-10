package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPersonMapper")
public class BPerson extends BaseModel {
	/**
	 * 房屋编号
	 */
	@NotBlank
	private String houseCode;
	/**
	 * 姓名
	 */
	@NotBlank
	private String name;
	/**
	 * 曾用名
	 */
	private String otherName;
	/**
	 * 性别：男/女
	 */
	@Pattern(regexp = "^[男,女]$")
	private String sex;
	/**
	 * 公民身份证号
	 */
	@NotBlank
	private String cid;
	/**
	 * 民族
	 */
	@NotBlank
	private String codeNation;
	/**
	 * 籍贯
	 */
	@NotBlank
	private String nativePlaceCode;
	@Transient
	private String nativePlaceStr;
	/**
	 * 婚姻状况
	 */
	@NotBlank
	private String codeMarriage;
	/**
	 * 政治面貌
	 */
	@NotBlank
	private String codePolitical;
	/**
	 * 学历
	 */
	private String codeEducation;
	/**
	 * 宗教信仰
	 */
	@NotBlank
	private String codeReligious;
	/**
	 * 职业类别
	 */
	@NotBlank
	private String codeJobType;
	/**
	 * 职业
	 */
	@NotBlank
	private String job;
	/**
	 * 服务处所
	 */
	private String serverAddress;
	/**
	 * 联系电话
	 */
	@NotBlank
	private String phone;
	/**
	 * 户籍地
	 */
	@NotBlank
	private String residenceAddressCode;
	@Transient
	private String residenceAddressStr;
	/**
	 * 户籍门（楼）详址
	 */
	@NotBlank
	private String residenceDetail;
	/**
	 * 现住地
	 */
	@NotBlank
	private String nowAddressCode;
	@Transient
	private String nowAddressStr;
	/**
	 * 现住地（楼）详址
	 */
	@NotBlank
	private String nowAddressDetail;
	/**
	 * 人户状态
	 */
	@NotBlank
	private String codeHouseholdStatus;
	/**
	 * 照片
	 */
	private String img;
	/**
	 * 管理类型
	 */
	@NotBlank
	private String codeManageType;
	/**
	 * 单位名称
	 */
	@Transient
	private String unitName;
	/**
	 * 楼栋名称
	 */
	@Transient
	private String buildName;
	/**
	 * 房间号
	 */
	@Transient
	private String houseNum;
	private String gridCode;
	@Transient
	private BPerFuShu fuShu;
	@Transient
	private BBuilding building;

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOtherName() {
		return otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCodeNation() {
		return codeNation;
	}

	public void setCodeNation(String codeNation) {
		this.codeNation = codeNation;
	}

	public String getCodeMarriage() {
		return codeMarriage;
	}

	public void setCodeMarriage(String codeMarriage) {
		this.codeMarriage = codeMarriage;
	}

	public String getCodePolitical() {
		return codePolitical;
	}

	public void setCodePolitical(String codePolitical) {
		this.codePolitical = codePolitical;
	}

	public String getCodeEducation() {
		return codeEducation;
	}

	public void setCodeEducation(String codeEducation) {
		this.codeEducation = codeEducation;
	}

	public String getCodeReligious() {
		return codeReligious;
	}

	public void setCodeReligious(String codeReligious) {
		this.codeReligious = codeReligious;
	}

	public String getCodeJobType() {
		return codeJobType;
	}

	public void setCodeJobType(String codeJobType) {
		this.codeJobType = codeJobType;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getServerAddress() {
		return serverAddress;
	}

	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getResidenceDetail() {
		return residenceDetail;
	}

	public void setResidenceDetail(String residenceDetail) {
		this.residenceDetail = residenceDetail;
	}

	public String getNowAddressDetail() {
		return nowAddressDetail;
	}

	public void setNowAddressDetail(String nowAddressDetail) {
		this.nowAddressDetail = nowAddressDetail;
	}

	public String getCodeHouseholdStatus() {
		return codeHouseholdStatus;
	}

	public void setCodeHouseholdStatus(String codeHouseholdStatus) {
		this.codeHouseholdStatus = codeHouseholdStatus;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCodeManageType() {
		return codeManageType;
	}

	public void setCodeManageType(String codeManageType) {
		this.codeManageType = codeManageType;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public BPerFuShu getFuShu() {
		return fuShu;
	}

	public void setFuShu(BPerFuShu fuShu) {
		this.fuShu = fuShu;
	}

	public String getNativePlaceCode() {
		return nativePlaceCode;
	}

	public void setNativePlaceCode(String nativePlaceCode) {
		this.nativePlaceCode = nativePlaceCode;
	}

	public String getResidenceAddressCode() {
		return residenceAddressCode;
	}

	public void setResidenceAddressCode(String residenceAddressCode) {
		this.residenceAddressCode = residenceAddressCode;
	}

	public String getNowAddressCode() {
		return nowAddressCode;
	}

	public void setNowAddressCode(String nowAddressCode) {
		this.nowAddressCode = nowAddressCode;
	}

	public String getNativePlaceStr() {
		return nativePlaceStr;
	}

	public void setNativePlaceStr(String nativePlaceStr) {
		this.nativePlaceStr = nativePlaceStr;
	}

	public String getResidenceAddressStr() {
		return residenceAddressStr;
	}

	public void setResidenceAddressStr(String residenceAddressStr) {
		this.residenceAddressStr = residenceAddressStr;
	}

	public String getNowAddressStr() {
		return nowAddressStr;
	}

	public void setNowAddressStr(String nowAddressStr) {
		this.nowAddressStr = nowAddressStr;
	}

	public BBuilding getBuilding() {
		return building;
	}

	public void setBuilding(BBuilding building) {
		this.building = building;
	}

}
