package com.dykj.GSM.action;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.TemplateJavaUtils;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年4月25日 上午10:55:49
* 修改人：
* 修改日期：
* 类说明:
*/
@RestController
@RequestMapping(value = "/codegenerationplatform")
public class CodeGenerationPlatformAction {
	
	private TemplateJavaUtils templateJavaUtils = new TemplateJavaUtils();
	
	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "codegenerationplatform/createCode");
		vdata.put("url1", "codegenerationplatform/createCodeFile");
		return new ModelAndView("/codegenerationplatform","vdata",vdata);
	}
	
	/**
	 * 修改
	 * @param <T>
	 * 
	 * @param building
	 * @return @
	 */
	@RequestMapping(value = "/createCode",produces="text/html;charset=UTF-8")
	public String createCode(String modelName,String createType,String authorName,String packageUrl) {
		String temp = null;
		if(createType!=""){
			if(createType.equals("Mapper")){ //生成Mapper接口
				try {
					temp = templateJavaUtils.createMapperInterface(modelName, createType, authorName, packageUrl);
					System.out.println(temp);
					return temp;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}else if(createType.equals("MapperImpl")){ // 生成MapperImpl实现类
				try {
					temp = templateJavaUtils.createMapperInterfaceImpl(modelName, createType, authorName, packageUrl);
					System.out.println(temp);
					return temp;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}else if(createType.equals("Service")){ // 生成MapperImpl实现类
				try {
					temp = templateJavaUtils.createServiceInterface(modelName, createType, authorName, packageUrl);
					return temp;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}else if(createType.equals("ServiceImpl")){ // 生成MapperImpl实现类
				try {
					temp = templateJavaUtils.createServiceInterfaceImpl(modelName, createType, authorName, packageUrl);
					return temp;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}else if(createType.equals("Mapper.xml")){ // 生成MapperImpl实现类
				try {
					temp = templateJavaUtils.createMapperXmlInterfaceImpl(modelName, createType, authorName, packageUrl);
					return temp;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
			}
			return temp;
		}else{
			return "生成出错！！";
		}
		
	} 
	
	@RequestMapping(value = "/createCodeFile",produces="text/html;charset=UTF-8")
	public String createCodeFile(String modelName,String createType,String authorName,String packageUrl,String soundCode) throws Exception {
		String clazzName = modelName+createType;
		String info = null;
		/*try {
			if (templateJavaUtils.createMapperInterfaceFile(packageUrl, clazzName) > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("没有成功插入数据!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}*/
		
		if(createType!=""){
			if(createType.equals("Mapper")||createType.equals("MapperImpl")){
				return info = templateJavaUtils.createMapperInterfaceFile(packageUrl, clazzName,soundCode);
			}else if(createType.equals("Service")||createType.equals("ServiceImpl")){
				return info = templateJavaUtils.createServiceInterfaceFile(packageUrl, clazzName, soundCode);
			}else if(createType.equals("Mapper.xml")){
				return info = templateJavaUtils.createMapperXmlFile(packageUrl, clazzName, soundCode);
			}
		}
		
		return info;
		
	}

}
