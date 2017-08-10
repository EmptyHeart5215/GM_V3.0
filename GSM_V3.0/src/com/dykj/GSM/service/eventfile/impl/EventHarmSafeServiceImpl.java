package com.dykj.GSM.service.eventfile.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.eventfile.impl.EventHarmSafeMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eventfile.EventHarmSafe;
import com.dykj.GSM.service.eventfile.EventHarmSafeService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 02:08:09 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EventHarmSafeServiceImpl implements EventHarmSafeService {
	@Autowired
	private EventHarmSafeMapperImpl eventHarmSafeMapperImpl;

	@Override
	public int insert(EventHarmSafe entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return eventHarmSafeMapperImpl.insert(entity);
	}

	@Override
	public int update(EventHarmSafe entity) {
		return eventHarmSafeMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return eventHarmSafeMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EventHarmSafe queryByKey(String primaryKey) {
		return eventHarmSafeMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<EventHarmSafe> queryList() {
		return eventHarmSafeMapperImpl.queryList();
	}

	@Override
	public List<EventHarmSafe> queryListParam(Map param) {
		return eventHarmSafeMapperImpl.queryListParam(param);
	}

	@Override
	public List<EventHarmSafe> queryTListParam(EventHarmSafe param) {
		return eventHarmSafeMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EventHarmSafe> queryByParamPage(int page, int size, String sidx, String sord, EventHarmSafe param) {
		return eventHarmSafeMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return eventHarmSafeMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(EventHarmSafe args) {
		return eventHarmSafeMapperImpl.Charts(args);
	}
}