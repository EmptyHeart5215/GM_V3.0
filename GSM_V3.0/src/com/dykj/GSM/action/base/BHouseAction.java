package com.dykj.GSM.action.base;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.base.BHouse;
import com.dykj.GSM.model.base.BUnit;
import com.dykj.GSM.service.base.BBuildingService;
import com.dykj.GSM.service.base.BHouseService;
import com.dykj.GSM.service.base.BUnitService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/base/house")
public class BHouseAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BHouseAction.class);
	@Autowired
	private BHouseService houseService;
	@Autowired
	private BUnitService bUnitService;
	@Autowired
	private BBuildingService bBuildingService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/house/manage");
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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, BHouse args, Boolean realQuery) {
		try {
			if (realQuery) {
				SessionModel session = MySession.getInfo();
				args.setGridCode(session.getGridCode());
				return houseService.queryByParamPage(page, rows, sidx, sord, args);
			} else {
				return new Page(page, rows, sidx, sord);
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad(@RequestParam String unitCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "base/house/add");
		Map<String, Object> house = new HashMap<String, Object>();
		house.put("unitCode", unitCode);
		try {
			BUnit u = bUnitService.queryByKey(unitCode);
			house.put("buildCode", u.getBuildCode());
			house.put("buildName", u.getBuildName());
			house.put("gridCode", u.getGridCode());
			house.put("gridTotalName", u.getGridTotalName());
			house.put("unitName", u.getName());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		vdata.put("house", house);
		return new ModelAndView("/base/house/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param bunit
	 * @return @
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BHouse house, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			house.setCreateBy(session.getCode());
			int i = houseService.insert(house);
			if (i > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("没有成功插入数据!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			BHouse b = houseService.queryByKey(code);
			vdata.put("house", b);
		} catch (Exception e) {
			logger.error("error", e);
		}
		vdata.put("url", "base/house/modify");
		return new ModelAndView("base/house/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param house
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BHouse house, BindingResult result) {
		try {
			if (house.getCode() == null || "".equals(house.getCode().trim())) {
				return new ActionMessage(false);
			}
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			house.setCreateBy(session.getCode());
			int i = houseService.update(house);
			if (i > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("更新数据没有成功!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(@RequestParam String code) {
		try {
			int i = houseService.deletePk(code);
			if (i > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("删除数据没有成功!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
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
		BHouse b = houseService.queryByKey(code);
		vdata.put("house", b);
		return new ModelAndView("base/house/infoSee", "vdata", vdata);
	}

	/**
	 * 手机查询
	 */
	@RequestMapping(value = "/infoSeej")
	public Object infoSeej(String code) throws Exception {

		Map<String, Object> vdata = new HashMap<String, Object>();
		BHouse b = houseService.queryByKey(code);
		vdata.put("house", b);
		return vdata;
	}
}
