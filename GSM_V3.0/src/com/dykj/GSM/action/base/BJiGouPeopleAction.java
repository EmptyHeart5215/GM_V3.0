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
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/base/bjigoupeople")
public class BJiGouPeopleAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BJiGouPeopleAction.class);
	@Autowired
	private BJiGouPeopleService jigoupeople;
	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad(@RequestParam String personCode) {
		return new ModelAndView("/base/bjigoupeople/manage", "personCode", personCode);
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, BJiGouPeople param,String personCode) {
		try {
			param.setPersonCode(personCode);
			param.setGuanLian("1E39B8CAAF48415B8124A8B64C93FF3F");
			return jigoupeople.queryByParamPage(page, rows, sidx, sord, param);
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
	public ModelAndView addLoad(@RequestParam String personCode) {
		System.out.println(personCode+"-------------------------");
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "base/bjigoupeople/add");
		vdata.put("bjigoupeoplecode", personCode);
		return new ModelAndView("/base/bjigoupeople/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BJiGouPeople jigou, BindingResult result,String personCode) {
		
		jigou.setPersonCode(personCode);
		try { 
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				jigou.setCreateBy(MySession.getInfo().getCode());
				if (0 != jigoupeople.insert(jigou)) {
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
			BJiGouPeople jigou = jigoupeople.queryByKey(code);
			vdata.put("url", "base/bjigoupeople/modify");
			vdata.put("bjigoupeople", jigou);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("base/bjigoupeople/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BJiGouPeople jigou, BindingResult result) throws Exception {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				jigou.setCreateBy(MySession.getInfo().getCode());
				if (jigoupeople.update(jigou) != 0) {
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
	public ActionMessage delete(@RequestParam List<String> codes) {

		try {
			if (jigoupeople.deleteBatch(codes) != 0) {
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
		BJiGouPeople jigou = jigoupeople.queryByKey(code);
		vdata.put("bjigoupeople", jigou);
		return new ModelAndView("base/bjigoupeople/infoSee", "vdata", vdata);

	}

}
