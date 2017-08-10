package com.dykj.GSM.service.eventfile.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.eventfile.impl.EventContradictMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eventfile.EventContradict;
import com.dykj.GSM.service.eventfile.EventContradictService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EventContradictServiceImpl implements EventContradictService {
	@Autowired
	private EventContradictMapperImpl eventContradictMapperImpl;

	@Override
	public int insert(EventContradict entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return eventContradictMapperImpl.insert(entity);
	}

	@Override
	public int update(EventContradict entity) {
		return eventContradictMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return eventContradictMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EventContradict queryByKey(String primaryKey) {
		return eventContradictMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<EventContradict> queryList() {
		return eventContradictMapperImpl.queryList();
	}

	@Override
	public List<EventContradict> queryListParam(Map param) {
		return eventContradictMapperImpl.queryListParam(param);
	}

	@Override
	public List<EventContradict> queryTListParam(EventContradict param) {
		return eventContradictMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EventContradict> queryByParamPage(int page, int size, String sidx, String sord, EventContradict param) {
		return eventContradictMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return eventContradictMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(EventContradict args) {
		return eventContradictMapperImpl.Charts(args);
	}
}
