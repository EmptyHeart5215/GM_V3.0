package com.dykj.GSM.action.charts;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.model.event.EOpinion;
import com.dykj.GSM.model.eventfile.EventActivities;
import com.dykj.GSM.model.eventfile.EventContradict;
import com.dykj.GSM.model.eventfile.EventHarmSafe;
import com.dykj.GSM.model.eventfile.EventInformation;
import com.dykj.GSM.model.sys.SysUpload;
import com.dykj.GSM.service.eventfile.EventActivitiesService;
import com.dykj.GSM.service.eventfile.EventContradictService;
import com.dykj.GSM.service.eventfile.EventHarmSafeService;
import com.dykj.GSM.service.eventfile.EventInformationService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;
import com.dykj.GSM.utils.ImgErToFileUtil;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;
import com.dykj.GSM.utils.Utils;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/charts/einformationcharts")
public class EventInformationChartsAction extends BaseAction {
	@Autowired
	private EventInformationService eventInfoserv;
	
	private static Logger logger = Logger.getLogger(EventInformationChartsAction.class);
	@RequestMapping(value = "/chartsLoad")
	public ModelAndView chartsLoad() {
		return new ModelAndView("/yanpanfenxi/charts/einformationcharts/manage");
	}
	
	@RequestMapping(value = "/Charts")
	public Map<String, Object> personCharts(EventInformation args){
		Map<String, Object> vdata = new HashMap<String,Object>();
		if (args.getGridCode()==null || "".equals(args.getGridCode())) {
			args.setGridCode(MySession.getInfo().getGridCode());
		};
		vdata = ToHighChartsUtil.toHighCharts2s(eventInfoserv.Charts(args));
		return vdata;
	}
	

}
