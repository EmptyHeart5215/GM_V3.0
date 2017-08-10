package com.dykj.GSM.action.emergencyscheduling;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.emergencyscheduling.SysGpsPosition;
import com.dykj.GSM.model.zongzhitraining.ZongzhiMaterial;
import com.dykj.GSM.service.emergencyscheduling.SysGpsPositionService;
import com.dykj.GSM.utils.ActionMessage;

/**
 * GPS地图历史轨迹
 * @author wangmingyuan
 *
 */
@RestController
@RequestMapping(value = "/emergencyscheduling/gpsmaphistorypath")
public class GpsMapHistoryPathAction {
	
    private static Logger logger = Logger.getLogger(GpsMapRealTimeMonitoringAction.class);
	
	@Autowired
	private SysGpsPositionService sysGpsPositionService;
	/**
	 * 管理页面加载
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad(){
		return new ModelAndView("emergencyscheduling/gpsmaphistorypath/manage");
	}
	
	@RequestMapping(value = "/historyGps")
	public Object historyGps(SysGpsPosition params){
		try {
			System.out.println(params.getDeviceImei()+"=="+params.getDateTime1()+"=="+params.getDateTime2());
			return sysGpsPositionService.historyGps(params);
		} catch (Exception e) {
			logger.error("error",e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}

		
	}
	
}
