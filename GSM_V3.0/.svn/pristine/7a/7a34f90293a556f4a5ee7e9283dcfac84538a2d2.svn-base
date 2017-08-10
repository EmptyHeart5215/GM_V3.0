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

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.emergencyscheduling.EmergencyPlace;
import com.dykj.GSM.model.emergencyscheduling.EmergencySupplies;
import com.dykj.GSM.service.emergencyscheduling.EmergencySuppliesService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

/**
 * 应急物资
 * 
 * @author wangmingyuan
 */
@RestController
@RequestMapping(value = "/emergencyscheduling/emergencysupplies")
public class EmergencySuppliesAction extends BaseAction {

	@Autowired
	private EmergencySuppliesService emergencySuppliesService;
	private static Logger logger = Logger.getLogger(EmergencySuppliesAction.class);

	/**
	 * 管理页面加载
	 * 
	 * @return
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("emergencyscheduling/emergencysupplies/manage");
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
		vdata.put("url", "/emergencyscheduling/emergencysupplies/add");
		return new ModelAndView("/emergencyscheduling/emergencysupplies/info", "vdata", vdata);
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
			EmergencySupplies EmergencySupplies = emergencySuppliesService.queryByKey(code);
			vdata.put("url", "emergencyscheduling/emergencysupplies/modify");
			vdata.put("EmergencySupplies", EmergencySupplies);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("emergencyscheduling/emergencysupplies/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param activities
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EmergencySupplies emergencySupplies, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				emergencySupplies.setCreateBy(MySession.getInfo().getCode());
				if (emergencySuppliesService.insert(emergencySupplies) != 0) {
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
	public ActionMessage modify(@Valid EmergencySupplies emergencySupplies, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if (emergencySupplies.getCode() != null && !"".equals(emergencySupplies.getCode())) {
					if (emergencySuppliesService.update(emergencySupplies) != 0) {
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
			if (emergencySuppliesService.deleteBatch(codes) != 0) {
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
		return new ModelAndView("emergencyscheduling/emergencysupplies/infoSee", "vdata", vdata);
	}
	
	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			EmergencySupplies emergencySupplies = emergencySuppliesService.queryByKey(code);
			vdata.put("emergencySupplies", emergencySupplies);
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
			if(m.get("suppliesCode") != null && !"".equals(m.get("suppliesCode"))){
				String[] code = ((String) m.get("suppliesCode")).split(",");
				m.put("code", code);
			}
			if (m.get("gridCode") == null || "".equals(m.get("gridCode"))) {
				m.put("gridCode", MySession.getInfo().getGridCode());
			}
			return emergencySuppliesService.queryByParamPage(page, rows, sidx, sord, m);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}

	}
	@RequestMapping(value = "/queryplaceSelect")
	public ModelAndView partyByPersonManage(String code,String select) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("supplies",code);
		vdata.put("select",select);
		return new ModelAndView("emergencyscheduling/emergencysupplies/managesamll", "vdata", vdata);
	}

}
