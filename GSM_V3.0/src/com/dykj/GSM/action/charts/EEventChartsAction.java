package com.dykj.GSM.action.charts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.service.event.EEventService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;
import com.dykj.GSM.utils.Utils;

@RestController
@RequestMapping(value = "/charts/eeventcharts")
public class EEventChartsAction {
	private static Logger logger = Logger.getLogger(EEventChartsAction.class);
	@Autowired
	private EEventService eventService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/eeventcharts/manage");
	}

	@RequestMapping(value = "/eeventCharts")
	public Map<String, Object> eeventCharts(String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			m = Utils.handleDateValue(m, "shouLiDate");
			// m.put("userCode", model.getCode());

			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			if (m.get("type") == null || m.get("type").toString().isEmpty()) {
				m.put("type", "gridCode");
			}

			List list = eventService.eventCharts(m);
			return ToHighChartsUtil.toHighCharts2(list);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return null;
	}

	@RequestMapping(value = "/chartsByOrgLoad")
	public ModelAndView chartsByOrgLoad() {
		return new ModelAndView("/yanpanfenxi/charts/eeventcharts/managebyorg");
	}

	@RequestMapping(value = "/eeventChartsByOrg")
	public Map<String, Object> eeventChartsByOrg(String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			m = Utils.handleDateValue(m, "shouLiDate");

			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			if (m.get("type") == null || m.get("type").toString().isEmpty()) {
				m.put("type", "dept");
			}
			List list = eventService.eventChartsByOrg(m);
			return ToHighChartsUtil.toHighCharts2(list);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		return null;
	}
}
