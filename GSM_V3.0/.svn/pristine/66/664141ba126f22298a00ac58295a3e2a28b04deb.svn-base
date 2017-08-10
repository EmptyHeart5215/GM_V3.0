package com.dykj.GSM.service.warningset.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.warningset.impl.WarningSetMapperImpl;
import com.dykj.GSM.model.warningset.WarningSet;
import com.dykj.GSM.service.warningset.WarningSetService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-06-03 12:36:42 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class WarningSetServiceImpl implements WarningSetService {
	@Autowired
	private WarningSetMapperImpl warningSetMapperImpl;

	@Override
	public int insert(WarningSet entity) {
		warningSetMapperImpl.deleteAll();
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return warningSetMapperImpl.insert(entity);
	}

	@Override
	public WarningSet queryOne() throws Exception {
		return warningSetMapperImpl.queryOne();
	}

	@Override
	public int update(WarningSet entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public WarningSet queryByKey(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WarningSet> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WarningSet> queryListParam(Map param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WarningSet> queryTListParam(WarningSet param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<WarningSet> queryByParamPage(int page, int size, String sidx, String sord, WarningSet param)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}