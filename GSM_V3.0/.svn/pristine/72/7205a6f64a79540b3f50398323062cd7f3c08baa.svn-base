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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysDicValue;
import com.dykj.GSM.service.sys.SysDicValueService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/dicvalue")
public class SysDicValueAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysDicValueAction.class);
	@Autowired
	private SysDicValueService dicService;

	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad(@RequestParam String sysDicCode) {
		return new ModelAndView("/sys/dicvalue/manage", "sysDicCode", sysDicCode);
	}

	/**
	 * 根据自定义的ztreeGird规范，查询对应数据，返回list集合给ztree控件显示为树形菜单
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryDicValueTree")
	public List<SysDicValue> queryDicValueTree(@RequestParam String sysDicCode) {
		return dicService.queryListParams(sysDicCode);
	}

	/**
	 * 新增页面加载
	 * 
	 * @param sysDicCode
	 *            字典code
	 * @param code
	 *            父节点code
	 * @return
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad(String sysDicCode, String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "sys/dicvalue/add");
		vdata.put("sysDicCode", sysDicCode);
		vdata.put("parentCode", code);
		try {
			if (code != null && !"0000".equals(code)) {
				vdata.put("parentName", dicService.queryByKey(code).getDicValue());
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("/sys/dicvalue/info", "vdata", vdata);
	}

	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysDicValue sysdicvalue, BindingResult result) {
		System.out.println(sysdicvalue.getDicValue());
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				SessionModel session = MySession.getInfo();
				sysdicvalue.setCreateBy(session.getCode());
				if (dicService.insertWithCheck(sysdicvalue) != 0) {
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
	 * @param sysDicCode
	 *            字典code
	 * @param code
	 *            字典值code
	 * @return
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String sysDicCode, @RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			SysDicValue dicValue1 = dicService.queryByKey(code);
			vdata.put("sysDicValue", dicValue1);
			vdata.put("url", "sys/dicvalue/modify");
			vdata.put("sysDicCode", sysDicCode);
			vdata.put("parentCode", dicValue1.getParentCode());
			if (dicValue1.getParentCode() != null && !"0000".equals(dicValue1.getParentCode())) {
				vdata.put("parentName", dicValue1.getTotalName().replace("-" + dicValue1.getDicValue(), ""));
			}
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/dicvalue/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysdicvalue
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysDicValue sysDicValue) {
		try {
			SessionModel session = MySession.getInfo();
			sysDicValue.setCreateBy(session.getCode());
			if (dicService.updateWithCheck(sysDicValue) != 0) {
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

	/**
	 * 删除
	 * 
	 * @param codes
	 * @return @
	 */
	@RequestMapping(value = "/delete")
	public ActionMessage delete(@RequestParam String codes) {
		try {
			if (dicService.deletePk(codes) != 0) {
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

	/**
	 * 对外接口
	 * 
	 * @param codes
	 * @return @
	 */
	@RequestMapping(value = "/queryManageTree")
	public List<Map<String, Object>> queryGridTree(String name_dic) {
		return dicService.queryManageTree(name_dic);
	}
}
