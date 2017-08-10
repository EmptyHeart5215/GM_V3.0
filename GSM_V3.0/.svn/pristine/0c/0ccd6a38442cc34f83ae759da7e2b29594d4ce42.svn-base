package com.dykj.GSM.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysLegalDateMapperImpl;
import com.dykj.GSM.model.sys.SysLegalDate;
import com.dykj.GSM.service.sys.SysLegalDateService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class SysLegalDateServiceImpl implements SysLegalDateService {
	@Autowired
	private SysLegalDateMapperImpl legalDateMapperImpl;

	@Override
	public int insert(SysLegalDate entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return legalDateMapperImpl.insert(entity);
	}

	/*
	 * 新增或修改
	 */
	@Override
	public int insertOrUpdate(SysLegalDate entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 进行修改
		if (entity.getCode() != null && !entity.getCode().isEmpty()) {
			return legalDateMapperImpl.update(entity);
		} else {// 进行添加
			return legalDateMapperImpl.insert(entity);
		}
	}

	@Override
	public SysLegalDate queryByYearAndMonth(Integer year, Integer month) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("month", month);
		return legalDateMapperImpl.queryByYearAndMonth(map);
	}

	@Override
	public int update(SysLegalDate entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysLegalDate queryByKey(String primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysLegalDate> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysLegalDate> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysLegalDate> queryTListParam(SysLegalDate param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysLegalDate> queryByParamPage(int page, int size, String sidx, String sord, SysLegalDate param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		// TODO Auto-generated method stub
		return 0;
	}
}
