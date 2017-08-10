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
import com.dykj.GSM.mapper.sys.impl.SysSeatSecondMapperImpl;
import com.dykj.GSM.model.sys.SysSeatSecond;
import com.dykj.GSM.service.sys.SysSeatSecondService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月20日 下午2:12:12 修改人： 修改日期： 类说明:
 */
@Service

public class SysSeatSecondServiceImpl implements SysSeatSecondService {

	@Autowired
	private SysSeatSecondMapperImpl sysSeatSecondMapperImpl;
	@Autowired
	private SysSeatGridMapperImpl sysSeatGridMapperImpl;

	@Override
	public int insert(SysSeatSecond entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		entity.setGridTotalName("唐山市-" + entity.getName());
		entity.setFirstName("唐山市");
		return sysSeatSecondMapperImpl.insert(entity);
	}

	@Override
	public int update(SysSeatSecond entity) {
		entity.setGridTotalName("唐山市-" + entity.getName());
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, Object> m = new HashMap<String, Object>();
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableName", "sys_seat_third");
		map.put("newValue", entity.getGridTotalName());
		list.add(map);
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("tableName", "sys_seat_four");
		map2.put("newValue", entity.getGridTotalName());
		list.add(map2);
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("tableName", "sys_seat_grid");
		map3.put("newValue", entity.getGridTotalName());
		list.add(map3);
		m.put("level", 2);

		m.put("gridCode", entity.getCode());
		m.put("list", list);
		int i = sysSeatGridMapperImpl.updateTotalGridName(m);
		System.out.println("-----------------" + i + "-----------------");
		return sysSeatSecondMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysSeatSecondMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysSeatSecond queryByKey(String primaryKey) {
		return sysSeatSecondMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysSeatSecond> queryList() {
		return sysSeatSecondMapperImpl.queryList();
	}

	@Override
	public List<SysSeatSecond> queryListParam(Map param) {
		return sysSeatSecondMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysSeatSecond> queryTListParam(SysSeatSecond param) {
		return sysSeatSecondMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysSeatSecond> queryByParamPage(int page, int size, String sidx, String sord, SysSeatSecond param) {
		// TODO Auto-generated method stub
		return sysSeatSecondMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysSeatSecondMapperImpl.deleteBatch(list);
	}

}
