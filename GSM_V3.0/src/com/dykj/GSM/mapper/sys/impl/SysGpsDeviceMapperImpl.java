package com.dykj.GSM.mapper.sys.impl;

import java.util.List;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysGpsDeviceMapper;
import com.dykj.GSM.mapper.sys.mapperinterf.SysUserMapper;
import com.dykj.GSM.model.sys.SysGpsDevice;
import com.dykj.GSM.model.sys.SysTempDevice;
import com.dykj.GSM.model.sys.SysUser;
import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;

public class SysGpsDeviceMapperImpl extends BaseMapperImpl<SysGpsDevice, String> implements SysGpsDeviceMapper {

	/**
	 * 通过设备查询人员列表
	 */
	@Override
	public Page<SysTempDevice> queryDeviceForUserParamPage(int page, int size, String sidx, String sord,SysGpsDevice param) {
		    String clazzName = this.getTClassName();
			sidx = clazzName + "." + sidx;
			PageHelper.startPage(page, size, sidx + " " + sord);
			// 得到结果
			PageResult results = (PageResult)  this.getSqlSession().selectList(getSqlName("queryDeviceForUserParamPage"), param);
			return PageHelper.endPage(results);
	}

}
