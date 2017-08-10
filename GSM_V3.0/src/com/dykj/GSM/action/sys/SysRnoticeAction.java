package com.dykj.GSM.action.sys;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysRnotice;
import com.dykj.GSM.service.sys.SysRnoticeService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.SendPush;

@RestController
@RequestMapping(value = "/sys/rnotice")
public class SysRnoticeAction {
	private static Logger logger = Logger.getLogger(SysRnoticeAction.class);
	@Autowired
	private SysRnoticeService sysRnoticeService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/rnotice/manage");
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页条数
	 * @param sort
	 *            排序字段名称
	 * @param order
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据
	 * @throws ParseException
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, SysRnotice param) throws ParseException {
		try {
			return sysRnoticeService.queryByParamPage(page, rows, sidx, sord, param);
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
		vdata.put("url", "sys/rnotice/add");
		return new ModelAndView("/sys/rnotice/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BCommunity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysRnotice sysRnotice, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				SessionModel model = MySession.getInfo();
				sysRnotice.setCreateBy(model.getCode());
				if (sysRnoticeService.insert(sysRnotice) != 0) {
					SendPush.sendGongGaoMessage(JSONObject.fromObject(sysRnotice).toString());
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
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
			SysRnotice sysRnotice = sysRnoticeService.queryByKey(code);
			vdata.put("url", "sys/rnotice/modify");
			vdata.put("sysRnotice", sysRnotice);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/rnotice/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param BCommunity
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysRnotice bcomm) throws Exception {
		try {
			if (sysRnoticeService.update(bcomm) != 0) {
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
			if (sysRnoticeService.deleteBatch(codes) != 0) {
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
		SysRnotice sysRnotice = sysRnoticeService.queryByKey(code);
		vdata.put("sysRnotice", sysRnotice);
		return new ModelAndView("sys/rnotice/infoSee", "vdata", vdata);
	}
}
