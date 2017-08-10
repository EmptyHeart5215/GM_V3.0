package com.dykj.GSM.model.base;

import java.util.Map;

import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月3日 下午4:16:44
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:境外人员信息
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerJingWaiMapper")
public class BPerJingWai extends BaseModel {
	/**
	 * 房屋编号
	 */
	@NotBlank
	private String houseCode;
	/**
	 * 外文姓
	 */
	@NotBlank
	private String lastName;
	/**
	 * 外文名儿
	 */
	@NotBlank
	private String firstName;
	/**
	 * 中文名
	 */
	private String name;
	/**
	 * 性别：男/女
	 */
	@Pattern(regexp = "^[男,女]$")
	private String sex;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 国籍
	 */
	@NotBlank
	private String codeNationality;
	/**
	 * 宗教信仰
	 */
	private String codeReligious;
	/**
	 * 证件类型
	 */
	@NotBlank
	private String codeIdType;
	/**
	 * 证件号
	 */
	@NotBlank
	private String cid;
	/**
	 * 证件有效期
	 */
	@NotBlank
	private String idEndDate;
	/**
	 * 联系电话
	 */
	@NotBlank
	private String phone;
	/**
	 * 来华目的
	 */
	@NotBlank
	private String codeComeChinaReason;
	/**
	 * 职业类别
	 */
	private String codeJobType;
	/**
	 * 职业
	 */
	private String job;
	/**
	 * 服务处所
	 */
	private String serverAddress;
	/**
	 * 现住地
	 */
	@NotBlank
	private String nowAddressCode;
	/**
	 * 现住地（楼）详址
	 */
	@NotBlank
	private String nowAddressDetail;
	/**
	 * 抵达日期
	 */
	@NotBlank
	private String comeDate;
	/**
	 * 预计离开日期
	 */
	@NotBlank
	private String goDate;
	/**
	 * 是否重点关注人员
	 */
	private Boolean isGuanZhu;
	/**
	 * 字典值
	 */
	@Transient
	private Map dicValueMap;
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
	/**
	 * 全名 外国姓+外国名
	 */
	@Transient
	private String totalName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCodeNationality() {
		return codeNationality;
	}

	public void setCodeNationality(String codeNationality) {
		this.codeNationality = codeNationality;
	}

	public String getCodeReligious() {
		return codeReligious;
	}

	public void setCodeReligious(String codeReligious) {
		this.codeReligious = codeReligious;
	}

	public String getCodeIdType() {
		return codeIdType;
	}

	public void setCodeIdType(String codeIdType) {
		this.codeIdType = codeIdType;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getIdEndDate() {
		return idEndDate;
	}

	public void setIdEndDate(String idEndDate) {
		this.idEndDate = idEndDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCodeComeChinaReason() {
		return codeComeChinaReason;
	}

	public void setCodeComeChinaReason(String codeComeChinaReason) {
		this.codeComeChinaReason = codeComeChinaReason;
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

	public String getNowAddressCode() {
		return nowAddressCode;
	}

	public void setNowAddressCode(String nowAddressCode) {
		this.nowAddressCode = nowAddressCode;
	}

	public String getNowAddressDetail() {
		return nowAddressDetail;
	}

	public void setNowAddressDetail(String nowAddressDetail) {
		this.nowAddressDetail = nowAddressDetail;
	}

	public String getComeDate() {
		return comeDate;
	}

	public void setComeDate(String comeDate) {
		this.comeDate = comeDate;
	}

	public String getGoDate() {
		return goDate;
	}

	public void setGoDate(String goDate) {
		this.goDate = goDate;
	}

	public Boolean getIsGuanZhu() {
		return isGuanZhu;
	}

	public void setIsGuanZhu(Boolean isGuanZhu) {
		this.isGuanZhu = isGuanZhu;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Map getDicValueMap() {
		return dicValueMap;
	}

	public void setDicValueMap(Map dicValueMap) {
		this.dicValueMap = dicValueMap;
	}

	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
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

	public String getTotalName() {
		return totalName;
	}

	public void setTotalName(String totalName) {
		this.totalName = totalName;
	}
}
