package com.dykj.GSM.service.base;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月27日 上午8:58:48
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface BCommunityService extends IBaseService<BCommunity, String> {
	public List<Map<String, Object>> Charts(BCommunity args);
	Page<BCommunity> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception;
}
