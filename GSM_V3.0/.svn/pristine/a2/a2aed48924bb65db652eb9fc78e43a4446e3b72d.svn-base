package com.dykj.GSM.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BHouseMapperImpl;
import com.dykj.GSM.mapper.base.impl.BUnitMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BHouse;
import com.dykj.GSM.model.event.EContradict;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BHouseService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service("houseService")
@Transactional(noRollbackFor = RuntimeException.class)
public class BHouseServiceImpl implements BHouseService {
	@Autowired
	private BHouseMapperImpl houseMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BUnitMapperImpl bUnitMapperImpl;

	@Override
	public int insert(BHouse entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		entity.setGridCode(bUnitMapperImpl.queryByKey(entity.getUnitCode()).getGridCode());
		return houseMapperImpl.insert(entity);
	}

	/*
	 * 新增或修改
	 */
	@Override
	public int update(BHouse entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return houseMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return houseMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BHouse queryByKey(String primaryKey) throws Exception {
		BHouse bhouse= houseMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bhouse, BHouse.class, "codeHouseNature,codeHouseUse,codeHouseSource,codeHouseOwnerCard,codeUseProperty,codeUseCard,codeHouseHousing");
		return bhouse;
	}

	@Override
	public List<BHouse> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BHouse> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BHouse> queryTListParam(BHouse param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BHouse> queryByParamPage(int pageNum, int size, String sidx, String sord, BHouse param)
			throws Exception {
		Page<BHouse> page = houseMapperImpl.queryByParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BHouse.class, "codeHouseUse");

		return page;
	}

	public Page<BHouse> queryMapParamPage(int pageNum, int size, String sidx, String sord, Map param) {
		// return houseMapperImpl.queryMapParamPage(pageNum, size, sidx, sord,
		// param);
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return houseMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BHouse args) {
		return houseMapperImpl.Charts(args);
	}
	
	@Override
	public Page<BHouse> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args)
			throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		Map<Integer, String> allStep = new HashMap<Integer, String>();
//		args.put("allSteps", this.getAllSteps().get("mapValue"));
//		args.put("endStepId", 办结Id);
		Page<BHouse> page = this.houseMapperImpl.queryZongHePage(pageNum, size, sidx, sord, args);
//		dicValueInputService.inputDicValue(page, EContradict.class, "codeEventType,codeEventFrom");
		return page;
	}
}
