package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BJiGouServicePeopleMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.model.base.BJiGouServicePeople;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 12:59:19 修改人： 修改日期： 类说明:
 */
public class BJiGouServicePeopleMapperImpl extends BaseMapperImpl<BJiGouServicePeople, String> implements
		BJiGouServicePeopleMapper {
	@Override
	public Page<BJiGouServicePeople> queryByParamPage(int pageNum, int size, String sidx, String sord,
			BJiGouService param) {
		String clazzName = getTClassName();
		sidx = clazzName + "." + sidx;
		PageHelper.startPage(pageNum, size, sidx + " " + sord);
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName(SQLID_QUERY_PAGE_PARAM), param);
		return PageHelper.endPage(results);
	}

	@Override
	public List<BJiGouServicePeople> queryAllByServiceId(String code) {
		return this.getSqlSession().selectList(getSqlName("queryAllByServiceId"), code);
	}

	@Override
	public int insertBatch(Map<String, Object> map) {
		// 声明一个标记标量，当插入失败时为0，成功则非0
		int rows = this.getSqlSession().insert(getSqlName("insertBatch"), map);
		return rows;
	}

	@Override
	public int deleteByServiceId(String serviceId) {
		int rows = this.getSqlSession().delete(getSqlName("deleteByServiceId"), serviceId);
		return rows;
	}
}