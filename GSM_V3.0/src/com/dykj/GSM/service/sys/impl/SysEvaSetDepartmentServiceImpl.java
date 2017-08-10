package com.dykj.GSM.service.sys.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysEvaSetDepartmentMapperImpl;
import com.dykj.GSM.model.sys.SysEvaSetDepartment;
import com.dykj.GSM.service.sys.SysEvaSetDepartmentService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class SysEvaSetDepartmentServiceImpl implements SysEvaSetDepartmentService {
	@Autowired
	private SysEvaSetDepartmentMapperImpl evaSetDepartmentMapperImpl;

	@Override
	public SysEvaSetDepartment queryOne() throws Exception {
		return evaSetDepartmentMapperImpl.queryOne();
	}

	@Override
	public int insert(SysEvaSetDepartment entity) throws Exception {
		evaSetDepartmentMapperImpl.deleteAll();
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return evaSetDepartmentMapperImpl.insert(entity);
	}

	@Override
	public int update(SysEvaSetDepartment entity) throws Exception {
		/*entity.setCreateDate(DateFormatUtil.getStringDate());
		return evaSetDepartmentMapperImpl.update(entity);*/
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SysEvaSetDepartment queryByKey(String primaryKey) throws Exception {
		return null;
	}

	@Override
	public List<SysEvaSetDepartment> queryList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysEvaSetDepartment> queryListParam(Map param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SysEvaSetDepartment> queryTListParam(SysEvaSetDepartment param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SysEvaSetDepartment> queryByParamPage(int page, int size, String sidx, String sord,
			SysEvaSetDepartment param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
}
