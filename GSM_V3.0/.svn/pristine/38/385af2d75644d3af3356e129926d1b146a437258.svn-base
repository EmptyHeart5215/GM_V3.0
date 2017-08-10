package com.dykj.GSM.service.zongzhitraining.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.zongzhitraining.impl.AppraisalManagementMapperImpl;
import com.dykj.GSM.model.zongzhitraining.AppraisalManagement;
import com.dykj.GSM.service.zongzhitraining.AppraisalManagementService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-05-06 14:35:16 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class AppraisalManagementServiceImpl implements AppraisalManagementService {
	@Autowired
	private AppraisalManagementMapperImpl appraisalManagementMapperImpl;

	@Override
	public int insert(AppraisalManagement entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return appraisalManagementMapperImpl.insert(entity);
	}

	@Override
	public int update(AppraisalManagement entity) {
		return appraisalManagementMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return appraisalManagementMapperImpl.deletePk(primaryKey);
	}

	@Override
	public AppraisalManagement queryByKey(String primaryKey) {
		return appraisalManagementMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<AppraisalManagement> queryList() {
		return appraisalManagementMapperImpl.queryList();
	}

	@Override
	public List<AppraisalManagement> queryListParam(Map param) {
		return appraisalManagementMapperImpl.queryListParam(param);
	}

	@Override
	public List<AppraisalManagement> queryTListParam(AppraisalManagement param) {
		return appraisalManagementMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<AppraisalManagement> queryByParamPage(int page, int size, String sidx, String sord,
			AppraisalManagement param) {
		return appraisalManagementMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return appraisalManagementMapperImpl.deleteBatch(list);
	}
}