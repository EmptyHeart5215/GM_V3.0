package com.dykj.GSM.mapper.sys.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysMenu;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 下午10:35:09
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:
 */
public interface SysMenuMapper extends IBaseMapper<SysMenu, String> {
	/**
	 * 查询所有的menu树
	 */
	public List<SysMenu> queryAllList();

	/**
	 * 查询某用户权限下某父节点的所有子孙节点，用于首页左侧菜单列表展示
	 */
	public List<SysMenu> queryAllChildMenuByParent(Map map);

	/**
	 * 查找整棵树，再根据角色code查看是否拥有某权限，如果有，checked为1
	 */
	public List<SysMenu> queryAllByRoleCode(String roleCode);

	/**
	 * 同名验证
	 */
	SysMenu queryMenuNameSelect(Map<String, String> map);
	
	public SysMenu queryByCode(String roleCode);
	
	public List<SysMenu> queryAllParentMenuByChild(String roleCode);
}
