package com.dykj.GSM.service.event;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.event.EEvent;
import com.dykj.GSM.model.event.EOpinion;
import com.dykj.GSM.model.sys.SysLegalDate;
import com.dykj.GSM.service.IBaseService;
import com.opensymphony.workflow.FactoryException;

public interface EEventService extends IBaseService<EEvent, String> {

	public int add(EEvent eevent, String userCode, String owner, EOpinion opinion) throws Exception;

	public Map<String, Object> queryApproval(Long wfid, String userCode, String roleCode, int stepID, String code)
			throws Exception;

	public int modify(EEvent eevent) throws Exception;

	public EEvent addDraft(EEvent eevent) throws Exception;

	public Date getDueDate(int begin, int j_begin, List<SysLegalDate> mapList, int year, int month, int day, int h,
			int mi, int s, int duration) throws Exception;

	public EEvent queryByCode(String code) throws Exception;

	/* 
	 * 待办列表
	 */
	public Page<EEvent> queryDaiBanPage(String sidx, int rows, int page, String sord, Map<String, Object> args,
			SessionModel model) throws Exception;

	public Map<String, Object> queryInitial(String userCode) throws Exception;

	public Map<String, Object> getAllSteps() throws FactoryException;

	public Page<EEvent> queryDraftPage(String sidx, int size, int pageNum, String sord, Map<String, Object> param)
			throws Exception;

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
	public Page<EEvent> queryYiBanPage(String sidx, int rows, int page, String sord, Map<String, Object> args,
			String userCode) throws Exception;

	/**
	 * 办理
	 * 
	 * @param eventCode
	 * @param wfid
	 * @param stepID
	 * @param actionID
	 * @param owner
	 * @param userCode
	 * @param opinion
	 * @param duration
	 * @return
	 * @throws Exception
	 */
	public int modifyApproval(String eventCode, long wfid, int stepID, int actionID, String owner, String userCode,
			EOpinion opinion, Integer duration, String gridCode) throws Exception;

	public Map<String, Object> queryAllStepsOfOneEvent(String entryId) throws FactoryException;

	Page<EEvent> queryCancelPage(String sidx, int rows, int page, String sord, Map<String, Object> args, String userCode)
			throws Exception;

	Page<EEvent> queryWanJiePage(String sidx, int rows, int page, String sord, Map<String, Object> args)
			throws Exception;

	Page<EEvent> queryDuBanPage(String sidx, int rows, int page, String sord, Map<String, Object> args)
			throws Exception;

	Page<EEvent> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception;

	List eventCharts(Map<String, Object> args) throws Exception;

	List<Map<String, Object>> eventChartsByOrg(Map<String, Object> args) throws Exception;
	List<Map<String, Object>> mapqueryWanJiePage(EEvent args);
}
