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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.base.BBuilding;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.service.base.BBuildingService;
import com.dykj.GSM.service.sys.SysSeatGridService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/base/building")
public class BBuildingAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BBuildingAction.class);
	@Autowired
	private BBuildingService bBuildingService;
	@Autowired
	private SysSeatGridService sysSeatGridService;

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
	 * @param realQuery
	 *            判断是否是真的查询，用于人房新增中的列表展示
	 * @return json数据 @
	 */
	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, BBuilding args, Boolean realQuery) {
		try {
			if (args.getGridCode() == null || args.getGridCode().trim().isEmpty()) {
				SessionModel session = MySession.getInfo();
				// 暂时写成01
				args.setGridCode(session.getGridCode());
			}
			return bBuildingService.queryByParamPage(page, rows, sidx, sord, args);
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
	public ModelAndView addLoad(@RequestParam String gridCode) {
		if (gridCode.length() != 20) {
			return null;
		}
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "base/building/add");
		Map<String, Object> building = new HashMap<String, Object>();
		building.put("gridCode", gridCode);
		try {
			SysSeatGrid grid = sysSeatGridService.queryByKey(gridCode);
			building.put("gridTotalName", grid.getGridTotalName());
			vdata.put("building", building);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("/base/building/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param bbuilding
	 * @return @
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BBuilding building, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			// 暂时写成01
			building.setCreateBy(session.getCode());
			int i = bBuildingService.insert(building);
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
			BBuilding b = bBuildingService.queryByKey(code);
			vdata.put("building", b);
		} catch (Exception e) {
			logger.error("error", e);
		}
		vdata.put("url", "base/building/modify");
		return new ModelAndView("base/building/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param building
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BBuilding building, BindingResult result) {
		try {
			if (building.getCode() == null || "".equals(building.getCode().trim())) {
				return new ActionMessage(false);
			}
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel s = MySession.getInfo();
			building.setCreateBy(s.getCode());
			int i = bBuildingService.update(building);
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
			int i = bBuildingService.deletePk(code);
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
		BBuilding b = bBuildingService.queryByKey(code);
		vdata.put("building", b);
		return new ModelAndView("base/building/infoSee", "vdata", vdata);
	}

	@RequestMapping(value = "/queryNameTreeBy")
	public List<Map<String, Object>> queryNameTreeBy(String gridCode) {
		List<Map<String, Object>> list = bBuildingService.queryNameTreeBy(gridCode);
		return list;
	}

	@RequestMapping(value = "/personCharts")
	public List<Map<String, Object>> personCharts(String code) {
		List<Map<String, Object>> vdata = bBuildingService.mapbpersonCharts(code);
		return vdata;
	}

	@RequestMapping(value = "/queryLpb")
	public Map<String, Object> queryLpb(String buildcode) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> JUMIN = bBuildingService.queryLpb(buildcode);
		map.put("JUMIN", JUMIN);
		map.put("DISHANG", "");
		map.put("DIXIASHI", "");
		return map;
	}

}
