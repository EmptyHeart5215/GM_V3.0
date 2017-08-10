package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
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
public interface BFieldsMapper extends IBaseMapper<BFields, String>{
	public List<Map<String, Object>> Charts(BFields args);
	public Page<BFields> queryZongHePage(int page, int size, String sidx, String sord, Map args);

}