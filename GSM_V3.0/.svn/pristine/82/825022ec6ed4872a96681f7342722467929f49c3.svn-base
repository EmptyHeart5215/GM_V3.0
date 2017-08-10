package com.dykj.GSM.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatThird;
import com.dykj.GSM.service.sys.SysSeatFourService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/seatfour")
public class SysSeatFourAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysSeatFourAction.class);
	@Autowired
	private SysSeatFourService sysSeatFourService;

	/**
	 * 新增页面的加载
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView fourAddLoad(@RequestParam String parentCode, HttpServletResponse response,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "/sys/seatfour/add");
		map.put("parentCode", parentCode);
		return new ModelAndView("sys/seatfour/fourinfo", "map", map);
	}

	/**
	 * 新增
	 * 
	 * @param seatFour
	 * @return @
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysSeatFour seatFour, BindingResult result) {
		SessionModel session = MySession.getInfo();
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				SysSeatThird sysSeatThird = sysSeatFourService.queryByparentCode(seatFour.getParentCode());
				seatFour.setThirdName(sysSeatThird.getName());
				seatFour.setCreateBy(session.getCode());
				seatFour.setGridTotalName(sysSeatThird.getGridTotalName() + "-" + seatFour.getName());
				if (sysSeatFourService.insert(seatFour) != 0) {
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
	 * 修改页面的加载
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView fourModifyLoad(@RequestParam String code, HttpServletResponse response,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatFour sysSeatFour = sysSeatFourService.queryByKey(code);
			map.put("url", "/sys/seatfour/modify");
			map.put("seat", sysSeatFour);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/seatfour/fourinfo", "map", map);
	}

	/**
	 * 修改
	 * 
	 * @param seatFour
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysSeatFour seatfour, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				SysSeatThird sysSeatThird = sysSeatFourService.queryByparentCode(seatfour.getParentCode());
				seatfour.setThirdName(sysSeatThird.getName());
				seatfour.setGridTotalName(sysSeatThird.getGridTotalName() + "-" + seatfour.getName());
				if (sysSeatFourService.update(seatfour) != 0) {
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
				}
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	/**
	 * 新增组织机构页面的加载
	 */
	@RequestMapping(value = "/addOrgLoad")
	public ModelAndView addOrgLoad(@RequestParam String parentCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "/sys/seatfour/add");
		map.put("parentCode", parentCode);
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}

	/**
	 * 修改页面的加载
	 */
	@RequestMapping(value = "/modifyOrgLoad")
	public ModelAndView modifyOrgLoad(@RequestParam String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatFour sysSeatFour = sysSeatFourService.queryByKey(code);
			map.put("url", "/sys/seatfour/modify");
			map.put("seat", sysSeatFour);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}
}