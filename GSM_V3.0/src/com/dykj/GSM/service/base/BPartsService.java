package com.dykj.GSM.service.base;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BHouse;
import com.dykj.GSM.model.base.BParts;
import com.dykj.GSM.model.sys.SysLegalDate;
import com.dykj.GSM.service.IBaseService;

public interface BPartsService extends IBaseService<BParts, String> {
	public List<Map<String, Object>> Charts(BParts args);
	Page<BParts> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception;
}
