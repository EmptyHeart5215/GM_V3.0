package com.dykj.GSM.mapper.event.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.event.mapperinterf.EOpinionMapper;
import com.dykj.GSM.model.event.EOpinion;

public class EOpinionMapperImpl extends BaseMapperImpl<EOpinion, String> implements EOpinionMapper {
	/**
	 * 根据entryId得到所有的建议
	 */
	@Override
	public List<EOpinion> queryOpinionsByWfEntry(Long entryId) {
		// 得到结果
		List results = this.getSqlSession().selectList(getSqlName("queryOpinionsByWfEntry"), entryId);
		return results;
	}

	/**
	 * 得到上一条意见
	 * 
	 * @param entryId
	 * @return
	 */
	@Override
	public EOpinion queryPreOpinion(Long entryId) {
		return this.getSqlSession().selectOne(getSqlName("queryPreOpinion"), entryId);
	}

	/**
	 * 更新某条意见的去向
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public int updateToPersonCode(Map map) {
		return this.getSqlSession().update(getSqlName("updateToPersonCode"), map);
	}

}