package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysRnoticeMapperImpl;
import com.dykj.GSM.model.sys.SysRnotice;
import com.dykj.GSM.service.sys.SysRnoticeService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016-06-20 14:31:54 修改人： 修改日期： 类说明:
 */
@Service
public class SysRnoticeServiceImpl implements SysRnoticeService {
	@Autowired
	private SysRnoticeMapperImpl sysRnoticeMapperImpl;

	@Override
	public int insert(SysRnotice entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return sysRnoticeMapperImpl.insert(entity);
	}

	@Override
	public int update(SysRnotice entity) {
		return sysRnoticeMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysRnoticeMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysRnotice queryByKey(String primaryKey) {
		return sysRnoticeMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysRnotice> queryList() {
		return sysRnoticeMapperImpl.queryList();
	}

	@Override
	public List<SysRnotice> queryListParam(Map param) {
		return sysRnoticeMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysRnotice> queryTListParam(SysRnotice param) {
		return sysRnoticeMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysRnotice> queryByParamPage(int page, int size, String sidx, String sord, SysRnotice param) {
		return sysRnoticeMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysRnoticeMapperImpl.deleteBatch(list);
	}
}