package com.dykj.GSM.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysMenu;
import com.dykj.GSM.service.sys.SysMenuService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/menu")
public class SysMenuAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysMenuAction.class);
	@Autowired
	private SysMenuService menuService;

	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad(@RequestParam String parentCode, @RequestParam String parentName) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		Map<String, Object> menuMap = new HashMap<String, Object>();
		vdata.put("url", "/sys/menu/add");
		menuMap.put("parentCode", parentCode);
		vdata.put("menu", menuMap);
		return new ModelAndView("/sys/menu/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param menu
	 * @return @
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysMenu menu, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			if (menu.getHasHideMenu() == null) {
				menu.setHasHideMenu(false);
			}
			menu.setCreateBy(MySession.getInfo().getCode());
			if (menuService.queryMenuNameSelect(menu.getMenuName(), menu.getParentCode())) {
				int i = menuService.insert(menu);
				if (i > 0) {
					return new ActionMessage(true);
				} else {
					throw new Exception("没有成功插入数据!");
				}
			} else {
				return new ActionMessage(false).setinfo("角色名称重复，请更换角色名称");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			SysMenu b = menuService.queryByKey(code);
			vdata.put("menu", b);
		} catch (Exception e) {
			logger.error("error", e);
		}
		vdata.put("url", "/sys/menu/modify");
		return new ModelAndView("/sys/menu/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param menu
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysMenu menu, BindingResult result) {
		try {
			if (menu.getCode() == null || "".equals(menu.getCode().trim())) {
				return new ActionMessage(false);
			}
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			menu.setCreateBy(session.getCode());
			int i = menuService.update(menu);
			if (i > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("更新数据没有成功!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/menu/manage");
	}

	/**
	 * 维护菜单树时用到的方法
	 */
	@RequestMapping(value = "/queryManage")
	public List<SysMenu> queryManage() {
		try {
			return menuService.queryAllTree();
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 通过主键查询
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryByCode")
	public SysMenu queryByCode(String code) {
		// return RMenuService.queryByCode(code);
		return menuService.queryByCode(code);
	}

	/**
	 * 查询根菜单
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/queryRoot")
	public List<SysMenu> queryRoot() {
		SessionModel session = MySession.getInfo();
		try {
			return menuService.queryRoot(session.getRoleCode());
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据父节点找到某用户权限下的所有子孙节点
	 * 
	 * @param parentCode
	 * @return
	 */
	@RequestMapping(value = "/queryAllChildMenuByParent")
	public List<SysMenu> queryAllChildMenuByParent(@RequestParam String parentCode) {
		SessionModel session = MySession.getInfo();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentCode", parentCode);
		map.put("roleCode", session.getRoleCode());
		return menuService.queryAllChildMenuByParent(map);
	}

	/**
	 * 根据父节点找到某用户权限下的子节点
	 * 
	 * @param parentCode
	 * @return
	 */

	@RequestMapping(value = "/queryMenuByParent")
	public List<SysMenu> queryMenuByParent(@RequestParam String parentCode) {
		SessionModel session = MySession.getInfo();
		try {
			return menuService.queryByParent(session.getRoleCode(), parentCode);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * * @RequestMapping(value = "/queryMenu") public List<Map<String, Object>>
	 * queryMenu() {
	 * 
	 * SessionModel session = MySession.getInfo(); return
	 * RMenuService.queryMenu(session.getCODE());
	 * 
	 * }
	 * 
	 * @RequestMapping(value = "/queryMenuByParent") public List<Map<String,
	 * Object>> queryMenuByParent(String parentCode) { return
	 * RMenuService.queryMenuByParent(parentCode);
	 * 
	 * }
	 * 
	 * }
	 */
	/**
	 * 修改
	 * 
	 * @param menu
	 * @return @
	 */
	@RequestMapping(value = "/delete")
	public ActionMessage delete(String code) {
		try {
			int i = menuService.deletePk(code);
			if (i > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("删除数据没有成功!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}
	
	@RequestMapping(value = "/queryAllParentMenuByChild")
	public List<SysMenu> queryAllParentMenuByChild(@RequestParam String code) {
		
			return menuService.queryAllParentMenuByChild(code);
		
	}
}
