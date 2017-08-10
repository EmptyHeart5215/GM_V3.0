package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BRouteEventsMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BRouteEvents;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BRouteEventsService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016-07-19 09:50:12 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BRouteEventsServiceImpl implements BRouteEventsService {
	@Autowired
	private BRouteEventsMapperImpl bRouteEventsMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BRouteEvents entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bRouteEventsMapperImpl.insert(entity);
	}

	@Override
	public int update(BRouteEvents entity) {
		return bRouteEventsMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bRouteEventsMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BRouteEvents queryByKey(String primaryKey) throws Exception {
		BRouteEvents bRouteEvents = bRouteEventsMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bRouteEvents, BRouteEvents.class, "codeEventNature");
		return bRouteEvents;
	}

	@Override
	public List<BRouteEvents> queryList() {
		return bRouteEventsMapperImpl.queryList();
	}

	@Override
	public List<BRouteEvents> queryListParam(Map param) {
		return bRouteEventsMapperImpl.queryListParam(param);
	}

	@Override
	public List<BRouteEvents> queryTListParam(BRouteEvents param) {
		return bRouteEventsMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BRouteEvents> queryByParamPage(int page, int size, String sidx, String sord, BRouteEvents param)
			throws Exception {
		Page<BRouteEvents> pages = bRouteEventsMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, BRouteEvents.class, "codeEventNature");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bRouteEventsMapperImpl.deleteBatch(list);
	}
}