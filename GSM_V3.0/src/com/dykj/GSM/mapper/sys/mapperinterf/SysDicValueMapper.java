package com.dykj.GSM.mapper.sys.mapperinterf;


import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysDicValue;
import com.dykj.GSM.model.sys.SysLegalDate;


public interface SysDicValueMapper extends IBaseMapper<SysDicValue, String>{ 
	public List<SysDicValue> queryListParams(String sysDicCode);
	public List<Map<String, Object>> queryManageTree(String code);
}
