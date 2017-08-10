package com.dykj.GSM.service.eva;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseDepartment;
import com.dykj.GSM.service.IBaseService;

public interface AppraiseDepartmentService extends IBaseService<AppraiseDepartment, String> {

	Page<AppraiseDepartment> queryByMapPage(String sidx, int rows, int page, String sord, Integer year, Integer month,
			String gridCode) throws Exception;

	int insertBySelect(String userCode, Integer year, Integer month, String gridCode) throws Exception;

	/**
	 * 统计
	 */
	Page<AppraiseDepartment> queryStatisticsPage(String sidx, int rows, int page, String sord, Integer year,
			Integer month, String gridCode, String type, Integer jiDu) throws Exception;

	Map<String, Object> getDetailOfAppraise(String primaryKey);

}
