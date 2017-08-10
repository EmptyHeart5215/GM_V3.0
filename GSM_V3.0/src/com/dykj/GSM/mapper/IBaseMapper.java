package com.dykj.GSM.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.dykj.GSM.mapper.support.Page;

public interface IBaseMapper<T, PK extends Serializable> {
	/**
	 * 插入一个实体对象（在数据库INSERT一条记录）
	 * 
	 * @param entity
	 *            实体对象
	 */
	public int insert(T entity);

	/**
	 * 更新实体对象（UPDATE一条记录）
	 * 
	 * @param entity
	 *            实体对象nam
	 */
	public int update(T entity);

	/**
	 * 修改符合条件的记录
	 * <p>
	 * 此方法特别适合于一次性把多条记录的某些字段值设置为新值（定值）的情况，比如修改符合条件的记录的状态字段
	 * </p>
	 * <p>
	 * 此方法的另一个用途是把一条记录的个别字段的值修改为新值（定值），此时要把条件设置为该记录的主键
	 * </p>
	 * 
	 * @param param
	 *            用于产生SQL的参数值，包括WHERE条件、目标字段和新值等
	 * @return 修改的记录个数，用于判断修改是否成功
	 */
	/*
	 * public int updateParam(Map param);
	 */
	/*	*//**
	 * 删除实体对象
	 * 
	 * @param entity
	 *            实体对象
	 */
	/*
	 * public int delete(T entity);
	 */
	/**
	 * 按主键删除记录
	 * 
	 * @param primaryKey
	 *            njm 主键对象
	 * @return 删除的对象个数，正常情况=1
	 */
	public int deletePk(PK primaryKey);

	/**
	 * 删除符合条件的记录
	 * <p>
	 * <strong>此方法一定要慎用，如果条件设置不当，可能会删除有用的记录！</strong>
	 * </p>
	 * 
	 * @param param
	 *            用于产生SQL的参数值，包括WHERE条件（其他参数内容不起作用）
	 * @return
	 */
	/*
	 * public int deleteParam(Map param);
	 */
	/**
	 * 清空表，比delete具有更高效率，而且是从数据库中物理删除（delete是逻辑假删除，被删除的记录依然占有空间）
	 * <p>
	 * <strong>此方法一定要慎用！</strong>
	 * </p>
	 * 
	 * @return
	 */
	/*
	 * public int truncate();
	 */
	/**
	 * 查询总记录数据
	 * 
	 * @return 整表总记录数
	 */
	/*
	 * public Integer queryAllCount();
	 */
	/**
	 * 查询符合条件的记录数
	 * 
	 * @param param
	 *            查询条件参数，包括WHERE条件（其他参数内容不起作用）。此参数设置为null，则相当于queryAllCount()
	 * @return
	 */
	/*
	 * public int queryAllCountParam(Object param);
	 */
	/**
	 * 根据主键查询实体对象
	 * 
	 * @param primaryKey
	 *            主键值
	 * @return 记录实体对象，如果没有符合主键条件的记录，则 throw DataAccessException
	 */
	public T queryByKey(PK primaryKey);

	/*	*//**
	 * 按主键取记录
	 * 
	 * @param primaryKey
	 *            primaryKey 主键值
	 * @return 记录实体对象，如果没有符合主键条件的记录，则 throw DataAccessException
	 */
	/*
	 * public T load(PK primaryKey) throws DataAccessException;
	 */
	/**
	 * 查询所有实体对象集合
	 * 
	 * @return 全部记录实体对象的List
	 */
	public List<T> queryList();

	/**
	 * 按条件查询记录
	 * 
	 * @param param
	 *            查询条件参数，包括WHERE条件、分页条件、排序条件
	 * @return 符合条件记录的实体对象的List
	 */
	public List<T> queryListParam(Map param);

	/**
	 * 根据对象参数查询
	 * 
	 * @param param
	 * @return
	 */
	public List<T> queryTListParam(T param);

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
	public Page<T> queryByParamPage(int page, int size, String sidx, String sord, T param);

	/*	*//**
	 * 批量插入
	 * 
	 * @param list
	 * @return
	 */
	/*
	 * public int insertBatch(final List<PK> list);
	 *//**
	 * 批量修改
	 * 
	 * @param list
	 * @return
	 */
	/*
	 * public int updateBatch(final List<PK> list);
	 */
	/**
	 * 批量删除
	 * 
	 * @param list
	 * @return
	 */
	public int deleteBatch(final List<PK> list);
}
