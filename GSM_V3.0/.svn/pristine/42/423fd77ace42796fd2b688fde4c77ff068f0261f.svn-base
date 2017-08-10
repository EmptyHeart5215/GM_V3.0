/*package com.dykj.GSM.interceptor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;

import com.dykj.GSM.mapper.support.Page;

*//**
 * 时间：2016年3月25日 下午 15时25分 mybtis分页，实现物理分页拦截器
 * 
 * @author wangmingyuan
 */
/*
// 只拦截查询部分
@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PaginationInterceptor implements Interceptor {
private final static Log log = LogFactory.getLog(PaginationInterceptor.class);
private static String defaultDialect = "oracle"; // 默认数据库类型为oracle
private static String defaultPageSqlId = ".*Page$"; // 需要拦截的ID（正则匹配）
private static String dialect = ""; // 数据库类型（默认为oracle）
private static String pageSqlId = ""; // 需要拦截的ＩＤ（正则匹配）
public static final ThreadLocal<Page> localPage = new ThreadLocal<Page>();

*//**
 * 开始分页
 * 
 * @param pageNum
 * @param pageSize
 */
/*
public static void startPage(Integer nowPage, Integer pageSize, String orderColumn, String orderTurn) {
localPage.set(new Page(nowPage, pageSize, orderColumn, orderTurn));
}

*//**
 * 结束分页并返回结果，该方法必须被调用，否则localPage会一直保存下去，直到下一次startPage
 * 
 * @return
 */
/*
public static Page endPage(List results) {
Page page = localPage.get();
page.setRows(results);
localPage.remove();
return page;
}

@Override
public Object intercept(Invocation invocation) throws Throwable {
if (localPage.get() == null) {
	return invocation.proceed();
}
if (invocation.getTarget() instanceof RoutingStatementHandler) {
	// 得到拦截的目标对象，并强制转化为StatementHandler对象
	StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
	*//**
 * MetaObject是Mybatis提供的一个的工具类， 通过它包装一个对象后可以获取或设置
 * 该对象的原本不可访问的属性（比如那些私有属性）。 forObject:用于包装对象；
 */
/*
MetaObject metaStatementHandler = SystemMetaObject.forObject(statementHandler);
// 分离代理对象链（由于目标类可能被多个拦截器拦截，从而形成多次代理，通过下面的两次循环
// 可以分离出最原始的目标类）
while (metaStatementHandler.hasGetter("h")) {
Object object = metaStatementHandler.getValue("h");
metaStatementHandler = SystemMetaObject.forObject(object);
}
// 分理出最后一个代理对象的目标类
while (metaStatementHandler.hasGetter("target")) {
Object object = metaStatementHandler.getValue("target");
metaStatementHandler = SystemMetaObject.forObject(object);
}
// property在mybatis settings文件内配置
Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
// 设置pageSqlId
dialect = configuration.getVariables().getProperty("dialect");
if (dialect == null || "".equals(dialect)) {
log.warn("没有设置数据库语言，默认为'oracle'");
dialect = defaultDialect;
}
pageSqlId = configuration.getVariables().getProperty("pageSqlId");
if (pageSqlId == null || "".equals(pageSqlId)) {
log.warn("Property pageSqlId is not setted,use default '.*Page$' ");
pageSqlId = defaultPageSqlId;
}
MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
	.getValue("delegate.mappedStatement");
// 只写需要分页的sql语句。通过MappedStatement的Id匹配，
// 默认从写以Page结尾的MappedStatement的sql
if (mappedStatement.getId().matches(pageSqlId)) {
if (invocation.getTarget() instanceof StatementHandler) {
	Page page = localPage.get();
	BoundSql boundSql = statementHandler.getBoundSql();
	String sql = boundSql.getSql();
	// 重写sql语句
	String pageSql = buildPageSql(sql, page);
	metaStatementHandler.setValue("delegate.boundSql.sql", pageSql);
	// 采用物理分页后，就不需要mybatis的内存分页了，所以重置下面的两个参数
	metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
	metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
	Connection connection = (Connection) invocation.getArgs()[0];
	// 重设分页参数的总页数等
	setPageParameter(sql, connection, mappedStatement, boundSql, page);
}
}
}
// 将执行权交给下一个拦截器
return invocation.proceed();
}

private void setPageParameter(String sql, Connection connection, MappedStatement mappedStatement,
BoundSql boundSql, Page page) {
// 取得总记录数
String countSql = "select count(0) from (" + sql + ") total";
PreparedStatement countStmt = null;
ResultSet rs = null;
try {
countStmt = connection.prepareStatement(countSql);
BoundSql countBS = new BoundSql(mappedStatement.getConfiguration(), countSql,
	boundSql.getParameterMappings(), boundSql.getParameterObject());

setParameters(countStmt, mappedStatement, countBS, boundSql.getParameterObject());
rs = countStmt.executeQuery();
PreparedStatementHandler p = new PreparedStatementHandler(new SimpleExecutor(
	(Configuration) metaStatementHandler.getValue("delegate.configuration"), null), mappedStatement,
	boundSql.getParameterObject(), new RowBounds(), null, boundSql);
p.query(mappedStatement, null);
int totalCount = 0;
if (rs.next()) {
totalCount = rs.getInt(1);
}
// page.setTotalCount(totalCount);
page.setRecords(totalCount);
int totalPage = totalCount / page.getPageSize() + ((totalCount % page.getPageSize() == 0) ? 0 : 1);
// page.setTotalPage(totalPage);
page.setTotal(totalPage);
} catch (SQLException e) {
log.error("Ignore this exception", e);
} finally {
try {
rs.close();
} catch (SQLException e) {
log.error("Ignore this exception", e);
}
try {
countStmt.close();
} catch (SQLException e) {
log.error("Ignore this exception", e);
}
}
}

*//**
 * 对SQL参数(?)设值
 * 
 * @param ps
 * @param mappedStatement
 * @param boundSql
 * @param parameterObject
 * @throws SQLException
 */
/*
private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
	Object parameterObject) throws SQLException {
ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, parameterObject, boundSql);
parameterHandler.setParameters(ps);
}

*//**
 * 根据数据库类型，生成特定的分页sql
 * 
 * @param sql
 * @param page
 * @return
 */
/*
private String buildPageSql(String sql, Page page) {
if (page != null) {
	StringBuilder pageSql = new StringBuilder();
	if ("oracle".equals(dialect)) {
		pageSql = buildPageSqlForOracle(sql, page);
	} else if ("mysql".equals(dialect)) {
		pageSql = buildPageSqlForMySql(sql, page);
	} else {
		return sql;
	}
	return pageSql.toString();
} else {
	return sql;
}
}

*//**
 * 参考hibernate的实现完成oralce的分页
 * 
 * @param sql
 * @param page
 * @return
 */
/*
public StringBuilder buildPageSqlForOracle(String sql, Page page) {
StringBuilder pageSql = new StringBuilder(100);
// 开始下标
String beginrow = String.valueOf((page.getNowPage() - 1) * page.getPageSize());
// 结束下标
String endrow = String.valueOf(page.getNowPage() * page.getPageSize());
pageSql.append("SELECT * FROM ( SELECT TEMP.*, ROWNUM ROW_ID FROM (");
pageSql.append(sql);
pageSql.append(" ORDER BY " + (page.getOrderColumn()).toUpperCase() + " " + page.getOrderTurn());
pageSql.append(" ) TEMP WHERE ROWNUM <= ").append(endrow);
pageSql.append(") WHERE ROW_ID > ").append(beginrow);
// pageSql.append(" ORDER BY " + (page.getOrderColumn()).toUpperCase() +
// " " + page.getOrderTurn());
return pageSql;
}

*//**
 * mysql的分页语句
 * 
 * @param sql
 * @param page
 * @return
 */
/*
public StringBuilder buildPageSqlForMySql(String sql, Page page) {
StringBuilder pageSql = new StringBuilder(100);
// 起始下标
String beginrow = String.valueOf((page.getNowPage() - 1) * page.getPageSize());
pageSql.append(sql);
pageSql.append(" limit " + beginrow + "," + page.getPageSize());
return pageSql;
}

@Override
public Object plugin(Object target) {
// 当目标类是StatementHandler类型时，才包装目标类，
// 否则直接返回目标本身，减少目标被代理的次数
if (target instanceof StatementHandler) {
	return Plugin.wrap(target, this);
} else {
	return target;
}
}

@Override
public void setProperties(Properties properties) {
// TODO Auto-generated method stub
}
}
*/