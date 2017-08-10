package com.dykj.GSM.service.base.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BHouseMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPersonMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysRegionMapperImpl;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.model.sys.SysRegion;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPersonService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPersonServiceImpl implements BPersonService {
	@Autowired
	private BPersonMapperImpl bPersonMapperImpl;
	@Autowired
	private BHouseMapperImpl houseMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private SysRegionMapperImpl sysRegionMapperImpl;

	@Override
	public int insert(BPerson entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		entity.setGridCode(houseMapperImpl.queryByKey(entity.getHouseCode()).getGridCode());
		bPersonMapperImpl.insert(entity);
		// 插入一条附属表信息
		BPerFuShu fuShu = new BPerFuShu();
		fuShu.setPersonCode(entity.getCode());
		fuShu.setCreateBy(entity.getCreateBy());
		fuShu.setCreateDate(entity.getCreateDate());
		return bPerFuShuMapperImpl.insert(fuShu);
	}

	/*
	 * 新增或修改
	 */
	@Override
	public int update(BPerson entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bPersonMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		bPersonMapperImpl.deletePk(primaryKey);
		return bPerFuShuMapperImpl.deleteByPersonCode(primaryKey);
	}

	@Override
	public BPerson queryByKey(String primaryKey) {
		return bPersonMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public BPerson queryByKeyForInfoSee(String primaryKey) throws Exception {
		BPerson p = bPersonMapperImpl.queryByKey(primaryKey);
		if (p != null) {
			dicValueInputService
					.inputDicValueForOne(p, BPerson.class,
							"codeNation,codeMarriage,codePolitical,codeEducation,codeReligious,codeJobType,codeHouseholdStatus,codeManageType");
			String natives = p.getNativePlaceCode();
			String c = p.getResidenceAddressCode();
			String n = p.getNowAddressCode();
			List<String> list = new ArrayList<String>();
			list.add(natives);
			list.add(c);
			list.add(n);
			List<SysRegion> l = sysRegionMapperImpl.queryListByCodes(list);
			for (SysRegion s : l) {
				if (s.getRegionId().equals(natives)) {
					p.setNativePlaceStr(s.getTotalName());
				} else if (s.getRegionId().equals(n)) {
					p.setNowAddressStr(s.getTotalName());
				} else if (s.getRegionId().equals(c)) {
					p.setResidenceAddressStr(s.getTotalName());
				}
			}
		}
		return p;
	}

	@Override
	public List<BPerson> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerson> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerson> queryTListParam(BPerson param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerson> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerson param) {
		return bPersonMapperImpl.queryByParamPage(pageNum, size, sidx, sord, param);
	}

	@Override
	public Page<List> queryParamPageMap(int pageNum, int size, String sidx, String sord, BPerson param) {
		return bPersonMapperImpl.queryParamPageMap(pageNum, size, sidx, sord, param);
	}

	@Override
	public Page<BPerson> queryMapParamPage(int pageNum, int size, String sidx, String sord, Map param) {
		return bPersonMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPersonMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BPerson args) {
		return bPersonMapperImpl.Charts(args);
	}

	@Override
	public List<Map<String, Object>> mapqueryByParamPage(BPerson args) {
		return bPersonMapperImpl.mapqueryByParamPage(args);
	}

	@Override
	public Page<BPerson> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		Map<Integer, String> allStep = new HashMap<Integer, String>();
		// args.put("allSteps", this.getAllSteps().get("mapValue"));
		// args.put("endStepId", 办结Id);
		Page<BPerson> page = this.bPersonMapperImpl.queryZongHePage(pageNum, size, sidx, sord, args);
		dicValueInputService.inputDicValue(page, BPerson.class,
				"codeNation,codeHouseholdStatus,codeManageType,codeMarriage,residenceAddressCode");
		return page;
	}

	/**
	 * 首页网格信息统计
	 * 
	 * @return
	 */
	@Override
	public Map<String, Object> queryPersonTypeStatistics(String gridCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		List<Map<String, Object>> list = bPersonMapperImpl.queryPersonTypeStatistics(map);
		if (list != null && !list.isEmpty()) {
			Map<String, Object> m = list.get(0);
			m.put("SHI",
					Integer.valueOf(m.get("WAI").toString()) + Integer.valueOf(m.get("LIU").toString())
							+ Integer.valueOf(m.get("CHANG").toString()));
			return m;
		}
		return null;
	}
}
