package com.dykj.GSM.service.eventfile.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.eventfile.impl.EventSignificantVisitsMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eventfile.EventSignificantVisits;
import com.dykj.GSM.service.eventfile.EventSignificantVisitsService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-27 16:05:38 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EventSignificantVisitsServiceImpl implements EventSignificantVisitsService {
	@Autowired
	private EventSignificantVisitsMapperImpl eventSignificantVisitsMapperImpl;

	@Override
	public int insert(EventSignificantVisits entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return eventSignificantVisitsMapperImpl.insert(entity);
	}

	@Override
	public int update(EventSignificantVisits entity) {
		return eventSignificantVisitsMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return eventSignificantVisitsMapperImpl.deletePk(primaryKey);
	}

	@Override
	public EventSignificantVisits queryByKey(String primaryKey) {
		return eventSignificantVisitsMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<EventSignificantVisits> queryList() {
		return eventSignificantVisitsMapperImpl.queryList();
	}

	@Override
	public List<EventSignificantVisits> queryListParam(Map param) {
		return eventSignificantVisitsMapperImpl.queryListParam(param);
	}

	@Override
	public List<EventSignificantVisits> queryTListParam(EventSignificantVisits param) {
		return eventSignificantVisitsMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<EventSignificantVisits> queryByParamPage(int page, int size, String sidx, String sord,
			EventSignificantVisits param) {
		return eventSignificantVisitsMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return eventSignificantVisitsMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(EventSignificantVisits args) {
		return eventSignificantVisitsMapperImpl.Charts(args);
	}
}