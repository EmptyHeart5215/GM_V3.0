package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysGpsDeviceMapperImpl;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysGpsDevice;
import com.dykj.GSM.model.sys.SysTempDevice;
import com.dykj.GSM.service.sys.SysGpsDeviceService;
import com.dykj.GSM.utils.DateFormatUtil;
import com.dykj.GSM.utils.MySession;

@Service
public class SysGpsDeviceServiceImpl implements SysGpsDeviceService {
	@Autowired
	private SysGpsDeviceMapperImpl gpsdrviceMapperImpl;

	@Override
	public int insert(SysGpsDevice entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		SessionModel model = MySession.getInfo();
		entity.setCreateBy(model.getCode()); 
		return gpsdrviceMapperImpl.insert(entity);
	}

	@Override
	public int update(SysGpsDevice entity) {
		return gpsdrviceMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return gpsdrviceMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysGpsDevice queryByKey(String primaryKey) {
		return gpsdrviceMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysGpsDevice> queryList() {
		return gpsdrviceMapperImpl.queryList();
	}

	@Override
	public List<SysGpsDevice> queryListParam(Map param) {
		return gpsdrviceMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysGpsDevice> queryTListParam(SysGpsDevice param) {
		return gpsdrviceMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysGpsDevice> queryByParamPage(int page, int size, String sidx, String sord, SysGpsDevice param) {
		return gpsdrviceMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return gpsdrviceMapperImpl.deleteBatch(list);
	}

	@Override
	public Page<SysTempDevice> queryDeviceForUserParamPage(int page, int size, String sidx, String sord,
			SysGpsDevice param) {
		return gpsdrviceMapperImpl.queryDeviceForUserParamPage(page, size, sidx, sord, param);
	}

}
