package com.dykj.GSM.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BFeiGongJingJiMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BFeiGongJingJi;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BFeiGongJingJiService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月26日 上午9:19:30 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BFeiGongJingJiServiceImpl implements BFeiGongJingJiService {
	@Autowired
	private BFeiGongJingJiMapperImpl bFeiGongJingJiMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BFeiGongJingJi entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return bFeiGongJingJiMapperImpl.insert(entity);
	}

	@Override
	public int update(BFeiGongJingJi entity) {
		return bFeiGongJingJiMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return bFeiGongJingJiMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BFeiGongJingJi queryByKey(String primaryKey) throws Exception {
		BFeiGongJingJi bFeiGongJingJi = bFeiGongJingJiMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bFeiGongJingJi, BFeiGongJingJi.class, "codeHouseSource");
		return bFeiGongJingJi;
	}

	@Override
	public List<BFeiGongJingJi> queryList() {
		return bFeiGongJingJiMapperImpl.queryList();
	}

	@Override
	public List<BFeiGongJingJi> queryListParam(Map param) {
		return bFeiGongJingJiMapperImpl.queryListParam(param);
	}

	@Override
	public List<BFeiGongJingJi> queryTListParam(BFeiGongJingJi param) {
		return bFeiGongJingJiMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BFeiGongJingJi> queryByParamPage(int page, int size, String sidx, String sord, BFeiGongJingJi param)
			throws Exception {
		Page<BFeiGongJingJi> pages = bFeiGongJingJiMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, BFeiGongJingJi.class, "codeHouseSource");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bFeiGongJingJiMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BFeiGongJingJi args) {
		return bFeiGongJingJiMapperImpl.Charts(args);
	}

	@Override
	public Page<BFeiGongJingJi> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args)
			throws Exception {
		if (args == null) {
			args = new HashMap<String, Object>();
		}
		Map<Integer, String> allStep = new HashMap<Integer, String>();
		Page<BFeiGongJingJi> page = this.bFeiGongJingJiMapperImpl.queryZongHePage(pageNum, size, sidx, sord, args);
		dicValueInputService.inputDicValue(page, BFeiGongJingJi.class, "codeHouseSource");
		return page;
	}
}
