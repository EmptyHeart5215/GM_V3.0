package com.dykj.GSM.service.base;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerLiuShou;
import com.dykj.GSM.service.IBaseService;

public interface BPerLiuShouService extends IBaseService<BPerLiuShou, String> {
	/**
	 * 根据基本信息code查询留守人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerLiuShou queryByPersonCode(String personCode) throws Exception;

	public Page<BPerLiuShou> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception;
}
