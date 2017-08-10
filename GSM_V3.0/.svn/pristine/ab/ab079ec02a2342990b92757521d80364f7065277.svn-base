package com.dykj.GSM.mapper.base.impl;


import java.util.List;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BJiGouPeopleMapper;
import com.dykj.GSM.model.base.BJiGouPeople;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016-08-05 09:34:47
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class BJiGouPeopleMapperImpl extends BaseMapperImpl<BJiGouPeople,String> implements BJiGouPeopleMapper{


	public int updateBatch(String primaryKey) {
		int rows = this.getSqlSession().update(getSqlName("updateBatch"), primaryKey);
		return rows;
	}

	@Override
	public List<BJiGouPeople> queryParamPageByCode(String args) {
		return this.getSqlSession().selectList(getSqlName("queryParamPageByCode"),  args);
	}

}