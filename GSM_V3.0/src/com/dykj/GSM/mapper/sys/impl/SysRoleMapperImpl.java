package com.dykj.GSM.mapper.sys.impl;

import java.util.List;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysRoleMapper;
import com.dykj.GSM.model.sys.SysRole;
import com.dykj.GSM.model.sys.SysRoleTree;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月18日 上午9:46:42 修改人： 修改日期： 类说明:
 */
public class SysRoleMapperImpl extends BaseMapperImpl<SysRole, String> implements SysRoleMapper {
	/**
	 * 为用户选择角色而做的树
	 * 
	 * @return
	 */
	@Override
	public List<SysRoleTree> queryAllRoleTreeForSelect() {
		try {
			return this.getSqlSession().selectList(getSqlName("queryAllRoleTreeForSelect"));
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
			return null;
		}
	}

	public SysRole queryNameRoleSelect(String primaryKey) {
		return this.getSqlSession().selectOne(getSqlName("queryNameRoleSelect"), primaryKey);
	}
}
