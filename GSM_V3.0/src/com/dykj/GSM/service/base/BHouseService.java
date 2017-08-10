package com.dykj.GSM.service.base;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BHouse;
import com.dykj.GSM.model.event.EContradict;
import com.dykj.GSM.service.IBaseService;

public interface BHouseService extends IBaseService<BHouse, String> {
	public List<Map<String, Object>> Charts(BHouse args);
	Page<BHouse> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception;
}
