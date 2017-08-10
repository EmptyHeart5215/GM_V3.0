package com.dykj.GSM.service.base;

import java.util.List;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.model.base.BJiGouServicePeople;
import com.dykj.GSM.service.IBaseService;

public interface BJiGouServicePeopleService extends IBaseService<BJiGouServicePeople, String> {

	Page<BJiGouServicePeople> queryByParamPage(int page, int size, String sidx, String sord, BJiGouService param)
			throws Exception;

	List<BJiGouServicePeople> queryAllByServiceId(String code) throws Exception;

}
