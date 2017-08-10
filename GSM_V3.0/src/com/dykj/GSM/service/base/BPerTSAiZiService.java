package com.dykj.GSM.service.base;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerTSAiZi;
import com.dykj.GSM.service.IBaseService;

public interface BPerTSAiZiService extends IBaseService<BPerTSAiZi, String> {
	/**
	 * 根据基本信息code查询矫正人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerTSAiZi queryByPersonCode(String personCode) throws Exception;

	public Page<BPerTSAiZi> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception;
}
