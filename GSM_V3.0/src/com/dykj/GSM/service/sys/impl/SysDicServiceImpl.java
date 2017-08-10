package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysDicMapperImpl;
import com.dykj.GSM.model.sys.SysDic;
import com.dykj.GSM.service.sys.SysDicService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service

public class SysDicServiceImpl implements SysDicService {
	@Autowired
	private SysDicMapperImpl sysdicMapperImpl;

	@Override
	public int insert(SysDic entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return sysdicMapperImpl.insert(entity);
	}

	@Override
	public int update(SysDic entity) {
		return sysdicMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysdicMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysDic queryByKey(String primaryKey) {
		return sysdicMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysDic> queryList() {
		return sysdicMapperImpl.queryList();
	}

	@Override
	public List<SysDic> queryListParam(Map param) {
		return sysdicMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysDic> queryTListParam(SysDic param) {
		return sysdicMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysDic> queryByParamPage(int page, int size, String sidx, String sord, SysDic param) {
		return sysdicMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysdicMapperImpl.deleteBatch(list);
	}
}
