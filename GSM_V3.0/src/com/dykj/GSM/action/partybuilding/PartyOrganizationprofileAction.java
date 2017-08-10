package com.dykj.GSM.action.partybuilding;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;

@RestController
@RequestMapping(value = "/partybuilding/organizationprofile")
public class PartyOrganizationprofileAction extends BaseAction{
	
	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/partybuilding/organizationprofile/manage");
	}

}
