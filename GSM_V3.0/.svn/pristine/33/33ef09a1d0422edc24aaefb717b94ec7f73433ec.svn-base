package com.dykj.GSM.model.base;

import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月18日 上午10:22:19
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:劳动保障
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerLaoDongMapper")
public class BPerLaoDong extends BaseModel {
	/**
	 * 关联的人的code
	 */
	@NotBlank
	private String personCode;
	/**
	 * 最高学历院校
	 */
	private String xueXiao;
	/**
	 * 专业
	 */
	private String zhuanYe;
	/**
	 * 毕业时间
	 */
	private String biYeDate;
	/**
	 * 毕业证号
	 */
	private String biYeCode;
	/**
	 * 是否有资格证
	 */
	private Boolean isZiGe;
	/**
	 * 资格证书类型
	 */
	private String ziGeZhengType;
	/**
	 * 是否持有就业失业登记证
	 */
	@NotNull
	private Boolean isHasJiuYeZheng;
	/**
	 * 就业失业登记证编号
	 */
	private String jiuYeCode;
	/**
	 * 就业失业登记证发证地
	 */
	private String faZhengDi;
	/**
	 * 发证时间
	 */
	private String faZhengDate;
	/**
	 * 就业状况类型
	 */
	private String codeJiuYeType;
	/**
	 * 是否签订劳动合同
	 */
	private Boolean isHeTong;
	/**
	 * 是否有养老保险
	 */
	private Boolean isYangLao;
	/**
	 * 是否有失业保险
	 */
	private Boolean isShiYeBaoXian;
	/**
	 * 是否有医疗保险
	 */
	private Boolean isYiLiao;
	/**
	 * 是否有工伤保险
	 */
	private Boolean isGongShang;
	/**
	 * 是否有生育保险
	 */
	private Boolean isShengYu;
	/**
	 * 是否有住房公积金
	 */
	private Boolean isGongJiJin;
	@Transient
	private BPerson person;

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public String getXueXiao() {
		return xueXiao;
	}

	public void setXueXiao(String xueXiao) {
		this.xueXiao = xueXiao;
	}

	public String getZhuanYe() {
		return zhuanYe;
	}

	public void setZhuanYe(String zhuanYe) {
		this.zhuanYe = zhuanYe;
	}

	public String getBiYeDate() {
		return biYeDate;
	}

	public void setBiYeDate(String biYeDate) {
		this.biYeDate = biYeDate;
	}

	public String getBiYeCode() {
		return biYeCode;
	}

	public void setBiYeCode(String biYeCode) {
		this.biYeCode = biYeCode;
	}

	public Boolean getIsZiGe() {
		return isZiGe;
	}

	public void setIsZiGe(Boolean isZiGe) {
		this.isZiGe = isZiGe;
	}

	public String getZiGeZhengType() {
		return ziGeZhengType;
	}

	public void setZiGeZhengType(String ziGeZhengType) {
		this.ziGeZhengType = ziGeZhengType;
	}

	public Boolean getIsHasJiuYeZheng() {
		return isHasJiuYeZheng;
	}

	public void setIsHasJiuYeZheng(Boolean isHasJiuYeZheng) {
		this.isHasJiuYeZheng = isHasJiuYeZheng;
	}

	public String getJiuYeCode() {
		return jiuYeCode;
	}

	public void setJiuYeCode(String jiuYeCode) {
		this.jiuYeCode = jiuYeCode;
	}

	public String getFaZhengDi() {
		return faZhengDi;
	}

	public void setFaZhengDi(String faZhengDi) {
		this.faZhengDi = faZhengDi;
	}

	public String getFaZhengDate() {
		return faZhengDate;
	}

	public void setFaZhengDate(String faZhengDate) {
		this.faZhengDate = faZhengDate;
	}

	public String getCodeJiuYeType() {
		return codeJiuYeType;
	}

	public void setCodeJiuYeType(String codeJiuYeType) {
		this.codeJiuYeType = codeJiuYeType;
	}

	public Boolean getIsHeTong() {
		return isHeTong;
	}

	public void setIsHeTong(Boolean isHeTong) {
		this.isHeTong = isHeTong;
	}

	public Boolean getIsYangLao() {
		return isYangLao;
	}

	public void setIsYangLao(Boolean isYangLao) {
		this.isYangLao = isYangLao;
	}

	public Boolean getIsShiYeBaoXian() {
		return isShiYeBaoXian;
	}

	public void setIsShiYeBaoXian(Boolean isShiYeBaoXian) {
		this.isShiYeBaoXian = isShiYeBaoXian;
	}

	public Boolean getIsYiLiao() {
		return isYiLiao;
	}

	public void setIsYiLiao(Boolean isYiLiao) {
		this.isYiLiao = isYiLiao;
	}

	public Boolean getIsGongShang() {
		return isGongShang;
	}

	public void setIsGongShang(Boolean isGongShang) {
		this.isGongShang = isGongShang;
	}

	public Boolean getIsShengYu() {
		return isShengYu;
	}

	public void setIsShengYu(Boolean isShengYu) {
		this.isShengYu = isShengYu;
	}

	public Boolean getIsGongJiJin() {
		return isGongJiJin;
	}

	public void setIsGongJiJin(Boolean isGongJiJin) {
		this.isGongJiJin = isGongJiJin;
	}

	public BPerson getPerson() {
		return person;
	}

	public void setPerson(BPerson person) {
		this.person = person;
	}
}
