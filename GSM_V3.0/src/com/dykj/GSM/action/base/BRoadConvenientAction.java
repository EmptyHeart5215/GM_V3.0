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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.base.BRoadConvenient;
import com.dykj.GSM.service.base.BRoadConvenientService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/base/broadconvenient")
public class BRoadConvenientAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BRoadConvenientAction.class);
	@Autowired
	private BRoadConvenientService bRoadConvenientService;

	// @Autowired
	// private SysSeatGridService sysSeatGridService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/broadconvenient/manage");
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
	public Object queryManage(int page, int rows, String sidx, String sord, BRoadConvenient param)
			throws ParseException {
		try {
			return bRoadConvenientService.queryByParamPage(page, rows, sidx, sord, param);
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
		vdata.put("url", "base/broadconvenient/add");
		return new ModelAndView("/base/broadconvenient/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BCommunity
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BRoadConvenient bRoadConvenient, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				bRoadConvenient.setCreateBy(MySession.getInfo().getCode());
				if (bRoadConvenientService.insert(bRoadConvenient) != 0) {
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
			BRoadConvenient BRoadConvenient = bRoadConvenientService.queryByKey(code);
			vdata.put("url", "base/broadconvenient/modify");
			vdata.put("BRoadConvenient", BRoadConvenient);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("base/broadconvenient/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param BCommunity
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BRoadConvenient bRoadConvenient, BindingResult result) throws Exception {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				bRoadConvenient.setCreateBy(MySession.getInfo().getCode());
				if (bRoadConvenientService.update(bRoadConvenient) != 0) {
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

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (bRoadConvenientService.deleteBatch(codes) != 0) {
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
		BRoadConvenient BRoadConvenient = bRoadConvenientService.queryByKey(code);
		vdata.put("BRoadConvenient", BRoadConvenient);
		return new ModelAndView("base/broadconvenient/infoSee", "vdata", vdata);
	}
}
