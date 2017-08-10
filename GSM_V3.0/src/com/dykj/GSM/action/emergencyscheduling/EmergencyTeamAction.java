package com.dykj.GSM.action.emergencyscheduling;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.model.emergencyscheduling.EmergencyTeam;
import com.dykj.GSM.model.eventfile.EventContradict;
import com.dykj.GSM.service.emergencyscheduling.EmergencyTeamService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

/**
 * 应急队伍
 * 
 * @author wangmingyuan
 */
@RestController
@RequestMapping(value = "/emergencyscheduling/emergencyteam")
public class EmergencyTeamAction {

	private static Logger logger = Logger.getLogger(EmergencyTeamAction.class);
	@Autowired
	private EmergencyTeamService emergencyTeamService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("emergencyscheduling/emergencyteam/manage");
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
		vdata.put("url", "/emergencyscheduling/emergencyteam/add");
		return new ModelAndView("/emergencyscheduling/emergencyteam/info", "vdata", vdata);
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
			EmergencyTeam EmergencyTeam = emergencyTeamService.queryByKey(code);
			vdata.put("url", "/emergencyscheduling/emergencyteam/modify");
			vdata.put("EmergencyTeam", EmergencyTeam);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("emergencyscheduling/emergencyteam/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param activities
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EmergencyTeam emergencyTeam, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				emergencyTeam.setCreateBy(MySession.getInfo().getCode());
				if (emergencyTeamService.insert(emergencyTeam) != 0) {
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
	public ActionMessage modify(@Valid EmergencyTeam emergencyTeam, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if (emergencyTeam.getCode() != null && !"".equals(emergencyTeam.getCode())) {
					if (emergencyTeamService.update(emergencyTeam) != 0) {
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
			if (emergencyTeamService.deleteBatch(codes) != 0) {
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

	/**
	 * 显示详情页面
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String code) {
		Map<String, Object> vdata = this.approvalData(code);
		return new ModelAndView("emergencyscheduling/emergencyteam/infoSee", "vdata", vdata);
	}
	
	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			EmergencyTeam emergencyTeam = emergencyTeamService.queryByKey(code);
			vdata.put("emergencyTeam", emergencyTeam);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return vdata;
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
			System.out.println(m.get("teamCode"));
			if(m.get("teamCode") != null && !"".equals(m.get("teamCode"))){
				String[] code = ((String) m.get("teamCode")).split(",");
				m.put("code", code);
			}
			System.out.println(m.get("code"));
			if (m.get("gridCode") == null || "".equals(m.get("gridCode"))) {
				m.put("gridCode", MySession.getInfo().getGridCode());
			}
			return emergencyTeamService.queryByParamPage(page, rows, sidx, sord, m);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}

	}
	@RequestMapping(value = "/queryteamSelect")
	public ModelAndView partyByPersonManage(String code,String select) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("team",code);
		vdata.put("select",select);
		return new ModelAndView("emergencyscheduling/emergencyteam/managesamll", "vdata", vdata);
	}

}
