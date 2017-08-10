package com.dykj.GSM.mapper.partybuilding.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
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
public interface PartyOrganizationManagerMapper extends IBaseMapper<PartyOrganizationManager, String>{
	
	/**
	 * 通过自身辖区权限，筛选党建树形菜单
	 * @param gridCode
	 * @return
	 */
	public Object queryPartyBuildingTree(String gridCode);
	
	/**
	 * 通过辖区code查询党组织概况
	 * @param gridCode
	 * @return
	 */
	public PartyOrganizationProfile queryPartyOrganizationManagerByGridCode(PartyOrganizationManager param);
	
	/**
	 * 通过gridCode查询党员男女分布比例
	 * @param partyMemberManager
	 * @return
	 */
	public List<ChartsTemp> chartsPartyMemberSexByGridCode(String gridCode);
	
	/**
	 * 通过gridCode查询党员类型分布比例
	 * @param partyMemberManager
	 * @return
	 */
	public List<ChartsTemp> chartsPartyMemberPartyTypeByGridCode(String gridCode);
	
	/**
	 * 通过gridCode查询党员年龄分布比例
	 * @param partyMemberManager
	 * @return
	 */
	public List<ChartsTemp> chartsPartyMemberAgeByGridCode(String gridCode);

}