package com.dykj.GSM.mapper.eva.mapperinterf;

import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseDepartment;

public interface AppraiseDepartmentMapper extends IBaseMapper<AppraiseDepartment, String> {

	public int deleteByYearAndMonth(Map<String, Object> map);

	public Page<AppraiseDepartment> queryByMapPage(int pageNum, int size, String sidx, String sord, Map param);

	public int insertBySelect(Map<String, Object> map);

	Page<AppraiseDepartment> queryStatisticsPage(int pageNum, int size, String sidx, String sord, Map param);

}