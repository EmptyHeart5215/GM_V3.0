package com.dykj.GSM.mapper.sys.impl;

import java.util.List;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysUploadMapper;
import com.dykj.GSM.model.sys.SysUpload;

public class SysUploadMapperImpl extends BaseMapperImpl<SysUpload, String> implements SysUploadMapper {
	/**
	 * 根据code，查询
	 */
	@Override
	public List<SysUpload> queryByCodes(List codes) {
		return this.getSqlSession().selectList(getSqlName("queryByCodes"), codes);
	}
}
