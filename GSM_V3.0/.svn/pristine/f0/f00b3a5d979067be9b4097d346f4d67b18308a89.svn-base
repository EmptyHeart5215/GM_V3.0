package com.dykj.GSM.action.zongzhitraining;

import java.util.ArrayList;
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
import com.dykj.GSM.model.zongzhitraining.EffectManagement;
import com.dykj.GSM.service.zongzhitraining.EffectManagementService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * 效果管理
 * 
 * @author wangmingyuan
 * 
 */
@RestController
@RequestMapping(value = "/zongzhitraining/effectmanagement")
public class EffectManagementAction extends BaseAction {

	@SuppressWarnings("unused")
	private static Logger logger = Logger.getLogger(EffectManagementAction.class);

	@Autowired
	private EffectManagementService effectManagementService;

	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("zongzhitraining/effectmanagement/manage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, EffectManagement param) {
		System.out.println(page + "----" + rows + "----" + sidx + "----" + sord);
		try {
			return effectManagementService.queryByParamPage(page, rows, sidx, sord, param);
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
		vdata.put("url", "zongzhitraining/effectmanagement/add");
		return new ModelAndView("zongzhitraining/effectmanagement/info", "vdata", vdata);
	}

	/**r
	 * 新增
	 * 
	 * @param sysdic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EffectManagement effectManagement, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				effectManagement.setDownLoadTime(DateFormatUtil.getStringDate());
				if (effectManagementService.insert(effectManagement) != 0) {
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
			EffectManagement effectManagement = effectManagementService.queryByKey(code);
			vdata.put("url", "zongzhitraining/effectmanagement/modify");
			vdata.put("effectManagement", effectManagement);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("zongzhitraining/effectmanagement/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysdic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid EffectManagement effectManagement) throws Exception {
		try {
			if (effectManagementService.update(effectManagement) != 0) {
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

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		System.out.println(codes);
		try {
			if (effectManagementService.deleteBatch(codes) != 0) {
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
		EffectManagement effectManagement = effectManagementService.queryByKey(code);
		vdata.put("effectManagement", effectManagement);
		return new ModelAndView("/zongzhitraining/effectmanagement/infoSee", "vdata", vdata);
	}
}
