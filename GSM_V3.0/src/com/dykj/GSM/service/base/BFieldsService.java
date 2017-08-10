package com.dykj.GSM.service.base;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.service.IBaseService;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.base.BFields;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-05-13 09:42:54
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface BFieldsService extends IBaseService<BFields, String>{
	public List<Map<String, Object>> Charts(BFields args);
	Page<BFields> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception;

}