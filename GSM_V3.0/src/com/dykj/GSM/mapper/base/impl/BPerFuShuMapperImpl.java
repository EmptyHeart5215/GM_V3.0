package com.dykj.GSM.mapper.base.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BPerFuShuMapper;
import com.dykj.GSM.model.base.BPerFuShu;

public class BPerFuShuMapperImpl extends BaseMapperImpl<BPerFuShu, String> implements BPerFuShuMapper {
	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BPerFuShu queryByPersonCode(String personCode) {
		try {
			return this.getSqlSession().selectOne(getSqlName("queryByPersonCode"), personCode);
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
			return null;
		}
	}

	/*
	 * 根据personCode删除
	 */
	@Override
	public int deleteByPersonCode(String personCode) {
		int rows = 0;
		try {
			rows = this.getSqlSession().delete(getSqlName("deleteByPersonCode"), personCode);
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
		}
		return rows;
	}
}