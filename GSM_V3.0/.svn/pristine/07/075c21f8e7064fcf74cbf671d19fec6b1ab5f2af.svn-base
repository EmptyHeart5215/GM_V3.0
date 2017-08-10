package com.dykj.GSM.action.eva.statistics;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

@RestController
public class StatisticsAppraiseAction extends BaseAction {
	@Autowired
	private AppraiseGridService appraiseGridService;
	@Autowired
	private AppraiseCommunityService appraiseCommunityService;
	@Autowired
	private AppraiseDepartmentService appraiseDepartmentService;
	@Autowired
	private AppraiseStreetService appraiseStreetService;

	private static Logger logger = Logger.getLogger(StatisticsAppraiseAction.class);

	/**
	 * 网格统计入口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticsgrid/statisticsGridLoad")
	public ModelAndView appraiseGridLoad() {
		return new ModelAndView("/eva/statistics/statisticsgrid");
	}

	/**
	 * 网格统计
	 * 
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @param gridCode
	 *            下去
	 * @param type
	 *            统计类型，年/季度/月
	 * @param jiDu
	 *            第几季度
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticsgrid/queryStatisticsGrid", method = RequestMethod.POST)
	public Object queryStatisticsGrid(int page, int rows, String sidx, String sord, @RequestParam Integer year,
			Integer month, @RequestParam String gridCode, @RequestParam String type, Integer jiDu) {
		Page<AppraiseGrid> results = null;
		try {
			results = appraiseGridService
					.queryStatisticsPage(sidx, rows, page, sord, year, month, gridCode, type, jiDu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}

	/**
	 * Grid统计入口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticscommunity/statisticsCommunityLoad")
	public ModelAndView appraiseCommunityLoad() {
		return new ModelAndView("/eva/statistics/statisticscommunity");
	}

	/**
	 * 社区统计
	 * 
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @param gridCode
	 *            下去
	 * @param type
	 *            统计类型，年/季度/月
	 * @param jiDu
	 *            第几季度
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticscommunity/queryStatisticsCommunity", method = RequestMethod.POST)
	public Object queryStatisticsCommunity(int page, int rows, String sidx, String sord, @RequestParam Integer year,
			Integer month, @RequestParam String gridCode, @RequestParam String type, Integer jiDu) {
		Page<AppraiseCommunity> results = null;
		try {
			results = appraiseCommunityService.queryStatisticsPage(sidx, rows, page, sord, year, month, gridCode, type,
					jiDu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}

	/**
	 * 部门统计入口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticsdepartment/statisticsDepartmentLoad")
	public ModelAndView appraiseDepartmentLoad() {
		return new ModelAndView("/eva/statistics/statisticsdepartment");
	}

	/**
	 * 部门统计
	 * 
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @param gridCode
	 *            下去
	 * @param type
	 *            统计类型，年/季度/月
	 * @param jiDu
	 *            第几季度
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticsdepartment/queryStatisticsDepartment", method = RequestMethod.POST)
	public Object queryStatisticsDepartment(int page, int rows, String sidx, String sord, @RequestParam Integer year,
			Integer month, @RequestParam String gridCode, @RequestParam String type, Integer jiDu) {
		Page<AppraiseDepartment> results = null;
		try {
			results = appraiseDepartmentService.queryStatisticsPage(sidx, rows, page, sord, year, month, gridCode,
					type, jiDu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}

	/**
	 * 部门统计入口
	 * 
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticsstreet/statisticsStreetLoad")
	public ModelAndView appraiseStreetLoad() {
		return new ModelAndView("/eva/statistics/statisticsstreet");
	}

	/**
	 * 部门统计
	 * 
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 * @param year
	 *            年份
	 * @param month
	 *            月份
	 * @param gridCode
	 *            下去
	 * @param type
	 *            统计类型，年/季度/月
	 * @param jiDu
	 *            第几季度
	 * @return
	 */
	@RequestMapping(value = "/eva/statisticsstreet/queryStatisticsStreet", method = RequestMethod.POST)
	public Object queryStatisticsStreet(int page, int rows, String sidx, String sord, @RequestParam Integer year,
			Integer month, @RequestParam String gridCode, @RequestParam String type, Integer jiDu) {
		Page<AppraiseStreet> results = null;
		try {
			results = appraiseStreetService.queryStatisticsPage(sidx, rows, page, sord, year, month, gridCode, type,
					jiDu);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return results;
	}
}
