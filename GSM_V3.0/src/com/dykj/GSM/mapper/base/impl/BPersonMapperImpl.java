package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BPersonMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BPerson;

public class BPersonMapperImpl extends BaseMapperImpl<BPerson, String> implements BPersonMapper {
	@Override
	public Page<List> queryParamPageMap(int pageNum, int size, String sidx, String sord, BPerson param) {
		try {
			PageHelper.startPage(pageNum, size, sidx, sord);
			// 得到结果
			PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryParamPageMap"), param);
			return PageHelper.endPage(results);
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
			return null;
		}
	}

	@Override
	public List<Map<String, Object>> Charts(BPerson args) {
		return this.getSqlSession().selectList(getSqlName("Charts"), args);
	}

	@Override
	public List<Map<String, Object>> mapqueryByParamPage(BPerson args) {
		return this.getSqlSession().selectList(getSqlName("mapqueryByParamPage"), args);
	}

	@Override
	public Page<BPerson> queryMapParamPage(int pageNum, int size, String sidx, String sord, Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerson> queryZongHePage(int page, int size, String sidx, String sord, Map args) {
		PageHelper.startPage(page, size, "b_person.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryZongHePage"), args);
		return PageHelper.endPage(results);
	}

	/**
	 * 首页网格信息统计
	 * 
	 * @param args
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryPersonTypeStatistics(Map<String, Object> args) {
		return this.getSqlSession().selectList(getSqlName("queryPersonTypeStatistics"), args);
	}

}