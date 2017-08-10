package com.dykj.GSM.action.charts;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.service.base.BJiGouServiceService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

@RestController
@RequestMapping(value = "/charts/bjigouservicecharts")
public class BjigouServiceChartsAction {

	private static Logger logger = Logger.getLogger(BjigouServiceChartsAction.class);
	@Autowired
	private BJiGouServiceService bjgouserv;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/bjigouservicecharts/manage");
	}

	@RequestMapping(value = "/Charts")
	public Map<String, Object> personCharts(BJiGouService args) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		if (args.getJiGou() == null) {
			args.setJiGou(new BJiGou());
		}
		if (args.getJiGou().getGridCode() == null || "".equals(args.getJiGou().getGridCode())) {
			args.getJiGou().setGridCode(MySession.getInfo().getGridCode());
		}
		vdata = ToHighChartsUtil.toHighCharts2s(bjgouserv.Charts(args));
		return vdata;
	}

}
