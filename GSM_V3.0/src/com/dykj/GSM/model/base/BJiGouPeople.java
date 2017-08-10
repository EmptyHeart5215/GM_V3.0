package com.dykj.GSM.model.base;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BJiGouPeopleMapper")
public class BJiGouPeople extends BaseModel{
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 现住址
	 */
	private String address;
	/**
	 * 关联code
	 */
	private String personCode;
	/**
	 * 
	 */
	private String guanLian;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPersonCode() {
		return personCode;
	}
	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}
	public String getGuanLian() {
		return guanLian;
	}
	public void setGuanLian(String guanLian) {
		this.guanLian = guanLian;
	}

}
