package com.dykj.GSM.service.emergencyscheduling.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.emergencyscheduling.impl.EmergencyPlaceMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencyPlace;
import com.dykj.GSM.service.emergencyscheduling.EmergencyPlaceService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 16:44:58 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EmergencyPlaceServiceImpl implements EmergencyPlaceService {
	@Autowired
	private EmergencyPlaceMapperImpl emergencyPlaceMapperImpl;

	@Override
	public int insert(EmergencyPlace entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return emergencyPlaceMapperImpl.insert(entity);
	}

	@Override
	public int update(EmergencyPlace entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return emergencyPlaceMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return emergencyPlaceMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EmergencyPlace queryByKey(String primaryKey) {
		return emergencyPlaceMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<EmergencyPlace> queryList() {
		return emergencyPlaceMapperImpl.queryList();
	}

	@Override
	public List<EmergencyPlace> queryListParam(Map param) {
		return emergencyPlaceMapperImpl.queryListParam(param);
	}

	@Override
	public List<EmergencyPlace> queryTListParam(EmergencyPlace param) {
		return emergencyPlaceMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EmergencyPlace> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> m) {
		return emergencyPlaceMapperImpl.queryByParamPage(page, size, sidx, sord, m);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return emergencyPlaceMapperImpl.deleteBatch(list);
	}

	@Override
	public Page<EmergencyPlace> queryByParamPage(int page, int size, String sidx, String sord, EmergencyPlace param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}