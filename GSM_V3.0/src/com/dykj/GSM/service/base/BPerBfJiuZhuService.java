package com.dykj.GSM.service.base;

import com.dykj.GSM.model.base.BPerBfJiuZhu;
import com.dykj.GSM.service.IBaseService;

public interface BPerBfJiuZhuService extends IBaseService<BPerBfJiuZhu, String> {
	/**
	 * 根据基本信息code查询矫正人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerBfJiuZhu queryByPersonCode(String personCode);
}
