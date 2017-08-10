package com.dykj.GSM.service.sys;

import com.dykj.GSM.model.sys.SysLegalDate;
import com.dykj.GSM.service.IBaseService;

public interface SysLegalDateService extends IBaseService<SysLegalDate, String> {
	public SysLegalDate queryByYearAndMonth(Integer year, Integer month);

	public int insertOrUpdate(SysLegalDate entity);
}
