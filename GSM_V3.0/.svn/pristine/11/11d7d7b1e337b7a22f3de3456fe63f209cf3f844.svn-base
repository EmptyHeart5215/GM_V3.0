package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysUploadMapperImpl;
import com.dykj.GSM.model.sys.SysUpload;
import com.dykj.GSM.service.sys.SysUploadService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service

public class SysUploadServiceImpl implements SysUploadService {
	@Autowired
	private SysUploadMapperImpl sysUploadMapperImpl;

	/*
	 * 根据codes，查询
	 */
	@Override
	public List<SysUpload> queryByCodes(List codes) {
		return sysUploadMapperImpl.queryByCodes(codes);
	}

	@Override
	public int insert(SysUpload entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return sysUploadMapperImpl.insert(entity);
	}

	@Override
	public int update(SysUpload entity) {
		if (entity.getCode() != null && !entity.getCode().isEmpty()) {
			entity.setCreateDate(DateFormatUtil.getStringDate());
			return sysUploadMapperImpl.update(entity);
		}
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) {
		return sysUploadMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysUpload queryByKey(String primaryKey) {
		return sysUploadMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysUpload> queryList() {
		return null;
	}

	@Override
	public List<SysUpload> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysUpload> queryTListParam(SysUpload param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysUpload> queryByParamPage(int page, int size, String sidx, String sord, SysUpload param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return sysUploadMapperImpl.deleteBatch(list);
	}
}
