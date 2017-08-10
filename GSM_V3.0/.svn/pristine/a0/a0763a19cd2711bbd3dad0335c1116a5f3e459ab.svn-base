package com.dykj.GSM.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BFieldsMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.base.BFields;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BFieldsService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-05-13 09:42:54 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BFieldsServiceImpl implements BFieldsService {
	@Autowired
	private BFieldsMapperImpl bFieldsMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BFields entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bFieldsMapperImpl.insert(entity);
	}

	@Override
	public int update(BFields entity) {
		return bFieldsMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bFieldsMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BFields queryByKey(String primaryKey) throws Exception {
		BFields bfields = bFieldsMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bfields, BFields.class, "codeBelongType");
		return bfields;
	}

	@Override
	public List<BFields> queryList() {
		return bFieldsMapperImpl.queryList();
	}

	@Override
	public List<BFields> queryListParam(Map param) {
		return bFieldsMapperImpl.queryListParam(param);
	}

	@Override
	public List<BFields> queryTListParam(BFields param) {
		return bFieldsMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BFields> queryByParamPage(int page, int size, String sidx, String sord, BFields param) throws Exception {
		Page<BFields> pages = bFieldsMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, BFields.class, "codeBelongType");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bFieldsMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BFields args) {
		return bFieldsMapperImpl.Charts(args);
	}
	@Override
	public Page<BFields> queryZongHePage(String sidx, int size, int pageNum,
			String sord, Map args) throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		Map<Integer, String> allStep = new HashMap<Integer, String>();
		Page<BFields> page = this.bFieldsMapperImpl.queryZongHePage(pageNum, size, sidx, sord, args);
		dicValueInputService.inputDicValue(page, BFields.class, "codeBelongType");
		return page;
	}
}