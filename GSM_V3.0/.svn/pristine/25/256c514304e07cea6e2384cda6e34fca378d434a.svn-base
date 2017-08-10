package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerson;

public interface BPersonMapper extends IBaseMapper<BPerson, String> {
	/**
	 * @param param
	 * @return
	 */
	public Page<List> queryParamPageMap(int pageNum, int size, String sidx, String sord, BPerson param);

	public List<Map<String, Object>> Charts(BPerson args);

	public List<Map<String, Object>> mapqueryByParamPage(BPerson args);

	Page<BPerson> queryMapParamPage(int pageNum, int size, String sidx, String sord, Map param);

	public Page<BPerson> queryZongHePage(int page, int size, String sidx, String sord, Map args);

	List<Map<String, Object>> queryPersonTypeStatistics(Map<String, Object> args);

}
