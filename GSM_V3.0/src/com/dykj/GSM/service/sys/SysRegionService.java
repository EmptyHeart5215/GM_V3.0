package com.dykj.GSM.service.sys;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.model.sys.SysRegion;
import com.dykj.GSM.service.IBaseService;

public interface SysRegionService extends IBaseService<SysRegion, String> {
	public List<Map<String, Object>> queryTree(Map map);
}
