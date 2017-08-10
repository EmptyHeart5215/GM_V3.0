package com.dykj.GSM.service.base;

import java.util.List;

import com.dykj.GSM.service.IBaseService;
import com.dykj.GSM.model.base.BJiGouPeople;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016-08-05 09:34:47
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface BJiGouPeopleService extends IBaseService<BJiGouPeople, String>{
	public int updateBatch(String primaryKey);
	public List<BJiGouPeople> queryParamPageByCode(String code);
}