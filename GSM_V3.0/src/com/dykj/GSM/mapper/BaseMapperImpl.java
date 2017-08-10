package com.dykj.GSM.mapper;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.constant.Constant;
import com.dykj.GSM.interceptor.pagehelper.PageHelper;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.support.PageResult;

public class BaseMapperImpl<T, PK extends Serializable> implements IBaseMapper<T, PK> {
	// 声明SQLSession对象
	@Autowired
	private SqlSession sqlSession;
	public static final String SQLNAME_SEPARATOR = ".";
	public static final String SQLID_INSERT = Constant.SQLID_INSERT;
	public static final String SQLID_INSERT_BATCH = Constant.SQLID_INSERT_BATCH;
	public static final String SQLID_UPDATE = Constant.SQLID_UPDATE;
	public static final String SQLID_UPDATE_PARAM = Constant.SQLID_UPDATE_PARAM;
	public static final String SQLID_UPDATE_BATCH = Constant.SQLID_UPDATE_BATCH; // 批量修改
	public static final String SQLID_DELETE = Constant.SQLID_DELETE; // 删除实体对象
	public static final String SQLID_DELETE_PK = Constant.SQLID_DELETE_PK; // 按主键删除记录
	public static final String SQLID_DELETE_PARAM = Constant.SQLID_DELETE_PARAM; // 删除符合条件的记录
	public static final String SQLID_DELETE_BATCH = Constant.SQLID_DELETE_BATCH; // 批量删除
	public static final String SQLID_TRUNCATE = Constant.SQLID_TRUNCATE; // 清空表，
	public static final String SQLID_QUERY_LIST = Constant.SQLID_QUERY_LIST; // 查询所有实体对象集合
	public static final String SQLID_LOAD = Constant.SQLID_LOAD; // 查询所有实体对象集合
																	// 没有返回异常
	public static final String SQLID_QUERY_BY_KEY = Constant.SQLID_QUERY_BY_KEY; // 根据主键查询实体对象
	public static final String SQLID_QUERY_LIST_PARAM = Constant.SQLID_QUERY_LIST_PARAM;
	public final static String SQLID_QUERY_PAGE = Constant.SQLID_QUERY_PAGE; // 查询分页
	public final static String SQLID_QUERY_PAGE_PARAM = Constant.SQLID_QUERY_PAGE_PARAM; // 根据条件查询分页
	public static final String SQLID_QUERY_ALL_COUNT = Constant.SQLID_QUERY_ALL_COUNT; // 查询总记录数据
	public static final String SQLID_QUERY_ALL_COUNT_PARAM = Constant.SQLID_QUERY_ALL_COUNT_PARAM; // 查询符合条件的记录数

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	/**
	 * 获取默认SqlMapping命名空间。 使用泛型参数中业务实体类型的全限定名作为默认的命名空间。
	 * 如果实际应用中需要特殊的命名空间，可由子类重写该方法实现自己的命名空间规则。
	 * 
	 * @return
	 */
	protected String getDefaultSqlNameSpace() {
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		MapperUrlAnnotion mua = clazz.getAnnotation(MapperUrlAnnotion.class);
		String namespace = mua.mapperUrl();
		return namespace;
	}

	/**
	 * 得到该类的表名
	 * 
	 * @return
	 */
	protected String getTClassName() {
		@SuppressWarnings("unchecked")
		Class<T> clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		String clazzName = clazz.getSimpleName();
		clazzName = clazzName.substring(0, 1).toLowerCase() + clazzName.substring(1);
		return clazzName;
	}

	// xxxmapper..xml中的namespace
	private String namespace = getDefaultSqlNameSpace();

	/**
	 * 将SqlMapping命名空间与给定的SqlMapping名组合在一起。
	 * 
	 * @param sqlName
	 * @return 组合了SqlMapping命名空间后的完整SqlMapping名
	 */
	public String getSqlName(String sqlName) {
		return namespace + SQLNAME_SEPARATOR + sqlName;
	}

	/**
	 * pNamespace，对应sqlmap.xml中的命名空间
	 * 
	 * @return
	 */
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@Override
	public int insert(T entity) {
		// 声明一个标记标量，当插入失败时为0，成功则非0
		int rows = this.sqlSession.insert(getSqlName(SQLID_INSERT), entity);
		return rows;
	}

	@Override
	public int update(T entity) {
		int rows = this.sqlSession.update(getSqlName(SQLID_UPDATE), entity);
		return rows;
	}

	@SuppressWarnings("rawtypes")
	/*
	 * @Override public int updateParam(Map param) { int rows = 0; try { rows =
	 * this.sqlSession.update(getSqlName(SQLID_UPDATE_PARAM), param); } catch
	 * (Exception e) { e.printStackTrace();// 打印输入异常信息 } return rows; }
	 */
	/**
	 * 删除实体对象 entity 对象实体
	 */
	/*
	 * @Override public int delete(T entity) { int rows = 0; try { rows =
	 * this.sqlSession.delete(getSqlName(SQLID_DELETE), entity); } catch
	 * (Exception e) { e.printStackTrace();// 打印输入异常信息 } return rows; }
	 */
	/**
	 * 根据主键删除实体对象
	 */
	@Override
	public int deletePk(PK primaryKey) {
		int rows = this.sqlSession.delete(getSqlName(SQLID_DELETE_PK), primaryKey);
		return rows;
	}

	/**
	 * 根据条件删除
	 */
	/*
	 * @Override public int deleteParam(@SuppressWarnings("rawtypes") Map param)
	 * { int rows = 0; try { rows =
	 * this.sqlSession.delete(getSqlName(SQLID_DELETE_PARAM), param); } catch
	 * (Exception e) { e.printStackTrace();// 打印输入异常信息 } return rows; }
	 */
	/**
	 * 真删除
	 */
	/*
	 * @Override public int truncate() { int rows = 0; try { rows =
	 * this.sqlSession.delete(getSqlName(SQLID_TRUNCATE)); } catch (Exception e)
	 * { e.printStackTrace();// 打印输入异常信息 } return rows; }
	 *//**
	 * 查询总记录数
	 */
	/*
	 * @Override public Integer queryAllCount() { Integer result = 0; try {
	 * result =
	 * this.getSqlSession().selectOne(getSqlName(SQLID_QUERY_ALL_COUNT)); }
	 * catch (Exception e) { e.printStackTrace();// 打印输入异常信息 } return result; }
	 *//**
	 * 根据条件查询总记录数
	 */
	/*
	 * @Override public int queryAllCountParam(Object param) { int result = 0;
	 * try { result =
	 * this.sqlSession.selectOne(getSqlName(SQLID_QUERY_ALL_COUNT_PARAM),
	 * param); } catch (Exception e) { e.printStackTrace();// 打印输入异常信息 } return
	 * result; }
	 */
	/**
	 * 根据主键查询实体对象
	 */
	@Override
	public T queryByKey(PK primaryKey) {
		return this.sqlSession.selectOne(getSqlName(SQLID_QUERY_BY_KEY), primaryKey);
	}

	/*	*//**
	 * ----------方法重复可不用----------
	 */
	/*
	 * @Override public T load(PK primaryKey) throws DataAccessException { //
	 * TODO Auto-generated method stub try { return
	 * this.sqlSession.selectOne(getSqlName(SQLID_QUERY_BY_KEY), primaryKey); }
	 * catch (Exception e) { e.printStackTrace();// 打印输入异常信息 return null; } }
	 */
	/**
	 * 查询所有实体集合
	 */
	@Override
	public List<T> queryList() {
		return this.sqlSession.selectList(getSqlName(SQLID_QUERY_LIST));
	}

	/*
	 * 根据条件查询实体集合 (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#queryListParam(java.util.Map)
	 */
	@Override
	public List<T> queryListParam(Map param) {
		return this.sqlSession.selectList(getSqlName(SQLID_QUERY_LIST_PARAM), param);
	}

	@Override
	public List<T> queryTListParam(T param) {
		return this.sqlSession.selectList(getSqlName(SQLID_QUERY_LIST_PARAM), param);
	}

	/**
	 * 带参数的，查询分页
	 */
	@Override
	public Page<T> queryByParamPage(int pageNum, int size, String sidx, String sord, T param) {
		String clazzName = getTClassName();
		sidx = clazzName + "." + sidx;
		PageHelper.startPage(pageNum, size, sidx + " " + sord);
		// 得到结果
		PageResult results = (PageResult) this.sqlSession.selectList(getSqlName(SQLID_QUERY_PAGE_PARAM), param);
		return PageHelper.endPage(results);
	}

	/**
	 * 设置 page 相关参数
	 * 
	 * @param page
	 *            当前页
	 * @param size
	 *            每页记录条数
	 * @param sidx
	 *            排序字段
	 * @param sord
	 *            排序类型
	 * @return 返回 page对象
	 */
	private Page setPageParam(int page, int size, String sidx, String sord) {
		Page myPage = new Page();
		myPage.setNowPage(page);
		myPage.setPageSize(size);
		myPage.setOrderColumn(sidx);
		myPage.setOrderTurn(sord);
		return myPage;
	}

	/**
	 * 设置 page 相关参数
	 * 
	 * @param page
	 *            当前页
	 * @param size
	 *            每页记录条数
	 * @param sidx
	 *            排序字段
	 * @param sord
	 *            排序类型
	 * @return 返回 page对象
	 */
	private Page setPageParam(int page, int size) {
		Page myPage = new Page();
		myPage.setNowPage(page);
		myPage.setPageSize(size);
		return myPage;
	}

	/*
	 * 批量更新 (non-Javadoc)
	 * 
	 * @see com.dykj.GSM.mapper.IBaseMapper#updateBatch(java.util.List)
	 */
	/*
	 * @Override public int updateBatch(List<PK> list) { try { return
	 * this.sqlSession.update(getSqlName(SQLID_UPDATE_BATCH), list); } catch
	 * (Exception e) { e.printStackTrace();// 打印输入异常信息 return 0; } }
	 */
	/**
	 * 批量删除
	 */
	@Override
	public int deleteBatch(List<PK> list) {
		return this.sqlSession.delete(getSqlName(SQLID_DELETE_BATCH), list);
	}
	/*
	 * @Override public int insertBatch(List<PK> list) { // TODO Auto-generated
	 * method stub return 0; }
	 */
}
