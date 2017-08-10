package com.dykj.GSM.action.partybuilding;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.charts.ChartsTemp;
import com.dykj.GSM.model.partybuilding.PartyOrganizationManager;
import com.dykj.GSM.model.partybuilding.PartyOrganizationProfile;
import com.dykj.GSM.service.partybuilding.PartyOrganizationManagerService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.ToHighChartsUtil;

/**
 * 党组织管理
 * 
 * @author wangmingyuan
 */
@RestController
@RequestMapping(value = "/partybuilding/partyorganizationmanager")
public class PartyOrganizationManagerAction extends BaseAction {

	private static Logger logger = Logger.getLogger(PartyOrganizationManagerAction.class);

	@Autowired
	private PartyOrganizationManagerService partyOrganizationManagerService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/partybuilding/partyorganizationmanager/manage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, PartyOrganizationManager param) {
		try {
			return partyOrganizationManagerService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
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
		vdata.put("url", "partybuilding/partyorganizationmanager/add");
		return new ModelAndView("partybuilding/partyorganizationmanager/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysdic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid PartyOrganizationManager organizationManager, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				organizationManager.setCreateBy(MySession.getInfo().getCode());
				if (partyOrganizationManagerService.insert(organizationManager) != 0) {
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
			PartyOrganizationManager partyOrganizationManager = partyOrganizationManagerService.queryByKey(code);
			vdata.put("url", "partybuilding/partyorganizationmanager/modify");
			vdata.put("partyOrganizationManager", partyOrganizationManager);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("partybuilding/partyorganizationmanager/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysdic
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid PartyOrganizationManager organizationManager, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				organizationManager.setCreateBy(MySession.getInfo().getCode());
				if (partyOrganizationManagerService.update(organizationManager) != 0) {
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (partyOrganizationManagerService.deleteBatch(codes) != 0) {
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
	 * 详细页面加载
	 * 
	 * @param code
	 *            主键
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/infoSee")
	public ModelAndView infoSee(String code) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		PartyOrganizationManager partyOrganizationManager = partyOrganizationManagerService.queryByKey(code);
		vdata.put("partyOrganizationManager", partyOrganizationManager);
		return new ModelAndView("partybuilding/partyorganizationmanager/infoSee", "vdata", vdata);
	}

	@RequestMapping(value = "/queryPartyBuildingTree")
	public Object queryPartyBuildingTree() {
		SessionModel model = MySession.getInfo();
		String gridCode = model.getGridCode();
		// String gridCode = "01001001000100000002";
		return partyOrganizationManagerService.queryPartyBuildingTree(gridCode);
	}

	@RequestMapping(value = "/queryPartyOrganizationManagerByGridCode")
	public PartyOrganizationProfile queryPartyOrganizationManagerByGridCode(PartyOrganizationManager param)
			throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		System.out.println(param.getGridCode() + "---" + param.getCode());
		return partyOrganizationManagerService.queryPartyOrganizationManagerByGridCode(param);
		/*vdata.put("partyOrganizationManager", partyOrganizationManager);
		return new ModelAndView("/partybuilding/organizationprofile/manage", "vdata", vdata);*/
	}

	@RequestMapping(value = "/chartsPartyMemberSexByGridCode")
	public Map<String, Object> chartsPartyMemberSexByGridCode(String gridCode) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		if (gridCode == null) {
			gridCode = "01";
		}
		vdata = ToHighChartsUtil
				.toHighChartss(partyOrganizationManagerService.chartsPartyMemberSexByGridCode(gridCode));
		return vdata;
	}

	@RequestMapping(value = "/chartsPartyMemberPartyTypeByGridCode")
	public Map<String, Object> chartsPartyMemberPartyTypeByGridCode(String gridCode) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		if (gridCode == null) {
			gridCode = "01";
		}
		List<ChartsTemp> list = partyOrganizationManagerService.chartsPartyMemberPartyTypeByGridCode(gridCode);

		vdata = ToHighChartsUtil.toHighChartss(list);
		return vdata;
	}

	@RequestMapping(value = "/chartsPartyMemberAgeByGridCode")
	public Map<String, Object> chartsPartyMemberAgeByGridCode(String gridCode) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		if (gridCode == null) {
			gridCode = "01";
		}
		vdata = ToHighChartsUtil
				.toHighChartss(partyOrganizationManagerService.chartsPartyMemberAgeByGridCode(gridCode));
		return vdata;
	}

}
