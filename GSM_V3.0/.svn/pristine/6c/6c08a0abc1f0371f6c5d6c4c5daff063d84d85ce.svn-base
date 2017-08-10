package com.dykj.GSM.service.eventfile.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.eventfile.impl.EventInformationMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eventfile.EventInformation;
import com.dykj.GSM.service.eventfile.EventInformationService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-27 16:38:59 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EventInformationServiceImpl implements EventInformationService {
	@Autowired
	private EventInformationMapperImpl eventInformationMapperImpl;

	@Override
	public int insert(EventInformation entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return eventInformationMapperImpl.insert(entity);
	}

	@Override
	public int update(EventInformation entity) {
		return eventInformationMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return eventInformationMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EventInformation queryByKey(String primaryKey) {
		return eventInformationMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<EventInformation> queryList() {
		return eventInformationMapperImpl.queryList();
	}

	@Override
	public List<EventInformation> queryListParam(Map param) {
		return eventInformationMapperImpl.queryListParam(param);
	}

	@Override
	public List<EventInformation> queryTListParam(EventInformation param) {
		return eventInformationMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EventInformation> queryByParamPage(int page, int size, String sidx, String sord, EventInformation param) {
		return eventInformationMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return eventInformationMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(EventInformation args) {
		return eventInformationMapperImpl.Charts(args);
	}
}