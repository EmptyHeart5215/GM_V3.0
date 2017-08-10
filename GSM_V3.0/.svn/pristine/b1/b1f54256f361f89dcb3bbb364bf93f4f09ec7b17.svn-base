package com.dykj.GSM.action.emergencyscheduling;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.emergencyscheduling.EmergencyPlan;
import com.dykj.GSM.model.emergencyscheduling.EmergencyTeam;
import com.dykj.GSM.model.sys.SysUpload;
import com.dykj.GSM.model.zongzhitraining.ZongzhiMaterial;
import com.dykj.GSM.service.emergencyscheduling.EmergencyPlanService;
import com.dykj.GSM.service.emergencyscheduling.EmergencyTeamService;
import com.dykj.GSM.service.sys.SysUploadService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.ConvertToPdf;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

/**
 * 应急预案
 * 
 * @author wangmingyuan
 */
@RestController
@RequestMapping(value = "/emergencyscheduling/emergencyplan")
public class EmergencyPlanAction extends BaseAction {
	@Autowired
	private EmergencyPlanService emergencyPlanService;
	@Autowired
	private SysUploadService sysUploadService;
	@Autowired
	private EmergencyTeamService emergencyTeamService;

	private static Logger logger = Logger.getLogger(EmergencyPlanAction.class);

	/**
	 * 管理页面加载
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("emergencyscheduling/emergencyplan/manage");
	}

	/**
	 * 新增页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "/emergencyscheduling/emergencyplan/add");
		return new ModelAndView("/emergencyscheduling/emergencyplan/info", "vdata", vdata);
	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			EmergencyPlan emergencyPlan = emergencyPlanService.queryByKey(code);
			vdata.put("url", "emergencyscheduling/emergencyplan/modify");
			vdata.put("emergencyPlan", emergencyPlan);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("emergencyscheduling/emergencyplan/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param activities
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EmergencyPlan emergencyPlan, BindingResult result) {
		try {
			Map<String, Object> vdata = new HashMap<String, Object>();
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				emergencyPlan.setCreateBy(MySession.getInfo().getCode());
				if (emergencyPlanService.insert(emergencyPlan) != 0) {
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ActionMessage(false).setinfo(e.getMessage());
		}

	}

	/**
	 * 修改
	 * 
	 * @param activities
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid EmergencyPlan emergencyPlan, BindingResult result) throws Exception {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if (emergencyPlan.getCode() != null && !"".equals(emergencyPlan.getCode())) {
					if (emergencyPlanService.update(emergencyPlan) != 0) {
						return new ActionMessage(true);
					} else {
						return new ActionMessage(false);
					}
				} else {
					return new ActionMessage(false);
				}

			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	/**
	 * 删除
	 * 
	 * @param codes
	 * @return
	 */
	@RequestMapping(value = "/delete")
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (emergencyPlanService.deleteBatch(codes) != 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}
	
	@RequestMapping(value = "/pdfSee")
	public ModelAndView detailLoad(String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("code", code);
		return new ModelAndView("emergencyscheduling/emergencyplan/pdfSee", "vdata", vdata);
	}
	@RequestMapping(value = "/infoSee")
	public ModelAndView infoSee(String code) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		EmergencyPlan emergencyPlan = emergencyPlanService.queryByKey(code);
		vdata.put("emergencyPlan", emergencyPlan);
		return new ModelAndView("emergencyscheduling/emergencyplan/infoSee", "vdata", vdata);
	}
	
	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页条数
	 * @param sort
	 *            排序字段名称
	 * @param order
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据
	 * @throws ParseException
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, String args) {
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			if (m.get("gridCode") == null || "".equals(m.get("gridCode"))) {
				m.put("gridCode", MySession.getInfo().getGridCode());
			}
			
			
			return emergencyPlanService.queryByParamPage(page, rows, sidx, sord, m);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}

	}
	

}
