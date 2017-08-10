package com.dykj.GSM.mapper.sys.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysMenuMapper;
import com.dykj.GSM.model.sys.SysMenu;

public class SysMenuMapperImpl extends BaseMapperImpl<SysMenu, String> implements SysMenuMapper {
	/**
	 * 查询所有的menu树
	 */
	@Override
	public List<SysMenu> queryAllList() {
		return this.getSqlSession().selectList(getSqlName("queryAllList"));
	}

	/**
	 * 查询某用户权限下某父节点的所有子孙节点，用于首页左侧菜单列表展示
	 */
	@Override
	public List<SysMenu> queryAllChildMenuByParent(Map map) {
		return this.getSqlSession().selectList(getSqlName("queryAllChildMenuByParent"), map);
	}

	/**
	 * 查找整棵树，再根据角色code查看是否拥有某权限，如果有，checked为1
	 */
	@Override
	public List<SysMenu> queryAllByRoleCode(String roleCode) {
		return this.getSqlSession().selectList(getSqlName("queryAllByRole"), roleCode);
	}

	public SysMenu queryMenuNameSelect(Map<String, String> map) {
		return this.getSqlSession().selectOne(getSqlName("queryMenuNameSelect"), map);
	}

	@Override
	public SysMenu queryByCode(String roleCode) {
		return this.getSqlSession().selectOne(getSqlName("queryByCode"), roleCode);
	}

	@Override
	public List<SysMenu> queryAllParentMenuByChild(String roleCode) {
		return this.getSqlSession().selectList(getSqlName("queryAllParentMenuByChild"), roleCode);
	}
}
