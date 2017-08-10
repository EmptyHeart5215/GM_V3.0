package com.dykj.GSM.service.base;

import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BEnterpriseStores;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-05-13 14:39:25 修改人： 修改日期： 类说明:
 */
public interface BEnterpriseStoresService extends IBaseService<BEnterpriseStores, String> {

	Page<BEnterpriseStores> queryByParamPage(int page, int size, String sidx, String sord, Map<String, Object> param)
			throws Exception;

}