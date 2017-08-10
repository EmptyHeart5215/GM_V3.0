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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.event.EOpinion;
import com.dykj.GSM.model.eventfile.EventKeyPlace;
import com.dykj.GSM.service.eventfile.EventKeyPlaceService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/eventfile/efkeyplace")
public class EventKeyPlaceAction extends BaseAction {

	private static Logger logger = Logger.getLogger(EventKeyPlaceAction.class);
	@Autowired
	private EventKeyPlaceService eKeyPlaceServ;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/manageLoad")
	public ModelAndView draftManageLoad() {
		return new ModelAndView("/eventfile/efkeyplace/manage");
	}

	/**
	 * 地图管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/mapmanageLoad")
	public ModelAndView draftmapManageLoad() {
		return new ModelAndView("/eventfile/efkeyplace/mapmanage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, EventKeyPlace param) {
		try {
			return eKeyPlaceServ.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String eventCode) {
		Map<String, Object> vdata = this.approvalData(eventCode);
		return new ModelAndView("/eventfile/efkeyplace/infoSee", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String eventCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			EventKeyPlace ekeyplace = eKeyPlaceServ.queryByKey(eventCode);
			vdata.put("efkeyplace", ekeyplace);
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
		vdata.put("url", "eventfile/efkeyplace/add");
		return new ModelAndView("/eventfile/efkeyplace/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid EventKeyPlace eKeyPlace, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				eKeyPlace.setCreateBy(MySession.getInfo().getCode());
				if (eKeyPlaceServ.insert(eKeyPlace) != 0) {
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
			EventKeyPlace param = eKeyPlaceServ.queryByKey(code);
			vdata.put("url", "eventfile/efkeyplace/modify");
			vdata.put("efkeyplace", param);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("eventfile/efkeyplace/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param fields
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid EventKeyPlace eventkeyplace, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				eventkeyplace.setCreateBy(MySession.getInfo().getCode());
				if (eKeyPlaceServ.update(eventkeyplace) != 0) {
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

	@RequestMapping(value = "/delete")
	public ActionMessage delete(@RequestParam List<String> codes) {

		try {
			if (eKeyPlaceServ.deleteBatch(codes) != 0) {
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
