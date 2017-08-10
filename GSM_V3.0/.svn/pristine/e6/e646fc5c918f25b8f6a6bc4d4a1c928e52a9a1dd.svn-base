package com.dykj.GSM.mapper.partybuilding.impl;

import java.util.List;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.partybuilding.mapperinterf.PartyMemberManagerMapper;
import com.dykj.GSM.model.partybuilding.PartyMemberManager;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年5月3日 下午4:32:09
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class PartyMemberManagerMapperImpl extends BaseMapperImpl<PartyMemberManager, String> implements PartyMemberManagerMapper {

	/* (non-Javadoc)
	 * @see com.dykj.GSM.mapper.partybuilding.mapperinterf.PartyMemberManagerMapper#compareSameUser(java.lang.String)
	 */
	@Override
	public List<PartyMemberManager> compareSameUser(String personCode) {
		return this.getSqlSession().selectList(getSqlName("compareSameUser"), personCode);
	}

}
