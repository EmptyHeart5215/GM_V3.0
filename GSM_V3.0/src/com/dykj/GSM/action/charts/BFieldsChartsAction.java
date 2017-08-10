package com.dykj.GSM.action.charts;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.base.BFields;
import com.dykj.GSM.service.base.BFieldsService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

@RestController
@RequestMapping(value = "/charts/bfieldscharts")
public class BFieldsChartsAction {
	private static Logger logger = Logger.getLogger(BFieldsChartsAction.class);
	@Autowired
	private BFieldsService bfService;
	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/bfieldscharts/manage");
	}
	@RequestMapping(value = "/Charts")
	public Map<String, Object> personCharts(BFields args){
		Map<String, Object> vdata = new HashMap<String,Object>();
		if (args.getGridCode()==null || "".equals(args.getGridCode())) {
			args.setGridCode(MySession.getInfo().getGridCode());
		}
		vdata = ToHighChartsUtil.toHighCharts2s(bfService.Charts(args));
		return vdata;
	}
}
