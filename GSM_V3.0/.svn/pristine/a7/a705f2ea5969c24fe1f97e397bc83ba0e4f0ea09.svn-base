package com.dykj.GSM.service.base;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerLiuDong;
import com.dykj.GSM.service.IBaseService;

public interface BPerLiuDongService extends IBaseService<BPerLiuDong, String> {
	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerLiuDong queryByPersonCode(String personCode)throws Exception;

	public Page<BPerLiuDong> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception;
}
