package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysRegionMapperImpl;
import com.dykj.GSM.model.sys.SysRegion;
import com.dykj.GSM.service.sys.SysRegionService;

@Service

public class SysRegionServiceImpl implements SysRegionService {
	@Autowired
	private SysRegionMapperImpl sysRegionMapperImpl;

	public List<Map<String, Object>> queryTree(Map map) {
		return sysRegionMapperImpl.queryTree(map);
	}

	@Override
	public int insert(SysRegion entity) {
		return 0;
	}

	@Override
	public int update(SysRegion entity) {
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) {
		return 0;
	}

	@Override
	public SysRegion queryByKey(String primaryKey) {
		return sysRegionMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysRegion> queryList() {
		return null;
	}

	@Override
	public List<SysRegion> queryListParam(Map param) {
		return null;
	}

	@Override
	public List<SysRegion> queryTListParam(SysRegion param) {
		return null;
	}

	@Override
	public Page<SysRegion> queryByParamPage(int page, int size, String sidx, String sord, SysRegion param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return 0;
	}
}
