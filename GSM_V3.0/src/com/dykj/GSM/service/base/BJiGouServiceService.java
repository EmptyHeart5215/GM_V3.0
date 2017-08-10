package com.dykj.GSM.service.base;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 12:59:19 修改人： 修改日期： 类说明:
 */
public interface BJiGouServiceService extends IBaseService<BJiGouService, String> {
	public List<Map<String, Object>> Charts(BJiGouService args);

	public List<BJiGouService> queryParamPageByName(String name);

	Page<BJiGouService> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> map)
			throws Exception;
}