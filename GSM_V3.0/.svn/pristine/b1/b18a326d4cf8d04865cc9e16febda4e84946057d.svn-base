package com.dykj.GSM.model.sys;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author Administrator
 * 
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysUserMapper")
public class SysUser extends BaseModel {
	/**
	 * 用户登录名
	 */
	@NotBlank
	private String loginName;
	/**
	 * 用户真实姓名
	 */
	@NotBlank
	private String realName;
	/**
	 * 密码
	 */
	private String passWord;
	/**
	 * 电话号码
	 */
	private String phone;
	/**
	 * 是否启用标识
	 */
	private Boolean flagIsEnable = true;
	/**
	 * 角色code
	 */
	@NotBlank
	private String roleCode;
	/**
	 * 所属网格
	 */
	@NotBlank
	private String gridCode;

	/**
	 * 所属组织结构
	 */
	private String departmentCode;

	/**
	 * 短信账户
	 */
	private String messageId;
	/**
	 * 短信密码
	 */
	private String messagePwd;
	/**
	 * gps上线时间
	 */
	private String gpsTime;
	/**
	 * 不知道干什么用的，先留着
	 */
	private String position;
	/**
	 * 角色名称
	 */
	@Transient
	private String roleName;
	/**
	 * 部门全名称名称，如：路南区-**街道-公安局
	 */
	@Transient
	private String departmentTotalName;

	/**
	 * 在页面上显示启用/禁用
	 */
	@Transient
	private String flagIsEnableString;

	public String getFlagIsEnableString() {
		if (true == flagIsEnable) {
			return "启用";
		}
		return "禁用";
	}

	public void setFlagIsEnableString(String flagIsEnableString) {
		this.flagIsEnableString = flagIsEnableString;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDepartmentTotalName() {
		return departmentTotalName;
	}

	public void setDepartmentTotalName(String departmentTotalName) {
		this.departmentTotalName = departmentTotalName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean getFlagIsEnable() {
		return flagIsEnable;
	}

	public void setFlagIsEnable(Boolean flagIsEnable) {
		this.flagIsEnable = flagIsEnable;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getMessagePwd() {
		return messagePwd;
	}

	public void setMessagePwd(String messagePwd) {
		this.messagePwd = messagePwd;
	}

	public String getGpsTime() {
		return gpsTime;
	}

	public void setGpsTime(String gpsTime) {
		this.gpsTime = gpsTime;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}
