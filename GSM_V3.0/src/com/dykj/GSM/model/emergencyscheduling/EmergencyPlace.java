package com.dykj.GSM.model.emergencyscheduling;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 应急场所
 * 
 * @author wangmingyuan
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.emergencyscheduling.mapperinterf.EmergencyPlaceMapper")
public class EmergencyPlace extends BaseModel {
	/**
	 * 所属辖区
	 */
	@NotBlank
	private String gridCode;
	/**
	 * 场所名称
	 */
	@NotBlank
	private String placeName;
	/**
	 * 场所地址
	 */
	@NotBlank
	private String address;
	/**
	 * 场所面积
	 */
	@NotBlank
	private String placeArea;
	/**
	 * 容纳人数
	 */
	@NotNull
	private Integer accommodateNum;
	/**
	 * 地图定位
	 */
	@NotBlank
	private String position;

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPlaceArea() {
		return placeArea;
	}

	public void setPlaceArea(String placeArea) {
		this.placeArea = placeArea;
	}

	public Integer getAccommodateNum() {
		return accommodateNum;
	}

	public void setAccommodateNum(Integer accommodateNum) {
		this.accommodateNum = accommodateNum;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
