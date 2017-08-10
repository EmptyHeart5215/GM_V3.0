package com.dykj.GSM.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.Log;
import com.dykj.GSM.service.sys.SysLogService;

/**
 * 消息发送拦截器，拦截各版块中需要发消息的方法
 * @author HotStrong
 * 
 */
@Component
@Aspect

public class LogAspect {
	
	@Autowired
	private SysLogService logService;
	@Autowired  
	HttpServletRequest request;
	 AddressUtils addressUtils = new AddressUtils();
	
	/**
	 * 添加业务逻辑方法切入点
	 * @Pointcut("execution(* com.dykj.supervision.service.sys.RUsersServiceImpl.*login(..))")
	 */
    @Pointcut("execution(* com.dykj.GSM.service.*.insert(..))")
    public void insertServiceCall() { }
    
    /**
	 * 修改业务逻辑方法切入点
	 */
    @Pointcut("execution(* com.dykj.GSM.service.*.update(..))")
    public void updateServiceCall() { }
    
    /**
	 * 删除业务逻辑方法切入点
	 */
    @Pointcut("execution(* com.dykj.GSM.service.*.deleteBatch(..))")
    public void deleteFilmCall() { }
    
    /**
     * 管理员添加操作日志(后置通知)
     * @param joinPoint
     * @param rtv
     * @throws Throwable
     */                    
	@AfterReturning(value="insertServiceCall()", argNames="rtv", returning="rtv")
    public void insertServiceCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable{
		        String userIp = NetworkUtil.getIpAddress(request);
		        String userAddress = addressUtils.getAddresses("ip="+userIp, "utf-8");
		        //判断参数
				if(joinPoint.getArgs() == null){//没有参数
					return;
				}
				SessionModel session = MySession.getInfo();
				String className = joinPoint.getArgs()[0].getClass().getName();
				className = className.substring(className.lastIndexOf(".") + 1);
				
				//获取操作内容
				Map<String, Object> opContent = adminOptionContent(joinPoint.getArgs());
				String logs = opContent.toString();
				Map<String, Object> zhi = (Map<String, Object>) opContent.get("值");
				 Log log = new Log();
				   log.setCreateBy(session.getCode());
				   log.setAfterLog(logs);
				   log.setOperation("添加");
				   log.setShuJu((String)zhi.get("getCode"));
				   log.setShuJuType(className);
				   log.setUserIp(userIp);
				   log.setUserAddress(userAddress);
				   logService.log(log);
		}
	
	 /**
     * 修改操作日志(环绕通知)使用环绕通知的目的是
     * 在数据被修改前可以先查询出数据信息用于日志记录
     * @param joinPoint
     * @param rtv
     * @throws Throwable
     */
    @Around(value="updateServiceCall()", argNames="rtv")
    public Object updateServiceCallCalls(ProceedingJoinPoint pjp) throws Throwable{
    	        String userIp = NetworkUtil.getIpAddress(request);
    	        String userAddress = addressUtils.getAddresses("ip="+userIp, "utf-8");
    	        //获取用户session
    			SessionModel session = MySession.getInfo();
    			Object result = null;
    			//获取操作之后Map
    			Map<String, Object> afterlog =adminOptionContent(pjp.getArgs());
    	    	Map<String, Object> zhi = (Map<String, Object>) afterlog.get("值");
    	    	//获取Model
    			String className = pjp.getArgs()[0].getClass().getName();
    			className = className.substring(className.lastIndexOf(".") + 1);
    			String classNames = Utils.transformPropertyToColumn(className);
    			classNames = classNames.substring(1,classNames.length());
    			String beforLog;
    		    	List<Map<String, String>> aa = getmethd(pjp.getArgs()[0],true);
    		    	for(Map<String, String> ss : aa){
    		    		//查询修改之前数据
    		    		Map<String, Object> asdf = logService.queryByCode(ss.get("rsValue"), classNames);
    		    		//转化数据库CLOB数据
    		    		Map<String, Object> cpmap = new HashMap<String, Object>();
    		    		  Iterator<Entry<String, Object>> it = asdf.entrySet().iterator();
    		    		   while (it.hasNext()) {
    		    		    Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
    		    		    Object key = entry.getKey();
    		    		    Object value = entry.getValue();
    		    		    //如果是clob类型转换为string类型
    		    		    if(value!=null && value.getClass().getName().trim().equals("oracle.sql.CLOB")){
    		    		     cpmap.put(key.toString().toLowerCase(), ClobToString((Clob)value));
    		    		    }else{
    		    		     cpmap.put(key.toString().toLowerCase(), value);
    		    		    }
    		    		   }
    		    		   beforLog = cpmap.toString();
    		    		   String afterLogs = afterlog.toString();
    		    		   Log log = new Log();
    		    		   log.setCreateBy(session.getCode());
    		    		   log.setBeforLog(beforLog);
    		    		   log.setAfterLog(afterLogs);
    		    		   log.setOperation("修改");
    		    		   log.setShuJu((String)zhi.get("getCode"));
    		    		   log.setShuJuType(className);
    		    		   log.setUserIp(userIp);
    		    		   log.setUserAddress(userAddress);
    		    		   logService.log(log);
    		    	}
    	    	
    		    	//执行操作
    		    	result = pjp.proceed();
    		    	
    		     return result;
	}
	
	/**
     *  管理员删除操作日志(后置通知)
     * @param joinPoint
     * @param rtv
     * @throws Throwable
     */
	@AfterReturning(value="deleteFilmCall()", argNames="rtv", returning="rtv")
	public void deleteFilmCallCalls(JoinPoint joinPoint, Object rtv) throws Throwable {
		String userIp = NetworkUtil.getIpAddress(request);
		String userAddress = addressUtils.getAddresses("ip="+userIp, "utf-8");
		//判断参数
		if(joinPoint.getArgs() == null){//没有参数
			return;
		}
		SessionModel session = MySession.getInfo();
		String className = joinPoint.getTarget().getClass().getName();
		className = className.substring(className.lastIndexOf(".") + 1,className.length()-11);
		
		 Log log = new Log();
		   log.setCreateBy(session.getCode());
		   log.setOperation("删除");
		   log.setShuJu(joinPoint.getArgs()[0].toString());
		   log.setShuJuType(className);
		   log.setUserIp(userIp);
		   log.setUserAddress(userAddress);
		   logService.log(log);
	}
	
	/**
	 * 使用Java反射来获取被拦截方法(insert、update)的参数值，
	 * 将参数值拼接为操作内容
	 */
	public Map<String, Object> adminOptionContent(Object[] args) throws Exception{

		if (args == null) {
			return null;
		}
		Map<String, Object> rs = new HashMap<String, Object>();
		Map<String, Object> rr = new HashMap<String, Object>();
		String className = null;
		int index = 1;
		// 遍历参数对象
		for (Object info : args) {
			
			//获取对象类型
			className = info.getClass().getName();
			className = className.substring(className.lastIndexOf(".") + 1);
			rs.put("参数", index);
			rs.put("类型", className);
			for (Map<String,String> method : getmethd(info,false)) {
				rr.put( method.get("methodName"), method.get("rsValue"));
			}
			
			rs.put("值",rr);
			
			index++;
		}
		
		return rs;
	}
	public List<Map<String,String>> getmethd(Object info,Boolean isCode){
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		Method[] methods = info.getClass().getMethods();
		// 遍历方法，判断get方法
		for (Method method : methods) {
			
			String methodName = method.getName();
			// 判断是不是get方法
			if (methodName.indexOf("get") == -1) {// 不是get方法
				continue;// 不处理
			}
			if(isCode){
				if (methodName != "getCode") {// 不是get方法
					continue;// 不处理
				}
			}
			try {
			Object rsValue = null;
				// 调用get方法，获取返回值
				rsValue = method.invoke(info);
				
				if (rsValue == null) {//没有返回值
					continue;
				}
			Map<String, String> map = new HashMap<String, String>();
			String rsvalue = rsValue.toString();
			map.put("rsValue", rsvalue);
			map.put("methodName", methodName);
			list.add(map);
			} catch (Exception e) {
				continue;
			}
			
		}
		
		return list;
	}
	//转化CLOB为String
	 public String ClobToString(Clob clob) throws SQLException, IOException {
		 String reString = "";
		 Reader is = clob.getCharacterStream();// 得到流
		 BufferedReader br = new BufferedReader(is);
		 String s = br.readLine();
		 StringBuffer sb = new StringBuffer();
		 while (s != null) {// 执行循环将字符串全部取出付值给StringBuffer由StringBuffer转成STRING
		 sb.append(s);
		 s = br.readLine();
		 }
		 reString = sb.toString();
		 return reString;
		 }
	
}