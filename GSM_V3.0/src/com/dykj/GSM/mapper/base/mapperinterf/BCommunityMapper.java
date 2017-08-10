package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.model.eventfile.EventActivities;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月27日 上午9:06:14
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface BCommunityMapper extends IBaseMapper<BCommunity, String> {
	public List<Map<String, Object>> Charts(BCommunity args);
	public Page<BCommunity> queryZongHePage(int page, int size, String sidx, String sord, Map args);
}
