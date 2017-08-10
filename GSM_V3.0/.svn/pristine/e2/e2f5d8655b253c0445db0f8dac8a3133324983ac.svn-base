package com.dykj.GSM.mapper.base.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.base.mapperinterf.BJiGouMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.model.base.BParts;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 11:12:53
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class BJiGouMapperImpl extends BaseMapperImpl<BJiGou,String> implements BJiGouMapper{
	@Override
	public List<Map<String, Object>> Charts(BJiGou args) {
		return this.getSqlSession().selectList(getSqlName("Charts"),  args);
	}
	/**
	 * 为用户选择角色而做的树
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryAllRoleTreeForSelect() {
		try {
			return this.getSqlSession().selectList(getSqlName("queryAllRoleTreeForSelect"));
		} catch (Exception e) {
			e.printStackTrace();// 打印输入异常信息
			return null;
		}
	}
	@Override
	public Page<BJiGou> queryParamPageSamll(int page, int size, String sidx,
			String sord, BJiGou args) {		
		PageHelper.startPage(page, size, "b_ji_gou.create_date desc");
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName("queryParamPageSamll"), args);
		return PageHelper.endPage(results);
	}

}