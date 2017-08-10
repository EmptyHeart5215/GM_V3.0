package com.dykj.GSM.service.eventfile.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.eventfile.impl.EventActivitiesMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eventfile.EventActivities;
import com.dykj.GSM.service.eventfile.EventActivitiesService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EventActivitiesServiceImpl implements EventActivitiesService {

	@Autowired
	private EventActivitiesMapperImpl eventActivitiesMapperImpl;

	@Override
	public int insert(EventActivities entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return eventActivitiesMapperImpl.insert(entity);
	}

	@Override
	public int update(EventActivities entity) {
		return eventActivitiesMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return eventActivitiesMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EventActivities queryByKey(String primaryKey) {
		return eventActivitiesMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<EventActivities> queryList() {
		return eventActivitiesMapperImpl.queryList();
	}

	@Override
	public List<EventActivities> queryListParam(Map param) {
		return eventActivitiesMapperImpl.queryListParam(param);
	}

	@Override
	public List<EventActivities> queryTListParam(EventActivities param) {
		return eventActivitiesMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EventActivities> queryByParamPage(int page, int size, String sidx, String sord, EventActivities param) {
		return eventActivitiesMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return eventActivitiesMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(EventActivities args) {
		return eventActivitiesMapperImpl.Charts(args);
	}
}
