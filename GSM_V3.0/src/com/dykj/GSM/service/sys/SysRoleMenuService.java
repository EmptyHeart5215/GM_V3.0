package com.dykj.GSM.service.sys;

import java.util.List;

import com.dykj.GSM.model.sys.SysRoleMenu;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 下午10:38:50
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:功能菜单
 */
public interface SysRoleMenuService extends IBaseService<SysRoleMenu, String> {
	/**
	 * 授权操作
	 * 
	 * @param list
	 * @return
	 */
	public int grant(String roleCode, List<String> menuCodes, String createBy);
}
