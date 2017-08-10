package com.dykj.GSM.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StringUtils;

import com.dykj.GSM.mapper.sys.impl.SysUserMapperImpl;
import com.dykj.GSM.model.sys.SysUser;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	public static final String VALIDATE_CODE = "validateCode";
	public static final String USERNAME = "username";
	public static final String PASSWORD = "password";
	public static final String UKEY = "ukey";
	private int showCheckCode = 0;

	public int getShowCheckCode() {
		return showCheckCode;
	}

	public void setShowCheckCode(int showCheckCode) {
		this.showCheckCode = showCheckCode;
	}

	@Autowired
	private SysUserMapperImpl sysUserMapperImpl;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}
		// 检测验证码

		String username = obtainUsername(request);
		String password = obtainPassword(request);
		// 验证用户账号与密码是否对应
		username = username.trim();
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("username", username);
		m.put("password", DigestUtils.md5Hex(password));
		SysUser user = this.sysUserMapperImpl.queryUserByUserAndPwd(m);
		HttpSession session = request.getSession();
		session = request.getSession(false);// false代表不创建新的session，直接获取当前的session

		// 将用户名存进session，如果登录成功，显示在主页
		session.setAttribute("login_account", username);
		if (user == null) {
			session.setAttribute("showCheckCode", "1");
			session.setAttribute("SECURITY_LOGIN_EXCEPTION", "用户名或密码错误！");

			throw new AuthenticationServiceException("用户名或密码错误！");

		} else if (user.getPassWord().equals("") || user.getPassWord() == null) {

			session.setAttribute("showCheckCode", "1");
			session.setAttribute("SECURITY_LOGIN_EXCEPTION", "用户名或密码错误！");

			throw new AuthenticationServiceException("用户名或密码错误！");

		} else if (!user.getPassWord().equals(DigestUtils.md5Hex(password))) {// password加密后再进行验证

			session.setAttribute("showCheckCode", "1");
			session.setAttribute("SECURITY_LOGIN_EXCEPTION", "用户名或密码错误！");

			throw new AuthenticationServiceException("用户名或密码错误！");

		} else {

			if (session.getAttribute("showCheckCode") == "1") {
				session.setAttribute("showCheckCode", "0");
			}
		}

		// UsernamePasswordAuthenticationToken实现 Authentication
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		// Place the last username attempted into HttpSession for views

		// 允许子类设置详细属性
		setDetails(request, authRequest);
		// 运行UserDetailsService的loadUserByUsername 再次封装Authentication
		return this.getAuthenticationManager().authenticate(authRequest);

	}

	protected void checkValidateCode(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String sessionValidateCode = obtainSessionValidateCode(session);
		// 让上一次的验证码失效
		session.setAttribute(VALIDATE_CODE, null);
		String validateCodeParameter = obtainValidateCodeParameter(request);
		if (StringUtils.isEmpty(validateCodeParameter) || !sessionValidateCode.equalsIgnoreCase(validateCodeParameter)) {
			throw new AuthenticationServiceException("验证码错误！");
		}
	}

	private String obtainValidateCodeParameter(HttpServletRequest request) {
		Object obj = request.getParameter(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	protected String obtainSessionValidateCode(HttpSession session) {
		Object obj = session.getAttribute(VALIDATE_CODE);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}

}