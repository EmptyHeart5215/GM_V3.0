package com.dykj.GSM.action.yanpanfenxi;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
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
import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.service.base.BJiGouServiceService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/yanpanfenxi/jigouservicequery")
public class BJiGouServiceQueryAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BJiGouServiceQueryAction.class);
	@Autowired
	private BJiGouServiceService jigouservs;
	private List<BJiGouService> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/yanpanfenxi/jigouservicequery/manage");
	}
	/**
	 * 地图管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/mapmanageLoad")
	public ModelAndView draftmapManageLoad() {
		return new ModelAndView("/base/bjigouservice/mapmanage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, BJiGouService param) {
		try {
			
			return jigouservs.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}
	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String entryId, int stepId, String eventCode) {
		Map<String, Object> vdata = this.approvalData(entryId, stepId, eventCode);
		return new ModelAndView("/base/bjigouservice/approval", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String entryId, int stepId, String eventCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			BJiGouService jigouserv = jigouservs.queryByKey(eventCode);
			vdata.put("jigouserv", jigouserv);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return vdata;
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
		vdata.put("url", "base/bjigouservice/add");
		return new ModelAndView("/base/bjigouservice/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BJiGouService jigouserv, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if (0!=jigouservs.insert(jigouserv)  ) {
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
			BJiGouService jigouserv = jigouservs.queryByKey(code);
			vdata.put("url", "base/bjigouservice/modify");
			vdata.put("bjigouser", jigouserv);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("base/bjigouservice/info", "vdata", vdata);
	}
	/**
	 * 修改
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BJiGouService jigouserv ) throws Exception {
		try {
			if (jigouservs.update(jigouserv) != 0) {
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

	@RequestMapping(value = "/delete")
public ActionMessage delete(@RequestParam List<String> codes) {
		
		try {
			if (jigouservs.deleteBatch(codes) != 0) {
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
}
