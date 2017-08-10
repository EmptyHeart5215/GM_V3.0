package com.dykj.GSM.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPartsMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BParts;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPartsService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPartsServiceImpl implements BPartsService {
	@Autowired
	private BPartsMapperImpl bPartsMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BParts entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bPartsMapperImpl.insert(entity);
	}

	/*
	 * 新增或修改
	 */
	@Override
	public int update(BParts entity) {
		if (entity.getCode() != null && !entity.getCode().isEmpty()) {
			entity.setCreateDate(DateFormatUtil.getStringDate());
			return bPartsMapperImpl.update(entity);
		}
		return 0;
	}

	@Override
	public int deletePk(String primaryKey) {
		return bPartsMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BParts queryByKey(String primaryKey) throws Exception {
		BParts bParts = bPartsMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bParts, BParts.class, "codeSmallType");
		return bParts;
	}

	@Override
	public List<BParts> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BParts> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BParts> queryTListParam(BParts param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BParts> queryByParamPage(int pageNum, int size, String sidx, String sord, BParts param)
			throws Exception {
		Page<BParts> pages = bPartsMapperImpl.queryByParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, BParts.class, "codeSmallType");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPartsMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BParts args) {
		return bPartsMapperImpl.Charts(args);
	}

	@Override
	public Page<BParts> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		Map<Integer, String> allStep = new HashMap<Integer, String>();
		Page<BParts> page = this.bPartsMapperImpl.queryZongHePage(pageNum, size, sidx, sord, args);
		dicValueInputService.inputDicValue(page, BParts.class, "codeSmallType");
		return page;
	}
}
