package com.dykj.GSM.mapper.eva.mapperinterf;

import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseStreet;

public interface AppraiseStreetMapper extends IBaseMapper<AppraiseStreet, String> {

	public int deleteByYearAndMonth(Map<String, Object> map);

	public Page<AppraiseStreet> queryByMapPage(int pageNum, int size, String sidx, String sord, Map param);

	public int insertBySelect(Map<String, Object> map);

	Page<AppraiseStreet> queryStatisticsPage(int pageNum, int size, String sidx, String sord, Map param);

}