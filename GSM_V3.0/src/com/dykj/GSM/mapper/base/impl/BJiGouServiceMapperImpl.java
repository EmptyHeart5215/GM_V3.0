package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BJiGouServiceMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BJiGouService;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 12:59:19 修改人： 修改日期： 类说明:
 */
public class BJiGouServiceMapperImpl extends BaseMapperImpl<BJiGouService, String> implements BJiGouServiceMapper {
	@Override
	public List<Map<String, Object>> Charts(BJiGouService args) {
		return this.getSqlSession().selectList(getSqlName("Charts"), args);
	}

	@Override
	public List<BJiGouService> queryParamPageByName(String args) {
		return this.getSqlSession().selectList(getSqlName("queryParamPageByName"), args);
	}

	/**
	 * 带参数的，查询分页
	 */
	@Override
	public Page<BJiGouService> queryByParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> map) {
		String clazzName = getTClassName();
		sidx = clazzName + "." + sidx;
		PageHelper.startPage(pageNum, size, sidx + " " + sord);
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName(SQLID_QUERY_PAGE_PARAM), map);
		return PageHelper.endPage(results);
	}
}