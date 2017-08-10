package com.dykj.GSM.service.base;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerQingShaoNian;
import com.dykj.GSM.service.IBaseService;

public interface BPerQingShaoNianService extends IBaseService<BPerQingShaoNian, String> {
	/**
	 * 根据基本信息code查询留守人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerQingShaoNian queryByPersonCode(String personCode) throws Exception;

	public Page<BPerQingShaoNian> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception;
}
