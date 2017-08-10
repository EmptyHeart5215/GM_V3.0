package com.dykj.GSM.service.sys;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.model.sys.SysMenu;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 下午10:38:50
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:功能菜单
 */
public interface SysMenuService extends IBaseService<SysMenu, String> {
	public List<SysMenu> queryRoot(String roleCode) throws Exception;

	/**
	 * 查询整个菜单树
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<SysMenu> queryAllTree() throws Exception;

	/**
	 * 查询某用户权限下某父节点的所有子孙节点，用于首页左侧菜单列表展示
	 */
	public List<SysMenu> queryAllChildMenuByParent(Map map);

	/**
	 * 查找整棵树，再根据角色code查看是否拥有某权限，如果有，checked为1
	 */
	public List<SysMenu> queryAllByRoleCode(String roleCode);

	List<SysMenu> queryByParent(String roleCode, String parentCode) throws Exception;

	/**
	 * 同名验证
	 */
	boolean queryMenuNameSelect(String name, String parentCode);
	
	public SysMenu queryByCode(String primaryKey);
	
	public List<SysMenu> queryAllParentMenuByChild(String roleCode);
}
