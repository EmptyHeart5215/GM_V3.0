package com.dykj.GSM.service.emergencyscheduling;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencyPlan;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 08:45:54 修改人： 修改日期： 类说明:
 */
public interface EmergencyPlanService extends IBaseService<EmergencyPlan, String> {

	Page<EmergencyPlan> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> param)
			throws Exception;

}