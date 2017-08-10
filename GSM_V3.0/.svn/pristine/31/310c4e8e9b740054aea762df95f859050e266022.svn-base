package com.dykj.GSM.service.sys.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysRoleMenuMapperImpl;
import com.dykj.GSM.model.sys.SysRoleMenu;
import com.dykj.GSM.security.MyInvocationSecurityMetadataSource;
import com.dykj.GSM.service.sys.SysRoleMenuService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service("roleMenuService")

public class SysRoleMenuServiceImpl implements SysRoleMenuService {
	@Autowired
	private SysRoleMenuMapperImpl menuMapperImpl;

	/*
	 * 授权操作
	 */
	@Override
	public int grant(String roleCode, List<String> menuCodes, String createBy) {
		// 先删除对应关系
		menuMapperImpl.deleteByRoleCode(roleCode);
		// 然后进行插入操作
		List<SysRoleMenu> roleList = new ArrayList<SysRoleMenu>();
		String createDate = DateFormatUtil.getStringDate();
		for (String menu : menuCodes) {
			SysRoleMenu role = new SysRoleMenu();
			String code = UUID.randomUUID().toString().replaceAll("-", "");
			role.setCode(code);
			role.setCreateBy(createBy);
			role.setCreateDate(createDate);
			role.setMenuCode(menu);
			role.setRoleCode(roleCode);
			roleList.add(role);
		}
		int i = menuMapperImpl.grant(roleList);
		new MyInvocationSecurityMetadataSource().resetMap(menuMapperImpl);
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#insert(java.lang.Object)
	 */
	@Override
	public int insert(SysRoleMenu entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#update(java.lang.Object)
	 */
	@Override
	public int update(SysRoleMenu entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#deletePk(java.io.Serializable)
	 */
	@Override
	public int deletePk(String primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#queryByKey(java.io.Serializable)
	 */
	@Override
	public SysRoleMenu queryByKey(String primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#queryList()
	 */
	@Override
	public List<SysRoleMenu> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#queryListParam(java.util.Map)
	 */
	@Override
	public List<SysRoleMenu> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#queryTListParam(java.lang.Object)
	 */
	@Override
	public List<SysRoleMenu> queryTListParam(SysRoleMenu param) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#queryByParamPage(int, int,
	 * java.lang.String, java.lang.String, java.lang.Object)
	 */
	@Override
	public Page<SysRoleMenu> queryByParamPage(int page, int size, String sidx, String sord, SysRoleMenu param) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#deleteBatch(java.util.List)
	 */
	@Override
	public int deleteBatch(List<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}
}
