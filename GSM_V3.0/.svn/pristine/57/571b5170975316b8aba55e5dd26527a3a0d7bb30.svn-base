/**
 * 
 */
package com.dykj.GSM.mapper.base.mapperinterf;

import java.util.Map;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.mapper.support.Page;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年5月18日 下午8:05:20 修改人： 修改日期： 类说明:
 */
public interface IBasePersonMapper<BaseModel> extends IBaseMapper<BaseModel, String> {
	public BaseModel queryByPersonCode(String personCode);

	public int deleteByPersonCode(String personCode);

	/**
	 * 带参数的，查询分页
	 */
	public Page<BaseModel> queryMapParamPage(int pageNum, int size, String sidx, String sord, Map<String, Object> param);
}
