package com.dykj.GSM.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysRoleMapperImpl;
import com.dykj.GSM.model.sys.SysRole;
import com.dykj.GSM.model.sys.SysRoleTree;
import com.dykj.GSM.security.MyInvocationSecurityMetadataSource;
import com.dykj.GSM.service.sys.SysRoleService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月18日 上午9:44:25 修改人： 修改日期： 类说明:
 */
@Service

public class SysRoleServiceImpl implements SysRoleService {
	@Autowired
	private SysRoleMapperImpl roleMapperImpl;

	@Override
	public int insert(SysRole entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = roleMapperImpl.insert(entity);
		new MyInvocationSecurityMetadataSource().setAllRole(roleMapperImpl);
		return i;
	}

	@Override
	public int update(SysRole entity) {
		return roleMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		int i = roleMapperImpl.deletePk(primaryKey);
		new MyInvocationSecurityMetadataSource().setAllRole(roleMapperImpl);
		return i;
	}

	@Override
	public SysRole queryByKey(String primaryKey) {
		return roleMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysRole> queryList() {
		return null;
	}

	@Override
	public List<SysRole> queryListParam(Map param) {
		return roleMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysRole> queryTListParam(SysRole param) {
		return roleMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysRole> queryByParamPage(int page, int size, String sidx, String sord, SysRole param) {
		return roleMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		int i = roleMapperImpl.deleteBatch(list);

		new MyInvocationSecurityMetadataSource().setAllRole(roleMapperImpl);
		return i;
	}

	/**
	 * 为用户选择角色而做的树
	 * 
	 * @return
	 */
	@Override
	public List<SysRoleTree> queryAllRoleTreeForSelect() {
		List<SysRoleTree> list = roleMapperImpl.queryAllRoleTreeForSelect();
		return list;
	}

	@Override
	public boolean queryNameRoleSelect(String roleName) {
		boolean flag= false;    
		SysRole userCodeS = roleMapperImpl.queryNameRoleSelect(roleName);  
	    if(userCodeS == null){ 
	    	flag = true;  
	    }  
	    return flag;
	}
}
