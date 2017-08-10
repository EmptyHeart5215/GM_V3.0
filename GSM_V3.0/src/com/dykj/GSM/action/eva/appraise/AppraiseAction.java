package com.dykj.GSM.action.eva.appraise;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.eva.AppraiseCommunity;
import com.dykj.GSM.model.eva.AppraiseDepartment;
import com.dykj.GSM.model.eva.AppraiseGrid;
import com.dykj.GSM.model.eva.AppraiseStreet;
import com.dykj.GSM.service.eva.AppraiseCommunityService;
import com.dykj.GSM.service.eva.AppraiseDepartmentService;
import com.dykj.GSM.service.eva.AppraiseGridService;
import com.dykj.GSM.service.eva.AppraiseStreetService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
public class AppraiseAction extends BaseAction {
	@Autowired
	private AppraiseGridService appraiseGridService;
	@Autowired
	private AppraiseCommunityService appraiseCommunityService;
	@Autowired
	private AppraiseDepartmentService appraiseDepartmentService;
	@Autowired
	private AppraiseStreetService appraiseStreetService;

	private static Logger logger = Logger.getLogger(AppraiseAction.class);

	@RequestMapping(value = "/eva/appraisegrid/appraiseGridLoad")
	public ModelAndView appraiseGridLoad() {
		String gridCode = MySession.getInfo().getGridCode();
		String nowDate = new SimpleDateFormat("yyyy-MM").format(new Date());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		map.put("nowDate", nowDate);
		return new ModelAndView("/eva/appraise/appraisegrid", "data", map);
	}

	@RequestMapping(value = "/eva/appraisegrid/appraiseGrid")
	public ActionMessage appraiseGrid(@RequestParam String date, @RequestParam String gridCode) {
		Integer year = Integer.valueOf(date.substring(0, 4));
		Integer month = Integer.valueOf(date.substring(5));
		try {
			int i = appraiseGridService.insertBySelect(MySession.getInfo().getCode(), year, month, gridCode);
			if (i > 0) {
				return new ActionMessage(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new ActionMessage(false);
	}

	@RequestMapping(value = "/eva/appraisegrid/queryAppraisedGrid")
	public Object queryAppraisedGrid(int page, int rows, String sidx, String sord, @RequestParam String date,
			@RequestParam String gridCode) {
		Page<AppraiseGrid> results = null;
		try {
			Integer year = Integer.valueOf(date.substring(0, 4));
			Integer month = Integer.valueOf(date.substring(5));
			results = appraiseGridService.queryByMapPage(sidx, rows, page, sord, year, month, gridCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}

	@RequestMapping(value = "/eva/appraisegrid/queryAppraisedGridDetail")
	public Object queryAppraisedGridDetail(@RequestParam String code) {
		Map<String, Object> map = null;
		try {
			map = appraiseGridService.getDetailOfAppraise(code);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new ModelAndView("/eva/appraise/appraisegridDetail", "data", map);
	}

	@RequestMapping(value = "/eva/appraisecommunity/appraiseCommunityLoad")
	public ModelAndView appraiseCommunityLoad() {
		String gridCode = MySession.getInfo().getGridCode();
		String nowDate = new SimpleDateFormat("yyyy-MM").format(new Date());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		map.put("nowDate", nowDate);
		return new ModelAndView("/eva/appraise/appraisecommunity", "data", map);
	}

	@RequestMapping(value = "/eva/appraisecommunity/appraiseCommunity")
	public ActionMessage appraiseCommunity(@RequestParam String date, @RequestParam String gridCode) {
		Integer year = Integer.valueOf(date.substring(0, 4));
		Integer month = Integer.valueOf(date.substring(5));
		try {
			int i = appraiseCommunityService.insertBySelect(MySession.getInfo().getCode(), year, month, gridCode);
			if (i > 0) {
				return new ActionMessage(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new ActionMessage(false);
	}

	@RequestMapping(value = "/eva/appraisecommunity/queryAppraisedCommunity")
	public Object queryAppraisedCommunity(int page, int rows, String sidx, String sord, @RequestParam String date,
			@RequestParam String gridCode) {
		Page<AppraiseCommunity> results = null;
		try {
			Integer year = Integer.valueOf(date.substring(0, 4));
			Integer month = Integer.valueOf(date.substring(5));
			results = appraiseCommunityService.queryByMapPage(sidx, rows, page, sord, year, month, gridCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}

	@RequestMapping(value = "/eva/appraisedepartment/appraiseDepartmentLoad")
	public ModelAndView appraiseDepartmentLoad() {
		String gridCode = MySession.getInfo().getGridCode();
		String nowDate = new SimpleDateFormat("yyyy-MM").format(new Date());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		map.put("nowDate", nowDate);
		return new ModelAndView("/eva/appraise/appraisedepartment", "data", map);
	}

	@RequestMapping(value = "/eva/appraisedepartment/queryAppraisedDepartmentDetail")
	public Object queryAppraisedDepartmentDetail(@RequestParam String code) {
		Map<String, Object> map = null;
		try {
			map = appraiseDepartmentService.getDetailOfAppraise(code);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new ModelAndView("/eva/appraise/appraisedepartmentDetail", "data", map);
	}

	@RequestMapping(value = "/eva/appraisedepartment/appraiseDepartment")
	public ActionMessage appraiseDepartment(@RequestParam String date, @RequestParam String gridCode) {
		Integer year = Integer.valueOf(date.substring(0, 4));
		Integer month = Integer.valueOf(date.substring(5));
		try {
			int i = appraiseDepartmentService.insertBySelect(MySession.getInfo().getCode(), year, month, gridCode);
			if (i > 0) {
				return new ActionMessage(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new ActionMessage(false);
	}

	@RequestMapping(value = "/eva/appraisedepartment/queryAppraisedDepartment")
	public Object queryAppraisedDepartment(int page, int rows, String sidx, String sord, @RequestParam String date,
			@RequestParam String gridCode) {
		Page<AppraiseDepartment> results = null;
		try {
			Integer year = Integer.valueOf(date.substring(0, 4));
			Integer month = Integer.valueOf(date.substring(5));
			results = appraiseDepartmentService.queryByMapPage(sidx, rows, page, sord, year, month, gridCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}

	@RequestMapping(value = "/eva/appraisestreet/appraisStreetLoad")
	public ModelAndView appraiseStreetLoad() {
		String gridCode = MySession.getInfo().getGridCode();
		String nowDate = new SimpleDateFormat("yyyy-MM").format(new Date());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("gridCode", gridCode);
		map.put("nowDate", nowDate);
		return new ModelAndView("/eva/appraise/appraisestreet", "data", map);
	}

	@RequestMapping(value = "/eva/appraisestreet/appraiseStreet")
	public ActionMessage appraiseStreet(@RequestParam String date, @RequestParam String gridCode) {
		Integer year = Integer.valueOf(date.substring(0, 4));
		Integer month = Integer.valueOf(date.substring(5));
		try {
			int i = appraiseStreetService.insertBySelect(MySession.getInfo().getCode(), year, month, gridCode);
			if (i > 0) {
				return new ActionMessage(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new ActionMessage(false);
	}

	@RequestMapping(value = "/eva/appraisestreet/queryAppraisedStreet")
	public Object queryAppraisedStreet(int page, int rows, String sidx, String sord, @RequestParam String date,
			@RequestParam String gridCode) {
		Page<AppraiseStreet> results = null;
		try {
			Integer year = Integer.valueOf(date.substring(0, 4));
			Integer month = Integer.valueOf(date.substring(5));
			results = appraiseStreetService.queryByMapPage(sidx, rows, page, sord, year, month, gridCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}

	@RequestMapping(value = "/eva/appraisestreet/queryAppraisedStreetDetail")
	public Object queryAppraisedStreetDetail(@RequestParam String code) {
		Map<String, Object> map = null;
		try {
			map = appraiseStreetService.getDetailOfAppraise(code);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return new ModelAndView("/eva/appraise/appraisestreetDetail", "data", map);
	}
}
