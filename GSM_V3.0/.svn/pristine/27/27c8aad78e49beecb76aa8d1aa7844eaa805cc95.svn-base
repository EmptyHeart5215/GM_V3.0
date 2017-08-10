package com.dykj.GSM.action.emergencyscheduling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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
import com.dykj.GSM.service.emergencyscheduling.SysGpsPositionService;
import com.dykj.GSM.utils.ActionMessage;

/**
 * GPS地图实时监控
 * @author wangmingyuan
 *
 */
@RestController
@RequestMapping(value = "/emergencyscheduling/gpsmaprealtimemonitoring")
public class GpsMapRealTimeMonitoringAction {
	
	private static Logger logger = Logger.getLogger(GpsMapRealTimeMonitoringAction.class);
	
	@Autowired
	private SysGpsPositionService sysGpsPositionService;
	
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad(){
		return new ModelAndView("emergencyscheduling/gpsmaprealtimemonitoring/manage");
	}
	
	@RequestMapping(value = "/actualGps")
	public Object actualGps(SysGpsPosition params){
		try {
			 SimpleDateFormat SimpleDateFormat = new  SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
			  Date date = new Date();
			  Calendar cal = Calendar. getInstance ();
		        cal.set(Calendar.SECOND , Calendar. SECOND -3 ) ; 
		        
		      Date date2 = new Date();
		      String date1 = SimpleDateFormat.format(cal.getTime());
		      String dates2 = SimpleDateFormat.format(date2.getTime());
		      params.setDateTime1(date1);
		      params.setDateTime2(dates2);
		      System.out.println(date1+"=="+dates2);
		      System.out.println(params.getCode()+"---"+params.getDeviceImei()+"---------------------------------------------");
			return sysGpsPositionService.actualGps(params);
		} catch (Exception e) {
			logger.error("error",e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}

		
	}
	
	
}
