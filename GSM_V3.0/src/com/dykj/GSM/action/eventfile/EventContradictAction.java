package com.dykj.GSM.action.eventfile;

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
import com.dykj.GSM.model.event.EOpinion;
import com.dykj.GSM.model.eventfile.EventContradict;
import com.dykj.GSM.service.eventfile.EventContradictService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

/**
 * 矛盾纠纷
 * 
 * @author limingda
 */
@RestController
@RequestMapping(value = "/eventfile/efcontradict")
public class EventContradictAction extends BaseAction {
	@Autowired
	private EventContradictService eventContradictService;

	private static Logger logger = Logger.getLogger(EventContradictAction.class);

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/manageLoad")
	public ModelAndView draftManageLoad() {
		return new ModelAndView("/eventfile/efcontradict/manage");
	}

	/**
	 * 地图管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/mapmanageLoad")
	public ModelAndView draftmapManageLoad() {
		return new ModelAndView("/eventfile/efcontradict/mapmanage");
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页函数
	 * @param sidx
	 *            排序字段
	 * @param sord
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据 @
	 */

	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, EventContradict param) {
		try {
			return eventContradictService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}

	}

	/**
	 * 添加事件草稿
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String eventCode) {
		Map<String, Object> vdata = this.approvalData(eventCode);
		return new ModelAndView("/eventfile/efcontradict/infoSee", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String eventCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			EventContradict efcontradict = eventContradictService.queryByKey(eventCode);
			vdata.put("efcontradict", efcontradict);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return vdata;
	}

	@RequestMapping(value = "/approval")
	public ActionMessage approval(String eventCode, long wfid, int stepId, int actionId, String owner,
			EOpinion opinion, Integer duration) {
		return new ActionMessage(true);
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
		vdata.put("url", "eventfile/efcontradict/add");
		return new ModelAndView("/eventfile/efcontradict/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EventContradict eventContradict, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				eventContradict.setCreateBy(MySession.getInfo().getCode());
				if (eventContradictService.insert(eventContradict) != 0) {
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
			EventContradict efcontradict = eventContradictService.queryByKey(code);
			vdata.put("url", "eventfile/efcontradict/modify");
			vdata.put("efcontradict", efcontradict);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("eventfile/efcontradict/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid EventContradict eventContradict, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				eventContradict.setCreateBy(MySession.getInfo().getCode());
				if (eventContradictService.update(eventContradict) != 0) {
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

	/**
	 * 删除
	 * 
	 * @param allparty
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		/*
		 * for (int i = 0; i < tempList.size(); i++) { SysUser tempUser =
		 * tempList.get(i); List codesList = Arrays.asList(codes); if
		 * (codesList.contains(tempUser.getCode())) { tempList.remove(i); i--; }
		 * } return new ActionMessage(true);
		 */
		try {
			if (eventContradictService.deleteBatch(codes) != 0) {
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

}
