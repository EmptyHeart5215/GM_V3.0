package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BHouse;
import com.dykj.GSM.model.base.BParts;

public interface BPartsMapper extends IBaseMapper<BParts, String> {
	public List<Map<String, Object>> Charts(BParts args);
	public Page<BParts> queryZongHePage(int page, int size, String sidx, String sord, Map args);

}