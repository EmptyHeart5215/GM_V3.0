package com.dykj.GSM.mapper.sys.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysRoleMenuMapper;
import com.dykj.GSM.model.sys.SysRoleMenu;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 下午10:38:07
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:角色权限对应
 */
public class SysRoleMenuMapperImpl extends BaseMapperImpl<SysRoleMenu, String> implements SysRoleMenuMapper {
	/*
	 * 授权操作
	 */
	@Override
	public int grant(List<SysRoleMenu> list) {
		// 声明一个标记标量，当插入失败时为0，成功则非0
		int rows = 0;
		try {
			rows = this.getSqlSession().insert(getSqlName("insertBatch"), list);
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
		}
		return rows;
	}

	/**
	 * 根据角色code删除对应关系
	 * 
	 * @param roleCode
	 * @return
	 */
	@Override
	public int deleteByRoleCode(String roleCode) {
		// 声明一个标记标量，当插入失败时为0，成功则非0
		int rows = 0;
		try {
			rows = this.getSqlSession().delete(getSqlName("deleteByRoleCode"), roleCode);
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
		}
		return rows;
	}

	@Override
	public List<Map<String, Object>> queryAllRoleAndUrl() {
		List<Map<String, Object>> list = this.getSqlSession().selectList(getSqlName("queryAllRoleAndUrl"), null);
		return list;
	}
}
