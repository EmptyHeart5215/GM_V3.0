package com.dykj.GSM.mapper.event.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;

public interface IBaseEventMpper<BaseModel> extends IBaseMapper<BaseModel, String> {
	/**
	 * 事件待办
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public Page<BaseModel> queryDaiBanPage(int pageNum, int size, String sidx, String sord, Map param);

	/**
	 * 事件草稿
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public Page<BaseModel> queryDraftPage(int pageNum, int size, String sidx, String sord, Map param);

	/**
	 * 事件已办
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public Page<BaseModel> queryYiBanPage(int pageNum, int size, String sidx, String sord, Map param);

	/**
	 * 为显示流程得到某事件的所有步骤
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public List<Map<String, Object>> queryAllStepsOfOneEvent(String entryId);

	public int updateEventCancel(String code);

	public int udpateEventDuBan(String code);

	/**
	 * 事件已被注销列表
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public Page<BaseModel> queryCancelPage(int page, int size, String sidx, String sord, Map args);

	public Page<BaseModel> queryWanJiePage(int page, int size, String sidx, String sord, Map args);

	public Page<BaseModel> queryZongHePage(int page, int size, String sidx, String sord, Map args);

	public List<Map<String, Object>> queryCharts(Map<String, Object> args);

	public List<Map<String, Object>> queryChartsByOrg(Map<String, Object> args);
}
