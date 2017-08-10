package com.dykj.GSM.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Transient;

import com.dykj.GSM.annotation.MapperUrlAnnotion;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年4月25日 下午3:57:16 修改人： 修改日期： 类说明:
 */
@SuppressWarnings("unused")
public class TemplateJavaUtils {
	
	private Class clazz;

	// 公共部分

	/* 回车换行 */
	private static final String RT_1 = "\r\n";
	/* 回车还两行 */

	private static final String RT_2 = RT_1 + RT_1;
	/* 空格：空一格 */
	private static final String BLANK_1 = " ";
	/* 空格：空四格 */
	private static final String BLANK_4 = "    ";
	/* 空格：空八格 */
	private static final String BLANK_8 = BLANK_4 + BLANK_4;

	// 注释部分
	/* 作者关键字 */
	private static final String ANNOTATION_AUTHOR_PARAMTER = " @author 作者 :";
	/* 创建人 */
	private static String ANNOTATION_AUTHOR_NAME = "***";

	/* 创建作者连接 */
	private static final String ANNOTATION_AUTHOR = ANNOTATION_AUTHOR_PARAMTER + ANNOTATION_AUTHOR_NAME;
	/* 创建日期 */
	private static final String ANNOTATION_VERSION_PARAMTER = " @version 创建时间：" + DateFormatUtil.getStringDate();
	/* 修改人 */
	private static final String ANNOTATION_CHANGEPERSON = " 修改人：";
	/* 修改日期 */
	private static final String ANNOTATION_CHANGEDATE = " 修改日期：";
	/* 类说明 */
	private static final String ANNOTATION_CLAZZ = " 类说明:";

	private static final String ANNOTATION = "/**" + RT_1 + BLANK_1 + "*" + ANNOTATION_AUTHOR + RT_1 + BLANK_1 + "*"
			+ ANNOTATION_VERSION_PARAMTER + RT_1 + BLANK_1 + "*" + ANNOTATION_CHANGEPERSON + RT_1 + BLANK_1 + "*"
			+ ANNOTATION_CHANGEDATE + RT_1 + BLANK_1 + "*" + ANNOTATION_CLAZZ + RT_1 + BLANK_1 + "*/" + RT_1;

	// 输出文件地址

	// 默认包名

	/* Mapper接口包路径 */
	private static final String BEAN_URL = "com.dykj.GSM.model.";
	/* Mapper接口包路径 */
	private static final String MAPPER_URL = "com.dykj.GSM.mapper.";
	/* Mapper接口实现类包路径 */
	private static final String MAPPER_IMPL_URL = "com.dykj.GSM.mapper.default.impl";
	/* Service接口包路径 */
	private static final String SERVICE_URL = "com.dykj.GSM.service.";
	/* Service接口实现类包路径 */
	private static final String SERVICE_IMPL_URL = "com.dykj.GSM.service.default.impl";
	/* Action包路径 */
	private static final String ACTION_URL = "com.dykj.GSM.action.default";
	
	//生成文件地址
	private static final String MAPPER_PATH = "com/dykj/GSM/mapper";
	private static final String SERVICE_PATH = "com/dykj/GSM/service";

	// 必须类包名全路径
	/* Mapper接口必须包路径 */
	private static final String REQUIRED_MAPPER_URL = "com.dykj.GSM.mapper.IBaseMapper";
	/* Mapper接口实现类必须包路径 */
	private static final String REQUIRED_MAPPER_IMPL_URL = "com.dykj.GSM.mapper.BaseMapperImpl";
	/* Service接口必须包路径 */
	private static final String REQUIRED_SERVICE_URL = "com.dykj.GSM.service.IBaseService";

	// 相关导入包
	private static final String JAVA_LIST = "java.util.List";
	private static final String JAVA_MAP = "java.util.Map";
	private static final String JAVA_HASHMAP = "java.util.HashMap";
	private static final String SPRING_ANNOTATION_AUTOW = "org.springframework.beans.factory.annotation.Autowired";
	private static final String SPRING_ANNOTATION_TRANSACTIONAL = "org.springframework.transaction.annotation.Transactional";
	private static final String SPRING_ANNOTATION_SERVICE = "org.springframework.stereotype.Service";
	private static final String UTILS_PAGE = "com.dykj.GSM.mapper.support.Page";
	private static final String UTILS_DATEFORMATUTIL = "com.dykj.GSM.utils.DateFormatUtil";

	// action相关包路径
	private static final String JAVAX_VALID = "javax.validation.Valid";
	private static final String LOG4J = "org.apache.log4j.Logger";
	private static final String SPRING_BINDINGRESULT = "org.springframework.validation.BindingResult";
	private static final String SPRING_OBJECTERROR = "org.springframework.validation.ObjectError";
	private static final String SPRING_ANNOTATION_REQUESTMAPPING = "org.springframework.web.bind.annotation.RequestMapping";
	private static final String SPRING_ANNOTATION_RequestMethod = "org.springframework.web.bind.annotation.RequestMethod";
	private static final String SPRING_ANNOTATION_REQUESTPARAM = "org.springframework.web.bind.annotation.RequestParam";
	private static final String SPRING_ANNOTATION_RESTCONTROLLER = "org.springframework.web.bind.annotation.RestController";
	private static final String SPRING_MODELANDVIEW = "org.springframework.web.servlet.ModelAndView";
	private static final String ACTION_BASEACTION = "com.dykj.GSM.action.BaseAction";
	private static final String UTILS_ACTIONMESSAGE = "com.dykj.GSM.utils.ActionMessage";

	/**
	 * 创建mapper接口
	 * @author wangmingyuan
	 * @param modelName
	 * @param authorName
	 * @param packageUrl
	 * @return
	 * @throws Exception
	 */
	public String createMapperInterface(String modelName,String createType, String authorName, String packageUrl) throws Exception {
		StringBuffer sb = new StringBuffer();
		String[] packages = packageUrl.split("\\.");
		String clazzName = modelName+createType;
		
		String ANNOTATION = "/**" + RT_1 + BLANK_1 + "*" + ANNOTATION_AUTHOR_PARAMTER + authorName + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_VERSION_PARAMTER + RT_1 + BLANK_1 + "*" + ANNOTATION_CHANGEPERSON + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_CHANGEDATE + RT_1 + BLANK_1 + "*" + ANNOTATION_CLAZZ + RT_1 + BLANK_1 + "*/" + RT_1;
		/*--------------------------------------------------------------------------------------------------------------------*/
		sb.append("package " + MAPPER_URL + packageUrl + ";" + RT_1 + RT_1); // 包名路径
		sb.append("import"+BLANK_1 +REQUIRED_MAPPER_URL + ";" + RT_1); // IBaseMapper导入接口
		sb.append("import"+BLANK_1 +BEAN_URL + packages[0] + "." + modelName + ";" + RT_1); // 导入该实体包路径
		sb.append(RT_1);
		sb.append(ANNOTATION);
		sb.append("public interface" + BLANK_1 + clazzName + BLANK_1 + "extends" + BLANK_1 + "IBaseMapper<" + modelName
				+ "," + BLANK_1 + "String>");
		sb.append("{" + RT_2 + "}");

		return sb.toString();
	}
	
	public String createMapperInterfaceImpl(String modelName,String createType, String authorName, String packageUrl) throws Exception {
		StringBuffer sb = new StringBuffer();
		String[] packages = packageUrl.split("\\.");
		String clazzName = modelName+createType;
		String mapper = createType.substring(0, 6);
		String clazzMapperInterface = modelName+mapper;
		String clazzMapperInterfaceUrl = packageUrl.replace("impl", "mapperinterf");
		
		String ANNOTATION = "/**" + RT_1 + BLANK_1 + "*" + ANNOTATION_AUTHOR_PARAMTER + authorName + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_VERSION_PARAMTER + RT_1 + BLANK_1 + "*" + ANNOTATION_CHANGEPERSON + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_CHANGEDATE + RT_1 + BLANK_1 + "*" + ANNOTATION_CLAZZ + RT_1 + BLANK_1 + "*/" + RT_1;
		/*--------------------------------------------------------------------------------------------------------------------*/
		sb.append("package"+BLANK_1+MAPPER_URL+packageUrl+";"+RT_1 + RT_1);  // 包名路径
		sb.append("import"+BLANK_1 +REQUIRED_MAPPER_IMPL_URL+";" + RT_1);// 导入BaseMapperImpl
		sb.append("import"+BLANK_1 +MAPPER_URL +clazzMapperInterfaceUrl+"."+clazzMapperInterface+";"+ RT_1); //导入该类的实现接口
		sb.append("import"+BLANK_1 +BEAN_URL + packages[0] + "." + modelName + ";" + RT_1); // 导入该实体包路径
		sb.append(RT_1);
		sb.append(ANNOTATION);
        sb.append("public class"+BLANK_1+clazzName+BLANK_1+"extends"+BLANK_1+"BaseMapperImpl<"+modelName+",String>");
        sb.append(BLANK_1+"implements"+BLANK_1+clazzMapperInterface);
        sb.append("{" + RT_2 + "}");

		return sb.toString();
	}
	
	public String createMapperInterfaceFile(String packageUrl,String clazzName,String soundCode) throws Exception{
		packageUrl = packageUrl.replace(".", "/");
		String fileName= "E:/TS_GSM/GSM_V3.0/src/"+MAPPER_PATH+"/"+packageUrl;
		String fileName2 = "E:/TS_GSM/GSM_V3.0/src/"+MAPPER_PATH+"/"+packageUrl+"/"+clazzName+".java";
		String info = "初始化数据。。。";
		//System.out.println(fileName);
		//System.out.println(soundCode);
		File file = new File(fileName); //文件夹
		File file2 = new File(fileName2); //文件
		if(!file.isDirectory()){
			file.mkdir();
			return info = "该文件夹不存在，正在创建该文件夹及文件，请稍后在次点击生成文件按钮";
		}else{
			if(!file2.exists()){
				file2.createNewFile();
				FileWriter fw = new FileWriter(file2);
				fw.write(soundCode);
				
				fw.flush();
				fw.close();
				return info = "正在创建文件，请稍后。。。。。。";
			}else{
				return info = "当前文件已存在，此操作不可执行！";
			}
		}
		
	}
	
	//===========================================以上为生成Mapper接口以及实现类的方法==================================
	
	public String createServiceInterface(String modelName,String createType, String authorName, String packageUrl) throws Exception {
		StringBuffer sb = new StringBuffer();
		String[] packages = packageUrl.split("\\.");
		String clazzName = modelName+createType;
		
		String ANNOTATION = "/**" + RT_1 + BLANK_1 + "*" + ANNOTATION_AUTHOR_PARAMTER + authorName + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_VERSION_PARAMTER + RT_1 + BLANK_1 + "*" + ANNOTATION_CHANGEPERSON + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_CHANGEDATE + RT_1 + BLANK_1 + "*" + ANNOTATION_CLAZZ + RT_1 + BLANK_1 + "*/" + RT_1;
		/*--------------------------------------------------------------------------------------------------------------------*/
		sb.append("package " + SERVICE_URL + packageUrl + ";" + RT_1 + RT_1); // 包名路径
		sb.append("import"+BLANK_1 +REQUIRED_SERVICE_URL + ";" + RT_1); // IBaseMapper导入接口
		sb.append("import"+BLANK_1 +BEAN_URL + packages[0] + "." + modelName + ";" + RT_1); // 导入该实体包路径
		sb.append(RT_1);
		sb.append(ANNOTATION);
		sb.append("public interface" + BLANK_1 + clazzName + BLANK_1 + "extends" + BLANK_1 + "IBaseService<" + modelName
				+ "," + BLANK_1 + "String>");
		sb.append("{" + RT_2 + "}");

		return sb.toString();
	}
	
	/**
	 * 生成service实现类
	 * @author wangmingyuan
	 * @param modelName
	 * @param createType
	 * @param authorName
	 * @param packageUrl
	 * @return
	 * @throws Exception
	 */
	public String createServiceInterfaceImpl(String modelName,String createType, String authorName, String packageUrl) throws Exception {
		StringBuffer sb = new StringBuffer();
		String[] packages = packageUrl.split("\\.");
		String clazzName = modelName+createType;
		String clazzNameMapperImpl = modelName+"MapperImpl";
		String clazzNameMapperImplToLowe = clazzNameMapperImpl.substring(0, 1).toLowerCase()+clazzNameMapperImpl.substring(1);
		String modelNameInterface = modelName+"Service";
		String ANNOTATION = "/**" + RT_1 + BLANK_1 + "*" + ANNOTATION_AUTHOR_PARAMTER + authorName + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_VERSION_PARAMTER + RT_1 + BLANK_1 + "*" + ANNOTATION_CHANGEPERSON + RT_1 + BLANK_1 + "*"
				+ ANNOTATION_CHANGEDATE + RT_1 + BLANK_1 + "*" + ANNOTATION_CLAZZ + RT_1 + BLANK_1 + "*/" + RT_1;
		/*--------------------------------------------------------------------------------------------------------------------*/
		sb.append("package"+BLANK_1+SERVICE_URL+packageUrl+";"+RT_1 + RT_1);  // 包名路径
		sb.append("import"+BLANK_1+JAVA_LIST+";"+RT_1);
		sb.append("import"+BLANK_1+JAVA_MAP+";"+RT_2);
		
		sb.append("import"+BLANK_1+SPRING_ANNOTATION_AUTOW+";"+RT_1);
		sb.append("import"+BLANK_1+SPRING_ANNOTATION_SERVICE+";"+RT_1);
		sb.append("import"+BLANK_1+SPRING_ANNOTATION_TRANSACTIONAL+";"+RT_2);
		
		sb.append("import"+BLANK_1+UTILS_PAGE+";"+RT_1);
		sb.append("import"+BLANK_1+MAPPER_URL+packageUrl+"."+clazzNameMapperImpl+";"+RT_1);
		sb.append("import"+BLANK_1+BEAN_URL+packages[0]+"."+modelName+";"+RT_1);
		sb.append("import"+BLANK_1+SERVICE_URL+packages[0]+"."+modelNameInterface+";"+RT_1);
		sb.append("import"+BLANK_1+UTILS_DATEFORMATUTIL+";"+RT_2);
		sb.append(ANNOTATION);
		sb.append("@Service"+RT_1);
		sb.append("@Transactional(noRollbackFor = RuntimeException.class)"+RT_1);
		sb.append("public class"+BLANK_1+clazzName+BLANK_1+"implements"+BLANK_1+modelNameInterface+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+"@Autowired"+RT_1);
		sb.append(BLANK_4+"private"+BLANK_1+clazzNameMapperImpl+BLANK_1+clazzNameMapperImplToLowe+";");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public int insert("+modelName+" entity)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"entity.setCreateDate(DateFormatUtil.getStringDate());"+RT_1);
		sb.append(BLANK_4+BLANK_4+"entity.setCreateBy(\"000001\");"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"insert(entity);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public int update("+modelName+" entity)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"update(entity);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public int deletePk(String primaryKey)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"deletePk(primaryKey);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public"+BLANK_1+modelName+BLANK_1+"queryByKey(String primaryKey)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"queryByKey(primaryKey);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public"+BLANK_1+"List<"+modelName+">"+BLANK_1+"queryList()"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"queryList();"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public"+BLANK_1+"List<"+modelName+">"+BLANK_1+"queryListParam(Map param)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"queryListParam(param);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public"+BLANK_1+"List<"+modelName+">"+BLANK_1+"queryTListParam("+modelName+BLANK_1+BLANK_1+"param)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"queryTListParam(param);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public"+BLANK_1+"Page<"+modelName+">"+BLANK_1+"queryByParamPage(int page, int size, String sidx, String sord, "+modelName+BLANK_1+BLANK_1+"param)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"queryByParamPage(page, size, sidx, sord, param);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_2);
		sb.append(BLANK_4+"@Override"+RT_1);
		sb.append(BLANK_4+"public int deleteBatch(List<String> list)"+BLANK_1+"{"+RT_1);
		sb.append(BLANK_4+BLANK_4+"return"+BLANK_1+clazzNameMapperImplToLowe+"."+"deleteBatch(list);"+RT_1);
		sb.append(BLANK_4+"}");
		sb.append(RT_1);
		sb.append("}");

		return sb.toString();
	}
	
	public String createServiceInterfaceFile(String packageUrl,String clazzName,String soundCode) throws Exception{
		packageUrl = packageUrl.replace(".", "/");
		String fileName= "E:/TS_GSM/GSM_V3.0/src/"+SERVICE_PATH+"/"+packageUrl;
		String fileName2 = "E:/TS_GSM/GSM_V3.0/src/"+SERVICE_PATH+"/"+packageUrl+"/"+clazzName+".java";
		System.out.println(fileName+"----------"+fileName2);
		String info = "初始化数据。。。";
		//System.out.println(fileName);
		//System.out.println(soundCode);
		File file = new File(fileName); //文件夹
		File file2 = new File(fileName2); //文件
		if(!file.isDirectory()){
			file.mkdir();
			return info = "该文件夹不存在，正在创建该文件夹及文件，请稍后在次点击生成文件按钮";
		}else{
			if(!file2.exists()){
				file2.createNewFile();
				FileWriter fw = new FileWriter(file2);
				fw.write(soundCode);
				
				fw.flush();
				fw.close();
				return info = "正在创建文件，请稍后刷新项目目录。。。。。。";
			}else{
				return info = "当前文件已存在，此操作不可执行！";
			}
			
		}
		
	}
	
	//===========================================以上为生成Service接口以及实现类的方法==================================
	
	@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
	public String createMapperXmlInterfaceImpl(String modelName,String createType, String authorName, String packageUrl) throws Exception {
		
		StringBuffer sb = new StringBuffer();
		StringBuffer sbf = new StringBuffer();
		StringBuffer sbfTransient = new StringBuffer();
		StringBuffer column = new StringBuffer();
		
		String[] packages = packageUrl.split("\\.");
		String modelUrl = BEAN_URL+packages[0]+"."+modelName;
		Class entity = clazz.forName(modelUrl);
		String[] createTypes = createType.split("\\.");
		String classNameXml = modelName+createTypes[0];
		String columns = null;
		String columnTemp = null;
		
		Pattern p = Pattern.compile("[A-Z]");
		String tableName = modelName.substring(0, 1).toLowerCase() + modelName.substring(1);
		Matcher mt = p.matcher(tableName);
		while(mt.find()){
			String a = mt.group();
			tableName = tableName.replaceAll(a, "_"+a.toLowerCase());
		}
		tableName = tableName.toUpperCase();
		
		Field[] fields = entity.getDeclaredFields();
		Field[] fields2 = entity.getSuperclass().getDeclaredFields();
		
		for(Field f : fields){
			Annotation[] annotations = f.getAnnotations();
			for(Annotation annotation : annotations){
				if(annotation.annotationType() == Transient.class){
					sbfTransient.append(f.getName()+",");
				}
			}
			sbf.append(f.getName()+",");
		}
		
		//===============================================================
		
		sb.append("<?xml version=\"1.0\"  encoding=\"UTF-8\"?>"+RT_1);
		sb.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">"+RT_1);
		sb.append("<mapper namespace=\""+MAPPER_URL+packageUrl+"."+classNameXml+"\">"+RT_1);
		sb.append(BLANK_4+"<cache type=\"org.mybatis.caches.ehcache.LoggingEhcache\"/>"+RT_1);
		sb.append(BLANK_4+"<resultMap type=\""+modelName+"\" id=\""+modelName.substring(0, 1).toLowerCase()+modelName.substring(1)+"Result"+"\">"+RT_1);
		sb.append(BLANK_8+"<id column=\"CODE\" property=\"code\"/>"+RT_1);
		sb.append(BLANK_8+" <result column=\"CREATE_DATE\" jdbcType=\"VARCHAR\" property=\"createDate\" />"+RT_1);
		sb.append(BLANK_8+"<result column=\"CREATE_BY\" jdbcType=\"VARCHAR\" property=\"createBy\" />"+RT_1);
		sb.append(BLANK_8+"<result column=\"FLAG_DEL\" jdbcType=\"CHAR\" property=\"flagDel\" />"+RT_1);
		sb.append(BLANK_8+"<result column=\"FLAG_DISPLAY\" jdbcType=\"CHAR\" property=\"flagDisplay\" />"+RT_1);
		sb.append(BLANK_8+"<result column=\"SORT\" jdbcType=\"DECIMAL\" property=\"sort\" />"+RT_1);
		sb.append(BLANK_8+"<result column=\"REMARK\" jdbcType=\"VARCHAR\" property=\"remark\" />"+RT_1);
		String[] modelFields = sbf.toString().split(",");
		// 正则初始化
		
		for(int i = 0;i<modelFields.length;i++){
			columnTemp = modelFields[i];
			columnTemp = columnTemp.substring(0, 1).toLowerCase() + columnTemp.substring(1);
			 mt = p.matcher(columnTemp);
			while(mt.find()){
				String a = mt.group();
				columnTemp = columnTemp.replaceAll(a, "_"+a.toLowerCase());
			}
			columnTemp = columnTemp.toUpperCase();
			column.append(columnTemp+",");
			columns = column.toString().substring(column.length()-1);
			sb.append(BLANK_8+"<result column=\""+columnTemp+"\""+BLANK_1+"jdbcType=\"VARCHAR\""+BLANK_1+"property=\""+modelFields[i]+"\""+BLANK_1+"/>"+RT_1);
		}
		sb.append(BLANK_4+"</resultMap>"+RT_2);
		sb.append(BLANK_4+"<!-- 保存实体对象  -->"+RT_1);
		sb.append(BLANK_4+"<!-- keyProperty	selectKey 语句结果应该被设置的目标属性。  -->"+RT_1);
		sb.append(BLANK_4+"<!-- resultType	结果的类型。MyBatis 通常可以算出来,但是写上也没有问题。MyBatis 允许任何简单类型用作主键的类型,包括字符串。 -->"+RT_1);
		sb.append(BLANK_4+"<!-- order	这可以被设置为 BEFORE 或 AFTER。如果设置为 BEFORE,那么它会首先选择主键,设置 keyProperty 然后执行插入语句。"+RT_1);
		sb.append(BLANK_4+"如果设置为 AFTER,那么先执行插入语句,然后是 selectKey 元素-这和如 Oracle 数据库相似,可以在插入语句中嵌入序列调用。 -->"+RT_1);
		sb.append(BLANK_4+"<!-- statementType	和前面的相 同,MyBatis 支持 STATEMENT ,PREPARED 和CALLABLE 语句的映射类型,分别代表 PreparedStatement和CallableStatement 类型。 -->"+RT_1);
		sb.append(BLANK_4+"<insert id=\"insert\" parameterType=\""+modelName+"\">"+RT_1);
		sb.append(BLANK_8+"<selectKey keyProperty=\"code\" resultType=\"String\" order=\"BEFORE\">"+RT_1);
		sb.append(BLANK_8+BLANK_4+"SELECT SYS_GUID() FROM DUAL"+RT_1);
		sb.append(BLANK_8+"</selectKey>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"INSERT INTO"+BLANK_1+tableName+RT_1);
		sb.append(BLANK_8+BLANK_1+BLANK_1+BLANK_1+BLANK_8+"(CODE,CREATE_DATE,CREATE_BY,SORT,REMARK,"+RT_1);
		for(int i = 0;i<modelFields.length;i++){
			columnTemp = modelFields[i];
			columnTemp = columnTemp.substring(0, 1).toLowerCase() + columnTemp.substring(1);
			 mt = p.matcher(columnTemp);
			while(mt.find()){
				String a = mt.group();
				columnTemp = columnTemp.replaceAll(a, "_"+a.toLowerCase());
			}
			columnTemp = columnTemp.toUpperCase();
			if(i== 0){
				sb.append(BLANK_8+BLANK_4+BLANK_8+columnTemp+",");
			}else{
				if(i%4 == 0){
					sb.append(BLANK_8+BLANK_4+BLANK_8+columnTemp+",");
				}else if(i%4 == 3){
					sb.append(columnTemp+","+RT_1);
				}else{
					sb.append(columnTemp+",");
				}
			}
			
		}
		sb.append(")"+RT_1);
		sb.append(BLANK_8+BLANK_4+"VALUES"+BLANK_1+" (#{code,jdbcType=VARCHAR}, #{createDate,jdbcType=VARCHAR}, #{createBy,jdbcType=VARCHAR},"+RT_1);
		sb.append(BLANK_8+BLANK_4+BLANK_1+BLANK_8+"#{sort,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR},");
		for(int i = 0;i<modelFields.length;i++){
			if(i== 0){
				sb.append("#{"+modelFields[i]+",jdbcType=VARCHAR},"+RT_1);
			}else{
				if(i%3 == 1){
					sb.append(BLANK_8+BLANK_4+BLANK_1+BLANK_8+"#{"+modelFields[i]+",jdbcType=VARCHAR},");
				}else if(i%3 == 0){
					sb.append("#{"+modelFields[i]+",jdbcType=VARCHAR},"+RT_1);
				}else{
					sb.append("#{"+modelFields[i]+",jdbcType=VARCHAR},");
				}
			}
			
		}
		sb.append(")"+RT_1);
		sb.append(BLANK_4+"</insert>"+RT_2);
		sb.append(BLANK_4+" <!-- 更新实体对象   -->"+RT_1);
		sb.append(BLANK_4+"<update id=\"update\" parameterType=\""+modelName+"\">"+RT_1);
		sb.append(BLANK_8+"UPDATE"+BLANK_1+tableName+RT_1);
		sb.append(BLANK_8+"<set>"+RT_1);
		for(int i = 0;i<modelFields.length;i++){
			columnTemp = modelFields[i];
			columnTemp = columnTemp.substring(0, 1).toLowerCase() + columnTemp.substring(1);
			 mt = p.matcher(columnTemp);
			while(mt.find()){
				String a = mt.group();
				columnTemp = columnTemp.replaceAll(a, "_"+a.toLowerCase());
			}
			columnTemp = columnTemp.toUpperCase();
			sb.append(BLANK_8+BLANK_4+"<if test=\""+modelFields[i]+" != null and "+modelFields[i]+" != ''\">"+RT_1);
			sb.append(BLANK_8+BLANK_8+columnTemp+BLANK_1+"="+BLANK_1+"#{"+modelFields[i]+",jdbcType=VARCHAR},"+RT_1);
			sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		}
		sb.append(BLANK_8+"</set>"+RT_1);
		sb.append(BLANK_8+"<where>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"code != null and code != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"CODE = #{code,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+"</where>"+RT_1);
		sb.append(BLANK_4+"</update>"+RT_2);
		sb.append(BLANK_4+"<!-- 根据主键删除实体对象(为假删，规定：0为显示，1为删除) -->"+RT_1);
		sb.append(BLANK_4+" <update id=\"deletePk\" parameterType=\"String\">"+RT_1);
		sb.append(BLANK_8+"UPDATE "+tableName+" SET FLAG_DEL=1 WHERE CODE=#{code}"+RT_1);
		sb.append(BLANK_4+"</update>"+RT_2);
		sb.append(BLANK_4+"<!-- 批量删除(为假删，规定：0为显示，1为删除) ，预留接口，但不对其实现功能-->"+RT_1);
		sb.append(BLANK_4+"<update id=\"deleteBatch\">"+RT_1);
		sb.append(BLANK_8+"UPDATE "+tableName+" SET FLAG_DEL=1 WHERE CODE IN "+RT_1);
		sb.append(BLANK_8+"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<foreach collection=\"list\" item=\"code\" separator=\",\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"#{code}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</foreach>"+RT_1);
		sb.append(BLANK_8+"</trim>"+RT_1);
		sb.append(BLANK_4+"</update>"+RT_2);
		sb.append(BLANK_4+"<!-- 根据主键查询实体对象  -->"+RT_1);
		sb.append(BLANK_4+"<select id=\"queryByKey\" parameterType=\"String\" resultMap=\""+modelName.substring(0, 1).toLowerCase()+modelName.substring(1)+"Result"+"\">"+RT_1);
		sb.append(BLANK_8+"SELECT * FROM "+tableName+" WHERE FLAG_DEL != 1 AND CODE=#{code}"+RT_1);
		sb.append(BLANK_4+"</select>"+RT_2);
		sb.append(BLANK_4+"<!-- 查询所有实体对象集合  -->"+RT_1);
		sb.append(BLANK_4+"<select id=\"queryList\" resultMap=\""+modelName.substring(0, 1).toLowerCase()+modelName.substring(1)+"Result"+"\">"+RT_1);
		sb.append(BLANK_8+"SELECT * FROM "+tableName+" where FLAG_DEL !=1 ORDER BY CODE ASC "+RT_1);
		sb.append(BLANK_4+"</select>"+RT_2);
		sb.append(BLANK_4+"<!-- 根据条件查询所有实体对象集合  -->"+RT_1);
		sb.append(BLANK_4+"<select id=\"queryListParam\" parameterType=\""+modelName+"\" resultMap=\""+modelName.substring(0, 1).toLowerCase()+modelName.substring(1)+"Result"+"\">"+RT_1);
		sb.append(BLANK_8+"SELECT * FROM"+BLANK_1+tableName+BLANK_1+RT_1);
		sb.append(BLANK_8+"<where>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"FLAG_DEL != 1"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"createDate != null and createDate != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"CREATE_DATE = #{createDate,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"createBy != null and createBy != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND CREATE_BY = #{createBy,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"flagDel != null and flagDel != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND FLAG_DEL = #{flagDel,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"flagDisplay != null and flagDisplay != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND FLAG_DISPLAY = #{flagDisplay,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"sort != null and sort != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND SORT = #{sort,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"remark != null and remark != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND REMARK = #{remark,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		for(int i = 0;i<modelFields.length;i++){
			columnTemp = modelFields[i];
			columnTemp = columnTemp.substring(0, 1).toLowerCase() + columnTemp.substring(1);
			 mt = p.matcher(columnTemp);
			while(mt.find()){
				String a = mt.group();
				columnTemp = columnTemp.replaceAll(a, "_"+a.toLowerCase());
			}
			columnTemp = columnTemp.toUpperCase();
			sb.append(BLANK_8+BLANK_4+"<if test=\""+modelFields[i]+" != null and "+modelFields[i]+" != ''\">"+RT_1);
			sb.append(BLANK_8+BLANK_8+"AND"+BLANK_1+columnTemp+BLANK_1+"="+BLANK_1+"#{"+modelFields[i]+",jdbcType=VARCHAR}"+RT_1);
			sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		}
		sb.append(BLANK_8+"</where>"+RT_1);
		sb.append(BLANK_4+"</select>"+RT_2);
		sb.append(BLANK_4+"<!-- 分页查询,所有实体对象集合  -->"+RT_1);
		sb.append(BLANK_4+"<select useCache=\"true\" id=\"queryParamPage\" parameterType=\""+modelName+"\" resultMap=\""+modelName.substring(0, 1).toLowerCase()+modelName.substring(1)+"Result"+"\">"+RT_1);
		sb.append(BLANK_8+"SELECT * FROM "+tableName+RT_1);
		sb.append(BLANK_8+"<where>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"FLAG_DEL != 1"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"createDate != null and createDate != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"CREATE_DATE = #{createDate,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"createBy != null and createBy != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND CREATE_BY = #{createBy,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"flagDel != null and flagDel != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND FLAG_DEL = #{flagDel,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"flagDisplay != null and flagDisplay != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND FLAG_DISPLAY = #{flagDisplay,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"sort != null and sort != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND SORT = #{sort,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"remark != null and remark != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND REMARK = #{remark,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		for(int i = 0;i<modelFields.length;i++){
			columnTemp = modelFields[i];
			columnTemp = columnTemp.substring(0, 1).toLowerCase() + columnTemp.substring(1);
			 mt = p.matcher(columnTemp);
			while(mt.find()){
				String a = mt.group();
				columnTemp = columnTemp.replaceAll(a, "_"+a.toLowerCase());
			}
			columnTemp = columnTemp.toUpperCase();
			sb.append(BLANK_8+BLANK_4+"<if test=\""+modelFields[i]+" != null and "+modelFields[i]+" != ''\">"+RT_1);
			sb.append(BLANK_8+BLANK_8+"AND"+BLANK_1+columnTemp+BLANK_1+"="+BLANK_1+"#{"+modelFields[i]+",jdbcType=VARCHAR}"+RT_1);
			sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		}
		sb.append(BLANK_8+"</where>"+RT_1);
		sb.append(BLANK_4+"</select>"+RT_2);
		sb.append(BLANK_4+"<!--  查询总记录数据  -->"+RT_1);
		sb.append(BLANK_4+"<select id=\"queryAllCount\"  resultType=\"Integer\">"+RT_1);
		sb.append(BLANK_8+"SELECT COUNT(*) C FROM "+tableName+" WHERE FLAG_DEL != 1"+RT_1);
		sb.append(BLANK_4+"</select>"+RT_2);
		sb.append(BLANK_4+"<!--  查询总记录数据  -->"+RT_1);
		sb.append(BLANK_4+"<select id=\"queryAllCountParam\" parameterType=\""+modelName+"\" resultType=\"Integer\">"+RT_1);
		sb.append(BLANK_8+"SELECT COUNT(*) C FROM "+tableName+BLANK_1+RT_1);
		sb.append(BLANK_8+"<where>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"FLAG_DEL != 1"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"createDate != null and createDate != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"CREATE_DATE = #{createDate,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"createBy != null and createBy != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND CREATE_BY = #{createBy,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"flagDel != null and flagDel != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND FLAG_DEL = #{flagDel,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"flagDisplay != null and flagDisplay != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND FLAG_DISPLAY = #{flagDisplay,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"sort != null and sort != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND SORT = #{sort,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		sb.append(BLANK_8+BLANK_4+"<if test=\"remark != null and remark != ''\">"+RT_1);
		sb.append(BLANK_8+BLANK_8+"AND REMARK = #{remark,jdbcType=VARCHAR}"+RT_1);
		sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		for(int i = 0;i<modelFields.length;i++){
			columnTemp = modelFields[i];
			columnTemp = columnTemp.substring(0, 1).toLowerCase() + columnTemp.substring(1);
			 mt = p.matcher(columnTemp);
			while(mt.find()){
				String a = mt.group();
				columnTemp = columnTemp.replaceAll(a, "_"+a.toLowerCase());
			}
			columnTemp = columnTemp.toUpperCase();
			sb.append(BLANK_8+BLANK_4+"<if test=\""+modelFields[i]+" != null and "+modelFields[i]+" != ''\">"+RT_1);
			sb.append(BLANK_8+BLANK_8+"AND"+BLANK_1+columnTemp+BLANK_1+"="+BLANK_1+"#{"+modelFields[i]+",jdbcType=VARCHAR}"+RT_1);
			sb.append(BLANK_8+BLANK_4+"</if>"+RT_1);
		}
		sb.append(BLANK_8+"</where>"+RT_1);
		sb.append(BLANK_4+"</select>"+RT_1);
		sb.append("</mapper>");
		return sb.toString();
	}
	
	public String createMapperXmlFile(String packageUrl,String clazzName,String soundCode) throws Exception{
		packageUrl = packageUrl.replace(".", "/");
		String[] packages = packageUrl.split("\\.");
		String fileName= "E:/TS_GSM/GSM_V3.0/src/"+MAPPER_PATH+"/"+packages[0];
		String fileName2 = "E:/TS_GSM/GSM_V3.0/src/"+MAPPER_PATH+"/"+packageUrl+"/"+clazzName;
		System.out.println(fileName+"----------"+fileName2);
		String info = "初始化数据。。。";
		//System.out.println(fileName);
		//System.out.println(soundCode);
		File file = new File(fileName); //文件夹
		File file2 = new File(fileName2); //文件
		if(!file.isDirectory()){
			file.mkdir();
			return info = "该文件夹不存在，正在创建该文件夹及文件，请稍后在次点击生成文件按钮";
		}else{
			if(!file2.exists()){
				file2.createNewFile();
				FileWriter fw = new FileWriter(file2);
				fw.write(soundCode);
				
				fw.flush();
				fw.close();
				return info = "正在创建文件，请稍后刷新项目目录。。。。。。";
			}else{
				return info = "当前文件已存在，此操作不可执行！";
			}
			
		}
	}
	
}
