package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BFeiGongJingJiMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BFeiGongJingJi;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月26日 上午9:34:40
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class BFeiGongJingJiMapperImpl extends BaseMapperImpl<BFeiGongJingJi, String> implements BFeiGongJingJiMapper {
	@Override
	public List<Map<String, Object>> Charts(BFeiGongJingJi args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}

	@Override
	public Page<BFeiGongJingJi> queryZongHePage(int page, int size,
			String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "b_fei_gong_jing_ji.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryZongHePage"), args);
		return PageHelper.endPage(results);
	}
}
