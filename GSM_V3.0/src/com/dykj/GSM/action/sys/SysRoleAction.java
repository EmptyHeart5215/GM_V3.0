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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.sys.SysRole;
import com.dykj.GSM.service.sys.SysRoleService;
import com.dykj.GSM.utils.ActionMessage;

@RestController
@RequestMapping(value = "/sys/role")
public class SysRoleAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysRoleAction.class);
	@Autowired
	private SysRoleService roleService;

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "sys/role/add");
		return new ModelAndView("/sys/role/info", "vdata", vdata);
	}

	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/role/manage");
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
	@RequestMapping(value = "/queryManage")
	public Object queryByParamPage(int page, int rows, String sidx, String sord, SysRole param) {
		try {
			System.out.println(param.getRoleName() + "_______________________________________");
			return roleService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 为用户选择角色而做的树
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryAllRoleTreeForSelect")
	public Object queryAllRoleTreeForSelect() {
		try {
			return roleService.queryAllRoleTreeForSelect();
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false);
		}
	}

	/**
	 * 新增
	 * 
	 * @param sysdic
	 * @return @
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysRole sysRole, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if(roleService.queryNameRoleSelect(sysRole.getRoleName())){
				
					if (roleService.insert(sysRole) != 0) {
						return new ActionMessage(true);
					} else {
						return new ActionMessage(false);
					}
				
				}else{
					return new ActionMessage(false).setinfo("角色名称重复，请更换角色名称");
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			SysRole sysRole = roleService.queryByKey(code);
			vdata.put("url", "sys/role/modify");
			vdata.put("sysRole", sysRole);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/role/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param rrole
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysRole role) throws Exception {
		try {
			if (roleService.update(role) != 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (roleService.deleteBatch(codes) != 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	/**
	 * 详细页面加载
	 * 
	 * @param code
	 *            主键
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/infoSee")
	public ModelAndView infoSee(String code) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		return new ModelAndView("/sys/role/infoSee", "vdata", vdata);
	}
	
}
