package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BRoadConvenientMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BRoadConvenient;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BRoadConvenientService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016-07-18 14:30:44 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BRoadConvenientServiceImpl implements BRoadConvenientService {
	@Autowired
	private BRoadConvenientMapperImpl bRoadConvenientMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BRoadConvenient entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bRoadConvenientMapperImpl.insert(entity);
	}

	@Override
	public int update(BRoadConvenient entity) {
		return bRoadConvenientMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bRoadConvenientMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BRoadConvenient queryByKey(String primaryKey) throws Exception {
		BRoadConvenient bRoadConvenient = bRoadConvenientMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bRoadConvenient, BRoadConvenient.class,
				"codeLineType,codeSecurityLevel");
		return bRoadConvenient;
	}

	@Override
	public List<BRoadConvenient> queryList() {
		return bRoadConvenientMapperImpl.queryList();
	}

	@Override
	public List<BRoadConvenient> queryListParam(Map param) {
		return bRoadConvenientMapperImpl.queryListParam(param);
	}

	@Override
	public List<BRoadConvenient> queryTListParam(BRoadConvenient param) {
		return bRoadConvenientMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BRoadConvenient> queryByParamPage(int page, int size, String sidx, String sord, BRoadConvenient param)
			throws Exception {
		Page<BRoadConvenient> pages = bRoadConvenientMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, BRoadConvenient.class, "codeLineType,codeSecurityLevel");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bRoadConvenientMapperImpl.deleteBatch(list);
	}
}