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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.sys.SysSeatSecond;
import com.dykj.GSM.service.sys.SysSeatSecondService;
import com.dykj.GSM.utils.ActionMessage;

@RestController
@RequestMapping(value = "/sys/seatsecond")
public class SysSeatSecondAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysSeatSecondAction.class);
	@Autowired
	private SysSeatSecondService seatSecondService;

	/**
	 * 新增页面的加载
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView secondAddLoad(String parentCode, HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "sys/seatsecond/add");
		map.put("parentCode", parentCode);
		return new ModelAndView("sys/seatsecond/secondinfo", "map", map);
	}

	/**
	 * 新增
	 * 
	 * @param seatsecond
	 * @return @
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(SysSeatSecond seatsecond, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if (seatSecondService.insert(seatsecond) != 0) {
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
	public ModelAndView secondModifyLoad(String code, HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatSecond sysSeatSecond = seatSecondService.queryByKey(code);
			map.put("url", "sys/seatsecond/modify");
			map.put("seat", sysSeatSecond);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/seatsecond/secondinfo", "map", map);
	}

	/**
	 * 修改
	 * 
	 * @param seatsecond
	 * @return @
	 */
	@RequestMapping(value = "/modify", method = { RequestMethod.POST })
	public ActionMessage modify(SysSeatSecond seatsecond) {
		try {
			if (seatSecondService.update(seatsecond) != 0) {
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

	/**
	 * 删除
	 * 
	 * @param codes
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (seatSecondService.deleteBatch(codes) != 0) {
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
	 * queryByCode(String code) { return SysSeatSecondService.queryByCode(code);
	 * }
	 */
	/**
	 * 新增组织机构页面的加载
	 */
	@RequestMapping(value = "/addOrgLoad")
	public ModelAndView addOrgLoad(String parentCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentCode", parentCode);
		map.put("url", "sys/seatsecond/add");
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}

	/**
	 * 修改页面的加载
	 */
	@RequestMapping(value = "/modifyOrgLoad")
	public ModelAndView modifyOrgLoad(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "/sys/seatsecond/modify");
		try {
			SysSeatSecond sysSeatSecond = seatSecondService.queryByKey(code);
			map.put("seat", sysSeatSecond);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}
}