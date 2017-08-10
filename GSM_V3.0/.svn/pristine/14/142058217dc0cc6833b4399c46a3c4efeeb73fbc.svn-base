package com.dykj.GSM.service.emergencyscheduling.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.emergencyscheduling.impl.EmergencyPlanMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencyPlan;
import com.dykj.GSM.model.emergencyscheduling.EmergencySupplies;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.emergencyscheduling.EmergencyPlanService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 08:45:54 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EmergencyPlanServiceImpl implements EmergencyPlanService {
	@Autowired
	private EmergencyPlanMapperImpl emergencyPlanMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(EmergencyPlan entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return emergencyPlanMapperImpl.insert(entity);
	}

	@Override
	public int update(EmergencyPlan entity) {
		return emergencyPlanMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return emergencyPlanMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EmergencyPlan queryByKey(String primaryKey) throws Exception {
		EmergencyPlan emergencyPlan = emergencyPlanMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(emergencyPlan, EmergencyPlan.class, "codePlanType");
		return emergencyPlan;
	}

	@Override
	public List<EmergencyPlan> queryList() {
		return emergencyPlanMapperImpl.queryList();
	}

	@Override
	public List<EmergencyPlan> queryListParam(Map param) {
		return emergencyPlanMapperImpl.queryListParam(param);
	}

	@Override
	public List<EmergencyPlan> queryTListParam(EmergencyPlan param) {
		return emergencyPlanMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EmergencyPlan> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> param)
			throws Exception {
		Page<EmergencyPlan> EmergencyPlan = emergencyPlanMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(EmergencyPlan, EmergencyPlan.class, "codePlanType");
		return EmergencyPlan;

	}

	@Override
	public int deleteBatch(List<String> list) {
		return emergencyPlanMapperImpl.deleteBatch(list);
	}

	@Override
	public Page<EmergencyPlan> queryByParamPage(int page, int size, String sidx, String sord, EmergencyPlan param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}