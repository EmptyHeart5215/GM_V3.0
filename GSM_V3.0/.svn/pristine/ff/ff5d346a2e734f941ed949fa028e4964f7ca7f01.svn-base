package com.dykj.GSM.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.sys.SysSeatSecond;
import com.dykj.GSM.model.sys.SysSeatThird;
import com.dykj.GSM.service.sys.SysSeatThirdService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/seatthird")
public class SysSeatThirdAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysSeatThirdAction.class);
	@Autowired
	private SysSeatThirdService sysSeatThirdService;

	/**
	 * 新增页面的加载
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView thirdAddLoad(String parentCode, HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "/sys/seatthird/add");
		map.put("parentCode", parentCode);
		return new ModelAndView("sys/seatthird/thirdinfo", "map", map);
	}

	/**
	 * 新增
	 * 
	 * @param seatThird
	 * @return @
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(SysSeatThird seatThird, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				SysSeatSecond sysSeatSecond = sysSeatThirdService.queryByparentCode(seatThird.getParentCode());
				seatThird.setSecondName(sysSeatSecond.getName());
				seatThird.setGridTotalName(sysSeatSecond.getGridTotalName() + "-" + seatThird.getName());
				SessionModel sessionModel = MySession.getInfo();
				seatThird.setCreateBy(sessionModel.getCode());
				if (sysSeatThirdService.insert(seatThird) != 0) {
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
	public ModelAndView thirdModifyLoad(String code, HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatThird sysSeatThird = sysSeatThirdService.queryByKey(code);
			map.put("url", "/sys/seatthird/modify");
			map.put("seat", sysSeatThird);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/seatthird/thirdinfo", "map", map);
	}

	/**
	 * 修改
	 * 
	 * @param seatThird
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(SysSeatThird seatThird) {
		try {
			SysSeatSecond sysSeatSecond = sysSeatThirdService.queryByparentCode(seatThird.getParentCode());
			seatThird.setSecondName(sysSeatSecond.getName());
			seatThird.setGridTotalName(sysSeatSecond.getGridTotalName() + "-" + seatThird.getName());
			if (seatThird.getCode() == null) {
				return new ActionMessage(false);
			}
			if (sysSeatThirdService.update(seatThird) != 0) {
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
	 * 通过主键查询
	 * 
	 * @param code
	 * @return @
	 */
	/*
	 * 
	 * @RequestMapping(value = "/queryByCode") public Map<String, Object>
	 * queryByCode(String code) { return SysSeatThirdService.queryByCode(code);
	 * }
	 */
	/**
	 * 新增组织机构页面的加载
	 */
	@RequestMapping(value = "/addOrgLoad")
	public ModelAndView addOrgLoad(String parentCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "/sys/seatthird/add");
		Map<String, Object> seat = new HashMap<String, Object>();
		seat.put("parentCode", parentCode);
		map.put("seat", seat);
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}

	/**
	 * 修改页面的加载
	 */
	@RequestMapping(value = "/modifyOrgLoad")
	public ModelAndView modifyOrgLoad(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "/sys/seatthird/modify");
		try {
			SysSeatThird sysSeatThird = sysSeatThirdService.queryByKey(code);
			map.put("seat", sysSeatThird);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}
}