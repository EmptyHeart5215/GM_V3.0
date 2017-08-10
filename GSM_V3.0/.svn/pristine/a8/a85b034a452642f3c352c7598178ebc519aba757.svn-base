package com.dykj.GSM.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BCommunityMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BCommunityService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月27日 上午9:01:19 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BCommunityServiceImpl implements BCommunityService {
	@Autowired
	private BCommunityMapperImpl bCommunityMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BCommunity entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bCommunityMapperImpl.insert(entity);
	}

	@Override
	public int update(BCommunity entity) {

		return bCommunityMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {

		return bCommunityMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BCommunity queryByKey(String primaryKey) throws Exception {
		BCommunity bCommunity = bCommunityMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bCommunity, BCommunity.class, "codeHouseSource");
		return bCommunity;
	}

	@Override
	public List<BCommunity> queryList() {

		return bCommunityMapperImpl.queryList();
	}

	@Override
	public List<BCommunity> queryListParam(Map param) {

		return bCommunityMapperImpl.queryListParam(param);
	}

	@Override
	public List<BCommunity> queryTListParam(BCommunity param) {

		return bCommunityMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BCommunity> queryByParamPage(int page, int size, String sidx, String sord, BCommunity param)
			throws Exception {
		Page<BCommunity> pages = bCommunityMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, BCommunity.class, "codeHouseSource");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {

		return bCommunityMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BCommunity args) {
		return bCommunityMapperImpl.Charts(args);
	}

	@Override
	public Page<BCommunity> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		Map<Integer, String> allStep = new HashMap<Integer, String>();
		Page<BCommunity> page = this.bCommunityMapperImpl.queryZongHePage(pageNum, size, sidx, sord, args);
		dicValueInputService.inputDicValue(page, BCommunity.class, "codeHouseSource");
		return page;
	}
}
