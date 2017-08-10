package com.dykj.GSM.mapper.emergencyscheduling.impl;

import java.util.Map;

import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.emergencyscheduling.mapperinterf.EmergencyTeamMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;
import com.dykj.GSM.model.emergencyscheduling.EmergencyTeam;

/**
 * @author 作者 :sunguoqiang
 * @version 创建时间：2016-07-18 15:08:41 修改人： 修改日期： 类说明:
 */
public class EmergencyTeamMapperImpl extends BaseMapperImpl<EmergencyTeam, String> implements EmergencyTeamMapper {
	@Override
	public Page<EmergencyTeam> queryByParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		String clazzName = getTClassName();
		sidx = clazzName + "." + sidx;
		PageHelper.startPage(pageNum, size, sidx + " " + sord);
		// 得到结果
		PageResult results = (PageResult) this.getSqlSession().selectList(getSqlName(SQLID_QUERY_PAGE_PARAM), param);
		return PageHelper.endPage(results);
	}
}