package com.dykj.GSM.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.sys.impl.SysDicValueMapperImpl;
import com.dykj.GSM.model.sys.SysDicValue;
import com.dykj.GSM.service.sys.SysDicValueService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
public class SysDicValueServiceImpl implements SysDicValueService {
	@Autowired
	private SysDicValueMapperImpl dicvalueMapperImpl;

	/**
	 * 查找同一字典中的同名字典值条数
	 * 
	 * @param param
	 * @return
	 */
	public int querySameNameCount(String sysDicCode, String nameC, String code) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("sysDicCode", sysDicCode);
		map.put("nameC", nameC);
		map.put("code", code);
		return dicvalueMapperImpl.querySameNameCount(map);
	}

	@Override
	public int insertWithCheck(SysDicValue entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		if (this.querySameNameCount(entity.getDicCode(), entity.getDicValue(), null) > 0) {
			throw new Exception("字典中已经有值为“" + entity.getDicValue() + "”的字典值");
		}
		if (entity.getParentCode() == null || entity.getParentCode().trim().equals("")) {
			entity.setTotalName(entity.getDicValue());
		} else {
			SysDicValue parent = dicvalueMapperImpl.queryByKey(entity.getParentCode());
			entity.setTotalName(parent.getTotalName() + "-" + entity.getDicValue());
		}
		return dicvalueMapperImpl.insert(entity);
	}

	@Override
	public int updateWithCheck(SysDicValue entity) throws Exception {
		SysDicValue before = dicvalueMapperImpl.queryByKey(entity.getCode());
		// 如果名称没有改变，则不需要修改totalName
		if (!before.getDicValue().equals(entity.getDicValue())) {
			if (this.querySameNameCount(entity.getDicCode(), entity.getDicValue(), entity.getCode()) > 0) {
				throw new Exception("字典中已经有值为“" + entity.getDicValue() + "”的字典值");
			}
			dicvalueMapperImpl.updateAllChildrenTotalName(entity.getCode(), before.getDicValue(), entity.getDicValue());
		}
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 同时更新其子节点的totalName
		return dicvalueMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return dicvalueMapperImpl.deletePk(primaryKey);
	}

	@Override
	public SysDicValue queryByKey(String primaryKey) {
		return dicvalueMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<SysDicValue> queryList() {
		return dicvalueMapperImpl.queryList();
	}

	@Override
	public List<SysDicValue> queryListParam(Map param) {
		return dicvalueMapperImpl.queryListParam(param);
	}

	@Override
	public List<SysDicValue> queryTListParam(SysDicValue param) {
		return dicvalueMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<SysDicValue> queryByParamPage(int page, int size, String sidx, String sord, SysDicValue param) {
		return dicvalueMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return dicvalueMapperImpl.deleteBatch(list);
	}

	@Override
	public List<SysDicValue> queryListParams(String sysDicCode) {
		return dicvalueMapperImpl.queryListParams(sysDicCode);
	}

	@Override
	public List<Map<String, Object>> queryManageTree(String code) {
		return dicvalueMapperImpl.queryManageTree(code);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#insert(java.lang.Object)
	 */
	@Override
	public int insert(SysDicValue entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#update(java.lang.Object)
	 */
	@Override
	public int update(SysDicValue entity) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 根据字典code查询字典值
	 * 
	 * @param codes
	 * @return
	 */
	@Override
	public List<Map<String, Object>> queryListByCodes(List<String> codes) {
		return dicvalueMapperImpl.queryListByCodes(codes);
	}
}
