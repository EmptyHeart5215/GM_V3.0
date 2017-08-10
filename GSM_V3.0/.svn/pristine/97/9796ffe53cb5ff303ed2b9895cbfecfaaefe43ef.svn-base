package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BFieldsMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.base.BFields;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-05-13 09:42:54
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class BFieldsMapperImpl extends BaseMapperImpl<BFields,String> implements BFieldsMapper{
	@Override
	public List<Map<String, Object>> Charts(BFields args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
	@Override
	public Page<BFields> queryZongHePage(int page, int size, String sidx,
			String sord, Map args) {
		PageHelper.startPage(page, size, "b_fields.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryZongHePage"), args);
		return PageHelper.endPage(results);
	}
}