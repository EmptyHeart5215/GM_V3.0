package com.dykj.GSM.service.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BJiGouServiceMapperImpl;
import com.dykj.GSM.mapper.base.impl.BJiGouServicePeopleMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.model.base.BJiGouServicePeople;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BJiGouServiceService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 12:59:19 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BJiGouServiceServiceImpl implements BJiGouServiceService {
	@Autowired
	private BJiGouServiceMapperImpl bJiGouServiceMapperImpl;
	@Autowired
	private BJiGouServicePeopleMapperImpl bJiGouServicePeopleMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BJiGouService entity) {
		String createDate = DateFormatUtil.getStringDate();
		entity.setCreateDate(createDate);
		int i = bJiGouServiceMapperImpl.insert(entity);
		Map<String, Object> map = new HashMap<String, Object>();
		if (i > 0) {
			if (!entity.getPeoples().isEmpty()) {
				map.put("code", entity.getCode());
				List<Object> l = entity.getPeoples();
				for (int j = 0; j < l.size(); j++) {
					BJiGouServicePeople p = (BJiGouServicePeople) l.get(j);
					p.setCreateDate(createDate);
					p.setCreateBy(entity.getCreateBy());
					l.set(j, p);
				}
				map.put("list", l);
				return bJiGouServicePeopleMapperImpl.insertBatch(map);
			}
		}
		return i;
	}

	@Override
	public int update(BJiGouService entity) {
		int i = bJiGouServiceMapperImpl.update(entity);
		if (i > 0) {
			bJiGouServicePeopleMapperImpl.deleteByServiceId(entity.getCode());
			Map<String, Object> map = new HashMap<String, Object>();
			if (!entity.getPeoples().isEmpty()) {
				map.put("code", entity.getCode());
				List<Object> l = entity.getPeoples();
				String createDate = DateFormatUtil.getStringDate();
				entity.setCreateDate(createDate);
				for (int j = 0; j < l.size(); j++) {
					BJiGouServicePeople p = (BJiGouServicePeople) l.get(j);
					p.setCreateDate(createDate);
					p.setCreateBy(entity.getCreateBy());
					l.set(j, p);
				}
				map.put("list", l);
				return bJiGouServicePeopleMapperImpl.insertBatch(map);
			}
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) {
		return bJiGouServiceMapperImpl.deletePk(primaryKey);
	}

	@Override
	public BJiGouService queryByKey(String primaryKey) throws Exception {
		BJiGouService bJiGouService = bJiGouServiceMapperImpl.queryByKey(primaryKey);
		dicValueInputService.inputDicValueForOne(bJiGouService, BJiGouService.class, "codeServiceType");
		return bJiGouService;
	}

	@Override
	public List<BJiGouService> queryList() {
		return bJiGouServiceMapperImpl.queryList();
	}

	@Override
	public List<BJiGouService> queryListParam(Map param) {
		return bJiGouServiceMapperImpl.queryListParam(param);
	}

	@Override
	public List<BJiGouService> queryTListParam(BJiGouService param) {
		return bJiGouServiceMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<BJiGouService> queryByParamPage(int page, int size, String sidx, String sord, BJiGouService param)
			throws Exception {
		return null;
	}

	@Override
	public Page<BJiGouService> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> map)
			throws Exception {
		Page<BJiGouService> pages = bJiGouServiceMapperImpl.queryByParamPage(page, size, sidx, sord, map);
		dicValueInputService.inputDicValue(pages, BJiGouService.class, "codeServiceType");
		return pages;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bJiGouServiceMapperImpl.deleteBatch(list);
	}

	@Override
	public List<Map<String, Object>> Charts(BJiGouService args) {
		return bJiGouServiceMapperImpl.Charts(args);
	}

	@Override
	public List<BJiGouService> queryParamPageByName(String name) {
		return bJiGouServiceMapperImpl.queryParamPageByName(name);
	}
}