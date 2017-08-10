package com.dykj.GSM.mapper.sys.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysLegalDate;

public interface SysLegalDateMapper extends IBaseMapper<SysLegalDate, String> {
	public SysLegalDate queryByYearAndMonth(Map param);

	List<SysLegalDate> queryLegalDateAfterNow(Map param);
}