package com.dykj.GSM.service.eva;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseStreet;
import com.dykj.GSM.service.IBaseService;

public interface AppraiseStreetService extends IBaseService<AppraiseStreet, String> {

	Page<AppraiseStreet> queryByMapPage(String sidx, int rows, int page, String sord, Integer year, Integer month,
			String gridCode) throws Exception;

	int insertBySelect(String userCode, Integer year, Integer month, String gridCode) throws Exception;

	/**
	 * 统计
	 */
	Page<AppraiseStreet> queryStatisticsPage(String sidx, int rows, int page, String sord, Integer year, Integer month,
			String gridCode, String type, Integer jiDu) throws Exception;

	Map<String, Object> getDetailOfAppraise(String primaryKey);

}
