package com.dykj.GSM.mapper.emergencyscheduling.mapperinterf;

import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencyPlan;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 08:45:54 修改人： 修改日期： 类说明:
 */
public interface EmergencyPlanMapper extends IBaseMapper<EmergencyPlan, String> {
	public Page<EmergencyPlan> queryByParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param);
}