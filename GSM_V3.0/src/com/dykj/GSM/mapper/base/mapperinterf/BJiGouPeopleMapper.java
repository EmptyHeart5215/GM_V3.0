package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.base.BJiGouPeople;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016-08-05 09:34:47
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface BJiGouPeopleMapper extends IBaseMapper<BJiGouPeople, String>{
	public int updateBatch(String primaryKey);
	public List<BJiGouPeople> queryParamPageByCode(String args);

}