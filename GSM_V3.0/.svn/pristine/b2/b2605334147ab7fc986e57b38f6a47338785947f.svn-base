package com.dykj.GSM.mapper.partybuilding.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.partybuilding.mapperinterf.PartyOrganizationManagerMapper;
import com.dykj.GSM.model.charts.ChartsTemp;
import com.dykj.GSM.model.partybuilding.PartyMemberManager;
import com.dykj.GSM.model.partybuilding.PartyOrganizationManager;
import com.dykj.GSM.model.partybuilding.PartyOrganizationProfile;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-05-16 17:27:30
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class PartyOrganizationManagerMapperImpl extends BaseMapperImpl<PartyOrganizationManager,String> implements PartyOrganizationManagerMapper{

	@Override
	public Object queryPartyBuildingTree(String gridCode) {
		return this.getSqlSession().selectList(getSqlName("queryPartyBuildingTree"), gridCode);
	}
 
	@Override
	public PartyOrganizationProfile queryPartyOrganizationManagerByGridCode(PartyOrganizationManager param) {
		return this.getSqlSession().selectOne(getSqlName("queryPartyOrganizationManagerByGridCode"), param);
	}
	
	/**
	 * 通过gridCode查询党员男女分布比例
	 */
	@Override
	public List<ChartsTemp> chartsPartyMemberSexByGridCode(String gridCode) {
		return  this.getSqlSession().selectList(getSqlName("chartsPartyMemberSexByGridCode"), gridCode);
	}

	/**
	 * 通过gridCode查询党员类型分布比例
	 */
	@Override
	public List<ChartsTemp> chartsPartyMemberPartyTypeByGridCode(String gridCode) {
		return  this.getSqlSession().selectList(getSqlName("chartsPartyMemberPartyTypeByGridCode"), gridCode);
	}

	/**
	 * 通过gridCode查询党员年龄分布比例
	 */
	@Override
	public List<ChartsTemp> chartsPartyMemberAgeByGridCode(String gridCode) {
		return  this.getSqlSession().selectList(getSqlName("chartsPartyMemberAgeByGridCode"), gridCode);
	}

}