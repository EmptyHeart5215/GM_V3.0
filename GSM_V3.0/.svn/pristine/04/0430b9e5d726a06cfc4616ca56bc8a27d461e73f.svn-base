package com.dykj.GSM.model.emergencyscheduling;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * 应急队伍
 * 
 * @author wangmingyuan
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.emergencyscheduling.mapperinterf.EmergencyTeamMapper")
public class EmergencyTeam extends BaseModel {
	/**
	 * 所属辖区
	 */
	@NotBlank
	private String gridCode;
	/**
	 * 队伍名称
	 */
	@NotBlank
	private String teamName;
	/**
	 * 队伍负责人
	 */
	@NotBlank
	private String teamPrincipal;
	/**
	 * 队伍成员
	 */
	@NotBlank
	private String teamMember;
	/**
	 * 负责人联系电话
	 */
	@NotBlank
	private String principalPhone;
	/**
	 * 队伍类型（字典表）
	 */
	@NotBlank
	private String codeTeamType;
	/**
	 * 队伍描述
	 */
	@NotBlank
	private String teamMiaoShu;

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamPrincipal() {
		return teamPrincipal;
	}

	public void setTeamPrincipal(String teamPrincipal) {
		this.teamPrincipal = teamPrincipal;
	}

	public String getTeamMember() {
		return teamMember;
	}

	public void setTeamMember(String teamMember) {
		this.teamMember = teamMember;
	}

	public String getPrincipalPhone() {
		return principalPhone;
	}

	public void setPrincipalPhone(String principalPhone) {
		this.principalPhone = principalPhone;
	}

	public String getCodeTeamType() {
		return codeTeamType;
	}

	public void setCodeTeamType(String codeTeamType) {
		this.codeTeamType = codeTeamType;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getTeamMiaoShu() {
		return teamMiaoShu;
	}

	public void setTeamMiaoShu(String teamMiaoShu) {
		this.teamMiaoShu = teamMiaoShu;
	}

}
