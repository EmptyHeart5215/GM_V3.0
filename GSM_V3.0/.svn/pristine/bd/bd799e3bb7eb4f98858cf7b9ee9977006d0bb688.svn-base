package com.dykj.GSM.model.sys;

import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 功能键/菜单表
 * 
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysMenuMapper")
public class SysMenu extends BaseModel {
	/**
	 * 功能键/菜单名称
	 */
	@NotBlank
	private String menuName;
	/**
	 * 父节点code
	 */
	private String parentCode;
	/**
	 * 图片路径
	 */
	private String picUrl;
	/**
	 * 功能键/菜单路径
	 */
	private String actionUrl;
	/**
	 * 是否拥有隐藏菜单
	 */
	private Boolean hasHideMenu;
	/**
	 * 父节点名称
	 */
	@Transient
	private String parentName;
	/**
	 * 查询时判断是否是某个角色的权限
	 */
	@Transient
	private Boolean checked;
	/**
	 * 传入的角色code，用于查询某角色下的权限
	 */
	@Transient
	private String roleCode;
	/**
	 * 是否是叶子节点，0不是，1是
	 */
	@Transient
	private Boolean isleaf;
	/**
	 * 层级
	 */
	@Transient
	private int level;
	/**
	 * 是否是菜单
	 */
	private Boolean isMenu;

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getActionUrl() {
		return actionUrl;
	}

	public void setActionUrl(String actionUrl) {
		this.actionUrl = actionUrl;
	}

	public Boolean getHasHideMenu() {
		return hasHideMenu;
	}

	public void setHasHideMenu(Boolean hasHideMenu) {
		if (hasHideMenu == null) {
			this.hasHideMenu = false;
		} else {
			this.hasHideMenu = hasHideMenu;
		}
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public Boolean getIsleaf() {
		return isleaf;
	}

	public void setIsleaf(Boolean isleaf) {
		this.isleaf = isleaf;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Boolean getIsMenu() {
		return isMenu;
	}

	public void setIsMenu(Boolean isMenu) {
		this.isMenu = isMenu;
	}
	
}
