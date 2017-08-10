package com.dykj.GSM.action.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.service.base.BPersonService;
import com.dykj.GSM.service.eva.AppraiseGridService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

@RestController
@RequestMapping(value = "/sys/main")
public class SysMainAction extends BaseAction {
	@Autowired
	private BPersonService bPersonService;
	@Autowired
	private AppraiseGridService appraiseGridService;
	private static Logger logger = Logger.getLogger(SysMainAction.class);

	@RequestMapping(value = "/index")
	public ModelAndView indexLoad(HttpServletRequest request) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		String prentcode = request.getParameter("prentcode");
		String left = request.getParameter("left");
		String hasHideMenu = request.getParameter("hasHideMenu");
		vdata.put("prentcode", prentcode);
		vdata.put("left", left);
		vdata.put("hasHideMenu", hasHideMenu);
		return new ModelAndView("indexTest", "vdata", vdata);
	}

	@RequestMapping(value = "/home")
	public ModelAndView homeLoad() throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		return new ModelAndView("home", "vdata", vdata);
	}

	@RequestMapping(value = "/mainLoad")
	public ModelAndView main() throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		return new ModelAndView("main");
	}

	/**
	 * 首页网格信息统计
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPersonTypeStatistics")
	public Object queryPersonTypeStatistics() throws Exception {
		try {
			return bPersonService.queryPersonTypeStatistics(MySession.getInfo().getGridCode());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * 首页的考核统计
	 * 
	 * @return
	 */
	@RequestMapping(value = "/staticForIndex")
	public Map<String, Object> staticForIndex() {
		try {
			List results = appraiseGridService.staticForIndex(MySession.getInfo().getGridCode());
			return ToHighChartsUtil.toHighCharts2(results);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

}
