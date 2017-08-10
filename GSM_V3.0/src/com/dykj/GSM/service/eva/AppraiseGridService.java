package com.dykj.GSM.service.eva;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseGrid;
import com.dykj.GSM.service.IBaseService;

public interface AppraiseGridService extends IBaseService<AppraiseGrid, String> {

	Page<AppraiseGrid> queryByMapPage(String sidx, int rows, int page, String sord, Integer year, Integer month,
			String gridCode) throws Exception;

	int insertBySelect(String userCode, Integer year, Integer month, String gridCode) throws Exception;

	/**
	 * 统计
	 */
	Page<AppraiseGrid> queryStatisticsPage(String sidx, int rows, int page, String sord, Integer year, Integer month,
			String gridCode, String type, Integer jiDu) throws Exception;

	List<Map<String, Object>> staticForIndex(String gridCode) throws Exception;

	Map<String, Object> getDetailOfAppraise(String primaryKey);

}
