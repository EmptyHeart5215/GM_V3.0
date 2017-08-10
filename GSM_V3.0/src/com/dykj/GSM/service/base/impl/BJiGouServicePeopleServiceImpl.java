package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BJiGouServicePeopleMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.model.base.BJiGouServicePeople;
import com.dykj.GSM.service.base.BJiGouServicePeopleService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 12:59:19 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BJiGouServicePeopleServiceImpl implements BJiGouServicePeopleService {
	@Autowired
	private BJiGouServicePeopleMapperImpl bJiGouServicePeopleMapperImpl;

	@Override
	public int insert(BJiGouServicePeople entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bJiGouServicePeopleMapperImpl.insert(entity);
	}

	@Override
	public int update(BJiGouServicePeople entity) {
		return bJiGouServicePeopleMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bJiGouServicePeopleMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BJiGouServicePeople queryByKey(String primaryKey) throws Exception {
		BJiGouServicePeople bJiGouService = bJiGouServicePeopleMapperImpl.queryByKey(primaryKey);
		return bJiGouService;
	}

	@Override
	public List<BJiGouServicePeople> queryList() {
		return bJiGouServicePeopleMapperImpl.queryList();
	}

	@Override
	public List<BJiGouServicePeople> queryListParam(Map param) {
		return bJiGouServicePeopleMapperImpl.queryListParam(param);
	}

	@Override
	public List<BJiGouServicePeople> queryTListParam(BJiGouServicePeople param) {
		return bJiGouServicePeopleMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BJiGouServicePeople> queryByParamPage(int page, int size, String sidx, String sord, BJiGouService param)
			throws Exception {
		Page<BJiGouServicePeople> pages = bJiGouServicePeopleMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		return pages;
	}

	@Override
	public List<BJiGouServicePeople> queryAllByServiceId(String code) throws Exception {
		List<BJiGouServicePeople> pages = bJiGouServicePeopleMapperImpl.queryAllByServiceId(code);
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bJiGouServicePeopleMapperImpl.deleteBatch(list);
	}

	@Override
	public Page<BJiGouServicePeople> queryByParamPage(int page, int size, String sidx, String sord,
			BJiGouServicePeople param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}