package com.dykj.GSM.action.base;

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
import com.dykj.GSM.model.base.BJiGou;
import com.dykj.GSM.model.base.BJiGouPeople;
import com.dykj.GSM.service.base.BJiGouPeopleService;
import com.dykj.GSM.service.base.BJiGouService;
import com.dykj.GSM.service.base.BJiGouServiceService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/base/bjigou")
public class BJiGouAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BJiGouAction.class);
	@Autowired
	private BJiGouService jigouserv;
	@Autowired
	private BJiGouPeopleService jigoupeople;
	@Autowired
	private BJiGouServiceService jigouse;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/bjigou/manage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, BJiGou param) {
		try {

			return jigouserv.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String entryId, int stepId, String eventCode) {
		Map<String, Object> vdata = this.approvalData(entryId, stepId, eventCode);
		return new ModelAndView("/base/bjigou/approval", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String entryId, int stepId, String eventCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			BJiGou jigou = jigouserv.queryByKey(eventCode);
			vdata.put("jigou", jigou);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return vdata;
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
		vdata.put("url", "base/bjigou/add");
		return new ModelAndView("/base/bjigou/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BJiGou jigou, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				jigou.setCreateBy(MySession.getInfo().getCode());
				if (0 != jigouserv.insert(jigou)) {
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
			BJiGou jigou = jigouserv.queryByKey(code);
			vdata.put("url", "base/bjigou/modify");
			vdata.put("bjigou", jigou);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("base/bjigou/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BJiGou jigou, BindingResult result) throws Exception {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				jigou.setCreateBy(MySession.getInfo().getCode());
				if (jigouserv.update(jigou) != 0) {
					return new ActionMessage(true);
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

	@RequestMapping(value = "/delete")
	public ActionMessage delete(@RequestParam String codes) {

		try {
			if (jigouserv.deletePk(codes) != 0) {
				jigoupeople.updateBatch(codes);
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
		BJiGou jigou = jigouserv.queryByKey(code);
		List<BJiGouPeople> list = jigoupeople.queryParamPageByCode(code);
		List<com.dykj.GSM.model.base.BJiGouService> lists = jigouse.queryParamPageByName(code);
		vdata.put("jigou", jigou);
		vdata.put("list", list);
		vdata.put("lists", lists);
		return new ModelAndView("base/bjigou/infoSee", "vdata", vdata);

	}

	/**
	 * 为用户选择角色而做的树
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryAllRoleTreeForSelect")
	public Object queryAllRoleTreeForSelect() {
		try {
			System.out.println("----------------" + jigouserv.queryAllRoleTreeForSelect());
			return jigouserv.queryAllRoleTreeForSelect();
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/queryjigouSelect")
	public ModelAndView partyByPersonManage() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		return new ModelAndView("/base/bjigou/managesamll", "vdata", vdata);
	}

	/**
	 * 服务双击名称显示机构队伍 （因需求修改，只能重写个方法）
	 */
	@RequestMapping(value = "/queryManageSamll")
	public Object queryParamPageSamll(int page, int rows, String sidx, String sord, BJiGou args) {
		try {

			return jigouserv.queryParamPageSamll(sidx, rows, page, sord, args);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}
}
