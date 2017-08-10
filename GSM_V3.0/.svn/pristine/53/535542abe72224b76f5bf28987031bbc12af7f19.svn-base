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

import com.dykj.GSM.model.base.BParts;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.service.base.BPartsService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

@RestController
@RequestMapping(value = "/charts/bpartscharts")
public class BpartsChartsAction {
	private static Logger logger = Logger.getLogger(BpartsChartsAction.class);
	@Autowired
	private BPartsService BPartsServ;
	public static List<BPerson> tempList;
	public Integer tempI;
	
	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/bpartscharts/manage");
	}
	
	@RequestMapping(value = "/partsCharts")
	public Map<String, Object> personCharts(BParts args){
		System.out.println(args.getName()+"*********");
		Map<String, Object> vdata = new HashMap<String,Object>();
		if (args.getGridCode()==null || "".equals(args.getGridCode())) {
			args.setGridCode(MySession.getInfo().getGridCode());
		}
		vdata = ToHighChartsUtil.toHighCharts2s(BPartsServ.Charts(args));
		return vdata;
	}

}
