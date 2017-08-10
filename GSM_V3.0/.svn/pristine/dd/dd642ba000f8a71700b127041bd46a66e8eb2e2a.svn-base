package com.dykj.GSM.mapper.base.impl;

import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月18日 下午4:55:42
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:
 */
public class BasePersonMapperImpl<BaseModel> extends BaseMapperImpl<BaseModel, String> {
	/**
	 * 根据基本信息code查询留守人员的信息
	 * 
	 * @param personCode
	 * @return
	 */
	public BaseModel queryByPersonCode(String personCode) {
		return this.getSqlSession().selectOne(getSqlName("queryByPersonCode"), personCode);
	}

	/*
	 * 根据personCode删除
	 */
	public int deleteByPersonCode(String personCode) {
		int rows = this.getSqlSession().delete(getSqlName("deleteByPersonCode"), personCode);
		return rows;
	}

	/**
	 * 带参数的，查询分页
	 */
	public Page<BaseModel> queryMapParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> param) {
		PageHelper.startPage(pageNum, size, sidx, sord);
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryMapParamPage"), param);
		return PageHelper.endPage(results);
	}
}
