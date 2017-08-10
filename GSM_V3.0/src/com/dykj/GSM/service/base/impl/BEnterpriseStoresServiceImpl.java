package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BEnterpriseStoresMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BEnterpriseStores;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BEnterpriseStoresService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-05-13 14:39:25 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BEnterpriseStoresServiceImpl implements BEnterpriseStoresService {
	@Autowired
	private BEnterpriseStoresMapperImpl bEnterpriseStoresMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BEnterpriseStores entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bEnterpriseStoresMapperImpl.insert(entity);
	}

	@Override
	public int update(BEnterpriseStores entity) {
		return bEnterpriseStoresMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bEnterpriseStoresMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BEnterpriseStores queryByKey(String primaryKey) throws Exception {
		BEnterpriseStores store = bEnterpriseStoresMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(store, BEnterpriseStores.class, "codeHouseSource");
		return store;
	}

	@Override
	public List<BEnterpriseStores> queryList() {
		return bEnterpriseStoresMapperImpl.queryList();
	}

	@Override
	public List<BEnterpriseStores> queryListParam(Map param) {
		return bEnterpriseStoresMapperImpl.queryListParam(param);
	}

	@Override
	public List<BEnterpriseStores> queryTListParam(BEnterpriseStores param) {
		return bEnterpriseStoresMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BEnterpriseStores> queryByParamPage(int page, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BEnterpriseStores> pageMap = bEnterpriseStoresMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pageMap, BEnterpriseStores.class, "codeHouseSource");
		return pageMap;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bEnterpriseStoresMapperImpl.deleteBatch(list);
	}

	@Override
	public Page<BEnterpriseStores> queryByParamPage(int page, int size, String sidx, String sord,
			BEnterpriseStores param) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}