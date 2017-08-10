package com.dykj.GSM.mapper.sys.impl;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysSeatGridMapper;
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysTempGrid;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月20日 下午3:18:02 修改人： 修改日期： 类说明:
 */
public class SysSeatGridMapperImpl extends BaseMapperImpl<SysSeatGrid, String> implements SysSeatGridMapper {
	@Override
	public List<SysTempGrid> queryGridTreeByUserGridCode(Map map) {
		List<SysTempGrid> list = this.getSqlSession().selectList(getSqlName("queryGridTreeByUserGridCode"), map);
		return list;
	}

	/**
	 * 得到部门树状结构
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public List<SysTempGrid> queryDepartmentTreeByUserGridCode(Map map) {
		List<SysTempGrid> list = this.getSqlSession().selectList(getSqlName("queryDepartmentTreeByUserGridCode"), map);
		return list;
	}

	/**
	 * 得到部门和街道的树状结构，主要是为了事件部门派遣时使用
	 * 
	 * @param map
	 * @return
	 */
	@Override
	public List<SysTempGrid> queryDepartmentAndStreetTreeByUserGridCode(Map map) {
		List<SysTempGrid> list = this.getSqlSession().selectList(
				getSqlName("queryDepartmentAndStreetTreeByUserGridCode"), map);
		return list;
	}

	@Override
	public SysSeatFour queryByparentCode(String parentCode) {
		return this.getSqlSession().selectOne(getSqlName("queryByparentCode"), parentCode);
	}

	/*
	 * 批量更新，用于删除
	 */
	@Override
	public int updateBatch(Map<String, Object> map) {
		return this.getSqlSession().update(getSqlName("updateBatch"), map);
	}

	/**
	 * 在更新二级辖区、三级辖区、四级辖区的时候去更新下属子孙辖区的gridtotalname
	 * 
	 * @param list
	 * @return
	 */
	@Override
	public int updateTotalGridName(Map<String, Object> map) {
		return this.getSqlSession().update(getSqlName("updateTotalGridName"), map);
	}

	/**
	 * 通过gridcode查询通讯相关人员
	 */
	@Override
	public List<SysTempGrid> queryImUserByGridCode() {
		List<SysTempGrid> list = this.getSqlSession().selectList(getSqlName("queryImUserByGridCode"));
		return list;
	}

	@Override
	public List<SysTempGrid> queryImTechnicalSupport() {
		List<SysTempGrid> list = this.getSqlSession().selectList(getSqlName("queryImTechnicalSupport"));
		return list;
	}

}
