package com.dykj.GSM.action.eventfile;

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
import com.dykj.GSM.model.event.EOpinion;
import com.dykj.GSM.model.eventfile.EventHarmSafe;
import com.dykj.GSM.service.eventfile.EventHarmSafeService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/eventfile/efharmsafe")
public class EventHarmSafeAction extends BaseAction {
	private static Logger logger = Logger.getLogger(EventHarmSafeAction.class);
	@Autowired
	private EventHarmSafeService eHarmSafeserv;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/manageLoad")
	public ModelAndView draftManageLoad() {
		return new ModelAndView("/eventfile/efharmsafe/manage");
	}

	/**
	 * 地图管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/mapmanageLoad")
	public ModelAndView draftmapManageLoad() {
		return new ModelAndView("/eventfile/efharmsafe/mapmanage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, EventHarmSafe param) {
		try {
			return eHarmSafeserv.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String eventCode) {
		Map<String, Object> vdata = this.approvalData(eventCode);
		return new ModelAndView("/eventfile/efharmsafe/infoSee", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String eventCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			EventHarmSafe eHarmSafe = eHarmSafeserv.queryByKey(eventCode);
			vdata.put("efharmsafe", eHarmSafe);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return vdata;
	}

	@RequestMapping(value = "/approval")
	public ActionMessage approval(String eventCode, long wfid, int stepId, int actionId, String owner,
			EOpinion opinion, Integer duration) {
		return new ActionMessage(true);
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
		vdata.put("url", "eventfile/efharmsafe/add");
		return new ModelAndView("/eventfile/efharmsafe/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EventHarmSafe eHarmSafe, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				eHarmSafe.setCreateBy(MySession.getInfo().getCode());
				if (eHarmSafeserv.insert(eHarmSafe) != 0) {
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
			EventHarmSafe eHarmSafe = eHarmSafeserv.queryByKey(code);
			vdata.put("url", "eventfile/efharmsafe/modify");
			vdata.put("efharmsafe", eHarmSafe);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("eventfile/efharmsafe/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid EventHarmSafe eventharmsafe, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				eventharmsafe.setCreateBy(MySession.getInfo().getCode());
				if (eHarmSafeserv.update(eventharmsafe) != 0) {
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
				}
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	/**
	 * 删除
	 * 
	 * @param allparty
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/delete")
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (eHarmSafeserv.deleteBatch(codes) != 0) {
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
