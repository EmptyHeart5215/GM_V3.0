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
import com.dykj.GSM.model.partybuilding.PartyMemberManager;
import com.dykj.GSM.service.partybuilding.PartyRetiredService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

/**
 * 退休党员
 * 
 * @author wangmingyuan
 */
@RestController
@RequestMapping(value = "/partybuilding/retiredparty")
public class PartyRetiredAction extends BaseAction {
	private static Logger logger = Logger.getLogger(PartyRetiredAction.class);
	@Autowired
	private PartyRetiredService partyRetiredService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/partybuilding/retiredparty/manage");
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
	public Object queryManage(int page, int rows, String sidx, String sord, PartyMemberManager param)
			throws ParseException {
		try {
			param.setCodePartyType("tuixiuparty");
			return partyRetiredService.queryByParamPage(page, rows, sidx, sord, param);
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
		PartyMemberManager partymembermanager = new PartyMemberManager();
		partymembermanager.setCodePartyType("退休");
		vdata.put("retiredparty", partymembermanager);
		vdata.put("url", "partybuilding/retiredparty/add");
		return new ModelAndView("/partybuilding/retiredparty/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param retiredparty
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid PartyMemberManager partymembermanager, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				partymembermanager.setCreateBy(MySession.getInfo().getCode());
				if (partyRetiredService.insert(partymembermanager) != 0) {
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
	 * @param retiredparty
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			PartyMemberManager partymembermanager = partyRetiredService.queryByKey(code);
			vdata.put("url", "partybuilding/retiredparty/modify");
			vdata.put("retiredparty", partymembermanager);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("partybuilding/retiredparty/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param retiredparty
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid PartyMemberManager partymembermanager, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				partymembermanager.setCreateBy(MySession.getInfo().getCode());
				if (partyRetiredService.update(partymembermanager) != 0) {
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
	 * @param retiredparty
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (partyRetiredService.deleteBatch(codes) != 0) {
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
		PartyMemberManager partymembermanager = partyRetiredService.queryByKey(code);
		vdata.put("retiredparty", partymembermanager);
		return new ModelAndView("partybuilding/retiredparty/infoSee", "vdata", vdata);
	}
}