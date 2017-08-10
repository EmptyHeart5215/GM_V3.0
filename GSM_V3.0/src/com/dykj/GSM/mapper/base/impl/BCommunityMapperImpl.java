package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BCommunityMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.eventfile.EventActivities;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月27日 上午9:06:46
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class BCommunityMapperImpl extends BaseMapperImpl<BCommunity, String> implements BCommunityMapper {
	@Override
	public List<Map<String, Object>> Charts(BCommunity args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}

	@Override
	public Page<BCommunity> queryZongHePage(int page, int size, String sidx,
			String sord, Map args) {
		PageHelper.startPage(page, size, "b_community.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryZongHePage"), args);
		return PageHelper.endPage(results);
	}
}
