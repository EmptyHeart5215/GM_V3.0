package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.model.base.BJiGouServicePeople;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 12:59:19 修改人： 修改日期： 类说明:
 */
public interface BJiGouServicePeopleMapper extends IBaseMapper<BJiGouServicePeople, String> {

	Page<BJiGouServicePeople> queryByParamPage(int pageNum, int size, String sidx, String sord, BJiGouService param);

	List<BJiGouServicePeople> queryAllByServiceId(String code);

	int insertBatch(Map<String, Object> map);

	int deleteByServiceId(String serviceId);

}