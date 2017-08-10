package com.dykj.GSM.mapper.sys.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysUserMapper;
import com.dykj.GSM.model.sys.SysUser;

public class SysUserMapperImpl extends BaseMapperImpl<SysUser, String> implements SysUserMapper {
	@Override
	public List<Map<String, Object>> queryUserByName(String username) {
		return this.getSqlSession().selectList(getSqlName("queryUserByName"), username);
	}

	@Override
	public SysUser queryUserByUserName(String username) {
		return this.getSqlSession().selectOne(getSqlName("queryUserByUserName"), username);
	}

	@Override
	public SysUser queryUserByUserAndPwd(Map<String, Object> map) {
		return this.getSqlSession().selectOne(getSqlName("queryUserByUserAndPwd"), map);
	}

	@Override
	public SysUser queryUserWangGeYuan(String gridCode) {
		return this.getSqlSession().selectOne(getSqlName("queryUserWangGeYuan"), gridCode);
	}

}
