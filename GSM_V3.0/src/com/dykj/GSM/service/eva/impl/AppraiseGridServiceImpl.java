package com.dykj.GSM.service.eva.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.eva.impl.AppraiseGridMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysEvaSetMapperImpl;
import com.dykj.GSM.model.eva.AppraiseGrid;
import com.dykj.GSM.model.sys.SysEvaSet;
import com.dykj.GSM.service.eva.AppraiseGridService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class AppraiseGridServiceImpl implements AppraiseGridService {
	@Autowired
	private AppraiseGridMapperImpl appraiseGridMapperImpl;
	@Autowired
	private SysEvaSetMapperImpl sysEvaSetMapperImpl;

	@Override
	public int insertBySelect(String userCode, Integer year, Integer month, String gridCode) throws Exception {
		SysEvaSet evaSet = sysEvaSetMapperImpl.queryOne();

		if (evaSet != null) {
			String createDate = DateFormatUtil.getStringDate();
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("year", year);
			map2.put("month", month);
			map2.put("gridCode", gridCode);
			// 先将之前考核的全部删除
			appraiseGridMapperImpl.deleteByYearAndMonth(map2);
			String month2 = String.valueOf(month);
			if (month < 10) {
				month2 = "0" + month2;
			}
			map2.put("createDate", createDate);

			map2.put("month2", month2);
			map2.put("evaSet", evaSet);
			map2.put("createBy", userCode);
			return appraiseGridMapperImpl.insertBySelect(map2);
		} else {
			throw new Exception("评估设置未填");
		}
	}

	@Override
	public Page<AppraiseGrid> queryByMapPage(String sidx, int rows, int page, String sord, Integer year, Integer month,
			String gridCode) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("month", month);
		map.put("gridCode", gridCode);
		return appraiseGridMapperImpl.queryByMapPage(page, rows, sidx, sord, map);
	}

	/**
	 * 统计
	 * 
	 * @param sidx
	 * @param rows
	 * @param page
	 * @param sord
	 * @param year
	 * @param month
	 * @param gridCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<AppraiseGrid> queryStatisticsPage(String sidx, int rows, int page, String sord, Integer year,
			Integer month, String gridCode, String type, Integer jiDu) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("month", month);
		map.put("gridCode", gridCode);
		map.put("type", type);
		map.put("jiDu", jiDu);
		return appraiseGridMapperImpl.queryStatisticsPage(page, rows, sidx, sord, map);
	}

	@Override
	public List<Map<String, Object>> staticForIndex(String gridCode) throws Exception {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH);
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("year", year);
		params.put("month", month);
		params.put("gridCode", gridCode);
		List<Map<String, Object>> list = appraiseGridMapperImpl.staticForIndex(params);
		return list;
	}

	/**
	 * 详情
	 * 
	 * @param primaryKey
	 * @return
	 */
	@Override
	public Map<String, Object> getDetailOfAppraise(String primaryKey) {
		Map<String, Object> map = new HashMap<String, Object>();
		AppraiseGrid appraise = appraiseGridMapperImpl.queryByKey(primaryKey);
		SysEvaSet set = sysEvaSetMapperImpl.queryOne();
		String contradictGongShi = appraise.getContradictGongShi();
		String eventGongShi = appraise.getEventGongShi();
		String xunChaGongShi = appraise.getXunGongShi();
		String logGongShi = appraise.getLogGongShi();
		map.put("grid", appraise.getGridTotalName());
		// 50-(2-1)*1-0*1
		if (contradictGongShi != null && !contradictGongShi.equals("")) {
			map.put("contradictGongShi", contradictGongShi);
			map.put("contradictJieShi", "矛盾基础分-(每月应报数量-每月实报数量)*每少报一篇扣分-逾期处理事件数量*每逾期处理一次扣分");
		}
		if (eventGongShi != null && !eventGongShi.equals("")) {
			map.put("eventGongShi", eventGongShi);
			map.put("eventJieShi", "事件基础分-(每月应报数量-每月实报数量)*每少报一篇扣分-逾期处理事件数量*每逾期处理一次扣分");
		}
		// 20-(22-0)*1
		if (logGongShi != null && !logGongShi.equals("")) {
			map.put("logGongShi", logGongShi);
			map.put("logJieShi", "日志基础分-(本月应报数量-本月实报数量)*每少报一篇扣分");
		}
		// 20-(2-0)*1
		if (xunChaGongShi != null && !xunChaGongShi.equals("")) {
			map.put("xunChaGongShi", xunChaGongShi);
			map.put("xunChaJieShi", "巡查走访基础分-(每月最少走访数量-实际走访数量)*每少走访一户扣分");
		}
		map.put("appraise", appraise);
		return map;
	}

	@Override
	public int insert(AppraiseGrid entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AppraiseGrid entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AppraiseGrid queryByKey(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseGrid> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseGrid> queryListParam(Map param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseGrid> queryTListParam(AppraiseGrid param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AppraiseGrid> queryByParamPage(int page, int size, String sidx, String sord, AppraiseGrid param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
