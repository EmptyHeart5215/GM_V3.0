package com.dykj.GSM.service.sys;

import java.util.List;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.sys.SysGpsDevice;
import com.dykj.GSM.model.sys.SysTempDevice;
import com.dykj.GSM.service.IBaseService;

public interface SysGpsDeviceService extends IBaseService<SysGpsDevice,String> {
	
	/**
	 * 通过设备查询人员列表
	 * @param param
	 * @return
	 */
	public Page<SysTempDevice> queryDeviceForUserParamPage(int page, int size, String sidx, String sord,SysGpsDevice param);

}
