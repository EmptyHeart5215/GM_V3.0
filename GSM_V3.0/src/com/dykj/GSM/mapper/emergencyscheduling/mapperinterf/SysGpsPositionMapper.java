package com.dykj.GSM.mapper.emergencyscheduling.mapperinterf;

import java.util.List;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.emergencyscheduling.SysGpsPosition;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-06-07 10:19:07
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface SysGpsPositionMapper extends IBaseMapper<SysGpsPosition, String>{
	
	/**
	 * 实时定时取点
	 * @param gpsImei
	 * @return
	 */
	public Object actualGps(SysGpsPosition params);
	
	/**
	 * 历史定时取点
	 * @param gpsImei
	 * @return
	 */
	public Object historyGps(SysGpsPosition params);

}