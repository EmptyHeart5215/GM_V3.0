package com.dykj.GSM.service.base;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.service.IBaseService;

public interface BPersonService extends IBaseService<BPerson, String> {
	public Page<List> queryParamPageMap(int pageNum, int size, String sidx, String sord, BPerson param);

	public BPerson queryByKeyForInfoSee(String primaryKey) throws Exception;

	public List<Map<String, Object>> Charts(BPerson args);

	List<Map<String, Object>> mapqueryByParamPage(BPerson args);

	Page<BPerson> queryMapParamPage(int pageNum, int size, String sidx, String sord, Map param);

	Page<BPerson> queryZongHePage(String sidx, int size, int pageNum, String sord, Map args) throws Exception;

	Map<String, Object> queryPersonTypeStatistics(String gridCode);

}
