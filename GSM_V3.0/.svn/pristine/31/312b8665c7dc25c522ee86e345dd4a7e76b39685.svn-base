package com.dykj.GSM.service.partybuilding.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.partybuilding.impl.PartyMemberManagerMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.partybuilding.PartyMemberManager;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.partybuilding.PartyVolunteersService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年5月4日 下午3:34:44 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class PartyVolunteersServiceImpl implements PartyVolunteersService {

	@Autowired
	private PartyMemberManagerMapperImpl partyAllMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(PartyMemberManager entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return partyAllMapperImpl.insert(entity);
	}

	@Override
	public int update(PartyMemberManager entity) {
		return partyAllMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return partyAllMapperImpl.deletePk(primaryKey);
	}

	@Override
	public PartyMemberManager queryByKey(String primaryKey) throws Exception {
		PartyMemberManager partyMemberManager = partyAllMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(partyMemberManager, PartyMemberManager.class,
				"codeEducation,codeNation,codePolitical");
		return partyMemberManager;
	}

	@Override
	public List<PartyMemberManager> queryList() {
		return partyAllMapperImpl.queryList();
	}

	@Override
	public List<PartyMemberManager> queryListParam(Map param) {
		return partyAllMapperImpl.queryListParam(param);
	}

	@Override
	public List<PartyMemberManager> queryTListParam(PartyMemberManager param) {
		return partyAllMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<PartyMemberManager> queryByParamPage(int page, int size, String sidx, String sord,
			PartyMemberManager param) throws Exception {
		Page<PartyMemberManager> pages = partyAllMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, PartyMemberManager.class, "codeEducation,codeNation,codePolitical");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return partyAllMapperImpl.deleteBatch(list);
	}

	/* (non-Javadoc)
	 * @see com.dykj.GSM.service.partybuilding.PartyVolunteersService#compareSameUser(java.lang.String)
	 */
	@Override
	public List<PartyMemberManager> compareSameUser(String personCode) {
		return partyAllMapperImpl.compareSameUser(personCode);
	}

}
