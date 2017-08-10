package com.dykj.GSM.service.emergencyscheduling.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.emergencyscheduling.impl.EmergencySuppliesMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.emergencyscheduling.EmergencySupplies;
import com.dykj.GSM.model.emergencyscheduling.EmergencyTeam;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.emergencyscheduling.EmergencySuppliesService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-19 08:16:01 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EmergencySuppliesServiceImpl implements EmergencySuppliesService {
	@Autowired
	private EmergencySuppliesMapperImpl emergencySuppliesMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(EmergencySupplies entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return emergencySuppliesMapperImpl.insert(entity);
	}

	@Override
	public int update(EmergencySupplies entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return emergencySuppliesMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return emergencySuppliesMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EmergencySupplies queryByKey(String primaryKey) throws Exception {
		EmergencySupplies emergencySupplies = emergencySuppliesMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(emergencySupplies, EmergencySupplies.class, "codeSuppliesType,codeSuppliesState");
		return emergencySupplies;
	}

	@Override
	public List<EmergencySupplies> queryList() {
		return emergencySuppliesMapperImpl.queryList();
	}

	@Override
	public List<EmergencySupplies> queryListParam(Map param) {
		return emergencySuppliesMapperImpl.queryListParam(param);
	}

	@Override
	public List<EmergencySupplies> queryTListParam(EmergencySupplies param) {
		return emergencySuppliesMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EmergencySupplies> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> m)
			throws Exception {
		Page<EmergencySupplies> emergencySupplies = emergencySuppliesMapperImpl.queryByParamPage(page, size, sidx,
				sord, m);
		dicValueInputService.inputDicValue(emergencySupplies, EmergencySupplies.class,
				"codeSuppliesType,codeSuppliesState");
		return emergencySupplies;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return emergencySuppliesMapperImpl.deleteBatch(list);
	}

	@Override
	public Page<EmergencySupplies> queryByParamPage(int page, int size, String sidx, String sord,
			EmergencySupplies param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}