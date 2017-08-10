package com.dykj.GSM.action.event;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.event.EEvent;
import com.dykj.GSM.model.event.EOpinion;
import com.dykj.GSM.service.event.EEventService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.workflow.FactoryException;

@RestController
@RequestMapping(value = "/event/eevent")
public class EEventAction extends BaseAction {
	private static Logger logger = Logger.getLogger(EEventAction.class);
	@Autowired
	private EEventService eventService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/draftManageLoad")
	public ModelAndView draftManageLoad() {
		return new ModelAndView("/event/eevent/draftManage");
	}

	@RequestMapping(value = "/mapdraftManageLoad")
	public ModelAndView mapdraftManageLoad() {
		return new ModelAndView("/event/eevent/mapmanage");
	}

	/**
	 * 事件暂存分页查询
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/draftManage")
	public Object draftManage(int page, int rows, String sidx, String sord, String args) {
		SessionModel model = MySession.getInfo();
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			m = Utils.handleDateValue(m, "createDate");
			m.put("userCode", model.getCode());
			// m.put("gridCode", model.getGridCode());
			return eventService.queryDraftPage(sidx, rows, page, sord, m);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/daibanManageLoad")
	public ModelAndView daibanManageLoad() {
		return new ModelAndView("/event/eevent/daibanManage");
	}

	/**
	 * 事件代办分页查询
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/daibanManage")
	public Object daibanManage(int page, int rows, String sidx, String sord, String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m, "stepId");
			m = Utils.handleDateValue(m, "startDate,timeLimit");
			// m.put("gridCode", model.getGridCode());
			return eventService.queryDaiBanPage(sidx, rows, page, sord, m, model);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yibanManageLoad")
	public ModelAndView yibanManageLoad() {
		return new ModelAndView("/event/eevent/yibanManage");
	}

	/**
	 * 事件已办分页查询
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/yibanManage")
	public Object yibanManage(int page, int rows, String sidx, String sord, String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m, "stepId");
			m = Utils.handleDateValue(m, "finishDate");
			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			return eventService.queryYiBanPage(sidx, rows, page, sord, m, model.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zongheManageLoad")
	public ModelAndView zongheManageLoad() {
		return new ModelAndView("/event/eevent/zongheManage");
	}

	/**
	 * 事件综合查询分页查询
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/zongheManage")
	public Object zongheManage(int page, int rows, String sidx, String sord, EEvent args) {
		return null;
	}

	/**
	 * 事件完结页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/wanJieManageLoad")
	public ModelAndView zhuxiaoManageLoad() {
		return new ModelAndView("/event/eevent/zhuxiaoManage");
	}

	/**
	 * 事件地图完结页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mapwanJieManageLoad")
	public ModelAndView mapzhuxiaoManageLoad() {

		return new ModelAndView("/event/eevent/mapzhuxiaoManage");
	}

	/**
	 * 事件注销分页查询，这个功能只有指挥中心有，因为这个操作只有指挥中心有，在此页面可以查询智慧中心已经注销的事件，并且可以删除已经注销的时间
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/wanJieManage")
	public Object zhuxiaoManage(int page, int rows, String sidx, String sord, String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			m = Utils.handleDateValue(m, "createDate,finishDate");
			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			return eventService.queryWanJiePage(sidx, rows, page, sord, m);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 事件注销分页查询，这个功能只有指挥中心有，因为这个操作只有指挥中心有，在此页面可以查询智慧中心已经注销的事件，并且可以删除已经注销的时间
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/mapwanJieManage")
	public List<Map<String, Object>> mapzhuxiaoManage(EEvent args) {
		try {
			return eventService.mapqueryWanJiePage(args);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 事件注销页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/beizhuxiaoManageLoad")
	public ModelAndView beizhuxiaoManageLoad() {
		return new ModelAndView("/event/eevent/beizhuxiaoManage");
	}

	/**
	 * 注销事件查询分页查询，这个功能所有的人都有，只某辖区内所有被注销的事件，在此页面中只能查询事件，不能修改和删除，在指挥中心那里被删除的时间仍然显示
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
	 * @return json数据 @
	 */
	@RequestMapping(value = "/beizhuxiaoManage")
	public Object beizhuxiaoManage(int page, int rows, String sidx, String sord, String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			m = Utils.handleDateValue(m, "createDate,finishDate");
			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			return eventService.queryCancelPage(sidx, rows, page, sord, m, model.getCode());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/dubanManageLoad")
	public ModelAndView dubanManageLoad() {
		return new ModelAndView("/event/eevent/dubanManage");
	}

	/**
	 * 督办查询
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/dubanManage")
	public Object dubanManage(int page, int rows, String sidx, String sord, String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			m = Utils.handleDateValue(m, "createDate,finishDate");
			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			return eventService.queryDuBanPage(sidx, rows, page, sord, m);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad() {
		SessionModel session = MySession.getInfo();
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			vdata = this.eventService.queryInitial(session.getCode());
			vdata.put("url", "/event/eevent/add");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("/event/eevent/info", "vdata", vdata);
	}

	/**
	 * 事件受理
	 * 
	 * @return @
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/eventaccept")
	public ActionMessage eventaccept(@Valid EEvent eevent, @RequestParam String owner, @Valid EOpinion opinion,
			BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			eevent.setCreateBy(session.getCode());
			opinion.setCreateBy(session.getCode());
			eventService.add(eevent, session.getCode(), owner, opinion);
			return new ActionMessage(true);
		} catch (Exception e) {
			logger.error(e);

			return new ActionMessage(false);
		}
	}

	/**
	 * 添加事件草稿
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/adddraft")
	public ActionMessage eventdraft(EEvent eevent, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			eevent.setCreateBy(session.getCode());
			eventService.addDraft(eevent);
			return new ActionMessage(true);
		} catch (Exception e) {
			logger.error(e);

			return new ActionMessage(false);
		}
	}

	/**
	 * 新增加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editDraftLoad")
	public ModelAndView editDraftLoad(@RequestParam String code) throws Exception {
		SessionModel session = MySession.getInfo();
		Map<String, Object> vdata = this.eventService.queryInitial(session.getCode());
		// vdata.put("url", "/event/eevent/info");
		vdata.put("event", eventService.queryByCode(code));
		return new ModelAndView("/event/eevent/edit", "vdata", vdata);
	}

	/**
	 * 添加事件草稿
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(@RequestParam Long entryId, int stepId, @RequestParam String eventCode) {
		Map<String, Object> vdata = this.approvalData(entryId, stepId, eventCode);
		return new ModelAndView("/event/eevent/approval", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(@RequestParam Long entryId, int stepId, @RequestParam String eventCode) {
		SessionModel session = MySession.getInfo();
		try {
			Map<String, Object> vdata = this.eventService.queryApproval(entryId, session.getCode(),
					session.getRoleCode(), stepId, eventCode);
			return vdata;
		} catch (Exception e) {
			logger.error(e);

			return null;
		}
	}

	/**
	 * 转向事件审批办理页面
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/approvalLoad")
	public ModelAndView approvalLoad(@RequestParam Long entryId, @RequestParam int stepId,
			@RequestParam String eventCode) {
		Map<String, Object> vdata = this.approvalData(entryId, stepId, eventCode);
		vdata.put("approval", true);
		return new ModelAndView("/event/eevent/approval", "vdata", vdata);
	}

	/**
	 * @param eventCode
	 * @param wfid
	 * @param stepId
	 * @param actionId
	 * @param owner
	 *            下个step的从属
	 * @param opinion
	 * @param duration
	 *            办理时限
	 * @return
	 */
	@RequestMapping(value = "/approval")
	public ActionMessage approval(@RequestParam String eventCode, @RequestParam long wfid, @RequestParam int stepId,
			@RequestParam int actionId, @RequestParam String owner, EOpinion eopinion, Integer duration) {
		SessionModel session = MySession.getInfo();

		eopinion.setCreateBy(session.getCode());

		try {
			if (this.eventService.modifyApproval(eventCode, wfid, stepId, actionId, owner, session.getCode(), eopinion,
					duration, session.getGridCode()) > 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}

		} catch (Exception e) { //
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 转向办件指引页面
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/eventGuideLoad")
	public ModelAndView eventGuidLoad() {
		return new ModelAndView("/event/eevent/eventguide");
	}

	/**
	 * 删除草稿事件
	 * 
	 * @param codes
	 * @return
	 */
	@RequestMapping(value = "/deleteDraft")
	public ActionMessage deleteDraft(String... codes) {
		try {
			eventService.deleteBatch(Arrays.asList(codes));
			return new ActionMessage(true);
		} catch (Exception e) {
			return new ActionMessage(false);
		}
	}

	/**
	 * 删除已经注销的事件，在删除的时候一定要检查是否这条事件是被注销的
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public ActionMessage delete(String... codes) {
		return new ActionMessage(true);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryAllSteps")
	public List queryAllSteps() throws FactoryException {
		return (List<String>) eventService.getAllSteps().get("listValue");
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/queryAllTreeSteps")
	public List<Map<String, Object>> queryAllTreeSteps() throws FactoryException {
		return (List<Map<String, Object>>) (eventService.getAllSteps().get("treeMapList"));
	}

	@RequestMapping(value = "/queryFlowSteps")
	public String queryFlowSteps(@RequestParam String entryId) {
		try {
			ObjectMapper om = new ObjectMapper();
			Map<String, Object> map = eventService.queryAllStepsOfOneEvent(entryId);
			String returnString = om.writeValueAsString(map);
			return returnString;
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}
}
