package com.dykj.GSM.mapper.sys.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysRoleMenu;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 下午10:35:01
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:
 */
public interface SysRoleMenuMapper extends IBaseMapper<SysRoleMenu, String> {
	/**
	 * 授权操作
	 * 
	 * @param list
	 * @return
	 */
	public int grant(List<SysRoleMenu> list);

	/**
	 * 根据角色code删除对应关系
	 * 
	 * @param roleCode
	 * @return
	 */
	public int deleteByRoleCode(String roleCode);

	public List<Map<String, Object>> queryAllRoleAndUrl();
}
