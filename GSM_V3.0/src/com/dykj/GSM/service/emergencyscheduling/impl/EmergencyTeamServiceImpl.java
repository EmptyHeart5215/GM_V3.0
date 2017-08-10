package com.dykj.GSM.service.emergencyscheduling.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.emergencyscheduling.impl.EmergencyTeamMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencyTeam;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.emergencyscheduling.EmergencyTeamService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 15:08:41 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EmergencyTeamServiceImpl implements EmergencyTeamService {
	@Autowired
	private EmergencyTeamMapperImpl emergencyTeamMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(EmergencyTeam entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return emergencyTeamMapperImpl.insert(entity);
	}

	@Override
	public int update(EmergencyTeam entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return emergencyTeamMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return emergencyTeamMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EmergencyTeam queryByKey(String primaryKey) throws Exception {
		EmergencyTeam emergencyTeam = emergencyTeamMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(emergencyTeam, EmergencyTeam.class, "codeTeamType");
		return emergencyTeam;
	}

	@Override
	public List<EmergencyTeam> queryList() {
		return emergencyTeamMapperImpl.queryList();
	}

	@Override
	public List<EmergencyTeam> queryListParam(Map param) {
		return emergencyTeamMapperImpl.queryListParam(param);
	}

	@Override
	public List<EmergencyTeam> queryTListParam(EmergencyTeam param) {
		return emergencyTeamMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EmergencyTeam> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> m)
			throws Exception {
		Page<EmergencyTeam> emergencyTeam = emergencyTeamMapperImpl.queryByParamPage(page, size, sidx, sord, m);
		dicValueInputService.inputDicValue(emergencyTeam, EmergencyTeam.class, "codeTeamType");
		return emergencyTeam;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return emergencyTeamMapperImpl.deleteBatch(list);
	}

	@Override
	public Page<EmergencyTeam> queryByParamPage(int page, int size, String sidx, String sord, EmergencyTeam param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}