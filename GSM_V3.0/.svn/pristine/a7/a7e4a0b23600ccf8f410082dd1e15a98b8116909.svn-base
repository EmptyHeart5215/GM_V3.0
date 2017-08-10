package com.dykj.GSM.service.workflow;

import org.springframework.stereotype.Service;

@Service
public class WorkFlowService {
	/*
	 * @Resource public WorkFlowDao WorkFlowDao;
	 * 
	 * @Resource public SpringConfiguration config;
	 * 
	 * @Resource public SpringTypeResolver typeresolver;
	 * 
	 * @Resource public WorkflowFactory factory;
	 *//**
	 * 新建一条流程
	 * 
	 * @param workFlowName
	 * @param BusinessCode
	 * @param transientVars
	 * @param usermodel
	 * @param actions
	 * @return
	 */
	/*
	 * public int createWorkFlow(String workFlowName, String BusinessCode,
	 * Map<String, Object> transientVars, Map<String, Object> actions,
	 * SessionModel sessionModel) throws Exception { workFlowName =
	 * WorkFlowDao.getNewWfname(workFlowName); String userID = (String)
	 * sessionModel.getCODE(); BasicWorkflow workflow = new
	 * BasicWorkflow(userID); workflow.setConfiguration(config);
	 * factory.initDone(); transientVars.put("WorkFlowName", workFlowName);
	 * transientVars.put("begin_date", new Date()); // 获取节假日
	 * transientVars.put("legaldays", WorkFlowDao.queryLegalDays(new Date()));
	 * long WfID = workflow.initialize(workFlowName, 100, transientVars); //
	 * 初始化一条流程 WorkflowDescriptor Wfd = factory.getWorkflow(workFlowName);
	 * 
	 * Map<String, Object> htt = Wfd.getMetaAttributes(); String tableName =
	 * (String) htt.get("TABLENAME"); // 更新业务表
	 * WorkFlowDao.modifyBussnessWfID(tableName, WfID, BusinessCode); //
	 * 插入上报意见节点 EOpinion osOpinion = new EOpinion();
	 * osOpinion.setActionId("100"); osOpinion.setCaller(userID); //
	 * osOpinion.setEntryId(String.valueOf(WfID)); osOpinion.setOpinion("受理");
	 * 
	 * osOpinion.setStepId("1"); osOpinion.setUserid(userID);
	 * WorkFlowDao.saveOpinion(osOpinion); // int m = 0; // int i = 1/m; //
	 * 判断是否需要执行action if (actions != null && actions.size() > 0) { if
	 * (actions.get("actionID").toString() != "120") { doAction(workFlowName,
	 * String.valueOf(WfID), (int) actions.get("stepID"), (int)
	 * actions.get("actionID"), actions.get("owner").toString(), osOpinion,
	 * sessionModel); } else { doAction(workFlowName, String.valueOf(WfID),
	 * (int) actions.get("stepID"), (int) actions.get("actionID"),
	 * actions.get("owner").toString(), osOpinion, sessionModel); } } return
	 * (int) WfID; }
	 *//**
	 * 执行流程
	 * 
	 * @param workFlowName
	 * @param wfID
	 * @param stepID
	 * @param actionID
	 * @param owner
	 * @param osOpinion
	 * @param sessionmodel
	 */
	/*
	 * public void doAction(String workFlowName, String wfID, int stepID, int
	 * actionID, String owner, EOpinion osOpinion, SessionModel sessionmodel)
	 * throws Exception { String userID = (String) sessionmodel.getCODE();
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * map.put("caller", userID); if (owner != null && owner != "") {
	 * map.put("owner", owner); } else { map.put("owner",
	 * sessionmodel.getRoleCode() + "#" + sessionmodel.getGridCode() + "#" +
	 * sessionmodel.getCODE()); } BasicWorkflow workflow = new
	 * BasicWorkflow(userID); workflow.setConfiguration(config);
	 * WorkflowDescriptor Wfd = factory.getWorkflow(workFlowName); // 获取节假日
	 * map.put("legaldays", WorkFlowDao.queryLegalDays(new Date())); Hashtable
	 * Ht = (Hashtable) Wfd.getMetaAttributes();
	 * workflow.doAction(Long.valueOf(wfID), actionID, map);
	 * 
	 * WorkFlowDao.saveOpinion(osOpinion); }
	 *//**
	 * 执行流程
	 * 
	 * @param workFlowName
	 * @param wfID
	 * @param stepID
	 * @param actionID
	 * @param opinion
	 * @param transientVars
	 */
	/*
	 * public void doAction(String workFlowName, String wfID, int stepID, int
	 * actionID, EOpinion osOpinion, Map<String, Object> transientVars,
	 * SessionModel sessionModel) throws Exception { String userID =
	 * sessionModel.getCODE(); transientVars.put("caller", userID);
	 * BasicWorkflow workflow = new BasicWorkflow(userID);
	 * workflow.setConfiguration(config); WorkflowDescriptor Wfd =
	 * workflow.getWorkflowDescriptor(workFlowName); // 获取指定步骤的延长小时数 if
	 * (transientVars.get("hourChangeStep") != null) { int hoursChange =
	 * WorkFlowDao.queryDelayHoursByWfIdStepID(wfID, (int)
	 * transientVars.get("hourChangeStep")); transientVars.put("hoursChange",
	 * hoursChange); } // 获取节假日 transientVars.put("legaldays",
	 * WorkFlowDao.queryLegalDays(new Date()));
	 * workflow.doAction(Long.valueOf(wfID), actionID, transientVars); int
	 * evaluate = 0; if (transientVars.get("evaluate") != null) { evaluate =
	 * (int) transientVars.get("evaluate"); } osOpinion.setUserid(userID);
	 * WorkFlowDao.saveOpinion(osOpinion); }
	 *//**
	 * 初始化审批页面
	 * 
	 * @param workFlowName
	 * @param wfID
	 * @param stepID
	 * @return
	 */
	/*
	 * public Map<String, Object> applavalLoad(String workFlowName, String wfID,
	 * String stepID, SessionModel sessionModel) throws Exception {
	 * BasicWorkflow workflow = new BasicWorkflow(sessionModel.getCODE());
	 * Map<String, Object> map = new HashMap<String, Object>();
	 * WorkflowDescriptor wfd = workflow.getWorkflowDescriptor(workFlowName); //
	 * 表名 String tableName = (String) wfd.getMetaAttributes().get("TABLENAME");
	 * // 查看详细页面 String workedURL = (String)
	 * wfd.getMetaAttributes().get("WORKEDURL"); // 工作流中文描述 String processName =
	 * (String) wfd.getMetaAttributes().get("PROCESSNAME"); // 审批页面审批动作按钮
	 * StepDescriptor sd = wfd.getStep(Integer.parseInt(stepID)); // 填充meata里边的值
	 * Map<String, Object> stepMetas = sd.getMetaAttributes(); for (String key :
	 * stepMetas.keySet()) { map.put(key, stepMetas.get(key)); } Map<String,
	 * Object> list = (Map<String, Object>) sd.getActions(); List<Map<String,
	 * Object>> actionList = new ArrayList<Map<String, Object>>(); for (int i =
	 * 0; i < list.size(); i++) { ActionDescriptor ad = (ActionDescriptor)
	 * list.get(i); Map<String, Object> actionHt = new HashMap<String,
	 * Object>(); String workingurl =
	 * ad.getMetaAttributes().get("WORKINGURL").toString(); //
	 * 将action里边的值写到actionHt Map<String, Object> actionMetas =
	 * ad.getMetaAttributes(); for (String key : actionMetas.keySet()) {
	 * actionHt.put(key, actionMetas.get(key)); } actionMetas.put("actionName",
	 * ad.getName()); actionMetas.put("actionID", ad.getId());
	 * actionMetas.put("workingurl", workingurl); actionList.add(actionMetas); }
	 * // 审批动作按钮-------listReturn[0] map.put("actionList", actionList); //
	 * listReturn.Add(actionList); // 审批意见列表-------listReturn[1]
	 * List<Map<String, Object>> opinionmap = WorkFlowDao.queryOpinion(wfID); //
	 * 审批意见加上步骤的描述 if (opinionmap != null && opinionmap.size() > 0) { for (int i
	 * = 0; i < opinionmap.size(); i++) { Map<String, Object> map2 =
	 * (Map<String, Object>) opinionmap.get(i); ActionDescriptor ad =
	 * wfd.getAction((int) map2.get("action_id")); map2.put("stepName",
	 * ad.getName()); } } map.put("opionsDs", opinionmap); //
	 * 审批页面引用业务的url和主键codeID-------listReturn[2] String code =
	 * WorkFlowDao.queryWfIDToCode(tableName, wfID); String detailURL =
	 * workedURL + "&code=" + code; map.put("event_code", code);
	 * map.put("detailURL", detailURL); return map; }
	 *//**
	 * 
	 * @param ds
	 */
	/*
	 * public void queryWorkFlowPermissions(List<Map<String, Object>> listmap,
	 * SessionModel sessionModel) throws Exception { String userID =
	 * sessionModel.getCODE(); List<Map<String, Object>> workflows =
	 * WorkFlowDao.queryCurrentState(userID); for (int i = 0; i <
	 * listmap.size(); i++) { Map<String, Object> map = (Map<String, Object>)
	 * listmap.get(i); int stepid =
	 * queryCurrentSetp(map.get("flag_wfid").toString()); map.put("step_id",
	 * stepid); map.put("is_permiss", 0); String wf_name =
	 * getWfNameByWfId(map.get("flag_wfid").toString()); map.put("wf_name",
	 * wf_name); map.put("direction", getDirectionByWfName(wf_name)); for (int j
	 * = 0; j < workflows.size(); j++) { Map<String, Object> wfmap =
	 * (Map<String, Object>) workflows.get(j); if (map.get("flag_wfid") == null)
	 * { continue; } String flag_wfid = map.get("flag_wfid").toString(); String
	 * entry_id = wfmap.get("entry_id").toString(); if
	 * (flag_wfid.equals(entry_id)) { map.put("is_permiss", 1); } } String js =
	 * queryHistoryStepsByEntryId((map.get("flag_wfid").toString())); if (js ==
	 * "") { js = "[{}]"; } map.put("historystep", js.replace("\"", "\\\"")); }
	 * }
	 * 
	 * public int queryCurrentSetp(String wfid) throws Exception { if (wfid !=
	 * null && wfid != "") { return 0; } int setpID =
	 * WorkFlowDao.queryCurrentSetp(Integer.parseInt(wfid)); return setpID; }
	 * 
	 * public String saveOrUpdateXml(String id, String wfname, String xml,
	 * String pointxml, String sign) throws Exception { String result =
	 * WorkFlowDao.saveOrUpdateXml(id, wfname, xml, pointxml, sign); return
	 * result; }
	 * 
	 * public String getAllXmls() throws Exception { String xml = "<root>";
	 * List<Map<String, Object>> listmap = WorkFlowDao.getAllXmls(); if (listmap
	 * != null && listmap.size() > 0) { for (int i = 0; i < listmap.size(); i++)
	 * { Map<String, Object> map = (Map<String, Object>) listmap.get(i); xml +=
	 * "<node><id>" + map.get("id") + "</id>" + "<wfname>" + map.get("wfname") +
	 * "</wfname>" + "<flowfile>" + map.get("flowfile") +
	 * "</flowfile><pointxml>" + map.get("pointxml") + "</pointxml></node>"; } }
	 * xml += "</root>"; return xml; }
	 * 
	 * public List<Map<String, Object>> getAllWfnames() throws Exception {
	 * List<Map<String, Object>> listmap = WorkFlowDao.getAllWfnames(); return
	 * listmap; }
	 * 
	 * public String getFlowFileByName(String wfName) throws Exception { return
	 * WorkFlowDao.getFlowFileByName(wfName); }
	 *//**
	 * 查找工作流名称
	 * 
	 * @param flag_wfid
	 * @return
	 */
	/*
	 * public String getWfNameByWfId(String flag_wfid) throws Exception { return
	 * WorkFlowDao.getWfNameByWfId(flag_wfid); }
	 *//**
	 * 
	 * @param wf_name
	 * @return
	 */
	/*
	 * public String getDirectionByWfName(String wfname) throws Exception {
	 * return WorkFlowDao.getDirectionByWfName(wfname); }
	 *//**
	 * 
	 * @param wf_name
	 * @return
	 */
	/*
	 * public String getWfNameByCache(String wfname) throws Exception { return
	 * WorkFlowDao.getNewWfname(wfname); }
	 *//**
	 * 通过entryId获取所有的步骤
	 * 
	 * @param entryId
	 * @return
	 */
	/*
	 * public List<Map<String, Object>> queryStepsByEntryId(String entryId)
	 * throws Exception { return WorkFlowDao.queryStepsByEntryId(entryId); }
	 *//**
	 * 通过entryId获取所有处理的步骤
	 * 
	 * @param entryId
	 * @return
	 */
	/*
	 * public String queryHistoryStepsByEntryId(String entryId) throws Exception
	 * { List<Map<String, Object>> listmap = new ArrayList<Map<String,
	 * Object>>(); String jsonString = ""; if (listmap != null && listmap.size()
	 * > 0) { jsonString = "["; for (int i = 0; i < listmap.size(); i++) {
	 * jsonString += "{"; Map<String, Object> map = listmap.get(i); for (String
	 * key : map.keySet()) { jsonString += "\"" + key + "\":"; String strValue =
	 * (String) map.get(key); if (strValue != null) { strValue =
	 * strValue.replace("\n", "").replace("\r", ""); }
	 * 
	 * if (i != map.size() - 1) { jsonString += "\"" + strValue + "\","; } else
	 * { jsonString += "\"" + strValue + "\""; } } jsonString += "},"; } }
	 * jsonString = jsonString.substring(0, jsonString.length() - 1); if
	 * (jsonString != "") { jsonString += "]"; } return jsonString; }
	 *//**
	 * 为查询的代办项目添加步骤等信息
	 * 
	 * @param ds
	 * @return
	 */
	/*
	 * public List<Map<String, Object>> queryStepsInfos(List<Map<String,
	 * Object>> listmap) throws Exception { if (listmap != null &&
	 * listmap.size() > 0) { for (int i = 0; i < listmap.size(); i++) {
	 * Map<String, Object> map = (Map<String, Object>) listmap.get(i);
	 * BasicWorkflow wf = new BasicWorkflow(""); wf.setConfiguration(config);
	 * factory.initDone(); WorkflowDescriptor wfd =
	 * factory.getWorkflow(map.get("wfname").toString()); String processName =
	 * null; // 流程名称 String stepName = null; // 步骤名称 String workingurl = ""; //
	 * 事件处理的url String history_steps = ""; // 处理的历史步骤 try { processName =
	 * wfd.getMetaAttributes().get("PROCESSNAME").toString(); // 流程名称 int stepid
	 * = (int) map.get("step_id"); StepDescriptor sd = wfd.getStep(stepid); if
	 * (stepid == 0) { stepName = "未受理"; } else { stepName = sd.getName(); } //
	 * 步骤名称 if (sd.getMetaAttributes().get("WORKINGURL") != null) { workingurl =
	 * sd.getMetaAttributes().get("WORKINGURL").toString(); } history_steps =
	 * this.queryHistoryStepsByEntryId(map.get("flag_wfid").toString()); if
	 * (history_steps == "") { history_steps = "[{}]"; } } catch (Exception ex)
	 * { // throw; } SimpleDateFormat sdf = new
	 * SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); if (map.get("finish_date") !=
	 * null && (sdf.parse(map.get("finish_date").toString()).getTime() -
	 * sdf.parse( map.get("due_date").toString()).getTime()) / 1000 < 10) {
	 * map.put("step_status",
	 * "<img src='/App_Themes/Project_App/Images/greenlight.gif' />"); } // 红灯
	 * else if ((new Date()).getTime() >=
	 * sdf.parse(map.get("due_date").toString()).getTime()) {
	 * map.put("step_status",
	 * "<img src='/App_Themes/Project_App/Images/redlight.gif' />"); } else { if
	 * (((new Date()).getTime() -
	 * sdf.parse(map.get("start_date").toString()).getTime()) / (1000 * 60 * 60)
	 * < 24) { // 绿灯 map.put("step_status",
	 * "<img src='/App_Themes/Project_App/Images/greenlight.gif' />"); } else {
	 * // 黄灯 map.put("step_status",
	 * "<img src='/App_Themes/Project_App/Images/yellowlight.gif' />"); } }
	 * map.put("name_cn", processName); map.put("step_name", stepName);
	 * map.put("workingurl", workingurl); map.put("history_steps",
	 * history_steps.replace("\"", "\\\"")); } } return listmap; }
	 *//**
	 * 查询历史步骤
	 * 
	 * @param ds
	 * @return
	 */
	/*
	 * public List<Map<String, Object>> queryHistoryStepsInfos(List<Map<String,
	 * Object>> listmap) throws Exception { if (listmap != null &&
	 * listmap.size() > 0) { String history_steps = ""; for (int i = 0; i <
	 * listmap.size(); i++) { Map<String, Object> map = (Map<String, Object>)
	 * listmap.get(i); history_steps =
	 * this.queryHistoryStepsByEntryId(map.get("flag_wfid").toString()); if
	 * (history_steps == "") { history_steps = "[{}]"; }
	 * map.put("history_steps", history_steps.replace("\"", "\\\"")); } } return
	 * listmap; }
	 *//**
	 * 查找所有的步骤
	 * 
	 * @param wfName
	 * @return
	 */
	/*
	 * public List<Map<String, Object>> queryAllSteps(String wfName) throws
	 * Exception { return getAllSteps(wfName); }
	 * 
	 * // 为服务查询添加列 public List<Map<String, Object>>
	 * queryStepsAllEvents(List<Map<String, Object>> listmap, SessionModel
	 * sessionModel) throws Exception { BasicWorkflow workflow = new
	 * BasicWorkflow(sessionModel.getCODE()); workflow.setConfiguration(config);
	 * 
	 * if (listmap != null && listmap.size() > 0) { for (int i = 0; i <
	 * listmap.size(); i++) { Map<String, Object> map = (Map<String, Object>)
	 * listmap.get(i); WorkflowDescriptor wfd =
	 * workflow.getWorkflowDescriptor(map.get("name").toString()); String
	 * processName = null; // 流程名称 String stepName = null; // 步骤名称 try {
	 * processName = wfd.getMetaAttributes().get("PROCESSNAME").toString(); //
	 * 流程名称 int stepid = (int) map.get("step_id"); StepDescriptor sd =
	 * wfd.getStep(stepid); if (stepid == 0) { stepName = "未受理"; } else {
	 * stepName = sd.getName(); } } catch (Exception ex) { } map.put("name_cn",
	 * processName); map.put("step_name", stepName); } } return listmap; }
	 *//**
	 * 
	 * @param entryID
	 * @return
	 */
	/*
	 * public List<Map<String, Object>> queryOverSee(String entryID) throws
	 * Exception { return WorkFlowDao.queryOverSee(entryID); }
	 *//**
	 * 改变事件状态
	 * 
	 * @param wfID
	 * @param newState
	 */
	/*
	 * public void ChangeEntryState(String wfID, int newState, SessionModel
	 * sessionModel) throws Exception { String userID = sessionModel.getCODE();
	 * AbstractWorkflow workflow = new BasicWorkflow(userID);
	 * workflow.setConfiguration(config);
	 * workflow.changeEntryState(Long.parseLong(wfID), newState); }
	 *//**
	 * 通过actionID获取action描述
	 * 
	 * @param workFlowName
	 * @param stepID
	 * @param actionID
	 * @param wfID
	 * @param transientVars
	 * @return
	 */
	/*
	 * public ResultDescriptor queryActionDescriptor(String workFlowName, String
	 * stepID, String actionID, String wfID, Map<String, Object> transientVars,
	 * SessionModel sessionModel) throws Exception { String userID =
	 * sessionModel.getCODE(); BasicWorkflow workflow = new
	 * BasicWorkflow(userID); workflow.setConfiguration(config);
	 * WorkflowDescriptor wfd = workflow.getWorkflowDescriptor(workFlowName);
	 * return workflow.getResultDescriptor(wfd, Long.parseLong(wfID),
	 * Integer.parseInt(actionID), stepID, transientVars); }
	 *//**
	 * 通过wfID获取时间
	 * 
	 * @param wfID
	 * @return
	 */
	/*
	 * public List<Map<String, Object>> queryStepDate(String wfID) throws
	 * Exception { return WorkFlowDao.queryStepDate(wfID); }
	 *//**
	 * 通过wfname获取所有的步骤
	 * 
	 * @param wfname
	 * @throws Exception
	 */
	/*
	 * public List<Map<String, Object>> getAllSteps(String wfname) throws
	 * Exception { BasicWorkflow workflow = new BasicWorkflow("");
	 * workflow.setConfiguration(config); WorkflowDescriptor wfd =
	 * workflow.getWorkflowDescriptor(wfname); List<Map<String, Object>> listmap
	 * = new ArrayList<Map<String, Object>>();
	 * 
	 * for (int i = 0; i < wfd.getSteps().size(); i++) { Map<String, Object> map
	 * = new HashMap<String, Object>(); StepDescriptor stepDescriptor =
	 * (StepDescriptor) wfd.getSteps().get(i); map.put("step_id",
	 * stepDescriptor.getId()); map.put("step_name", stepDescriptor.getName());
	 * listmap.add(map); } return listmap; }
	 */
}
