package com.dykj.GSM.action.charts;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.base.BHouse;
import com.dykj.GSM.service.base.BHouseService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

@RestController
@RequestMapping(value = "/charts/bhousecharts")
public class BHouseChartsAction {
	private static Logger logger = Logger.getLogger(BHouseChartsAction.class);
	@Autowired
	private BHouseService houseService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/bhousecharts/manage");
	}

	@RequestMapping(value = "/Charts")
	public Map<String, Object> personCharts(BHouse args) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		if (args.getGridCode() == null || "".equals(args.getGridCode())) {
			args.setGridCode(MySession.getInfo().getGridCode());
		}
		vdata = ToHighChartsUtil.toHighCharts2s(houseService.Charts(args));
		return vdata;
	}
}
