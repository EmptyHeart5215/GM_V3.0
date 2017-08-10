package com.dykj.GSM.model.eventfile;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.eventfile.mapperinterf.EventKeyPlaceMapper")
public class EventKeyPlace extends BaseModel {

	/**
	 * 所属辖区或网格
	 */
	
	private String gridCode;

	/**
	 * 编号
	 */
	
	private String numbers;

	/**
	 * 网格编码
	 */
	
	private String gridNum;

	/**
	 * 治安重点地区名称
	 */
	
	private String troubleName;

	/**
	 * 区域范围
	 */
	
	private String placeRange;

	/**
	 * 存在的治安问题
	 */
	
	private String securityPro;

	/**
	 * 主管或所属单位
	 */
	
	private String belongUnit;

	/**
	 * 单位负责人
	 */
	
	private String unitName;

	/**
	 * 单位负责人职务
	 */
	
	private String unitJob;
	/**
	 * 单位负责人电话
	 */
	
	private String unitPhone;
	/**
	 * 管理负责人
	 */
	
	private String adminName;
	/**
	 * 管理责任人职务
	 */
	
	private String adminJob;
	/**
	 * 管理责任人电话
	 */
	
	private String adminPhone;
	/**
	 * 所属派出所
	 */
	
	private String police;
	/**
	 * 所长及联系电话
	 */
	
	private String directorPhone;
	/**
	 * 是否上级挂牌
	 */
	
	private String codeSuperiorsListing;
	/**
	 * 整治时限
	 */
	
	private String remediationDate;
	/**
	 * 整治措施
	 */
	
	private String remediationMeasure;
	/**
	 * 整治情况
	 */
	
	private String remediationSituation;
	/**
	 * 上级验收情况
	 */
	
	private String superiorsAccep;
	/**
	 * 定位
	 */
	
	private String position;
	/**
	 * 登记时间
	 */
	private String registerDate;

	/**
	 * 备注
	 */
	private String rmark;

	

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getNumbers() {
		return numbers;
	}

	public void setNumbers(String numbers) {
		this.numbers = numbers;
	}

	public String getGridNum() {
		return gridNum;
	}

	public void setGridNum(String gridNum) {
		this.gridNum = gridNum;
	}

	public String getTroubleName() {
		return troubleName;
	}

	public void setTroubleName(String troubleName) {
		this.troubleName = troubleName;
	}

	public String getPlaceRange() {
		return placeRange;
	}

	public void setPlaceRange(String placeRange) {
		this.placeRange = placeRange;
	}

	public String getSecurityPro() {
		return securityPro;
	}

	public void setSecurityPro(String securityPro) {
		this.securityPro = securityPro;
	}

	public String getBelongUnit() {
		return belongUnit;
	}

	public void setBelongUnit(String belongUnit) {
		this.belongUnit = belongUnit;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitJob() {
		return unitJob;
	}

	public void setUnitJob(String unitJob) {
		this.unitJob = unitJob;
	}

	public String getUnitPhone() {
		return unitPhone;
	}

	public void setUnitPhone(String unitPhone) {
		this.unitPhone = unitPhone;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminJob() {
		return adminJob;
	}

	public void setAdminJob(String adminJob) {
		this.adminJob = adminJob;
	}

	public String getAdminPhone() {
		return adminPhone;
	}

	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}

	public String getPolice() {
		return police;
	}

	public void setPolice(String police) {
		this.police = police;
	}

	public String getDirectorPhone() {
		return directorPhone;
	}

	public void setDirectorPhone(String directorPhone) {
		this.directorPhone = directorPhone;
	}

	public String getCodeSuperiorsListing() {
		return codeSuperiorsListing;
	}

	public void setCodeSuperiorsListing(String codeSuperiorsListing) {
		this.codeSuperiorsListing = codeSuperiorsListing;
	}

	public String getRemediationDate() {
		return remediationDate;
	}

	public void setRemediationDate(String remediationDate) {
		this.remediationDate = remediationDate;
	}

	public String getRemediationMeasure() {
		return remediationMeasure;
	}

	public void setRemediationMeasure(String remediationMeasure) {
		this.remediationMeasure = remediationMeasure;
	}

	public String getRemediationSituation() {
		return remediationSituation;
	}

	public void setRemediationSituation(String remediationSituation) {
		this.remediationSituation = remediationSituation;
	}

	public String getSuperiorsAccep() {
		return superiorsAccep;
	}

	public void setSuperiorsAccep(String superiorsAccep) {
		this.superiorsAccep = superiorsAccep;
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

	public String getRmark() {
		return rmark;
	}

	public void setRmark(String rmark) {
		this.rmark = rmark;
	}

}
