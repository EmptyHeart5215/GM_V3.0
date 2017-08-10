package com.dykj.GSM.mapper.base.impl;

import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BPerJingWaiMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BPerJingWai;

public class BPerJingWaiMapperImpl extends BaseMapperImpl<BPerJingWai, String> implements BPerJingWaiMapper {
	/**
	 * 带参数的，查询分页
	 */
	@Override
	public Page<BPerJingWai> queryMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		try {
			PageHelper.startPage(pageNum, size, sidx, sord);
			// 得到结果
			PageResult<BPerJingWai> results = (PageResult) this.getSqlSession().selectList(
					getSqlName("queryMapParamPage"), param);
			return PageHelper.endPage(results);
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
			return null;
		}
	}
}