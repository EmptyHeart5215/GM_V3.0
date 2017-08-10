package com.dykj.GSM.model.base;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BHouseMapper")
public class BHouse extends BaseModel {
	/**
	 * 所属
	 */
	private String gridCode;
	/**
	 * 所属楼栋
	 */
	@Transient
	private String buildCode;
	/**
	 * 所属楼栋名称
	 */
	@Transient
	private String buildName;
	/**
	 * 所属单元
	 */
	private String unitCode;
	/**
	 * 所属单元名称
	 */
	@Transient
	private String unitName;
	/**
	 * 房间号
	 */
	private String houseNum;
	/**
	 * 本户建筑面积
	 */
	private String houseArea;
	/**
	 * 本户户型
	 */
	private String codeHouseLayout;
	/**
	 * 建成年份
	 */
	private Integer buildYear;
	/**
	 * 房屋产权证号
	 */
	private String housePropertyNum;
	/**
	 * 房屋产权证发证日期
	 */
	private String housePropertyDate;
	/**
	 * 房屋土地证发证日期
	 */
	private String houseLandDate;
	/**
	 * 房屋土地证号
	 */
	private String houseLandNum;
	/**
	 * 房屋来源
	 */
	private String codeHouseSource;
	/**
	 * 房屋性质
	 */
	private String codeHouseNature;
	/**
	 * 房屋用途
	 */
	private String codeHouseUse;
	/**
	 * 房屋用途显示名称
	 */
	@Transient
	private String houseUseString;
	/**
	 * 当前层
	 */
	private Integer currentLayer;
	/**
	 * 所在层(跃层式示例：1-2)
	 */
	private String ubietyLayer;
	/**
	 * 产权人姓名
	 */
	private String houseOwnerName;
	/**
	 * 性别
	 */
	@Pattern(regexp = "^[男,女]$")
	private String sex;
	/**
	 * 产权人证件类型
	 */
	private String codeHouseOwnerCard;
	/**
	 * 证件号
	 */
	private String houseOwnerCardNum;
	/**
	 * 是否户主
	 */
	private Boolean isHousehold;
	/**
	 * 产权人户籍地
	 */
	private String houseOwnerAddress;
	/**
	 * 产权人现地址
	 */
	private String houseOwnerNowAddress;
	/**
	 * 工作单位
	 */
	private String houseOwnerCompany;
	/**
	 * 产权人电话
	 */
	private String houseOwnerPhone;
	/**
	 * 共有人姓名
	 */
	private String houseCommonName;
	/**
	 * 共有人与产权人关系
	 */
	private String commonOwnerRelation;
	/**
	 * 共有人数
	 */
	private Integer housePerson;
	/**
	 * 使用人\单位
	 */
	private String useName;
	/**
	 * 使用人与产权人关系
	 */
	private String useOwnerRelation;
	/**
	 * 性别
	 */
	@Pattern(regexp = "^[男,女]$")
	private String useSex;
	/**
	 * 法定代表人
	 */
	private String legalPerson;
	/**
	 * 使用人性质
	 */
	private String codeUseProperty;
	/**
	 * 使用人证件类型
	 */
	private String codeUseCard;
	/**
	 * 使用人证件号码
	 */
	private String useCardNumber;
	/**
	 * 联系方式
	 */
	private String usePhone;
	/**
	 * 户籍地址
	 */
	private String useAddress;
	/**
	 * 现住址
	 */
	private String useCurrentAddress;
	/**
	 * 使用人是否流动人口
	 */
	private Boolean isUserFlow;
	/**
	 * 工作单位
	 */
	private String useWork;
	/**
	 * 使用人居住证号
	 */
	private String useLiveNumber;
	/**
	 * 共同使用人姓名
	 */
	private String useTogetherName;
	/**
	 * 与使用人关系
	 */
	private String useTogetherRelation;
	/**
	 * 租赁时间
	 */
	private String rentDate;
	/**
	 * 租赁期限，以年为单位
	 */
	private String rentTerm;
	/**
	 * 是否租赁整体
	 */
	private Boolean isRentWhole;
	/**
	 * 租金
	 */
	private BigDecimal rentFund;
	/**
	 * 租赁间数
	 */
	private Integer rentRoomCount;
	/**
	 * 租赁面积
	 */
	private BigDecimal rentArea;
	/**
	 * 租赁合同
	 */
	private Boolean haveRentContract;
	/**
	 * 是否登记备案
	 */
	private Boolean isRegistration;
	/**
	 * 到期时间
	 */
	private String expiryDate;
	/**
	 * 租赁公房
	 */
	private String codeHouseHousing;
	/**
	 * 双方签订计划生育保证书
	 */
	private Boolean isSignBirth;
	/**
	 * 双方签订治安责任保证书
	 */
	private Boolean isSignOrder;
	@Transient
	private Map dicValueMap;
	/**
	 * 描边
	 */
	private String position;
	
	public String getBuildCode() {
		return buildCode;
	}

	public void setBuildCode(String buildCode) {
		this.buildCode = buildCode;
	}

	public String getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(String unitCode) {
		this.unitCode = unitCode;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getHouseArea() {
		return houseArea;
	}

	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}

	public String getCodeHouseLayout() {
		return codeHouseLayout;
	}

	public void setCodeHouseLayout(String codeHouseLayout) {
		this.codeHouseLayout = codeHouseLayout;
	}

	public Integer getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(Integer buildYear) {
		this.buildYear = buildYear;
	}

	public String getHousePropertyNum() {
		return housePropertyNum;
	}

	public void setHousePropertyNum(String housePropertyNum) {
		this.housePropertyNum = housePropertyNum;
	}

	public String getHousePropertyDate() {
		return housePropertyDate;
	}

	public void setHousePropertyDate(String housePropertyDate) {
		this.housePropertyDate = housePropertyDate;
	}

	public String getHouseLandDate() {
		return houseLandDate;
	}

	public void setHouseLandDate(String houseLandDate) {
		this.houseLandDate = houseLandDate;
	}

	public String getHouseLandNum() {
		return houseLandNum;
	}

	public void setHouseLandNum(String houseLandNum) {
		this.houseLandNum = houseLandNum;
	}

	public String getCodeHouseSource() {
		return codeHouseSource;
	}

	public void setCodeHouseSource(String codeHouseSource) {
		this.codeHouseSource = codeHouseSource;
	}

	public String getCodeHouseNature() {
		return codeHouseNature;
	}

	public void setCodeHouseNature(String codeHouseNature) {
		this.codeHouseNature = codeHouseNature;
	}

	public String getCodeHouseUse() {
		return codeHouseUse;
	}

	public void setCodeHouseUse(String codeHouseUse) {
		this.codeHouseUse = codeHouseUse;
	}

	public Integer getCurrentLayer() {
		return currentLayer;
	}

	public void setCurrentLayer(Integer currentLayer) {
		this.currentLayer = currentLayer;
	}

	public String getUbietyLayer() {
		return ubietyLayer;
	}

	public void setUbietyLayer(String ubietyLayer) {
		this.ubietyLayer = ubietyLayer;
	}

	public String getHouseOwnerName() {
		return houseOwnerName;
	}

	public void setHouseOwnerName(String houseOwnerName) {
		this.houseOwnerName = houseOwnerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHouseOwnerAddress() {
		return houseOwnerAddress;
	}

	public void setHouseOwnerAddress(String houseOwnerAddress) {
		this.houseOwnerAddress = houseOwnerAddress;
	}

	public String getHouseOwnerNowAddress() {
		return houseOwnerNowAddress;
	}

	public void setHouseOwnerNowAddress(String houseOwnerNowAddress) {
		this.houseOwnerNowAddress = houseOwnerNowAddress;
	}

	public String getHouseOwnerCompany() {
		return houseOwnerCompany;
	}

	public void setHouseOwnerCompany(String houseOwnerCompany) {
		this.houseOwnerCompany = houseOwnerCompany;
	}

	public String getHouseOwnerPhone() {
		return houseOwnerPhone;
	}

	public void setHouseOwnerPhone(String houseOwnerPhone) {
		this.houseOwnerPhone = houseOwnerPhone;
	}

	public String getHouseCommonName() {
		return houseCommonName;
	}

	public void setHouseCommonName(String houseCommonName) {
		this.houseCommonName = houseCommonName;
	}

	public String getUseName() {
		return useName;
	}

	public void setUseName(String useName) {
		this.useName = useName;
	}

	public String getUseSex() {
		return useSex;
	}

	public void setUseSex(String useSex) {
		this.useSex = useSex;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getCodeUseProperty() {
		return codeUseProperty;
	}

	public void setCodeUseProperty(String codeUseProperty) {
		this.codeUseProperty = codeUseProperty;
	}

	public String getCodeUseCard() {
		return codeUseCard;
	}

	public void setCodeUseCard(String codeUseCard) {
		this.codeUseCard = codeUseCard;
	}

	public String getUseCardNumber() {
		return useCardNumber;
	}

	public void setUseCardNumber(String useCardNumber) {
		this.useCardNumber = useCardNumber;
	}

	public String getUsePhone() {
		return usePhone;
	}

	public void setUsePhone(String usePhone) {
		this.usePhone = usePhone;
	}

	public String getUseAddress() {
		return useAddress;
	}

	public void setUseAddress(String useAddress) {
		this.useAddress = useAddress;
	}

	public String getUseCurrentAddress() {
		return useCurrentAddress;
	}

	public void setUseCurrentAddress(String useCurrentAddress) {
		this.useCurrentAddress = useCurrentAddress;
	}

	public String getUseWork() {
		return useWork;
	}

	public void setUseWork(String useWork) {
		this.useWork = useWork;
	}

	public String getUseLiveNumber() {
		return useLiveNumber;
	}

	public void setUseLiveNumber(String useLiveNumber) {
		this.useLiveNumber = useLiveNumber;
	}

	public String getUseTogetherName() {
		return useTogetherName;
	}

	public void setUseTogetherName(String useTogetherName) {
		this.useTogetherName = useTogetherName;
	}

	public String getUseTogetherRelation() {
		return useTogetherRelation;
	}

	public void setUseTogetherRelation(String useTogetherRelation) {
		this.useTogetherRelation = useTogetherRelation;
	}

	public String getRentDate() {
		return rentDate;
	}

	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}

	public String getRentTerm() {
		return rentTerm;
	}

	public void setRentTerm(String rentTerm) {
		this.rentTerm = rentTerm;
	}

	public Boolean getIsRentWhole() {
		return isRentWhole;
	}

	public void setIsRentWhole(Boolean isRentWhole) {
		this.isRentWhole = isRentWhole;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public BigDecimal getRentFund() {
		return rentFund;
	}

	public void setRentFund(BigDecimal rentFund) {
		this.rentFund = rentFund;
	}

	public Integer getRentRoomCount() {
		return rentRoomCount;
	}

	public void setRentRoomCount(Integer rentRoomCount) {
		this.rentRoomCount = rentRoomCount;
	}

	public BigDecimal getRentArea() {
		return rentArea;
	}

	public void setRentArea(BigDecimal rentArea) {
		this.rentArea = rentArea;
	}

	public Boolean getHaveRentContract() {
		return haveRentContract;
	}

	public void setHaveRentContract(Boolean haveRentContract) {
		this.haveRentContract = haveRentContract;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getCodeHouseHousing() {
		return codeHouseHousing;
	}

	public void setCodeHouseHousing(String codeHouseHousing) {
		this.codeHouseHousing = codeHouseHousing;
	}

	public Boolean getIsSignBirth() {
		return isSignBirth;
	}

	public void setIsSignBirth(Boolean isSignBirth) {
		this.isSignBirth = isSignBirth;
	}

	public Boolean getIsSignOrder() {
		return isSignOrder;
	}

	public void setIsSignOrder(Boolean isSignOrder) {
		this.isSignOrder = isSignOrder;
	}

	public String getHouseUseString() {
		return houseUseString;
	}

	public void setHouseUseString(String houseUseString) {
		this.houseUseString = houseUseString;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Boolean getIsHousehold() {
		return isHousehold;
	}

	public void setIsHousehold(Boolean isHousehold) {
		this.isHousehold = isHousehold;
	}

	public String getCommonOwnerRelation() {
		return commonOwnerRelation;
	}

	public void setCommonOwnerRelation(String commonOwnerRelation) {
		this.commonOwnerRelation = commonOwnerRelation;
	}

	public String getUseOwnerRelation() {
		return useOwnerRelation;
	}

	public void setUseOwnerRelation(String useOwnerRelation) {
		this.useOwnerRelation = useOwnerRelation;
	}

	public Integer getHousePerson() {
		return housePerson;
	}

	public void setHousePerson(Integer housePerson) {
		this.housePerson = housePerson;
	}

	public Boolean getIsUserFlow() {
		return isUserFlow;
	}

	public void setIsUserFlow(Boolean isUserFlow) {
		this.isUserFlow = isUserFlow;
	}

	public Boolean getIsRegistration() {
		return isRegistration;
	}

	public void setIsRegistration(Boolean isRegistration) {
		this.isRegistration = isRegistration;
	}

	public String getCodeHouseOwnerCard() {
		return codeHouseOwnerCard;
	}

	public void setCodeHouseOwnerCard(String codeHouseOwnerCard) {
		this.codeHouseOwnerCard = codeHouseOwnerCard;
	}

	public String getHouseOwnerCardNum() {
		return houseOwnerCardNum;
	}

	public void setHouseOwnerCardNum(String houseOwnerCardNum) {
		this.houseOwnerCardNum = houseOwnerCardNum;
	}

	public Map getDicValueMap() {
		return dicValueMap;
	}

	public void setDicValueMap(Map dicValueMap) {
		this.dicValueMap = dicValueMap;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
