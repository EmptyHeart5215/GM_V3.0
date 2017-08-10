package com.dykj.GSM.service.emergencyscheduling;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencyTeam;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 15:08:41 修改人： 修改日期： 类说明:
 */
public interface EmergencyTeamService extends IBaseService<EmergencyTeam, String> {

	Page<EmergencyTeam> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> m)
			throws Exception;

}