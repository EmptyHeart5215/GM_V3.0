package com.dykj.GSM.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysUser;
import com.dykj.GSM.service.sys.SysUserService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/user")
public class SysUserAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysUserAction.class);
	@Autowired
	private SysUserService userService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/user/manage");
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
	 * @return json数据
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryManage")
	public Object queryByParamPage(int page, int rows, String sidx, String sord, SysUser param) {
		try {
			System.out.println(param.getLoginName() + "_______________________________________");
			return userService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 新增页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "sys/user/add");
		return new ModelAndView("/sys/user/info", "vdata", vdata);
	}

	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysUser user, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				SysUser u = userService.queryUserByUserName(user.getLoginName());
				if (u == null) {
					if (userService.insert(user) != 0) {
						return new ActionMessage(true);
					} else {
						return new ActionMessage(false);
					}
				} else {
					return new ActionMessage(false).setinfo("名称重复，请更换名称");
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
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			SysUser sysUser = userService.queryByKey(code);
			vdata.put("url", "sys/user/modify");
			vdata.put("user", sysUser);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/user/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param rusers
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysUser user) throws Exception {
		try {
			if (userService.update(user) != 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	/**
	 * 修改
	 * 
	 * @param rusers
	 * @return
	 * @throws Exception
	 */
	/*
	 * @RequestMapping(value = "/lockOrUnlock") public ActionMessage
	 * modify(@RequestParam String[] codes, Boolean nowState) throws Exception {
	 * for (int i = 0; i < tempList.size(); i++) { SysUser tempUser =
	 * tempList.get(i); List codesList = Arrays.asList(codes); if
	 * (codesList.contains(tempUser.getCode())) {
	 * tempUser.setFlagIsEnable(!nowState); tempList.set(i, tempUser); } }
	 * return new ActionMessage(true); }
	 */
	/**
	 * 删除
	 * 
	 * @param codes
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		/*
		 * for (int i = 0; i < tempList.size(); i++) { SysUser tempUser =
		 * tempList.get(i); List codesList = Arrays.asList(codes); if
		 * (codesList.contains(tempUser.getCode())) { tempList.remove(i); i--; }
		 * } return new ActionMessage(true);
		 */
		try {
			if (userService.deleteBatch(codes) != 0) {
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
		return new ModelAndView("/sys/user/infoSee", "vdata", vdata);
	}

	/**
	 * 对外接口
	 * 
	 * @param codes
	 * @return @
	 */
	@RequestMapping(value = "/queryUserByName")
	public List<Map<String, Object>> queryGridTree(String username) {
		return userService.queryUserByName(username);
	}

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request) throws Exception {
		request.getSession().setAttribute("base", "/GSM_V3.0");
		return new ModelAndView("/login");
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public ActionMessage userlogin(String username, String password) throws Exception {
		SessionModel model = MySession.getInfo();
		return new ActionMessage(true).setinfo(model);
	}
	/**
	 * 用户详细信息
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/userManage")
	public SysUser UserManage(HttpServletResponse response,HttpServletRequest request) throws Exception{
		SessionModel aa=MySession.getInfo();
		return userService.queryByKey(aa.getCode());
	}
	@RequestMapping(value = "/setPwd")
	public ActionMessage setPwd(String pwd_old,String pwd_new,String pwd_new_again) throws Exception {
		SessionModel session=MySession.getInfo();
		String pwdOld = DigestUtils.md5Hex(pwd_old);
		String pwdNew = DigestUtils.md5Hex(pwd_new);
		SysUser user  = userService.queryByKey(session.getCode());
		String login_pwd = user.getPassWord();
		if (login_pwd.equals(pwdOld)) {
			if(pwd_new.equals(pwd_new_again)){
				user.setPassWord(pwdNew);
				
				if(userService.update(user) != 0){
					return new ActionMessage(true);
				}
			}
		}else{
			return new ActionMessage(false).setinfo("当前密码输入不存在，请重新输入!");
		}
		return null;
	}
	

	/**
	 * ???-对外接口
	 * 
	 * @param codes
	 * @return @
	 */
	@RequestMapping(value = "/userWangGeYuan")
	public SysUser queryUserWangGeYuan(String gridCode) {
		System.out.println("************"+gridCode);
		return userService.queryUserWangGeYuan(gridCode);
	}
}

