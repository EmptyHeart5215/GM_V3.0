package com.dykj.GSM.action.sys;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.service.sys.SysMenuService;
import com.dykj.GSM.service.sys.SysRoleMenuService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/rolemenu")
public class SysRoleMenuAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysRoleMenuAction.class);
	@Autowired
	private SysRoleMenuService roleMenuService;
	@Autowired
	private SysMenuService menuService;

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/grantLoad")
	public ModelAndView grantLoad(@RequestParam String code) {
		return new ModelAndView("/sys/rolemenu/grant", "roleCode", code);
	}

	/**
	 * 新增
	 * 
	 * @param rrolemenu
	 * @return @
	 */
	@RequestMapping(value = "/grant")
	public ActionMessage grant(@RequestParam String roleCode, @RequestParam String[] menuCodes) {
		SessionModel session = MySession.getInfo();
		try {
			int i = roleMenuService.grant(roleCode, Arrays.asList(menuCodes), session.getCode());
			if (i == menuCodes.length) {
				return new ActionMessage(true);
			} else {
				throw new Exception("没有成功插入数据!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/queryAllByRole")
	public Object queryAllByRole(@RequestParam String roleCode) {
		try {
			return menuService.queryAllByRoleCode(roleCode);
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(String[] codes) {
		return new ActionMessage(true);
	}

	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/rolemenu/manage");
	}
	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页函数
	 * @param sidx
	 *            排序字段
	 * @param sord
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据 @
	 */
	/*
	 * @RequestMapping(value = "/queryManage") public Map<String, Object>
	 * queryManage(int page, int rows, String sidx, String sord, String[] args)
	 * {
	 * 
	 * 
	 * }
	 */
}
