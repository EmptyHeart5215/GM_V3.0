package com.dykj.GSM.model.sys;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 下午10:08:09
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:角色权限对应表 角色权限对应表
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysRoleMenuMapper")
public class SysRoleMenu extends BaseModel {
	/**
	 * 菜单code
	 */
	@NotBlank
	private String menuCode;
	/**
	 * 角色code
	 */
	@NotBlank
	private String roleCode;

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
}
