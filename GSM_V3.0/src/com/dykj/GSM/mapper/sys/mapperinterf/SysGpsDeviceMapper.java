package com.dykj.GSM.mapper.sys.mapperinterf;

import java.util.List;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.sys.SysGpsDevice;
import com.dykj.GSM.model.sys.SysTempDevice;

public interface SysGpsDeviceMapper extends IBaseMapper<SysGpsDevice, String>{ 
	
	/**
	 * 通过设备查询人员列表
	 * @param param
	 * @return
	 */
	public Page<SysTempDevice> queryDeviceForUserParamPage(int page, int size, String sidx, String sord,SysGpsDevice param);
	
}
