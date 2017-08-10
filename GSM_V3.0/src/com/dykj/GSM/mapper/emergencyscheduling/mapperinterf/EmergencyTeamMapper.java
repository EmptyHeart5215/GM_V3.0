package com.dykj.GSM.mapper.emergencyscheduling.mapperinterf;

import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencyTeam;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 15:08:41 修改人： 修改日期： 类说明:
 */
public interface EmergencyTeamMapper extends IBaseMapper<EmergencyTeam, String> {

	Page<EmergencyTeam> queryByParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> param);

}