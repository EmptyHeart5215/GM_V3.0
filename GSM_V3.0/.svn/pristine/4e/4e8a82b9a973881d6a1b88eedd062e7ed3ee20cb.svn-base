package com.dykj.GSM.mapper.eva.mapperinterf;

import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseCommunity;

public interface AppraiseCommunityMapper extends IBaseMapper<AppraiseCommunity, String> {

	public int deleteByYearAndMonth(Map<String, Object> map);

	public Page<AppraiseCommunity> queryByMapPage(int pageNum, int size, String sidx, String sord, Map param);

	public int insertBySelect(Map<String, Object> map);

	public Page<AppraiseCommunity> queryStatisticsPage(int pageNum, int size, String sidx, String sord, Map param);

}