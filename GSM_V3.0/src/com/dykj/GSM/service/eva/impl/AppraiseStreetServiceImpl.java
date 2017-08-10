package com.dykj.GSM.service.eva.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.eva.impl.AppraiseStreetMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysEvaSetDepartmentMapperImpl;
import com.dykj.GSM.model.eva.AppraiseStreet;
import com.dykj.GSM.model.sys.SysEvaSetDepartment;
import com.dykj.GSM.service.eva.AppraiseStreetService;
import com.dykj.GSM.service.event.impl.EContradictServiceImpl;
import com.dykj.GSM.service.event.impl.EEventServiceImpl;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class AppraiseStreetServiceImpl implements AppraiseStreetService {
	@Autowired
	private AppraiseStreetMapperImpl appraiseStreetMapperImpl;
	@Autowired
	private SysEvaSetDepartmentMapperImpl sysEvaSetMapperImpl;

	@Override
	public int insertBySelect(String userCode, Integer year, Integer month, String gridCode) throws Exception {
		SysEvaSetDepartment evaSet = sysEvaSetMapperImpl.queryOne();

		if (evaSet != null) {
			String createDate = DateFormatUtil.getStringDate();
			Map<String, Object> map2 = new HashMap<String, Object>();
			map2.put("year", year);
			map2.put("month", month);
			map2.put("gridCode", gridCode);
			// 先将之前考核的全部删除
			appraiseStreetMapperImpl.deleteByYearAndMonth(map2);
			String month2 = String.valueOf(month);
			if (month < 10) {
				month2 = "0" + month2;
			}
			map2.put("createDate", createDate);

			map2.put("month2", month2);
			map2.put("evaSet", evaSet);
			map2.put("createBy", userCode);
			map2.put("buMenBanLiStepContradict", EContradictServiceImpl.部门办理StepId);
			map2.put("shenQingJieAnActionContradict", EContradictServiceImpl.申请结案ActionId);
			map2.put("duBanActionContradict", EContradictServiceImpl.督办Id);
			map2.put("yanShouActionContradict", EContradictServiceImpl.验收ActionId);
			map2.put("buMenBanLiStepEvent", EEventServiceImpl.部门办理StepId);
			map2.put("shenQingJieAnActionEvent", EEventServiceImpl.申请结案ActionId);
			map2.put("duBanActionEvent", EEventServiceImpl.督办Id);
			map2.put("yanShouActionEvent", EEventServiceImpl.验收ActionId);

			// 不满意的id
			map2.put("buManYiCodeAppraise", "0498");
			return appraiseStreetMapperImpl.insertBySelect(map2);
		} else {
			throw new Exception("评估设置未填");
		}
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
		AppraiseStreet appraise = appraiseStreetMapperImpl.queryByKey(primaryKey);
		String contradictGongShi = appraise.getGongShiContradict();
		String eventGongShi = appraise.getGongShiEvent();
		// 30-0*4-0*4-0*5
		if (contradictGongShi != null && !contradictGongShi.equals("")) {
			map.put("contradictGongShi", contradictGongShi);
			map.put("contradictJieShi", "矛盾基础分-逾期处理矛盾数量*每逾期处理一次扣分-返回重办矛盾数量*每返回重办一次扣分-群众反馈不满意矛盾数量*每不满意一次扣分");
		}// 30-0*3-0*4-0*5
		if (eventGongShi != null && !eventGongShi.equals("")) {
			map.put("eventGongShi", eventGongShi);
			map.put("eventJieShi", "事件基础分-逾期处理事件数量*每逾期处理一次扣分-返回重办事件数量*每返回重办一次扣分-群众反馈不满意事件数量*每不满意一次扣分");
		}
		map.put("appraise", appraise);
		return map;
	}

	@Override
	public Page<AppraiseStreet> queryByMapPage(String sidx, int rows, int page, String sord, Integer year,
			Integer month, String gridCode) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("month", month);
		map.put("gridCode", gridCode);
		return appraiseStreetMapperImpl.queryByMapPage(page, rows, sidx, sord, map);
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
	public Page<AppraiseStreet> queryStatisticsPage(String sidx, int rows, int page, String sord, Integer year,
			Integer month, String gridCode, String type, Integer jiDu) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("month", month);
		map.put("gridCode", gridCode);
		map.put("type", type);
		map.put("jiDu", jiDu);
		return appraiseStreetMapperImpl.queryStatisticsPage(page, rows, sidx, sord, map);
	}

	@Override
	public int insert(AppraiseStreet entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AppraiseStreet entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AppraiseStreet queryByKey(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseStreet> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseStreet> queryListParam(Map param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseStreet> queryTListParam(AppraiseStreet param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AppraiseStreet> queryByParamPage(int page, int size, String sidx, String sord, AppraiseStreet param)
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
