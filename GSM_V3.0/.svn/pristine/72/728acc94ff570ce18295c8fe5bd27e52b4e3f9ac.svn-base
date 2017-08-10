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
import com.dykj.GSM.model.eventfile.EventSignificantVisits;
import com.dykj.GSM.service.eventfile.EventSignificantVisitsService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

/**
 * 矛盾纠纷
 * 
 * @author limingda
 */
@RestController
@RequestMapping(value = "/eventfile/efsignificantvisits")
public class EventSignificantVisitsAction extends BaseAction {
	private static Logger logger = Logger.getLogger(EventSignificantVisitsAction.class);
	@Autowired
	private EventSignificantVisitsService significantVisitsService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView draftManageLoad() {
		return new ModelAndView("/eventfile/efsignificantvisits/manage");
	}

	/**
	 * 地图管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/mapmanageLoad")
	public ModelAndView draftmapManageLoad() {
		return new ModelAndView("/eventfile/efsignificantvisits/mapmanage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, EventSignificantVisits param) {
		try {
			return significantVisitsService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String eventCode) {
		Map<String, Object> vdata = this.approvalData(eventCode);
		return new ModelAndView("/eventfile/efsignificantvisits/infoSee", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String eventCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			EventSignificantVisits significantVisits = significantVisitsService.queryByKey(eventCode);
			vdata.put("efsignificantvisits", significantVisits);
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
		vdata.put("url", "eventfile/efsignificantvisits/add");
		return new ModelAndView("/eventfile/efsignificantvisits/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EventSignificantVisits significantVisits, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				significantVisits.setCreateBy(MySession.getInfo().getCode());
				if (0 != significantVisitsService.insert(significantVisits)) {
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
			EventSignificantVisits significantVisits = significantVisitsService.queryByKey(code);
			System.out.println(significantVisits.getRmark());
			vdata.put("url", "eventfile/efsignificantvisits/modify");
			vdata.put("efsignificantvisits", significantVisits);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("eventfile/efsignificantvisits/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid EventSignificantVisits significantVisits, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				significantVisits.setCreateBy(MySession.getInfo().getCode());
				if (significantVisitsService.update(significantVisits) != 0) {
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
			if (significantVisitsService.deleteBatch(codes) != 0) {
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
