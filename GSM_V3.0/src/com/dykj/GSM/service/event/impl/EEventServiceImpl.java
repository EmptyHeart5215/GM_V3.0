package com.dykj.GSM.service.event.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.event.impl.EDelayMapperImpl;
import com.dykj.GSM.mapper.event.impl.EDurationMapperImpl;
import com.dykj.GSM.mapper.event.impl.EEventMapperImpl;
import com.dykj.GSM.mapper.event.impl.EOpinionMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysLegalDateMapperImpl;
import com.dykj.GSM.mapper.sys.impl.SysUploadMapperImpl;
import com.dykj.GSM.mapper.warningset.impl.WarningSetMapperImpl;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.event.EDelay;
import com.dykj.GSM.model.event.EDuration;
import com.dykj.GSM.model.event.EEvent;
import com.dykj.GSM.model.event.EOpinion;
import com.dykj.GSM.model.event.FlowLine;
import com.dykj.GSM.model.event.FlowNode;
import com.dykj.GSM.model.event.OsStep;
import com.dykj.GSM.model.sys.SysLegalDate;
import com.dykj.GSM.model.warningset.WarningSet;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.event.EEventService;
import com.dykj.GSM.utils.DateFormatUtil;
import com.dykj.GSM.utils.SendPush;
import com.dykj.GSM.utils.Utils;
import com.opensymphony.workflow.FactoryException;
import com.opensymphony.workflow.basic.BasicWorkflow;
import com.opensymphony.workflow.config.SpringConfiguration;
import com.opensymphony.workflow.loader.ActionDescriptor;
import com.opensymphony.workflow.loader.ResultDescriptor;
import com.opensymphony.workflow.loader.StepDescriptor;
import com.opensymphony.workflow.loader.WorkflowDescriptor;
import com.opensymphony.workflow.loader.WorkflowFactory;
import com.opensymphony.workflow.spi.SimpleStep;

@Service
public class EEventServiceImpl implements EEventService {
	@Autowired
	private EOpinionMapperImpl eOpininonMapperImpl;
	@Autowired
	private EEventMapperImpl eEventMapperImpl;
	@Autowired
	private SysUploadMapperImpl sysUploadMapperImpl;
	@Autowired
	private SysLegalDateMapperImpl sysLegalDateMapperImpl;
	@Autowired
	private EDelayMapperImpl delayMapperImpl;
	@Autowired
	private EDurationMapperImpl durationMapperImpl;
	private final String wfname = "EEvent";
	@Resource
	private SpringConfiguration config;
	@Resource
	private WorkflowFactory factory;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private WarningSetMapperImpl warningSetMapper;
	public final static Integer 办结Id;
	public final static Integer 督办Id;
	public final static Integer 部门办结Id;
	public final static Integer 上报指挥中心ActionId;
	public final static Integer 申请延时ActionId;
	public final static Integer 同意延时ActionId;
	public final static Integer 同意退办ActionId;
	public final static Integer 驳回延时ActionId;
	public final static Integer 延时审批StepId;
	public final static Integer 中心审查StepId;
	public final static Integer 退办审批StepId;
	public final static Integer 部门办理StepId;
	public final static Integer 立案派遣ActionId;
	public final static Integer 返回重新办理ActionId;
	public final static String 指挥中心权限Id;
	public final static String 市指挥中心权限Id;
	public final static Integer 自办自结ActionId;
	public final static Integer 上报市指挥中心ActionId;
	public final static Integer 取消受理ActionId;
	public final static Integer 部门签收ActionId;
	public final static Integer 中心办结ActionId;
	public final static Integer 中心注销ActionId;
	public final static Integer 受理ActionId;
	public final static Integer 取消受理Id;
	public final static Integer 验收ActionId;
	public final static Integer 申请结案ActionId;
	public final static Integer 中心派遣Id;

	private static WorkflowDescriptor wfd;

	@Override
	public Map<String, Object> queryInitial(final String userCode) throws Exception {
		final Map<String, Object> map = new HashMap<String, Object>();
		setWfd();
		map.put("WorkflowDescriptor", wfd);
		map.put("userCode", userCode);
		return map;
	}

	private void setWfd() throws FactoryException {
		if (wfd == null) {
			factory.initDone();
			wfd = this.factory.getWorkflow(this.wfname);
		}
	}

	@Override
	public int insert(EEvent entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(EEvent entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public EEvent queryByKey(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EEvent> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EEvent> queryListParam(Map param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EEvent> queryTListParam(EEvent param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<EEvent> queryByParamPage(int page, int size, String sidx, String sord, EEvent param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) throws Exception {
		return this.eEventMapperImpl.deleteBatch(list);
	}

	@Override
	public int add(EEvent eevent, String userCode, String owner, EOpinion opinion) throws Exception {
		WarningSet warnset = warningSetMapper.queryOne();
		if (warnset == null) {
			throw new Exception("请先进行预警提醒——提醒设置操作！");
		}
		final BasicWorkflow workflow = new BasicWorkflow(userCode);
		workflow.setConfiguration(this.config);
		this.factory.initDone();
		Map<String, Object> transientVars = new HashMap<String, Object>();
		transientVars.put("owner", owner);
		// 将步骤的开始时间和办理时限存入map中
		putDatesToTransientVars(new Date(), transientVars, warnset.getDefaultBanLiDateEvent());
		long WfID = workflow.initialize(this.wfname, 受理ActionId, transientVars); // 初始化一条流程
		eevent.setWfEntry(WfID);
		// 事件添加
		this.addDraft(eevent);
		// eevent = EEventDao.add(eevent);
		// 意见添加
		opinion.setCreateDate(eevent.getCreateDate());
		opinion.setActionId(String.valueOf(受理ActionId));
		opinion.setToPersonCode(userCode);
		opinion.setEntryId(WfID);
		eOpininonMapperImpl.insert(opinion);
		return (int) WfID;
	}

	/**
	 * 添加草稿
	 * 
	 * @param eevent
	 * @return
	 * @throws Exception
	 */
	@Override
	public EEvent addDraft(EEvent eevent) throws Exception {
		String createDate = DateFormatUtil.getStringDate();
		eevent.setCreateDate(createDate);
		// 如果不是空的证明是事件受理而不是事件暂存，此时添加上受理编号
		if (eevent.getWfEntry() != null) {
			String eventNum = createDate.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
			eevent.setEventNum(eventNum);
		}
		if (eevent.getCode() == null || "".equals(eevent.getCode().trim()) || eevent.getCode().equals("00000000")) {
			// 事件添加
			eEventMapperImpl.insert(eevent);
		} else {
			eEventMapperImpl.update(eevent);
		}
		return eevent;
	}

	/**
	 * 将步骤的开始时间，和办理时限放入transientVars，在创建新步骤的时候用到
	 * 
	 * @param transientVars
	 * @param duration
	 * @throws Exception
	 */
	private void putDatesToTransientVars(Date startDate, Map<String, Object> transientVars, int duration)
			throws Exception {
		Calendar ca = Calendar.getInstance();
		ca.setTime(startDate);
		int day = ca.get(Calendar.DAY_OF_MONTH);
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int h = ca.get(Calendar.HOUR_OF_DAY);
		int mi = ca.get(Calendar.MINUTE);
		int s = ca.get(Calendar.SECOND);
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("month", month);
		map.put("year", year);
		List<SysLegalDate> mapList = sysLegalDateMapperImpl.queryLegalDateAfterNow(map);
		Date dueDate = this.getDueDate(0, 0, mapList, year, month, day, h, mi, s, duration);
		transientVars.put("startDate", startDate);
		transientVars.put("dueDate", dueDate);
	}

	@Override
	// begin的初始值为0
	public Date getDueDate(int begin, int j_begin, List<SysLegalDate> mapList, int year, int month, int day, int h,
			int mi, int s, int duration) throws Exception {
		SysLegalDate sameMonthMap = mapList.get(begin);
		if (sameMonthMap.getMonth() == month && (sameMonthMap.getYear() == year)) {
			String[] days = sameMonthMap.getWorkDay().split(",");
			for (int j = j_begin; j < days.length - 1; j++) {
				if (Integer.compare(Integer.valueOf(days[j]), day) == 0) {
					for (int n = duration; n > 0; n--) {
						j++;
						if (j == days.length - 1) {
							duration = n;
							day = 0;
							begin++;
							if (month == 12) {
								year++;
								month = 1;
							} else {
								month++;
							}
							return getDueDate(begin, 0, mapList, year, month, day, h, mi, s, duration);
						} else if (n == 1) {
							Calendar ca = Calendar.getInstance();
							ca.set(year, month - 1, Integer.valueOf(days[j]), h, mi, s);
							return ca.getTime();
						}
					}
				}
				if (Integer.compare(Integer.valueOf(days[j]), day) == 1) {
					if (duration == 1) {
						Calendar ca = Calendar.getInstance();
						ca.set(year, month - 1, Integer.valueOf(days[j]), h, mi, s);
						return ca.getTime();
					} else {
						day = Integer.valueOf(days[j]);
						duration = duration - 1;
						j_begin = j;
						h = 8;
						mi = 0;
						s = 0;
						return getDueDate(begin, j_begin, mapList, year, month, day, h, mi, s, duration);
					}
				}
				if (j == days.length - 2 && Integer.compare(Integer.valueOf(days[j]), day) == -1) {// 如果已经是最后一个数了，结果还是小于要找的那个数
					// 直接进入下一个月
					duration = duration + 1;
					day = 0;
					begin++;
					if (month == 12) {
						year++;
						month = 1;
					} else {
						month++;
					}
					return getDueDate(begin, 0, mapList, year, month, day, h, mi, s, duration);
				}
			}
		} else {
			throw new Exception("请先设置节假日");
		}
		return null;
	}

	/**
	 * 修改
	 * 
	 * @param eevent
	 * @return
	 * @throws Exception
	 */
	@Override
	public int modify(EEvent eevent) throws Exception {
		return eEventMapperImpl.update(eevent);
	}

	/**
	 * 通过主键查询
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public EEvent queryByCode(String code) throws Exception {
		return eEventMapperImpl.queryByKey(code);
	}

	/* 
	 * 待办列表
	 */
	@Override
	public Page<EEvent> queryDaiBanPage(String sidx, int rows, int page, String sord, Map<String, Object> args,
			SessionModel model) throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		args.put("userCode", model.getCode());
		args.put("departCode", model.getDepartmentCode() == null ? "" : model.getDepartmentCode());
		args.put("roleCode", model.getRoleCode());
		args.put("gridCode", model.getGridCode());
		Page<EEvent> pageMap = eEventMapperImpl.queryDaiBanPage(page, rows, sidx, sord, args);
		if (pageMap.getRecords() > 0) {
			dicValueInputService.inputDicValue(pageMap, EEvent.class, "codeEventType,codeEventFrom");
			Map stepMap = (Map) getAllSteps().get("mapValue");
			for (EEvent e : pageMap.getRows()) {
				String stepName = (String) stepMap.get(e.getStep().getStepId().toString());
				e.setStepName(stepName);
			}
			if (!model.getRoleCode().equals(指挥中心权限Id)) {
				if (pageMap != null && pageMap.getRecords() > 0) {
					List<EEvent> listMaps = pageMap.getRows();
					if (listMaps != null && !listMaps.isEmpty()) {
						this.putAlertLight(listMaps);
					}
				}
			}
		}
		return pageMap;
	}

	// 设置事件预警
	private void putAlertLight(List<EEvent> listMaps) throws Exception {
		WarningSet warnset = warningSetMapper.queryOne();
		if (warnset == null) {
			throw new Exception("请先进行预警提醒——提醒设置操作！");
		}
		Date startDate = new Date();
		Calendar ca = Calendar.getInstance();
		ca.setTime(startDate);
		final int day = ca.get(Calendar.DAY_OF_MONTH);
		final int year = ca.get(Calendar.YEAR);
		final int month = ca.get(Calendar.MONTH) + 1;
		final int h = ca.get(Calendar.HOUR_OF_DAY);
		final int mi = ca.get(Calendar.MINUTE);
		final int s = ca.get(Calendar.SECOND);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("month", month);
		map.put("year", year);
		List<SysLegalDate> mapList = sysLegalDateMapperImpl.queryLegalDateAfterNow(map);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		for (EEvent m : listMaps) {
			OsStep step = m.getStep();
			if (step != null && step.getDueDate() != null) {
				Date due_date = step.getDueDate();
				// 将现在的时间与due-date相比，如果现在时间>due-date则为红灯
				if (startDate.compareTo(due_date) == 1) {
					m.setAlertLight("red");
				} else {// 将现在时间+1个工作日与due-date相比，如果>due-date则为黄灯，否则则为绿灯
					Date dueDate1 = this.getDueDate(0, 0, mapList, year, month, day, h, mi, s,
							warnset.getEventToYellow());
					if (dueDate1.compareTo(due_date) == 1) {
						m.setAlertLight("yellow");
					} else {
						m.setAlertLight("green");
					}
				}
			}
		}
	}

	/*
	 * private void putAlertLight(List<Map<String, Object>> listMaps) throws
	 * Exception { for (Map<String, Object> m : listMaps) {
	 * if("一级".equals(m.get("CODE_EVENT_YUJING_NAME"))){ m.put("light", "red");
	 * }else if("二级".equals(m.get("CODE_EVENT_YUJING_NAME"))){ m.put("light",
	 * "yellow"); }else{ m.put("light", "green"); } } }
	 */
	/**
	 * 查询事件已办
	 * 
	 * @param sortname
	 * @param psize
	 * @param page
	 * @param sortorder
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<EEvent> queryYiBanPage(String sidx, int rows, int page, String sord, Map<String, Object> args,
			String userCode) throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		args.put("userCode", userCode);

		Page<EEvent> pageMap = this.eEventMapperImpl.queryYiBanPage(page, rows, sidx, sord, args);
		dicValueInputService.inputDicValue(pageMap, EEvent.class, "codeEventType,codeEventFrom");
		/*Map stepMap = (Map) getAllSteps().get("mapValue");
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) stepMap.get(e.getStep().getStepId().toString());
			e.setStepName(stepName);
		}*/
		/*Map actionMap =this.getAllActions();
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) actionMap.get(e.get.toString());
			e.setStepName(stepName);
		}*/
		return pageMap;
	}

	/**
	 * 查询事件已经注销
	 * 
	 * @param sortname
	 * @param psize
	 * @param page
	 * @param sortorder
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<EEvent> queryCancelPage(String sidx, int rows, int page, String sord, Map<String, Object> args,
			String userCode) throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		args.put("userCode", userCode);

		Page<EEvent> pageMap = this.eEventMapperImpl.queryCancelPage(page, rows, sidx, sord, args);
		dicValueInputService.inputDicValue(pageMap, EEvent.class, "codeEventType");
		/*Map stepMap = (Map) getAllSteps().get("mapValue");
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) stepMap.get(e.getStep().getStepId().toString());
			e.setStepName(stepName);
		}*/
		/*Map actionMap =this.getAllActions();
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) actionMap.get(e.get.toString());
			e.setStepName(stepName);
		}*/
		return pageMap;
	}

	Map getAllActions() throws FactoryException {
		setWfd();
		List<StepDescriptor> stepsDescriptors = wfd.getSteps();
		Map<String, String> mapValue = new HashMap<String, String>();
		List<Map<String, Object>> treeMapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		for (StepDescriptor s : stepsDescriptors) {
			List<ActionDescriptor> actions = s.getActions();
			for (ActionDescriptor a : actions) {
				map.put(String.valueOf(a.getId()), a.getName());
			}
		}
		List<ActionDescriptor> actions = wfd.getInitialActions();
		for (ActionDescriptor a : actions) {
			map.put(String.valueOf(a.getId()), a.getName());
		}
		return map;
	}

	/**
	 * 查询事件督办列表
	 * 
	 * @param sortname
	 * @param psize
	 * @param page
	 * @param sortorder
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<EEvent> queryDuBanPage(String sidx, int rows, int page, String sord, Map<String, Object> args)
			throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		args.put("actionId", 督办Id);
		args.put("shenQingBanJieAction", 申请结案ActionId);
		Page<EEvent> pageMap = this.eEventMapperImpl.queryDuBanPage(page, rows, sidx, sord, args);
		dicValueInputService.inputDicValue(pageMap, EEvent.class, "codeEventType");
		/*Map stepMap = (Map) getAllSteps().get("mapValue");
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) stepMap.get(e.getStep().getStepId().toString());
			e.setStepName(stepName);
		}*/
		/*Map actionMap =this.getAllActions();
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) actionMap.get(e.get.toString());
			e.setStepName(stepName);
		}*/
		return pageMap;
	}

	/**
	 * 查询办理完结的事件
	 * 
	 * @param sortname
	 * @param psize
	 * @param page
	 * @param sortorder
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<EEvent> queryWanJiePage(String sidx, int rows, int page, String sord, Map<String, Object> args)
			throws Exception {
		Integer[] actionIds = { 自办自结ActionId, 中心办结ActionId, 中心注销ActionId, 部门办结Id };
		String[] actionName = { "自办自结", "中心办结", "中心注销", "部门办结" };
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		Map<Integer, String> actionMap = new HashMap<Integer, String>();
		for (int i = 0; i < 4; i++) {
			actionMap.put(actionIds[i], actionName[i]);
		}
		args.put("actions", actionMap);
		Page<EEvent> pageMap = this.eEventMapperImpl.queryWanJiePage(page, rows, sidx, sord, args);
		dicValueInputService.inputDicValue(pageMap, EEvent.class, "codeEventType");
		/*Map stepMap = (Map) getAllSteps().get("mapValue");
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) stepMap.get(e.getStep().getStepId().toString());
			e.setStepName(stepName);
		}*/
		/*Map actionMap =this.getAllActions();
		for (EEvent e : pageMap.getRows()) {
			String stepName = (String) actionMap.get(e.get.toString());
			e.setStepName(stepName);
		}*/
		return pageMap;
	}

	@Override
	public Map getAllSteps() throws FactoryException {
		setWfd();
		List<StepDescriptor> stepsDescriptors = wfd.getSteps();
		Map<String, String> mapValue = new HashMap<String, String>();
		List<Map<String, Object>> treeMapList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<String> listValue = new ArrayList<String>();
		for (StepDescriptor s : stepsDescriptors) {
			Map<String, Object> treeMap = new HashMap<String, Object>();
			mapValue.put(String.valueOf(s.getId()), s.getName());
			treeMap.put("code", String.valueOf(s.getId()));
			treeMap.put("name", s.getName());
			treeMap.put("parentCode", "000");
			treeMapList.add(treeMap);
			/*
			 * if (s.getMetaAttributes().get("isEndStep") != null) {
			 * 
			 * }
			 */
			listValue.add(s.getId() + ":" + s.getName());
		}
		map.put("listValue", listValue);
		map.put("mapValue", mapValue);
		map.put("treeMapList", treeMapList);
		return map;
	}

	/**
	 * 获得最后一步step的id
	 */
	@Cacheable(value = "serviceCache")
	public Integer getEndStepId() throws FactoryException {
		setWfd();
		List<StepDescriptor> stepsDescriptors = wfd.getSteps();
		for (int i = stepsDescriptors.size() - 1; i >= 0; i--) {
			StepDescriptor s = stepsDescriptors.get(i);
			if (s.getMetaAttributes().get("isEndStep") != null) {
				return s.getId();
			}
		}
		return null;
	}

	@Cacheable(value = "serviceCache")
	public String getActionName(String actionId) throws FactoryException {

		return wfd.getAction(Integer.valueOf(actionId)).getName();
	}

	/**
	 * 办理事件时，获得事件的详情，包括审批过程
	 * 
	 * @param wfid
	 * @param userCode
	 * @param stepID
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> queryApproval(Long wfid, String userCode, String roleCode, int stepID, String code)
			throws Exception {
		return this.queryApprovalDetail(wfid, userCode, roleCode, stepID, code, true);
	}

	/**
	 * 事件已办时查看详情
	 * 
	 * @param wfid
	 * @param userCode
	 * @param stepID
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> queryApprovalWhenInfoSee(Long wfid, String userCode, String roleCode, int stepID,
			String code) throws Exception {
		return this.queryApprovalDetail(wfid, userCode, roleCode, stepID, code, false);
	}

	// roleCode 为当前用户的角色，主要用于判断是不是市指挥中心角色
	private Map<String, Object> queryApprovalDetail(Long wfid, String userCode, String roleCode, int stepID,
			String code, Boolean approval) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		// 如果是进行审批操作
		if (approval) {
			// 查询流程信息
			BasicWorkflow wf = new BasicWorkflow(userCode);
			wf.setConfiguration(config);
			setWfd();
			StepDescriptor sd = wfd.getStep(stepID);
			map.put("wfid", wfid);
			map.put("userCode", userCode);
			// 查询操作，用于显示按钮
			List<Map<String, Object>> actions = new ArrayList<Map<String, Object>>();
			for (int i = 0; i < sd.getActions().size(); i++) {
				Map<String, Object> action = new HashMap<String, Object>();
				ActionDescriptor ad = (ActionDescriptor) sd.getActions().get(i);
				// 如果是中心派遣，则会出现上报市指挥中心这个action，需要进行权限控制，如果当前本来就是市指挥中心的用户在登陆了，那么就不需要再进行上报市指挥中心了，此时去掉这个action
				if (!(ad.getId() == 上报市指挥中心ActionId && roleCode.equals(市指挥中心权限Id))) {
					action.put("name", ad.getName());
					action.put("id", ad.getId());
					action.put("workUrl", ad.getMetaAttributes().get("workUrl"));
					action.put("stepRight", ad.getMetaAttributes().get("stepRight"));
					action.put("depart", ad.getMetaAttributes().get("depart"));
					action.put("duration", ad.getMetaAttributes().get("duration"));
					action.put("delay", ad.getMetaAttributes().get("delay"));
					action.put("delayApply", ad.getMetaAttributes().get("delayApply"));
					action.put("appraise", ad.getMetaAttributes().get("appraise"));
					actions.add(action);
				}
			}
			map.put("actions", actions);
			map.put("allActionMap", this.getAllActions());
			map.put("metaAttributes", sd.getMetaAttributes());
			map.put("stepId", sd.getId());
			// 判断如果是stepId是要审批延时，则需要查询延时表得到申请延时的天数
			if (stepID == 延时审批StepId) {
				EDelay delayMap = delayMapperImpl.queryOneByWfEntry(wfid);
				map.put("durationHistory", delayMap.getDayCountHistory());
				map.put("duration", delayMap.getDayCount());
			} else if (stepID == 部门办理StepId) {// 如果是部门办理，有可能需要申请延时，需要查询出原办理时限
				EDuration du = durationMapperImpl.queryOneByWfEntry(wfid);
				map.put("durationHistory", du.getDuration());
			}
		}
		// 查询事件详细信息
		EEvent eevent = eEventMapperImpl.queryByKey(code);
		if (eevent == null) {
			throw new Exception("查不到事件");
		}
		dicValueInputService.inputDicValueForOne(eevent, EEvent.class,
				"codeEventType,codeEventFrom,codeEventGuimo,codeXueLi,codeEventRenYuanType,codeNation");
		map.put("event", eevent);
		// 查询出事件的图片信息
		String img = eevent.getImg();
		if (img != null && !img.equals("")) {
			map.put("eeventImg", sysUploadMapperImpl.queryByCodes(Arrays.asList(img.split(";"))));
		}

		// 查询办理记录信息
		List<EOpinion> opinions = eOpininonMapperImpl.queryOpinionsByWfEntry(wfid);
		map.put("opinions", opinions);
		// =========================================================================================================
		// 流程显示
		return map;
	}

	/*
	 * private List<Calendar> getDates(Calendar p_start, Calendar p_end) {
	 * List<Calendar> result = new ArrayList<Calendar>();
	 * p_start.add(Calendar.DAY_OF_YEAR, 1); while (p_start.before(p_end)) {
	 * result.add(p_start); p_start.add(Calendar.DAY_OF_YEAR, 1); }
	 * result.add(p_end); return result; }
	 */
	/**
	 * 执行工作流程
	 * 
	 * @return
	 */
	@Override
	public int modifyApproval(String eventCode, long wfid, int stepID, int actionID, String owner, String userCode,
			EOpinion opinion, Integer duration, String gridCode) throws Exception {
		WarningSet warnset = warningSetMapper.queryOne();
		if (warnset == null) {
			throw new Exception("请先进行预警提醒——提醒设置操作！");
		}
		// 需要特殊处理的是申请延时，和延时驳回的步骤
		// 申请延时时，需要在延时表中插入一条数据，延时表中的数据有 上一个步骤的开始时间
		// 和due-date,如果申请驳回之后需要这两个属性，插入新步骤，还需要申请延时的天数，
		// 延时同意时，开始时间就是当前系统事件，duration是申请的天数，
		// 延时驳回时，开始时间和due-date还是之前的数值，已经存放到延时表中

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("caller", userCode);
		BasicWorkflow workflow = new BasicWorkflow(userCode);
		workflow.setConfiguration(config);
		List<SimpleStep> currentSteps = workflow.getCurrentSteps(wfid);
		SimpleStep step = currentSteps.get(0);
		// 如果是驳回延时审批，则开始时间和dueDate都是之前的值
		if (actionID == 驳回延时ActionId) {
			EDelay delayMap = delayMapperImpl.queryOneByWfEntry(wfid);
			duration = delayMap.getDayCountHistory();
			putDatesToTransientVars(new Date(), map, duration);
		} else {
			if (duration == null) {
				duration = warnset.getDefaultBanLiDateEvent();
			}
			// 如果是同意延时，则开始时间变为现在了，duration变成以前的duration+现在的duration
			if (actionID == 同意延时ActionId) {
				EDelay delayMap = delayMapperImpl.queryOneByWfEntry(wfid);
				duration = delayMap.getDayCount() + delayMap.getDayCountHistory();
				EDuration du = durationMapperImpl.queryOneByWfEntry(wfid);
				du.setDuration(duration);
				durationMapperImpl.update(du);
			}
			if (actionID != 立案派遣ActionId) {
				// 将步骤的开始时间和办理时限存入map中
				putDatesToTransientVars(new Date(), map, duration);
			} else {
				// 将步骤的开始时间和办理时限存入map中,如果是立案派遣的，那么部门签收的有效期仍然是默认的天数，部门办理时间才是获得的时间
				putDatesToTransientVars(new Date(), map, warnset.getDefaultBanLiDateEvent());
			}

			// 如果是申请延时操作,则需要添加一条延时数据
			if (actionID == 申请延时ActionId) {
				if (duration == null) {
					throw new Exception("没有设置延时天数");
				}
				EDelay delay = new EDelay();
				delay.setActionId(actionID);
				delay.setDayCount(duration);
				delay.setDueDate(step.getDueDate());
				delay.setStartDate(step.getStartDate());
				delay.setEntryId(wfid);
				delay.setEventCode(eventCode);
				delay.setCreateBy(userCode);
				delay.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(map.get("startDate")));
				EDuration du = durationMapperImpl.queryOneByWfEntry(wfid);
				delay.setDayCountHistory(du.getDuration());
				delayMapperImpl.insert(delay);
			} else if (actionID == 立案派遣ActionId || actionID == 返回重新办理ActionId) {
				EDuration du = new EDuration();
				du.setStepId(step.getStepId());
				du.setCreateBy(userCode);
				du.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(map.get("startDate")));
				du.setEntryId(step.getEntryId());
				du.setActionId(actionID);
				du.setEventCode(eventCode);
				du.setCode(String.valueOf(step.getId()));
				du.setDuration(duration);
				if (actionID == 立案派遣ActionId) {
					// 如果是立案派遣，真正生效的时候是在部门签收的时候，所以设置为不可用
					du.setFlagDisplay("1");
				}
				durationMapperImpl.insert(du);
			} else if (actionID == 上报指挥中心ActionId) {// 上报区指挥中心
				// #3代表既有辖区又有角色控制，主要是指挥中心的问题，区指挥中心是个角色，辖区管理在区级和市级，多个区，所以需要由两个条件一同控制,在存入数据库市格式为
				// “区指挥中心角色id#3区gridCode”，
				// 得到该用户从属的区
				String qu = gridCode.substring(0, 5);
				owner = owner + qu;
			} else if (actionID == 部门签收ActionId) {
				// 如果是部门签收，则需要修改办理的开始时间和状态为可用
				EDuration du = durationMapperImpl.queryOneByWfEntry(wfid);
				du.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(map.get("startDate")));
				du.setFlagDisplay("0");
				durationMapperImpl.update(du);
				// owner还是是自己的部门
				owner = step.getOwner();
				putDatesToTransientVars((Date) map.get("startDate"), map, du.getDuration());
			} else if (actionID == 中心注销ActionId) {
				this.eEventMapperImpl.updateEventCancel(eventCode);
			}
		}
		if (owner != null && !owner.equals("")) {
			map.put("owner", owner);
		} else {
			// 返回到以前
			setWfd();
			ResultDescriptor rd = workflow.getResultDescriptor(wfd, wfid, actionID, String.valueOf(stepID), map);
			List<SimpleStep> historySteps = config.getWorkflowStore().findHistorySteps(wfid);
			for (SimpleStep simpleStep : historySteps) {
				if (rd.getMetaAttributes().get("ownerStep") != null
						&& Integer.valueOf(rd.getMetaAttributes().get("ownerStep").toString()) == simpleStep
								.getStepId()) {
					map.put("owner", simpleStep.getCaller() + "#1");
					break;
				}
			}
		}
		workflow.doAction(Long.valueOf(wfid), actionID, map);
		EOpinion opinionMap = eOpininonMapperImpl.queryPreOpinion(wfid);
		// 得到上一条意见，将当前用户作为上一条的caller
		if (opinionMap != null) {
			String code = opinionMap.getCode();
			Map<String, String> m = new HashMap<String, String>();
			m.put("toPersonCode", userCode);
			m.put("code", code);
			eOpininonMapperImpl.updateToPersonCode(m);
		}
		// 添加意见
		opinion.setActionId(String.valueOf(actionID));
		opinion.setEntryId(wfid);
		opinion.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(map.get("startDate")));
		eOpininonMapperImpl.insert(opinion);

		currentSteps = workflow.getCurrentSteps(wfid);
		if (currentSteps != null && !currentSteps.isEmpty()) {
			String currentOwner = currentSteps.get(0).getOwner();
			if (currentOwner.indexOf('#') > 0) {
				currentOwner = currentOwner.substring(0, currentOwner.indexOf('#'));
			}
			if (actionID == 督办Id) {
				this.eEventMapperImpl.udpateEventDuBan(eventCode);
			}
			EEvent event = eEventMapperImpl.queryByKey(eventCode);
			String args = "{type:'事件',code:'" + eventCode + "',eventTitle:'" + event.getEventTitle() + "',stepId:'"
					+ currentSteps.get(0).getStepId() + "',entryId:'" + currentSteps.get(0).getEntryId() + "'}";
			if (event != null) {
				SendPush.sendEventMessageAuto(currentOwner, args);
				/*
				JPush.testSendPush(currentOwner, contradict);
				*/
			}

		}
		return 1;
	}

	/*
		*//**
	 * 综合查询
	 */
	/*
	public Map<String, Object> queryAllSearchPage(String sortname, int psize, int page, String sortorder,
		String[] args, String userCode) throws FactoryException {

	return this.EEventDao.queryAllSearchPage(sortname, psize, page, sortorder, args, userCode, 办结Id);
	}

	*//**
	 * 事件注销查询
	 */
	/*
	public Map<String, Object> queryCloseEventPage(String sortname, int psize, int page, String sortorder,
		String[] args, String userCode) throws FactoryException {
	return this.EEventDao.queryCloseEventPage(sortname, psize, page, sortorder, args, userCode, 办结Id);
	}

	*//**
	 * 事件注销
	 */
	/*
	public void deleteEvent(String... codes) throws Exception {
	EEventDao.deleteEvent(codes);
	}
	*/
	/**
	 * 事件草稿
	 * 
	 * @param sortname
	 * @param psize
	 * @param page
	 * @param sortorder
	 * @param args
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<EEvent> queryDraftPage(String sidx, int size, int pageNum, String sord, Map param) throws Exception {
		Page<EEvent> page = this.eEventMapperImpl.queryDraftPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, EEvent.class, "codeEventType,codeEventFrom");
		return page;
	}

	/* private void getWorkDayBetweenTwoDates(Date startDate,Date endDate)
	* throws Exception { Calendar ca1 = Calendar.getInstance();
	* ca1.setTime(startDate); int day_1 = ca1.get(Calendar.DAY_OF_MONTH); int
	* year_1 = ca1.get(Calendar.YEAR); int month_1 = ca1.get(Calendar.MONTH) +
	* 1; int h_1 = ca1.get(Calendar.HOUR_OF_DAY); int mi_1 =
	* ca1.get(Calendar.MINUTE); int s_1 = ca1.get(Calendar.SECOND); Calendar
	* ca2 = Calendar.getInstance(); ca2.setTime(startDate); int day_2 =
	* ca2.get(Calendar.DAY_OF_MONTH); int year_2 = ca2.get(Calendar.YEAR); int
	* month_2 = ca2.get(Calendar.MONTH) + 1; int h_2 =
	* ca2.get(Calendar.HOUR_OF_DAY); int mi_2 = ca2.get(Calendar.MINUTE); int
	* s_2= ca2.get(Calendar.SECOND); List<Map<String, Object>> mapList =
	* RLegalDateDao.queryLegalDateAfterNow(year_1, month_1); Map<String,
	* String> returnMap = new HashMap<String, String>(); String y = ""; String
	* m = ""; String workDate = ""; for (Map<String, Object> map : mapList) {
	* String y_temp = map.get("YEAR").toString(); String m_temp =
	* map.get("MONTH").toString(); String w_temp =
	* map.get("WORK_DATE").toString(); returnMap.put(y_temp + "-" + m_temp,
	* w_temp); } for(int y=year1) }
	
	*//**
	 * 呼叫登记页面的上报指挥中心
	 * 
	 * @param callRegister
	 * @param reply
	 * @throws Exception
	 */
	/*
	public void reportTo(DCallRegister callRegister, DCallBack reply, EEvent event, EOpinion opinion)
		throws Exception {
	// 1.------------------------添加呼叫登记、呼叫回复
	DCallRegister register = DCallRegisterDao.add(callRegister, reply);
	// 2.------------------------实现事件受理，加入呼叫Id
	event.setNameAppeal(register.getEventTitle());
	event.setEventAddress(register.getEventSite());
	String userCode = register.getCreatedBy();
	Map<String, Object> userMap = RUsersDao.UserManage(userCode);
	if (userMap != null) {
		event.setCreatedName(userMap.get("LOGIN_NAME").toString());
	}
	event.setAppealName(register.getCallName());
	event.setAppealAddress(register.getAddress());
	event.setAppealTelephone(register.getCPhoneNo());
	event.setAppealContent(register.getEvent());
	event.setCallRegisterCode(register.getCode());
	// 初始化流程
	BasicWorkflow workflow = new BasicWorkflow(userCode);
	workflow.setConfiguration(this.config);
	setWfd();
	ActionDescriptor ad = (ActionDescriptor) wfd.getInitialActions().get(0);
	// 受理的actionId
	int actionId = ad.getId();
	Map<String, Object> transientVars = new HashMap<String, Object>();
	transientVars.put("owner", userCode);
	// 将步骤的开始时间和办理时限存入map中
	putDatesToTransientVars(transientVars, 办理天数);
	long WfID = workflow.initialize(this.wfname, actionId, transientVars); // 初始化一条流程
	event.setWfEntry(WfID);
	// 事件添加
	event = this.addDraft(event);
	// 意见添加
	opinion.setActionId(String.valueOf(actionId));
	opinion.setToPersonCode(userCode);
	opinion.setEntryId(WfID);
	opinion.setActionName(ad.getName());
	String opinionStr = opinion.getOpinion();
	// 受理时意见为空
	opinion.setOpinion(null);
	EOpinionDao.add(opinion);
	// 3.------------------------事件上报指挥中心
	int duration = EEventServiceImpl.办理天数;
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("caller", userCode);
	// 将步骤的开始时间和办理时限存入map中
	ActionDescriptor action = wfd.getAction(上报指挥中心ActionId);
	map.put("owner", action.getMetaAttributes().get("ONMOUSEOVER"));
	putDatesToTransientVars(map, duration);
	// 上报指挥中心
	workflow.doAction(Long.valueOf(WfID), 上报指挥中心ActionId, map);
	Map<String, Object> opinionMap = EOpinionDao.queryPreOpinion(WfID);
	// 得到上一条意见，将当前用户作为上一条的caller
	if (opinionMap != null) {
		String code = (String) opinionMap.get("CODE");
		EOpinionDao.updateCaller(userCode, code);
	}
	// 添加意见
	opinion.setOpinion(opinionStr);
	opinion.setActionId(String.valueOf(上报指挥中心ActionId));
	opinion.setEntryId(WfID);
	opinion.setActionName("上报指挥中心");
	EOpinionDao.add(opinion);
	// 消息推送
	List<SimpleStep> currentSteps = workflow.getCurrentSteps(WfID);
	if (currentSteps != null && !currentSteps.isEmpty()) {
		final String currentOwner = currentSteps.get(0).getOwner()
				.substring(0, currentSteps.get(0).getOwner().indexOf('#'));
		SendPush.sendEventMessageAuto(currentOwner, event.getCode());
	}
	}
	*/
	static {
		Properties prop = new Properties();
		int i = prop.size();
		InputStream in = EEventServiceImpl.class.getResourceAsStream("/workflowProperties_event.properties");

		try {
			prop.load(in);
			i = prop.size();
		} catch (IOException e) {
			e.printStackTrace();
		}
		办结Id = Integer.valueOf(prop.getProperty("banJieId").trim());
		督办Id = Integer.valueOf(prop.getProperty("duBanAction").trim());
		部门办结Id = Integer.valueOf(prop.getProperty("banLiBanJieAction").trim());
		申请延时ActionId = Integer.valueOf(prop.getProperty("shenQingYanShiAction").trim());
		同意延时ActionId = Integer.valueOf(prop.getProperty("tongYiYanShiAction").trim());
		驳回延时ActionId = Integer.valueOf(prop.getProperty("boHuiYanShiAction").trim());
		延时审批StepId = Integer.valueOf(prop.getProperty("yanShiShenPi").trim());
		退办审批StepId = Integer.valueOf(prop.getProperty("tuiBanShenPi").trim());
		中心审查StepId = Integer.valueOf(prop.getProperty("zhongXinShenCha").trim());
		中心办结ActionId = Integer.valueOf(prop.getProperty("zhongXinBanJieAction").trim());
		部门办理StepId = Integer.valueOf(prop.getProperty("buMenBanLi").trim());
		立案派遣ActionId = Integer.valueOf(prop.getProperty("liAnPaiQianAction").trim());
		返回重新办理ActionId = Integer.valueOf(prop.getProperty("fanHuiChongXinBanLiAction").trim());
		指挥中心权限Id = prop.getProperty("zhiHuiZhongXinQuanXianId").trim();
		市指挥中心权限Id = prop.getProperty("shiZhiHuiZhongXinQuanXianId").trim();

		上报指挥中心ActionId = Integer.valueOf(prop.getProperty("shangBaoZhiHuiZhongXinAction").trim());
		上报市指挥中心ActionId = Integer.valueOf(prop.getProperty("shangBaoShiZhiHuiZhongXinAction").trim());
		同意退办ActionId = Integer.valueOf(prop.getProperty("tongYiTuiBanAction").trim());
		自办自结ActionId = Integer.valueOf(prop.getProperty("ziBanZiJieAction").trim());
		取消受理ActionId = Integer.valueOf(prop.getProperty("quXiaoShouLiAction").trim());
		部门签收ActionId = Integer.valueOf(prop.getProperty("qianShouActon").trim());
		中心注销ActionId = Integer.valueOf(prop.getProperty("zhuXiaoAciton").trim());
		取消受理Id = Integer.valueOf(prop.getProperty("quXiaoShouLi").trim());
		中心派遣Id = Integer.valueOf(prop.getProperty("zhongXinPaiQian").trim());
		受理ActionId = Integer.valueOf(prop.getProperty("shouLiAction").trim());
		验收ActionId = Integer.valueOf(prop.getProperty("yanShouAction").trim());
		申请结案ActionId = Integer.valueOf(prop.getProperty("shenQingJieAnAction").trim());
	}

	@Override
	public Map<String, Object> queryAllStepsOfOneEvent(String entryId) throws FactoryException {
		int left = 300;
		int top = 5;
		// 流程图当中step执行的顺序
		Integer[][] stepOrders = { { 1, 44 }, { 3 }, { 5 }, { 6 }, { 11, 8, 9 }, { 12 }, { 13 }, { 4 } };
		Map<Integer, FlowNode> nodeMap = new HashMap<Integer, FlowNode>();
		Map<Integer, FlowLine> lineMap = new HashMap<Integer, FlowLine>();
		Map<String, Object> returnMap = new HashMap<String, Object>();
		setWfd();

		// 所有的步骤
		List<StepDescriptor> stepsDescriptors = wfd.getSteps();
		for (StepDescriptor s : stepsDescriptors) {
			FlowNode node = new FlowNode();
			for (int i = 0; i < stepOrders.length; i++) {
				for (int j = 0; j < stepOrders[i].length; j++) {
					if (s.getId() == stepOrders[i][j]) {
						if (j == 0) {
							node.setLeft(left);
						} else if (j == 1) {
							node.setLeft(left - 160);
						} else {
							node.setLeft(left + 160);
						}
						node.setTop(top + (i + 1) * 70);
						node.setName(s.getName());
					}
				}
			}
			nodeMap.put(s.getId(), node);
			// 步骤中的action
			List<ActionDescriptor> actions = s.getActions();
			for (ActionDescriptor a : actions) {
				FlowLine line = new FlowLine();
				line.setFrom(String.valueOf(s.getId()));
				ResultDescriptor r = a.getUnconditionalResult();
				line.setTo(String.valueOf(r.getStep()));
				line.setType("sl");
				if (自办自结ActionId.equals(a.getId())) {
					line.setType("lr");
					line.setM(node.getLeft() + 450);
				} else if (中心办结ActionId.equals(a.getId())) {
					line.setType("lr");
					line.setM(node.getLeft() + 400);
				} else if (中心注销ActionId.equals(a.getId())) {
					line.setType("lr");
					line.setM(node.getLeft() + 350);
				}

				else if (同意延时ActionId.equals(a.getId()) || 返回重新办理ActionId.equals(a.getId())) {
					line.setType("lr");
					line.setM(node.getLeft() + 40);
				} else if (同意退办ActionId.equals(a.getId()) || 督办Id.equals(a.getId())) {
					line.setType("lr");
					line.setM(node.getLeft() - 40);
				} else if (驳回延时ActionId.equals(a.getId())) {
					line.setType("lr");
					line.setM(node.getLeft() + node.getWidth() + 40);
				}
				/*else if (取消受理ActionId.equals(a.getId())) {
					line.setType("lr");
					line.setM(node.getLeft() - 300);
				}*/
				line.setName(a.getName());
				line.setDash(true);
				lineMap.put(a.getId(), line);

			}
		}
		FlowNode startNode = new FlowNode();
		startNode.setType("start yiban");
		startNode.setName("开始");
		startNode.setLeft(left);
		startNode.setTop(top);
		nodeMap.put(0, startNode);
		/*// 添加市指挥中心派遣
		FlowNode st = new FlowNode();
		st.setName("上报市指挥中心");
		st.setLeft(left + 160);
		st.setTop(top + 3 * 70);// 放到部门签收旁边
		nodeMap.put(14, startNode);*/

		List<ActionDescriptor> actions = wfd.getInitialActions();
		FlowLine line = new FlowLine();
		line.setName(actions.get(0).getName());
		line.setFrom("0");
		line.setTo(String.valueOf(actions.get(0).getUnconditionalResult().getStep()));
		line.setType("sl");
		line.setDash(false);
		lineMap.put(actions.get(0).getId(), line);
		/*// 添加上报市指挥中心
		FlowLine li = new FlowLine();
		li.setName("上报市指挥中心");
		li.setFrom("3");
		li.setTo("14");
		li.setType("lr");
		li.setDash(true);
		li.setM(400 + 40);
		lineMap.put(1900, li);
		// 添加市指挥中心立案派遣
		FlowLine li2 = new FlowLine();
		li2.setName("立案派遣");
		li2.setFrom("14"); // 从市指挥中心 到部门签收
		li2.setTo("5");
		li2.setType("lr");
		li2.setDash(false);
		lineMap.put(1901, li2);*/
		// 设置已办和在办的状态
		List<Map<String, Object>> list = this.eEventMapperImpl.queryAllStepsOfOneEvent(entryId);
		for (Map<String, Object> map : list) {
			Integer action_id = map.get("ACTION_ID") == null ? null : Integer.valueOf(map.get("ACTION_ID").toString());
			Integer step_id = map.get("STEP_ID") == null ? null : Integer.valueOf(map.get("STEP_ID").toString());
			Object owner = map.get("OWNER");
			FlowNode node = nodeMap.get(step_id);
			FlowLine l = lineMap.get(action_id);
			if (step_id == 3) {// 如果是中心派遣step，有可能是市中心派遣

			}

			if (node != null) {
				node.setType("task " + map.get("STATUS"));
				nodeMap.put(step_id, node);
			}
			if (l != null) {
				l.setDash(false);
				lineMap.put(action_id, l);
			}
		}
		FlowNode endNode = nodeMap.get(办结Id);
		if (endNode.getType().contains("yiban")) {
			endNode.setType("end yiban");
		} else {
			endNode.setType("end weiban");
		}
		/*FlowNode endNode2 = nodeMap.get(取消受理Id);
		if (endNode2.getType().contains("yiban")) {
			endNode2.setType("end yiban");
		} else {
			endNode2.setType("end weiban");
		}*/

		nodeMap.put(办结Id, endNode);
		/*nodeMap.put(取消受理Id, endNode2);*/

		returnMap.put("title", "dsdfsdf");
		returnMap.put("nodes", nodeMap);
		returnMap.put("lines", lineMap);
		return returnMap;
	}

	/**
	 * 综合查询
	 */
	@Override
	public Page<EEvent> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception {
		/*Integer[] actionIds = { 自办自结ActionId, 中心办结ActionId, 中心注销ActionId, 部门办结Id };
		String[] actionName = { "自办自结", "中心办结", "中心注销", "部门办结" };*/
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		/*Map<Integer, String> actionMap = new HashMap<Integer, String>();
		for (int i = 0; i < 4; i++) {
			actionMap.put(actionIds[i], actionName[i]);
		}
		args.put("banJieActions", actionMap);*/
		// args.put("allActions", getAllActions());

		Map<Integer, String> allStep = new HashMap<Integer, String>();
		args.put("allSteps", this.getAllSteps().get("mapValue"));
		args.put("endStepId", 办结Id);
		Page<EEvent> page = this.eEventMapperImpl.queryZongHePage(pageNum, size, sidx, sord, args);
		dicValueInputService.inputDicValue(page, EEvent.class, "codeEventType,codeEventFrom");
		/*if (page != null && page.getRecords() > 0) {
			List<EEvent> listMaps = page.getRows();
			if (listMaps != null && !listMaps.isEmpty()) {
				this.putAlertLight(listMaps);
			}
		}*/
		return page;
	}

	/**
	 * @param args
	 *            查询条件数组
	 * @param type
	 *            分组类型
	 * @param gridCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public List eventCharts(Map<String, Object> args) throws Exception {
		String gridCode = args.get("gridCode").toString();
		String type = args.get("type").toString();
		type = Utils.transformPropertyToColumn(type);
		args.put("type", type);
		String[] types = { "CODE_EVENT_TYPE", "GRID_CODE", "CODE_EVENT_FROM", "STEP_ID", "CODE_APPRAISE", "ACTION_ID" };
		if (!Arrays.asList(types).contains(type)) {
			throw new Exception("统计类型不正确");
		}
		Map<String, String> allStep = null;
		if (type.equals("STEP_ID")) {
			allStep = (Map<String, String>) getAllSteps().get("mapValue");
			args.put("allSteps", allStep);
		}
		Map<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
		lengthMap.put(2, 5);
		lengthMap.put(5, 8);
		lengthMap.put(8, 12);
		lengthMap.put(12, 20);
		lengthMap.put(20, 20);
		Object searchLength = lengthMap.get(gridCode.length());
		args.put("searchLength", searchLength);
		args.put("banJieId", 办结Id);
		args.put("pingJiaActionId", 验收ActionId);
		List<Map<String, Object>> list = this.eEventMapperImpl.queryCharts(args);
		return list;
	}

	/**
	 * @param args
	 *            查询条件数组
	 * @param type
	 *            分组类型
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<Map<String, Object>> eventChartsByOrg(Map<String, Object> args) throws Exception {
		String[] types = { "DEPT", "CODE_EVENT_TYPE", "CODE_EVENT_FROM", "CODE_APPRAISE" };
		String type = args.get("type").toString();
		type = Utils.transformPropertyToColumn(type);
		args.put("type", type);
		if (!Arrays.asList(types).contains(type)) {
			throw new Exception("统计类型不正确");
		}
		args.put("banJieId", 办结Id);
		args.put("pingJiaActionId", 验收ActionId);
		args.put("banLiBanJieActionId", 部门办结Id);
		Map<String, Object> returnMap = new HashMap<String, Object>();
		// 键值为COUNT,GROUPTYPE，最后一条数据的count值为合计值,
		List<Map<String, Object>> list = eEventMapperImpl.queryChartsByOrg(args);

		return list;
	}

	@Override
	public List<Map<String, Object>> mapqueryWanJiePage(EEvent args) {
		return eEventMapperImpl.mapqueryWanJiePage(args);
	}
}
