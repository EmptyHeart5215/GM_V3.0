package com.dykj.GSM.service.base;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerTSXieJiao;
import com.dykj.GSM.service.IBaseService;

public interface BPerTSXieJiaoService extends IBaseService<BPerTSXieJiao, String> {
	/**
	 * 根据基本信息code查询矫正人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerTSXieJiao queryByPersonCode(String personCode);

	public Page<BPerTSXieJiao> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception;
}
