package com.dykj.GSM.service.documentquery.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.documentquery.impl.DocumentQueryMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.documentquery.DocumentQuery;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.documentquery.DocumentQueryService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月28日 上午9:31:20 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class DocumentQueryServiceImpl implements DocumentQueryService {
	@Autowired
	private DocumentQueryMapperImpl documentQueryMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(DocumentQuery entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return documentQueryMapperImpl.insert(entity);
	}

	@Override
	public int update(DocumentQuery entity) {
		return documentQueryMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return documentQueryMapperImpl.deletePk(primaryKey);
	}

	@Override
	public DocumentQuery queryByKey(String primaryKey) throws Exception {
		DocumentQuery doc = documentQueryMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(doc, DocumentQuery.class, "codeDocumnetType");
		return doc;
	}

	@Override
	public List<DocumentQuery> queryList() {
		return documentQueryMapperImpl.queryList();
	}

	@Override
	public List<DocumentQuery> queryListParam(Map param) {
		return documentQueryMapperImpl.queryListParam(param);
	}

	@Override
	public List<DocumentQuery> queryTListParam(DocumentQuery param) {
		return documentQueryMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<DocumentQuery> queryByParamPage(int page, int size, String sidx, String sord, DocumentQuery param)
			throws Exception {
		Page<DocumentQuery> pages = documentQueryMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, DocumentQuery.class, "codeDocumnetType");

		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return documentQueryMapperImpl.deleteBatch(list);
	}

}
