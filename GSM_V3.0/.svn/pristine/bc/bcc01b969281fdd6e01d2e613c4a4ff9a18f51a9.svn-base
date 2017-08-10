package com.dykj.GSM.service.base;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerTSJiaoZheng;
import com.dykj.GSM.service.IBaseService;

public interface BPerTSJiaoZhengService extends IBaseService<BPerTSJiaoZheng, String> {
	/**
	 * 根据基本信息code查询矫正人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerTSJiaoZheng queryByPersonCode(String personCode)throws Exception;

	public Page<BPerTSJiaoZheng> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception;
}
