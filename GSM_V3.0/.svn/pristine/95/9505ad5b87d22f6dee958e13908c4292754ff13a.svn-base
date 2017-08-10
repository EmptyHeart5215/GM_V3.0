package com.dykj.GSM.service.partybuilding.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.partybuilding.impl.PartyOrganizationManagerMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.charts.ChartsTemp;
import com.dykj.GSM.model.partybuilding.PartyOrganizationManager;
import com.dykj.GSM.model.partybuilding.PartyOrganizationProfile;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.partybuilding.PartyOrganizationManagerService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-05-17 08:13:37 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class PartyOrganizationManagerServiceImpl implements PartyOrganizationManagerService {
	@Autowired
	private PartyOrganizationManagerMapperImpl partyOrganizationManagerMapperImpl;

	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(PartyOrganizationManager entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return partyOrganizationManagerMapperImpl.insert(entity);
	}

	@Override
	public int update(PartyOrganizationManager entity) {
		return partyOrganizationManagerMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return partyOrganizationManagerMapperImpl.deletePk(primaryKey);
	}

	@Override
	public PartyOrganizationManager queryByKey(String primaryKey) throws Exception {
		PartyOrganizationManager partyOrganizationManager = partyOrganizationManagerMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(partyOrganizationManager, PartyOrganizationManager.class,
				"codePartyOrganizationType");
		return partyOrganizationManager;
	}

	@Override
	public List<PartyOrganizationManager> queryList() {
		return partyOrganizationManagerMapperImpl.queryList();
	}

	@Override
	public List<PartyOrganizationManager> queryListParam(Map param) {
		return partyOrganizationManagerMapperImpl.queryListParam(param);
	}

	@Override
	public List<PartyOrganizationManager> queryTListParam(PartyOrganizationManager param) {
		return partyOrganizationManagerMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<PartyOrganizationManager> queryByParamPage(int page, int size, String sidx, String sord,
			PartyOrganizationManager param) throws Exception {
		Page<PartyOrganizationManager> pages = partyOrganizationManagerMapperImpl.queryByParamPage(page, size, sidx,
				sord, param);
		dicValueInputService.inputDicValue(pages, PartyOrganizationManager.class, "codePartyOrganizationType");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return partyOrganizationManagerMapperImpl.deleteBatch(list);
	}

	@Override
	public Object queryPartyBuildingTree(String gridCode) {
		return partyOrganizationManagerMapperImpl.queryPartyBuildingTree(gridCode);
	}

	@Override
	public PartyOrganizationProfile queryPartyOrganizationManagerByGridCode(PartyOrganizationManager param)
			throws Exception {
		PartyOrganizationProfile partyOrganizationProfile = partyOrganizationManagerMapperImpl
				.queryPartyOrganizationManagerByGridCode(param);
		dicValueInputService.inputDicValueForOne(partyOrganizationProfile, PartyOrganizationProfile.class,
				"codePartyOrganizationType");
		return partyOrganizationProfile;
	}

	@Override
	public List<ChartsTemp> chartsPartyMemberSexByGridCode(String gridCode) throws Exception {
		return partyOrganizationManagerMapperImpl.chartsPartyMemberSexByGridCode(gridCode);
	}

	@Override
	public List<ChartsTemp> chartsPartyMemberPartyTypeByGridCode(String gridCode) throws Exception {
		return partyOrganizationManagerMapperImpl.chartsPartyMemberPartyTypeByGridCode(gridCode);
	}

	@Override
	public List<ChartsTemp> chartsPartyMemberAgeByGridCode(String gridCode) throws Exception {
		return partyOrganizationManagerMapperImpl.chartsPartyMemberAgeByGridCode(gridCode);
	}
}