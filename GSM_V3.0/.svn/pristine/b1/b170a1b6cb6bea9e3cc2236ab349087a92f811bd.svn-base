package com.dykj.GSM.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.dykj.GSM.model.sys.SysUser;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月18日 上午10:56:46 修改人： 修改日期： 类说明: 用于缓存使用
 */
public class SessionModel extends User {

	public SessionModel(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
	}

	public static SessionModel setUserForSecurity(SysUser user) {
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRoleCode());
		auths.add(authority);
		SessionModel model = new SessionModel(user.getLoginName(), user.getPassWord(), true, true, true, true, auths);
		model.setCode(user.getCode());
		model.setGridCode(user.getGridCode());
		model.setDepartmentCode(user.getDepartmentCode());
		model.setRoleCode(user.getRoleCode());
		model.setPwd(user.getPassWord());
		model.setRealName(user.getRealName());
		return model;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* 用户主键 */
	private String code;
	/* 辖区主键 */
	private String gridCode;
	/* 部门主键 */
	private String departmentCode;
	/* 角色主键 */
	private String roleCode;
	/* 短信账户 */
	private String messageId;
	/* 短息密码 */
	private String messagePwd;

	private String pwd;

	private String realName;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

}
