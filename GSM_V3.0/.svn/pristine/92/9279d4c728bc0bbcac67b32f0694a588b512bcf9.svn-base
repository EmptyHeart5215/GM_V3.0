package com.dykj.GSM.mapper.eva.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseGrid;

public interface AppraiseGridMapper extends IBaseMapper<AppraiseGrid, String> {

	public int deleteByYearAndMonth(Map<String, Object> map);

	public Page<AppraiseGrid> queryByMapPage(int pageNum, int size, String sidx, String sord, Map param);

	public int insertBySelect(Map<String, Object> map);

	Page<AppraiseGrid> queryStatisticsPage(int pageNum, int size, String sidx, String sord, Map param);

	List<Map<String, Object>> staticForIndex(Map<String, Object> params);

}