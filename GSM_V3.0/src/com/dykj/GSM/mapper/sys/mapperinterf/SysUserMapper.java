package com.dykj.GSM.mapper.sys.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysUser;

public interface SysUserMapper extends IBaseMapper<SysUser, String> {
	public List<Map<String, Object>> queryUserByName(String username);

	public SysUser queryUserByUserName(String username);

	public SysUser queryUserByUserAndPwd(Map<String, Object> map);
	
	public SysUser queryUserWangGeYuan(String gridCode); 
	
}
