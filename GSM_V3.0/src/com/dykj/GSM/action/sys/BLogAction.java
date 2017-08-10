package com.dykj.GSM.action.sys;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.sys.Log;
import com.dykj.GSM.service.sys.SysLogService;
import com.dykj.GSM.utils.ActionMessage;

@RestController
@RequestMapping(value = "/sys/log")
public class BLogAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BLogAction.class);
	@Autowired
	private SysLogService logService;
	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/log/manage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, Log param) {
		try {
			
			return logService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}
	@RequestMapping(value = "/infoSee")
	public ModelAndView infoSee(String code) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		Log log = logService.queryByKey(code);
		vdata.put("log", log);
		return new ModelAndView("sys/log/infoSee","vdata", vdata);
	}
}
