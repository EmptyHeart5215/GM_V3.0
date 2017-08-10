package com.dykj.GSM.service.eva;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseCommunity;
import com.dykj.GSM.service.IBaseService;

public interface AppraiseCommunityService extends IBaseService<AppraiseCommunity, String> {

	Page<AppraiseCommunity> queryByMapPage(String sidx, int rows, int page, String sord, Integer year, Integer month,
			String gridCode) throws Exception;

	int insertBySelect(String userCode, Integer year, Integer month, String gridCode) throws Exception;

	Page<AppraiseCommunity> queryStatisticsPage(String sidx, int rows, int page, String sord, Integer year,
			Integer month, String gridCode, String type, Integer jiDu) throws Exception;

}
