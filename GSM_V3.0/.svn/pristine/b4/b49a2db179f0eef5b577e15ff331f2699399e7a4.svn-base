package com.dykj.GSM.model.event;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;

@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.event.mapperinterf.EEventMapper")
public class EEvent extends BaseEvent {

	/**
	 * 严重程度
	 */
	private String codeEventYanZhong;
	/**
	 * 诉求人姓名
	 */
	@NotBlank
	private String petitionersName;
	/**
	 * 诉求人身份证号
	 */
	private String petitionersId;
	/**
	 * 诉求人性别
	 */
	private String petitionersSex;
	/**
	 * 诉求人联系电话
	 */
	private String petitionersPhone;
	/**
	 * 诉求人联系地址
	 */
	private String petitionersAddress;

	/**
	 * 共同诉求人
	 */
	private String petitionersPersons;

	public String getCodeEventYanZhong() {
		return codeEventYanZhong;
	}

	public void setCodeEventYanZhong(String codeEventYanZhong) {
		this.codeEventYanZhong = codeEventYanZhong;
	}

	public String getPetitionersName() {
		return petitionersName;
	}

	public void setPetitionersName(String petitionersName) {
		this.petitionersName = petitionersName;
	}

	public String getPetitionersId() {
		return petitionersId;
	}

	public void setPetitionersId(String petitionersId) {
		this.petitionersId = petitionersId;
	}

	public String getPetitionersSex() {
		return petitionersSex;
	}

	public void setPetitionersSex(String petitionersSex) {
		this.petitionersSex = petitionersSex;
	}

	public String getPetitionersPhone() {
		return petitionersPhone;
	}

	public void setPetitionersPhone(String petitionersPhone) {
		this.petitionersPhone = petitionersPhone;
	}

	public String getPetitionersAddress() {
		return petitionersAddress;
	}

	public void setPetitionersAddress(String petitionersAddress) {
		this.petitionersAddress = petitionersAddress;
	}

	public String getPetitionersPersons() {
		return petitionersPersons;
	}

	public void setPetitionersPersons(String petitionersPersons) {
		this.petitionersPersons = petitionersPersons;
	}

}
