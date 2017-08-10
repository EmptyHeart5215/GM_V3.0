package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BCommunity;
import com.dykj.GSM.model.base.BFeiGongJingJi;
/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年4月26日 上午9:29:22
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface BFeiGongJingJiMapper extends IBaseMapper<BFeiGongJingJi, String>{
	public List<Map<String, Object>> Charts(BFeiGongJingJi args);
	public Page<BFeiGongJingJi> queryZongHePage(int page, int size, String sidx, String sord, Map args);
}
