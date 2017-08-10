package com.dykj.GSM.action.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.sys.SysEvaSet;
import com.dykj.GSM.model.sys.SysEvaSetDepartment;
import com.dykj.GSM.service.sys.SysEvaSetDepartmentService;
import com.dykj.GSM.service.sys.SysEvaSetService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/evaset")
public class SysEvaSetAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysEvaSetAction.class);
	@Autowired
	private SysEvaSetService sysEvaSetService;
	@Autowired
	private SysEvaSetDepartmentService sysEvaSetDepartmentService;

	@RequestMapping(value = "/evaSetLoad")
	public ModelAndView evaSetLoad() {
		SysEvaSet vdata = null;
		try {
			vdata = sysEvaSetService.queryOne();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return new ModelAndView("sys/evaset/evaset", "vdata", vdata);
	}

	@RequestMapping(value = "/evaSet")
	public ActionMessage evaSet(@Valid SysEvaSet evaSet, BindingResult result, HttpServletRequest request) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				evaSet.setCreateBy(MySession.getInfo().getCode());
				int i = sysEvaSetService.insert(evaSet);
				if (i <= 0) {
					throw new Exception("系统异常，请稍后再试！");
				}
				return new ActionMessage(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	@RequestMapping(value = "/evaSetDepartmentLoad")
	public ModelAndView evaSetDepartmentLoad() {
		SysEvaSetDepartment vdata = null;
		try {
			vdata = sysEvaSetDepartmentService.queryOne();
		} catch (Exception e) {
			logger.error(e);
			e.printStackTrace();
		}
		return new ModelAndView("sys/evaset/evasetdepartment", "vdata", vdata);
	}

	@RequestMapping(value = "/evaSetDepartment")
	public ActionMessage evaSetDepartment(@Valid SysEvaSetDepartment evaSetDepartment, BindingResult result,
			HttpServletRequest request) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				evaSetDepartment.setCreateBy(MySession.getInfo().getCode());
				int i = sysEvaSetDepartmentService.insert(evaSetDepartment);
				if (i <= 0) {
					throw new Exception("系统异常，请稍后再试！");
				}
				return new ActionMessage(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}
}
