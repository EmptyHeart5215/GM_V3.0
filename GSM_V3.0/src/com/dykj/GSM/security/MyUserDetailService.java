package com.dykj.GSM.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.sys.impl.SysUserMapperImpl;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysUser;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private SysUserMapperImpl sysUserMapperImpl;
	private UserCache userCache;

	public UserCache getUserCache() {
		return userCache;
	}

	public void setUserCache(UserCache userCache) {
		this.userCache = userCache;
	}

	// 登陆验证时，通过username获取用户的所有权限信息，
	// 并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserDetails model = userCache.getUserFromCache(username);
		if (model == null) {
			SysUser user = null;
			if (username != null && !username.isEmpty()) {
				user = sysUserMapperImpl.queryUserByUserName(username);
			}
			if (user == null) {
				throw new UsernameNotFoundException(username);
			}
			model = SessionModel.setUserForSecurity(user);
			userCache.putUserInCache(model);
			return model;
		}
		return model;
	}
}