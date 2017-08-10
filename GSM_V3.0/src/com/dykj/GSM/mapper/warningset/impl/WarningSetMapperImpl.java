package com.dykj.GSM.mapper.warningset.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.warningset.mapperinterf.WarningSetMapper;
import com.dykj.GSM.model.warningset.WarningSet;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-06-03 12:36:42 修改人： 修改日期： 类说明:
 */
public class WarningSetMapperImpl extends BaseMapperImpl<WarningSet, String> implements WarningSetMapper {
	@Override
	public int deleteAll() {
		int rows = this.getSqlSession().update(getSqlName("deleteAll"));
		return rows;
	}

	@Override
	public WarningSet queryOne() {
		return this.getSqlSession().selectOne(getSqlName("queryOne"));
	}
}