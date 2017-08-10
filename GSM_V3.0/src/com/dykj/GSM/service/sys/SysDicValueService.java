package com.dykj.GSM.service.sys;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.model.sys.SysDicValue;
import com.dykj.GSM.service.IBaseService;

public interface SysDicValueService extends IBaseService<SysDicValue, String> {
	public List<SysDicValue> queryListParams(String sysDicCode);

	public List<Map<String, Object>> queryManageTree(String code);

	public int insertWithCheck(SysDicValue entity) throws Exception;

	/**
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int updateWithCheck(SysDicValue entity) throws Exception;

	/**
	 * 根据字典code查询字典值
	 * 
	 * @param codes
	 * @return
	 */
	List<Map<String, Object>> queryListByCodes(List<String> codes);
}
