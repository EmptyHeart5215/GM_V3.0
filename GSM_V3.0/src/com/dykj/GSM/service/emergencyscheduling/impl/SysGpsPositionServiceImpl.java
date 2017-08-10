package com.dykj.GSM.service.emergencyscheduling.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.emergencyscheduling.impl.SysGpsPositionMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.SysGpsPosition;
import com.dykj.GSM.service.emergencyscheduling.SysGpsPositionService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-06-07 10:19:07 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class SysGpsPositionServiceImpl implements SysGpsPositionService {
	@Autowired
	private SysGpsPositionMapperImpl sysGpsPositionMapperImpl;

	@Override
	public int insert(SysGpsPosition entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return sysGpsPositionMapperImpl.insert(entity);
	}

	@Override
	public int update(SysGpsPosition entity) {
		return sysGpsPositionMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysGpsPositionMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysGpsPosition queryByKey(String primaryKey) {
		return sysGpsPositionMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysGpsPosition> queryList() {
		return sysGpsPositionMapperImpl.queryList();
	}

	@Override
	public List<SysGpsPosition> queryListParam(Map param) {
		return sysGpsPositionMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysGpsPosition> queryTListParam(SysGpsPosition param) {
		return sysGpsPositionMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysGpsPosition> queryByParamPage(int page, int size, String sidx, String sord, SysGpsPosition param) {
		return sysGpsPositionMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysGpsPositionMapperImpl.deleteBatch(list);
	}

	@Override
	public Object actualGps(SysGpsPosition params) {
		// TODO Auto-generated method stub
		return sysGpsPositionMapperImpl.actualGps(params);
	}

	@Override
	public Object historyGps(SysGpsPosition params) {
		return sysGpsPositionMapperImpl.historyGps(params);
	}
}