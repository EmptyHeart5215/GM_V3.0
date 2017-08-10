package com.dykj.GSM.action.charts;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.base.BBuilding;
import com.dykj.GSM.service.base.BBuildingService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

@RestController
@RequestMapping(value = "/charts/bbuildcharts")
public class BBuildChartsAction {
	private static Logger logger = Logger.getLogger(BBuildChartsAction.class);
	@Autowired
	private BBuildingService buildService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/bbuildcharts/manage");
	}

	@RequestMapping(value = "/Charts")
	public Map<String, Object> personCharts(BBuilding args) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		if (args.getGridCode() == null || "".equals(args.getGridCode())) {
			args.setGridCode(MySession.getInfo().getGridCode());
		}
		vdata = ToHighChartsUtil.toHighCharts2s(buildService.Charts(args));
		return vdata;
	}

}
