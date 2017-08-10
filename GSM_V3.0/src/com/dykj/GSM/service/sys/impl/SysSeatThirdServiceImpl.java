package com.dykj.GSM.service.sys.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysSeatGridMapperImpl;
import com.dykj.GSM.mapper.sys.impl.SysSeatThirdMapperImpl;
import com.dykj.GSM.model.sys.SysSeatSecond;
import com.dykj.GSM.model.sys.SysSeatThird;
import com.dykj.GSM.service.sys.SysSeatThirdService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月21日 下午4:09:30 修改人： 修改日期： 类说明:
 */
@Service

public class SysSeatThirdServiceImpl implements SysSeatThirdService {
	@Autowired
	private SysSeatThirdMapperImpl sysSeatThirdMapperImpl;
	@Autowired
	private SysSeatGridMapperImpl sysSeatGridMapperImpl;

	@Override
	public int insert(SysSeatThird entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return sysSeatThirdMapperImpl.insert(entity);
	}

	@Override
	public int update(SysSeatThird entity) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("tableName", "sys_seat_four");
		map2.put("newValue", entity.getGridTotalName());
		list.add(map2);
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("tableName", "sys_seat_grid");
		map3.put("newValue", entity.getGridTotalName());
		list.add(map3);
		m.put("level", 3);
		m.put("gridCode", entity.getCode());
		m.put("list", list);
		int i = sysSeatGridMapperImpl.updateTotalGridName(m);
		return sysSeatThirdMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysSeatThirdMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysSeatThird queryByKey(String primaryKey) {
		return sysSeatThirdMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysSeatThird> queryList() {
		return sysSeatThirdMapperImpl.queryList();
	}

	@Override
	public List<SysSeatThird> queryListParam(Map param) {
		return sysSeatThirdMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysSeatThird> queryTListParam(SysSeatThird param) {
		return sysSeatThirdMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysSeatThird> queryByParamPage(int page, int size, String sidx, String sord, SysSeatThird param) {
		return sysSeatThirdMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysSeatThirdMapperImpl.deleteBatch(list);
	}

	@Override
	public SysSeatSecond queryByparentCode(String parentCode) {
		return sysSeatThirdMapperImpl.queryByparentCode(parentCode);
	}
}
