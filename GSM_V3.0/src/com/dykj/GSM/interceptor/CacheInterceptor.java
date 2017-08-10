package com.dykj.GSM.interceptor;

import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.builder.SqlSourceBuilder;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.jdbc.SqlBuilder;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.type.TypeHandlerRegistry;

import com.dykj.GSM.mapper.support.Page;

@Intercepts({@Signature(type = Executor.class,method = "query",args = {MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class})})
public class CacheInterceptor implements Interceptor{
	
	private static final Log logger = LogFactory.getLog(CacheInterceptor.class);
	private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
	private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
	private static String defaultPageSqlId = ".*Page$"; // 需要拦截的ID（匹配）
	private static String pageSqlId = ""; //需要拦截器的ID匹配

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Executor executorProxy = (Executor) invocation.getTarget();
		MetaObject metaExecutor = MetaObject.forObject(executorProxy, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		//分离代理对象
		while(metaExecutor.hasGetter("h")){
			Object object = metaExecutor.getValue("h");
			metaExecutor = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		//分离最后一个代理对象的目标类
		while(metaExecutor.hasGetter("target")){
			Object object = metaExecutor.getValue("target");
			metaExecutor = MetaObject.forObject(object, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		}
		Object[] args = invocation.getArgs();
		return this.query(metaExecutor, args);
	}
	
	public <T> List<T> query(MetaObject metaExecutor,Object[] args) throws SQLException{
		MappedStatement ms = (MappedStatement) args[0];
		Object parameterObject = args[1];
		RowBounds rowBounds = (RowBounds) args[2];
		ResultHandler resultHandler = (ResultHandler) args[3];
		BoundSql boundSql = ms.getBoundSql(parameterObject);
		CacheKey cacheKey = createCacheKey(ms, parameterObject, rowBounds, boundSql);
		Executor executor = (Executor) metaExecutor.getOriginalObject();
		return executor.query(ms, parameterObject, rowBounds, resultHandler,cacheKey,boundSql);
	}
	
	private CacheKey createCacheKey(MappedStatement ms,Object parameterObject,RowBounds rowBounds,BoundSql boundSql){
		Configuration configuration = ms.getConfiguration();
		pageSqlId = configuration.getVariables().getProperty("pageSqlId");
		if(pageSqlId == null || "".equals(pageSqlId)){
			logger.warn("Property pageSqlId is not setted,use default '.*Page$' ");
			pageSqlId = defaultPageSqlId;
		}
		CacheKey cacheKey = new CacheKey();
		cacheKey.update(ms.getId());
		cacheKey.update(rowBounds.getOffset());
		cacheKey.update(rowBounds.getLimit());
		List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
		
		MetaObject metaObject = MetaObject.forObject(parameterObject, DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY);
		
		if(parameterMappings.size()>0 && parameterObject !=null){
			TypeHandlerRegistry typeHandlerRegistry = ms.getConfiguration().getTypeHandlerRegistry();
			if(typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())){
				cacheKey.update(parameterObject);
			}else{
				for(ParameterMapping parameterMapping : parameterMappings){
					String propertyName = parameterMapping.getProperty();
					if(metaObject.hasGetter(propertyName)){
						cacheKey.update(metaObject.getValue(propertyName));
					}else if(boundSql.hasAdditionalParameter(propertyName)){
						cacheKey.update(boundSql.getAdditionalParameter(propertyName));
					}
				}
			}
		}
		
		// 当需要分页查询时，将page参数里的当前页和每页数加到cacheKey里
		if(ms.getId().matches(pageSqlId)&&metaObject.hasGetter("page")){
			Page page = (Page) metaObject.getValue("page");
			if(page != null){
				cacheKey.update(page.getNowPage());
				cacheKey.update(page.getPageSize());
				
				cacheKey.update(page.getRecords());
			}
		}
		return cacheKey;
	}

	@Override
	public Object plugin(Object target) {
		if(target instanceof CachingExecutor){
			return Plugin.wrap(target, this);
		}else{			
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
		
	}
	
	private SqlSource buildSqlSource(Configuration configuration,String originalSql,Class<?> parameterType){
		SqlSourceBuilder builder = new SqlSourceBuilder(configuration);
		return builder.parse(originalSql, parameterType, null);
	}

}
