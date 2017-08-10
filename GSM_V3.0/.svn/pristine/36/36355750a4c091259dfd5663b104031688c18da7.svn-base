package com.dykj.GSM.service.eventfile.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.eventfile.impl.EventKeyPlaceMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eventfile.EventKeyPlace;
import com.dykj.GSM.service.eventfile.EventKeyPlaceService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 01:35:53 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EventKeyPlaceServiceImpl implements EventKeyPlaceService {
	@Autowired
	private EventKeyPlaceMapperImpl eventKeyPlaceMapperImpl;

	@Override
	public int insert(EventKeyPlace entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return eventKeyPlaceMapperImpl.insert(entity);
	}

	@Override
	public int update(EventKeyPlace entity) {
		return eventKeyPlaceMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return eventKeyPlaceMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EventKeyPlace queryByKey(String primaryKey) {
		return eventKeyPlaceMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<EventKeyPlace> queryList() {
		return eventKeyPlaceMapperImpl.queryList();
	}

	@Override
	public List<EventKeyPlace> queryListParam(Map param) {
		return eventKeyPlaceMapperImpl.queryListParam(param);
	}

	@Override
	public List<EventKeyPlace> queryTListParam(EventKeyPlace param) {
		return eventKeyPlaceMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EventKeyPlace> queryByParamPage(int page, int size, String sidx, String sord, EventKeyPlace param) {
		return eventKeyPlaceMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return eventKeyPlaceMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(EventKeyPlace args) {
		return eventKeyPlaceMapperImpl.Charts(args);
	}
}