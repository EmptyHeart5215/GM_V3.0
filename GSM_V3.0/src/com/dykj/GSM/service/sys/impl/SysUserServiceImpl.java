package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysUserMapperImpl;
import com.dykj.GSM.model.sys.SysUser;
import com.dykj.GSM.service.sys.SysUserService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class SysUserServiceImpl implements SysUserService {
	@Autowired
	private SysUserMapperImpl userMapperImpl;

	@Override
	public int insert(SysUser entity) {
		String pwd = DigestUtils.md5Hex("123456");
		entity.setCreateDate(DateFormatUtil.getStringDate());
		entity.setPassWord(pwd);
		;
		return userMapperImpl.insert(entity);
	}

	@Override
	public int update(SysUser entity) {
		return userMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return userMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysUser queryByKey(String primaryKey) {
		return userMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysUser> queryList() {
		return userMapperImpl.queryList();
	}

	@Override
	public List<SysUser> queryListParam(Map param) {
		return userMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysUser> queryTListParam(SysUser param) {
		return userMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysUser> queryByParamPage(int page, int size, String sidx, String sord, SysUser param) {
		Page<SysUser> p = userMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		return p;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return userMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> queryUserByName(String username) {
		return userMapperImpl.queryUserByName(username);
	}

	@Override
	public SysUser queryUserByUserName(String username) {
		return userMapperImpl.queryUserByUserName(username);
	}

	@Override
	public SysUser queryUserWangGeYuan(String gridCode) {
		return userMapperImpl.queryUserWangGeYuan(gridCode);
	}

}
