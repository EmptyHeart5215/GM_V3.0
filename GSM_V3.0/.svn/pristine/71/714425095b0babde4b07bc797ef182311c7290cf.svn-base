package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BJiGouMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BJiGouService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 11:12:53 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BJiGouServiceImpl implements BJiGouService {
	@Autowired
	private BJiGouMapperImpl bJiGouMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BJiGou entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bJiGouMapperImpl.insert(entity);
	}

	@Override
	public int update(BJiGou entity) {
		return bJiGouMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bJiGouMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BJiGou queryByKey(String primaryKey) throws Exception {
		BJiGou bJiGou = bJiGouMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bJiGou, BJiGou.class, "codeJigouFunction,codeJigouState");
		return bJiGou;
	}

	@Override
	public List<BJiGou> queryList() {
		return bJiGouMapperImpl.queryList();
	}

	@Override
	public List<BJiGou> queryListParam(Map param) {
		return bJiGouMapperImpl.queryListParam(param);
	}

	@Override
	public List<BJiGou> queryTListParam(BJiGou param) {
		return bJiGouMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BJiGou> queryByParamPage(int page, int size, String sidx, String sord, BJiGou param) throws Exception {
		Page<BJiGou> pages = bJiGouMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, BJiGou.class, "codeJigouFunction,codeJigouState");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bJiGouMapperImpl.deleteBatch(list);
	}

	/**
	 * 为用户选择角色而做的树
	 * 
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryAllRoleTreeForSelect() {
		List<Map<String, Object>> list = bJiGouMapperImpl.queryAllRoleTreeForSelect();
		return list;
	}

	@Override
	public List<Map<String, Object>> Charts(BJiGou args) {
		return bJiGouMapperImpl.Charts(args);
	}

	@Override
	public Page<BJiGou> queryParamPageSamll(String sidx, int size, int pageNum,
			String sord, BJiGou args) {
		return bJiGouMapperImpl.queryParamPageSamll(pageNum, size, sidx, sord, args);
	}



}