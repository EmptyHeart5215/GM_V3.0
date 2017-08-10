package com.dykj.GSM.service.eva.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.eva.impl.AppraiseCommunityMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseCommunity;
import com.dykj.GSM.service.eva.AppraiseCommunityService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class AppraiseCommnunityServiceImpl implements AppraiseCommunityService {
	@Autowired
	private AppraiseCommunityMapperImpl appraiseCommunityMapperImpl;

	@Override
	public int insertBySelect(String userCode, Integer year, Integer month, String gridCode) throws Exception {
		String createDate = DateFormatUtil.getStringDate();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("year", year);
		map2.put("month", month);
		map2.put("gridCode", gridCode);
		// 先将之前考核的全部删除
		appraiseCommunityMapperImpl.deleteByYearAndMonth(map2);
		map2.put("createDate", createDate);
		map2.put("createBy", userCode);
		return appraiseCommunityMapperImpl.insertBySelect(map2);
	}

	@Override
	public Page<AppraiseCommunity> queryByMapPage(String sidx, int rows, int page, String sord, Integer year,
			Integer month, String gridCode) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("month", month);
		map.put("gridCode", gridCode);
		return appraiseCommunityMapperImpl.queryByMapPage(page, rows, sidx, sord, map);
	}

	/**
	 * 统计
	 * 
	 * @param sidx
	 * @param rows
	 * @param page
	 * @param sord
	 * @param year
	 * @param month
	 * @param gridCode
	 * @return
	 * @throws Exception
	 */
	@Override
	public Page<AppraiseCommunity> queryStatisticsPage(String sidx, int rows, int page, String sord, Integer year,
			Integer month, String gridCode, String type, Integer jiDu) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("year", year);
		map.put("month", month);
		map.put("gridCode", gridCode);
		map.put("type", type);
		map.put("jiDu", jiDu);
		return appraiseCommunityMapperImpl.queryStatisticsPage(page, rows, sidx, sord, map);
	}

	@Override
	public int insert(AppraiseCommunity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(AppraiseCommunity entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AppraiseCommunity queryByKey(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseCommunity> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseCommunity> queryListParam(Map param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppraiseCommunity> queryTListParam(AppraiseCommunity param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<AppraiseCommunity> queryByParamPage(int page, int size, String sidx, String sord,
			AppraiseCommunity param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
