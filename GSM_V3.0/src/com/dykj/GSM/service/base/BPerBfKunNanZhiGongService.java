package com.dykj.GSM.service.base;

import com.dykj.GSM.model.base.BPerBfKunNanZhiGong;
import com.dykj.GSM.service.IBaseService;

public interface BPerBfKunNanZhiGongService extends IBaseService<BPerBfKunNanZhiGong, String> {
	/**
	 * 根据基本信息code查询矫正人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerBfKunNanZhiGong queryByPersonCode(String personCode);
}
