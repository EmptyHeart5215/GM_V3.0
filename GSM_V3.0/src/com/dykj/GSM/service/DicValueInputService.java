/**
 * 
 */
package com.dykj.GSM.service;

import com.dykj.GSM.mapper.support.Page;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月28日 下午3:39:03
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:
 */
public interface DicValueInputService {
	public void inputDicValue(Page p, Class<?> c) throws Exception;

	/**
	 * 提供要查询的关于字典值得属性，如BHouse中的;codeHouseSource;codeHouseType;等
	 * 
	 * @param p
	 * @param c
	 * @param fieldNamesStr
	 *            用;号分割，并且前后用;包围，如;codeHouseSource;codeHouseType;
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 */
	public void inputDicValue(Page p, Class<?> c, String fieldNamesStr) throws Exception;

	// public void inputDicValue(Page p, Class<?> c, List<Field> fields) throws
	// Exception;
	public void inputDicValueForOne(Object o, Class<?> c, String fieldNamesStr) throws Exception;
}
