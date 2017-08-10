package com.dykj.GSM.service.base;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.service.IBaseService;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.model.base.BJiGouPeople;
import com.dykj.GSM.model.base.BParts;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016-04-29 11:12:53
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface BJiGouService extends IBaseService<BJiGou, String>{

	/**
	 * 为用户选择角色而做的树
	 * 
	 * @return
	 */
	public List<Map<String, Object>> queryAllRoleTreeForSelect();

	public List<Map<String, Object>> Charts(BJiGou args);
	
	public Page<BJiGou> queryParamPageSamll(String sidx, int size, int pageNum, String sord, BJiGou args);
	

}