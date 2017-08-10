package com.dykj.GSM.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月19日 上午11:12:20
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:
 */
public interface IBaseService<T, PK extends Serializable> {
	/**
	 * 插入一个实体对象（在数据库INSERT一条记录）
	 * 
	 * @param entity
	 *            实体对象
	 */
	public int insert(T entity) throws Exception;

	/**
	 * 更新实体对象（UPDATE一条记录）
	 * 
	 * @param entity
	 *            实体对象nam
	 */
	public int update(T entity) throws Exception;

	/**
	 * 按主键删除记录
	 * 
	 * @param primaryKey
	 *            njm 主键对象
	 * @return 删除的对象个数，正常情况=1
	 */
	public int deletePk(PK primaryKey) throws Exception;

	/**
	 * 根据主键查询实体对象
	 * 
	 * @param primaryKey
	 *            主键值
	 * @return 记录实体对象，如果没有符合主键条件的记录，则 throw DataAccessException
	 */
	public T queryByKey(PK primaryKey) throws Exception;

	/**
	 * 查询所有实体对象集合
	 * 
	 * @return 全部记录实体对象的List
	 */
	public List<T> queryList() throws Exception;

	/**
	 * 按条件查询记录
	 * 
	 * @param param
	 *            查询条件参数，包括WHERE条件、分页条件、排序条件
	 * @return 符合条件记录的实体对象的List
	 */
	public List<T> queryListParam(Map param) throws Exception;

	/**
	 * 根据对象参数查询
	 * 
	 * @param param
	 * @return
	 */
	public List<T> queryTListParam(T param) throws Exception;

	/**
	 * 带参数的分页查询
	 * 
	 * @param page
	 *            当前页
	 * @param size
	 *            每页记录数
	 * @param sidx
	 *            排序字段
	 * @param sord
	 *            排序方式
	 * @param param
	 * @return 返回的list集合
	 */
	public Page<T> queryByParamPage(int page, int size, String sidx, String sord, T param) throws Exception;

	/**
	 * 批量删除
	 * 
	 * @param list
	 * @return
	 */
	public int deleteBatch(final List<PK> list) throws Exception;
}
