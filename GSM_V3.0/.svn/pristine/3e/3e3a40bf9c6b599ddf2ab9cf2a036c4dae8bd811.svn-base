package com.dykj.GSM.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.dykj.GSM.mapper.sys.impl.SysRoleMapperImpl;
import com.dykj.GSM.mapper.sys.impl.SysRoleMenuMapperImpl;
import com.dykj.GSM.model.sys.SysRoleTree;

public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	private final UrlMatcher urlMatcher = new AntUrlPathMatcher();
	// 如果权限和路径对应表有修改,那么需要相应的修改resourceMap的值
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
	// 只要是登陆的用户都应该有的访问路径
	private List<String> defaultUrl;
	private Collection<ConfigAttribute> allRoles;
	private Map<String, String> duiYingUrlMap;
	@Resource
	private SysRoleMenuMapperImpl sysRoleMenuMapperImpl;
	@Resource
	private SysRoleMapperImpl sysRoleMapperImpl;

	// tomcat启动时实例化一次
	public MyInvocationSecurityMetadataSource() {
	}

	// key是请求的url，value是对应的url
	private Map<String, String> returnDuiYingUrlMap() {
		// 存放请求的地址，
		String[] requestUrls = { "/sys/rolemenu/grantLoad;/sys/rolemenu/grant",
				"/sys/seatthird/*;/sys/seatsecond/*;/sys/seatfour/*", "/sys/dicvalue/*",
				"/sys/sysupload/uploadApp;/sys/sysupload/upload;/sys/sysupload/uploadFile;/sys/sysupload/downLoad",
				"/base/person/*;/base/unit/*;/base/building/*;/base/*/person/*",
				"/sys/sysupload/uploadApp;/sys/sysupload/upload;/sys/sysupload/downLoad;/sys/sysupload/uploadFile",
				"/sys/sysupload/upload;/sys/sysupload/downLoad;/sys/sysupload/uploadFile",
				"/sys/sysupload/upload;/sys/sysupload/downLoad;/sys/sysupload/uploadFile;/sys/sysupload/infosee" };
		// 存放对应的地址，意思是说只要有对应的某个地址的权限就有请求的某个地址的权限，比如有角色管理的权限，url是/sys/role/*,就有角色授权/sys/rolemenu/*的权限
		String[] duiYingUrls = { "/sys/role/*", "/sys/seatgird/*", "/sys/dic/*", "/event/econtradic/*",
				"/base/house/*", "/event/eevent/*", "/zongzhitraining/materialmanagement/*",
				"/emergencyscheduling/emergencyplan/*" };
		duiYingUrlMap = new HashMap<String, String>();
		/*for (int i = 0; i < duiYingUrls.length; i++) {
			String s = duiYingUrls[i];
			String[] r = requestUrls[i].split(";");
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < r.length; j++) {
				list.add(r[j]);
			}
			duiYingUrlMap.put(s, list);
		}*/
		for (int i = 0; i < requestUrls.length; i++) {
			String s = duiYingUrls[i];
			String[] r = requestUrls[i].split(";");
			for (int j = 0; j < r.length; j++) {
				duiYingUrlMap.put(r[j], s);
			}
		}
		return duiYingUrlMap;
	}

	private void initDefaultUrl() {
		String url = "/sys/sysupload/queryByCodes;/sys/main/staticForIndex;/sys/main/queryPersonTypeStatistics;/sys/dicvalue/queryManageTree;/sys/main/mainLoad;/sys/menu/queryRoot;/sys/menu/queryMenuByParent;/sys/menu/queryAllChildMenuByParent;/sys/main/index;/sys/seatgird/queryGridTreeByUserGridCode;/sys/seatgrid/queryMenuByParent;/sys/role/queryManage;/sys/rolemenu/queryAllByRole;/sys/seatgird/queryOrgnizationTreeForSelect";
		defaultUrl = Arrays.asList(url.split(";"));
	}

	private List<String> getDefaultUrl() {
		// 临时的
		String url = "/sys/sysupload/queryByCodes;/sys/main/staticForIndex;/sys/main/queryPersonTypeStatistics;/sys/dicvalue/queryManageTree;/sys/main/mainLoad;/sys/main/home;/sys/menu/queryRoot;/sys/menu/queryMenuByParent;/sys/menu/queryAllChildMenuByParent;/sys/main/index;/sys/seatgird/queryGridTreeByUserGridCode;/sys/seatgrid/queryMenuByParent;/sys/role/queryManage;/sys/rolemenu/queryAllByRole;/sys/seatgird/queryOrgnizationTreeForSelect";
		defaultUrl = Arrays.asList(url.split(";"));
		return defaultUrl;
	}

	public Collection<ConfigAttribute> getAllRoles() {
		return allRoles;
	}

	// 得到所有的角色，在角色修改或删除的时候需要更新它
	public void setAllRole(SysRoleMapperImpl sysRoleMapperImpl) {
		if (sysRoleMapperImpl == null) {
			sysRoleMapperImpl = this.sysRoleMapperImpl;
		}
		List<SysRoleTree> allRole = sysRoleMapperImpl.queryAllRoleTreeForSelect();
		allRoles = new ArrayList<ConfigAttribute>();
		for (SysRoleTree m : allRole) {
			ConfigAttribute c = new SecurityConfig(m.getCode());
			allRoles.add(c);
		}
	}

	// 得到角色权限对应数据，在修改rolemenu表的时候需要更新它
	public void resetMap(SysRoleMenuMapperImpl sysRoleMenuMapperImpl) {
		if (sysRoleMenuMapperImpl == null) {
			sysRoleMenuMapperImpl = this.sysRoleMenuMapperImpl;
		}
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		List<Map<String, Object>> list = sysRoleMenuMapperImpl.queryAllRoleAndUrl();
		for (Map<String, Object> map : list) {
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			String[] roleNames = map.get("ROLECODE").toString().split(",");
			for (int i = 0; i < roleNames.length; i++) {
				ConfigAttribute con = new SecurityConfig(roleNames[i]);
				atts.add(con);
			}
			resourceMap.put(map.get("URL").toString(), atts);
		}
	}

	@PostConstruct
	// tomcat开启时加载一次，加载所有url和权限（或角色）的对应关系
	private void loadResourceDefine() {
		initDefaultUrl();
		resetMap(this.sysRoleMenuMapperImpl);
		setAllRole(sysRoleMapperImpl);
		returnDuiYingUrlMap();
	}

	private String getDuiYingUrl(String url) {
		String returnUrl = duiYingUrlMap.get(url);
		if (returnUrl == null) {
			returnUrl = url.substring(0, url.lastIndexOf("/") + 1) + "*";
			returnUrl = duiYingUrlMap.get(returnUrl);
			if (returnUrl != null) {
				return returnUrl;
			}
		}
		if (returnUrl == null) {
			Set<String> keys = duiYingUrlMap.keySet();
			AntUrlPathMatcher pathMatcher = new AntUrlPathMatcher();
			for (String key : keys) {
				if (pathMatcher.pathMatchesUrl(key, url)) {
					return getDuiYingUrl(key);
				}
			}
		}
		return returnUrl;
	}

	// 参数是要访问的url，返回这个url对于的所有权限（或角色）
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

		// 将参数转为url
		String url = ((FilterInvocation) object).getRequestUrl();
		int in = url.indexOf("?");
		if (in != -1) {
			url = url.substring(0, in);
		}
		List<String> list = getDefaultUrl();
		if (list.contains(url)) {
			return allRoles;
		} else {
			String tempUrl = getDuiYingUrl(url);
			if (tempUrl != null) {
				url = tempUrl;
			}
		}
		Iterator<String> ite = resourceMap.keySet().iterator();
		while (ite.hasNext()) {
			String resURL = ite.next();
			if (urlMatcher.pathMatchesUrl(resURL, url)) {
				System.out.println(resourceMap.get(resURL));
				return resourceMap.get(resURL);
			}
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

}
