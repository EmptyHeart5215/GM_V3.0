package com.dykj.GSM.action.sys;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;

@RestController
@RequestMapping(value = "/sys/security")
public class SysSecurityAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysSeatGridAction.class);

	@RequestMapping(value = "/accessDenied")
	public ModelAndView accessDenied(HttpServletRequest request) {
		return new ModelAndView("accessDenied");
	}

	@RequestMapping(value = "/loginTimeout")
	public ModelAndView loginTimeout(HttpServletRequest request) {
		return new ModelAndView("loginTimeout");
	}
}
