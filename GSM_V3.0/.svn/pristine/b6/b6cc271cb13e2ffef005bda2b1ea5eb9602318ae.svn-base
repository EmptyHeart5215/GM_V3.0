package com.dykj.GSM.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysSeatFourMapperImpl;
import com.dykj.GSM.mapper.sys.impl.SysSeatGridMapperImpl;
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatThird;
import com.dykj.GSM.service.sys.SysSeatFourService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月21日 下午4:22:50 修改人： 修改日期： 类说明:
 */
@Service

public class SysSeatFourServiceImpl implements SysSeatFourService {

	@Autowired
	private SysSeatFourMapperImpl sysSeatFourMapperImpl;
	@Autowired
	private SysSeatGridMapperImpl sysSeatGridMapperImpl;

	@Override
	public int insert(SysSeatFour entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return sysSeatFourMapperImpl.insert(entity);
	}

	@Override
	public int update(SysSeatFour entity) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("tableName", "sys_seat_grid");
		map3.put("newValue", entity.getGridTotalName());
		list.add(map3);
		m.put("level", 4);
		m.put("gridCode", entity.getCode());
		m.put("list", list);
		int i = sysSeatGridMapperImpl.updateTotalGridName(m);
		return sysSeatFourMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysSeatFourMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysSeatFour queryByKey(String primaryKey) {
		return sysSeatFourMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysSeatFour> queryList() {
		return sysSeatFourMapperImpl.queryList();
	}

	@Override
	public List<SysSeatFour> queryListParam(Map param) {
		return sysSeatFourMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysSeatFour> queryTListParam(SysSeatFour param) {
		return sysSeatFourMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysSeatFour> queryByParamPage(int page, int size, String sidx, String sord, SysSeatFour param) {
		return sysSeatFourMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysSeatFourMapperImpl.deleteBatch(list);
	}

	@Override
	public SysSeatThird queryByparentCode(String parentCode) {
		return sysSeatFourMapperImpl.queryByparentCode(parentCode);
	}

}
