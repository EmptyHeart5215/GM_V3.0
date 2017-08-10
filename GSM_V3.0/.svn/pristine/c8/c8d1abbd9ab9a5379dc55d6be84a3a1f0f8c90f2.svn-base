package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGouService;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 12:59:19 修改人： 修改日期： 类说明:
 */
public interface BJiGouServiceMapper extends IBaseMapper<BJiGouService, String> {
	public List<Map<String, Object>> Charts(BJiGouService args);

	public List<BJiGouService> queryParamPageByName(String args);

	Page<BJiGouService> queryByParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> map);

}