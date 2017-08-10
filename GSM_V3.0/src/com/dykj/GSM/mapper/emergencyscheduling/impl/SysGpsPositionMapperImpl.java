package com.dykj.GSM.mapper.emergencyscheduling.impl;

import java.util.List;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.emergencyscheduling.mapperinterf.SysGpsPositionMapper;
import com.dykj.GSM.model.emergencyscheduling.SysGpsPosition;



/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-06-07 10:19:07
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class SysGpsPositionMapperImpl extends BaseMapperImpl<SysGpsPosition, String> implements SysGpsPositionMapper{

	/**
	 * 定时取点
	 */
	@Override
	public Object actualGps(SysGpsPosition params) {
		return this.getSqlSession().selectList(getSqlName("actualGps"), params);
	}

	/**
	 * 历史定时取点
	 */
	@Override
	public Object historyGps(SysGpsPosition params) {
		return this.getSqlSession().selectList(getSqlName("historyGps"), params);
	}

	
	
}