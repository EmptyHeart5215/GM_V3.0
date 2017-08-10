package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysDicMapperImpl;
import com.dykj.GSM.mapper.sys.impl.SysLogMapperImpl;
import com.dykj.GSM.model.sys.Log;
import com.dykj.GSM.model.sys.SysDic;
import com.dykj.GSM.service.sys.SysDicService;
import com.dykj.GSM.service.sys.SysLogService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service

public class SysLogServiceImpl implements SysLogService {
	@Autowired
	private SysLogMapperImpl syslogMapperImpl;

	@Override
	public int insert(Log entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int log(Log entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return syslogMapperImpl.insert(entity);
	}

	@Override
	public int update(Log entity) {
		return syslogMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return syslogMapperImpl.deletePk(primaryKey);
	}

	@Override
	public Log queryByKey(String primaryKey) {
		return syslogMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<Log> queryList() {
		return syslogMapperImpl.queryList();
	}

	@Override
	public List<Log> queryListParam(Map param) {
		return syslogMapperImpl.queryListParam(param);
	}

	@Override
	public List<Log> queryTListParam(Log param) {
		return syslogMapperImpl.queryTListParam(param);
	}
	
	@Override
	public Page<Log> queryByParamPage(int page, int size, String sidx, String sord, Log param) {
		return syslogMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return syslogMapperImpl.deleteBatch(list);
	}

	@Override
	public Map<String, Object> queryByCode(String code, String name)
			throws Exception {
		return syslogMapperImpl.queryByCode(code,name);
	}

	

	

}

