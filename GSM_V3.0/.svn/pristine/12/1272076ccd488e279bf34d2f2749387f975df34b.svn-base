package com.dykj.GSM.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.sys.SysDic;
import com.dykj.GSM.service.sys.SysDicService;
import com.dykj.GSM.utils.ActionMessage;

@RestController
@RequestMapping(value = "/sys/dic")
public class SysDicAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysDicAction.class);
	@Autowired
	private  SysDicService dicService;
	public static List<SysDic> tempList;
	private int tempI;
	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/dic/manage");
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页函数
	 * @param sidx
	 *            排序字段
	 * @param sord
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据 @
	 */
	
	@RequestMapping(value = "/queryManage")
	public Object queryByParamPage(int page, int rows, String sidx, String sord, SysDic param) {
		try {
			
			return dicService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "sys/dic/add");
		return new ModelAndView("/sys/dic/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysdic
	 * @return @
	 */
	
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysDic sysdic, BindingResult result) {

		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				
				if (dicService.insert(sysdic) != 0) {
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ActionMessage(false).setinfo(e.getMessage());
		}

	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return @
	 */
	
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			SysDic dic = dicService.queryByKey(code);
			vdata.put("url", "sys/dic/modify");
			vdata.put("sysDic", dic);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/dic/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysdic
	 * @return @
	 */
	
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysDic sysdic) throws Exception {
		try {
			if (dicService.update(sysdic) != 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		System.out.println(codes);
		try {
			if (dicService.deleteBatch(codes) != 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

}
