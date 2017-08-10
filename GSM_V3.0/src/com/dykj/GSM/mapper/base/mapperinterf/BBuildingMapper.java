package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BBuilding;

public interface BBuildingMapper extends IBaseMapper<BBuilding, String> {
	public List<Map<String, Object>> Charts(BBuilding args);

	public List<Map<String, Object>> queryNameTreeBy(String gridCode);

	public List<Map<String, Object>> mapbpersonCharts(String code);

	public List<Map<String, Object>> queryLpb(String code);

	Page<BBuilding> queryByMapParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> param);

}