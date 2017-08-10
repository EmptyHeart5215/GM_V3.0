package com.dykj.GSM.action.charts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.base.BFeiGongJingJi;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.service.base.BFeiGongJingJiService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

@RestController
@RequestMapping(value = "/charts/bfeiggongcharts")
public class BFeiGongJingJiChartsAction {
	
	private static Logger logger = Logger.getLogger(BFeiGongJingJiChartsAction.class);
	@Autowired
	private BFeiGongJingJiService bFeiGongJingJiService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/bfeiggongcharts/manage");
	}
	
	@RequestMapping(value = "/Charts")
	public Map<String, Object> personCharts(BFeiGongJingJi args){
		Map<String, Object> vdata = new HashMap<String,Object>();
		if (args.getGridCode()==null || "".equals(args.getGridCode())) {
			args.setGridCode(MySession.getInfo().getGridCode());
		}
		vdata = ToHighChartsUtil.toHighCharts2s(bFeiGongJingJiService.Charts(args));
		return vdata;
	}

}
