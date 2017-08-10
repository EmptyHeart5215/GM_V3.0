package com.dykj.GSM.model.base;

import javax.validation.constraints.Pattern;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年8月17日 下午3:43:49
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:被服务的人的详细信息
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BJiGouServicePeopleMapper")
public class BJiGouServicePeople extends BaseModel {
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	@Pattern(regexp = "^[男,女]$")
	private String sex;
	/**
	 * 电话
	 */
	private String phone;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 服务id
	 */
	private String serviceId;

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

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
