package com.dykj.GSM.service.partybuilding.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.partybuilding.impl.PartyOrganizationalifeMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.partybuilding.PartyOrganizationalife;
import com.dykj.GSM.service.partybuilding.PartyOrganizationalifeService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-05-06 11:03:50 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class PartyOrganizationalifeServiceImpl implements PartyOrganizationalifeService {
	@Autowired
	private PartyOrganizationalifeMapperImpl partyOrganizationalifeMapperImpl;

	@Override
	public int insert(PartyOrganizationalife entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return partyOrganizationalifeMapperImpl.insert(entity);
	}

	@Override
	public int update(PartyOrganizationalife entity) {
		return partyOrganizationalifeMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return partyOrganizationalifeMapperImpl.deletePk(primaryKey);
	}

	@Override
	public PartyOrganizationalife queryByKey(String primaryKey) {
		return partyOrganizationalifeMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<PartyOrganizationalife> queryList() {
		return partyOrganizationalifeMapperImpl.queryList();
	}

	@Override
	public List<PartyOrganizationalife> queryListParam(Map param) {
		return partyOrganizationalifeMapperImpl.queryListParam(param);
	}

	@Override
	public List<PartyOrganizationalife> queryTListParam(PartyOrganizationalife param) {
		return partyOrganizationalifeMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<PartyOrganizationalife> queryByParamPage(int page, int size, String sidx, String sord,
			PartyOrganizationalife param) {
		return partyOrganizationalifeMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return partyOrganizationalifeMapperImpl.deleteBatch(list);
	}
}