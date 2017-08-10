package com.dykj.GSM.service.base.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BHouseMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerJingWaiMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysRegionMapperImpl;
import com.dykj.GSM.model.base.BPerJingWai;
import com.dykj.GSM.model.sys.SysRegion;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerJingWaiService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerJingWaiServiceImpl implements BPerJingWaiService {
	@Autowired
	private BPerJingWaiMapperImpl bPerJingWaiMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BHouseMapperImpl houseMapperImpl;
	@Autowired
	private SysRegionMapperImpl sysRegionMapperImpl;

	@Override
	public int insert(BPerJingWai entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		entity.setGridCode(houseMapperImpl.queryByKey(entity.getHouseCode()).getGridCode());
		return bPerJingWaiMapperImpl.insert(entity);
	}

	/*
	 * 新增或修改
	 */
	public int update(BPerJingWai entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bPerJingWaiMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bPerJingWaiMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BPerJingWai queryByKey(String primaryKey) throws Exception {
		BPerJingWai PerJingWai = bPerJingWaiMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(PerJingWai, BPerJingWai.class, "codeNationality,codeReligious,codeIdType,codeComeChinaReason,codeJobType,nowAddressCode");
		String n = PerJingWai.getNowAddressCode();
		List<String> list = new ArrayList<String>();
		list.add(n);
		List<SysRegion> l = sysRegionMapperImpl.queryListByCodes(list);
		for (SysRegion s : l) {
			 if (s.getRegionId().equals(n)) {
				PerJingWai.setNowAddressCode(s.getTotalName());
			}
		}
		return PerJingWai;
	}

	@Override
	public List<BPerJingWai> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerJingWai> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerJingWai> queryTListParam(BPerJingWai param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Page<BPerJingWai> queryByParamPage(int page, int size, String sidx, String sord, BPerJingWai param) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<BPerJingWai> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		Page<BPerJingWai> page = bPerJingWaiMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		try {
			dicValueInputService.inputDicValue(page, BPerJingWai.class, "codeNationality,codeComeChinaReason");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
}
