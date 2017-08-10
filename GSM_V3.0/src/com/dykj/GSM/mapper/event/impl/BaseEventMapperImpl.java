package com.dykj.GSM.mapper.event.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;

public class BaseEventMapperImpl<BaseModel> extends BaseMapperImpl<BaseModel, String> {
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
	public Page<BaseModel> queryDaiBanPage(int pageNum, int size, String sidx, String sord, Map param) {

		PageHelper.startPage(pageNum, size, "step.due_date asc,step.start_date asc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryDaiBanPage"), param);
		return PageHelper.endPage(results);
	}

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
	public Page<BaseModel> queryDraftPage(int pageNum, int size, String sidx, String sord, Map param) {
		String clazzName = getTClassName();
		sidx = clazzName + "." + sidx;
		PageHelper.startPage(pageNum, size, sidx + " " + sord);
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryDraftPage"), param);
		return PageHelper.endPage(results);
	}

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
	public Page<BaseModel> queryYiBanPage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "step.finish_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryYiBanPage"), args);
		return PageHelper.endPage(results);
	}

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
	public List<Map<String, Object>> queryAllStepsOfOneEvent(String entryId) {
		// 得到结果
		List<Map<String, Object>> results = this.getSqlSession().selectList(getSqlName("queryAllStepsOfOneEvent"),
				entryId);
		return results;
	}

	public int updateEventCancel(String code) {
		return this.getSqlSession().update(getSqlName("updateEventCancel"), code);
	}

	public int udpateEventDuBan(String code) {
		return this.getSqlSession().update(getSqlName("udpateEventDuBan"), code);
	}

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
	public Page<BaseModel> queryCancelPage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "step.finish_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryCancelPage"), args);
		return PageHelper.endPage(results);
	}

	/**
	 * 督办列表
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public Page<BaseModel> queryDuBanPage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "event_num desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryDuBanPage"), args);
		return PageHelper.endPage(results);
	}

	/**
	 * 事件已完结列表
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public Page<BaseModel> queryWanJiePage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "step.finish_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryWanJiePage"), args);
		return PageHelper.endPage(results);
	}

	/**
	 * 综合查询
	 * 
	 * @param pageNum
	 * @param size
	 * @param sidx
	 * @param sord
	 * @param param
	 * @return
	 */
	public Page<BaseModel> queryZongHePage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "e_contradict.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryZongHePage"), args);
		return PageHelper.endPage(results);
	}

	public List<Map<String, Object>> queryCharts(Map<String, Object> args) {
		return this.getSqlSession().selectList(getSqlName("queryCharts"), args);
	}

	public List<Map<String, Object>> queryChartsByOrg(Map<String, Object> args) {
		return this.getSqlSession().selectList(getSqlName("queryChartsByOrg"), args);
	}
}
