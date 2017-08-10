package com.dykj.GSM.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysMenuMapperImpl;
import com.dykj.GSM.mapper.sys.impl.SysRoleMenuMapperImpl;
import com.dykj.GSM.model.sys.SysMenu;
import com.dykj.GSM.security.MyInvocationSecurityMetadataSource;
import com.dykj.GSM.service.sys.SysMenuService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuMapperImpl menuMapperImpl;
	@Autowired
	private SysRoleMenuMapperImpl roleMenuMapperImpl;

	@Override
	public int insert(SysMenu entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return menuMapperImpl.insert(entity);
	}

	@Override
	public int update(SysMenu entity) {
		if (entity.getCode() != null && !entity.getCode().isEmpty()) {
			entity.setCreateDate(DateFormatUtil.getStringDate());
			int i = menuMapperImpl.update(entity);
			new MyInvocationSecurityMetadataSource().resetMap(roleMenuMapperImpl);
			return i;
		}
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) {
		return menuMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysMenu queryByKey(String primaryKey) {
		return menuMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysMenu> queryList() {
		return menuMapperImpl.queryList();
	}

	/**
	 * 查询某用户角色里的所有根菜单
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysMenu> queryRoot(String roleCode) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 代表父级菜单为空的
		map.put("parentCode", "--");
		map.put("roleCode", roleCode);
		if (roleCode == null || roleCode.trim().isEmpty()) {
			throw new Exception("角色不能为空！");
		}
		return menuMapperImpl.queryListParam(map);
	}

	@Override
	public List<SysMenu> queryByParent(String roleCode, String parentCode) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 代表父级菜单为空的
		map.put("parentCode", parentCode);
		map.put("roleCode", roleCode);
		if (roleCode == null || roleCode.trim().isEmpty()) {
			throw new Exception("角色不能为空！");
		}
		return menuMapperImpl.queryListParam(map);
	}

	/**
	 * 查询整个菜单树
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<SysMenu> queryAllTree() throws Exception {
		return menuMapperImpl.queryAllList();
	}

	/**
	 * 查询某用户权限下某父节点的所有子孙节点，用于首页左侧菜单列表展示
	 */
	@Override
	public List<SysMenu> queryAllChildMenuByParent(Map map) {
		return menuMapperImpl.queryAllChildMenuByParent(map);
	}

	@Override
	public List<SysMenu> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysMenu> queryTListParam(SysMenu param) {
		return menuMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysMenu> queryByParamPage(int page, int size, String sidx, String sord, SysMenu param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 查找整棵树，再根据角色code查看是否拥有某权限，如果有，checked为1
	 */
	@Override
	public List<SysMenu> queryAllByRoleCode(String roleCode) {
		return menuMapperImpl.queryAllByRoleCode(roleCode);
	}

	@Override
	public boolean queryMenuNameSelect(String name, String parentCode) {
		boolean flag = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("parentCode", parentCode);
		SysMenu userCodeS = menuMapperImpl.queryMenuNameSelect(map);
		if (userCodeS == null) {
			flag = true;
		}
		return flag;
	}

	@Override
	public SysMenu queryByCode(String primaryKey) {
		return menuMapperImpl.queryByCode(primaryKey);
	}

	@Override
	public List<SysMenu> queryAllParentMenuByChild(String roleCode) {
		return menuMapperImpl.queryAllParentMenuByChild(roleCode);
	}
}
