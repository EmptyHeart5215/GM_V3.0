package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysEvaSetMapperImpl;
import com.dykj.GSM.model.sys.SysEvaSet;
import com.dykj.GSM.service.sys.SysEvaSetService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class SysEvaSetServiceImpl implements SysEvaSetService {
	@Autowired
	private SysEvaSetMapperImpl evaSetMapperImpl;

	@Override
	public SysEvaSet queryOne() throws Exception {
		return evaSetMapperImpl.queryOne();
	}

	@Override
	public int insert(SysEvaSet entity) throws Exception {
		evaSetMapperImpl.deleteAll();
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return evaSetMapperImpl.insert(entity);
	}

	@Override
	public int update(SysEvaSet entity) throws Exception {
		/*entity.setCreateDate(DateFormatUtil.getStringDate());
		if (!entity.getIsContradict()) {
			entity.setLeastContradict(null);
			entity.setLessKouFenContradict(null);
			entity.setLateKouFenContradict(null);
			entity.setContradictBaseScore(null);
		}
		if (!entity.getIsEvent()) {
			entity.setLeastEvent(null);
			entity.setLessKouFenEvent(null);
			entity.setLateKouFenEvent(null);
			entity.setEventBaseScore(null);
		}
		if (!entity.getIsLog()) {
			entity.setLessKouFenLog(null);
			entity.setLogBaseScore(null);
		}
		if (!entity.getIsXunCha()) {
			entity.setZouFangBaseScore(null);
			entity.setLeastZouFangHu(null);
			entity.setLessKouFenZouFangHu(null);
		}
		return evaSetMapperImpl.update(entity);*/
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysEvaSet queryByKey(String primaryKey) throws Exception {
		return null;
	}

	@Override
	public List<SysEvaSet> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysEvaSet> queryListParam(Map param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysEvaSet> queryTListParam(SysEvaSet param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysEvaSet> queryByParamPage(int page, int size, String sidx, String sord, SysEvaSet param)
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
