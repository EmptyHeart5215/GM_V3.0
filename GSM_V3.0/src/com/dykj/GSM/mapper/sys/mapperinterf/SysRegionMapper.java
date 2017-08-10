package com.dykj.GSM.mapper.sys.mapperinterf;

import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysRegion;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月19日 下午7:45:04
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:省市县
 */
public interface SysRegionMapper extends IBaseMapper<SysRegion, String> {
	public List<Map<String, Object>> queryTree(Map map);

	/**
	 * codes的形式以,号隔开的，如1,2,3,4
	 * 
	 * @param codes
	 * @return
	 */
	public List<SysRegion> queryListByCodes(List<String> list);
}
