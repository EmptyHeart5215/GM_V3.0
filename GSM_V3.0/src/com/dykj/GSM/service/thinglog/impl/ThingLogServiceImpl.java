package com.dykj.GSM.service.thinglog.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.thinglog.impl.ThingLogMapperImpl;
import com.dykj.GSM.model.thinglog.ThingLog;
import com.dykj.GSM.service.thinglog.ThingLogService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月25日 上午8:30:41 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class ThingLogServiceImpl implements ThingLogService {
	@Autowired
	private ThingLogMapperImpl thingLogMapperImpl;

	@Override
	public int insert(ThingLog entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return thingLogMapperImpl.insert(entity);
	}

	@Override
	public int update(ThingLog entity) {
		return thingLogMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return thingLogMapperImpl.deletePk(primaryKey);
	}

	@Override
	public ThingLog queryByKey(String primaryKey) {
		return thingLogMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<ThingLog> queryList() {
		return thingLogMapperImpl.queryList();
	}

	@Override
	public List<ThingLog> queryListParam(Map param) {
		return thingLogMapperImpl.queryListParam(param);
	}

	@Override
	public List<ThingLog> queryTListParam(ThingLog param) {
		return thingLogMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<ThingLog> queryByParamPage(int page, int size, String sidx, String sord, ThingLog param) {
		return thingLogMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return thingLogMapperImpl.deleteBatch(list);
	}

	@Override
	public ThingLog statisticLogQuestion(ThingLog thingLog) {
		return thingLogMapperImpl.statisticLogQuestion(thingLog);
	}

	/* (non-Javadoc)
	 * @see com.dykj.GSM.service.thinglog.ThingLogService#queryAutoGirgInfo(com.dykj.GSM.model.thinglog.ThingLog)
	 */
	@Override
	public ThingLog queryAutoGirgInfo(ThingLog thingLog) {
		return thingLogMapperImpl.queryAutoGirgInfo(thingLog);
	}

}
