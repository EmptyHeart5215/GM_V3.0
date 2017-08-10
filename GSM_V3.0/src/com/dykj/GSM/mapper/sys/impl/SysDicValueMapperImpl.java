package com.dykj.GSM.mapper.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysDicValueMapper;
import com.dykj.GSM.model.sys.SysDicValue;

public class SysDicValueMapperImpl extends BaseMapperImpl<SysDicValue, String> implements SysDicValueMapper {
	@Override
	public List<SysDicValue> queryListParams(String sysDicCode) {
		return this.getSqlSession().selectList(getSqlName("queryListParams"), sysDicCode);
	}

	@Override
	public List<Map<String, Object>> queryManageTree(String code) {
		return this.getSqlSession().selectList(getSqlName("queryManageTree"), code);
	}

	/**
	 * 查找同一字典中的同名字典值条数
	 * 
	 * @param param
	 * @return
	 */
	public int querySameNameCount(Map param) {
		int result = 1;
		result = this.getSqlSession().selectOne(getSqlName("querySameNameCount"), param);
		return result;
	}

	/**
	 * 修改下级字典值的所有totalName
	 * 
	 * @param code
	 * @param beforeName
	 * @param nowName
	 * @return
	 */
	public int updateAllChildrenTotalName(String code, String beforeName, String nowName) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("beforeName", beforeName);
		map.put("nowName", nowName);
		map.put("code", code);
		int result = 1;
		result = this.getSqlSession().update(getSqlName("updateAllChildrenTotalName"), map);
		return result;
	}

	/**
	 * 根据字典code查询字典值
	 * 
	 * @param codes
	 * @return
	 */
	public List<Map<String, Object>> queryListByCodes(List<String> codes) {
		return this.getSqlSession().selectList(getSqlName("queryListByCodes"), codes);
	}
}
