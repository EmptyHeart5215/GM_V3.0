package com.dykj.GSM.action.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysTempGrid;
import com.dykj.GSM.service.sys.SysRegionService;
import com.dykj.GSM.service.sys.SysSeatGridService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/seatgird")
public class SysSeatGridAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysSeatGridAction.class);
	@Autowired
	private SysSeatGridService sysSeatGridService;
	@Autowired
	private SysRegionService sysRegionService;

	@RequestMapping(value = "/gridManageLoad")
	public ModelAndView gridmanageLoad(HttpServletResponse response) {
		return new ModelAndView("sys/seatgrid/gridmanage");
	}

	/**
	 * 通过自身权限获取树状辖区菜单
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryAllGridTree")
	public Object queryAllGridTree() {
		try {
			// 01是唐山市的
			List<SysTempGrid> list = new ArrayList<SysTempGrid>();
			list.addAll(sysSeatGridService.queryGridTreeByUserGridCode("01", SysSeatGridService.DEPARTMENTFLAG_GRID,
					null));
			return list;
		} catch (Exception e) {
			return new ActionMessage(false);
		}
	}

	/**
	 * 通过自身权限获取树状辖区菜单
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryGridTreeByUserGridCode")
	public Object queryGridTreeByUserGridCode(Integer leastLength) {
		try {
			List<SysTempGrid> list = new ArrayList<SysTempGrid>();
			SessionModel model = MySession.getInfo();
			list.addAll(sysSeatGridService.queryGridTreeByUserGridCode(model.getGridCode(),
					SysSeatGridService.DEPARTMENTFLAG_GRID, null, leastLength));
			return list;
		} catch (Exception e) {
			return new ActionMessage(false);
		}
	}

	/**
	 * 通过自身权限获取树状街道菜单
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryDepartmentTreeByUserGridCode")
	public Object queryDepartmentTreeByUserGridCode() {
		try {
			List<SysTempGrid> list = new ArrayList<SysTempGrid>();
			SessionModel model = MySession.getInfo();
			list.addAll(sysSeatGridService.queryDepartmentTreeByUserGridCode(model.getGridCode()));
			return list;
		} catch (Exception e) {
			return new ActionMessage(false);
		}
	}

	/**
	 * 获取全国省市区的树形列表
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryRegionTree")
	public Object queryRegionTree() {
		try {
			return sysRegionService.queryTree(null);
		} catch (Exception e) {
			return new ActionMessage(false);
		}
	}

	/*
	 * 得到整个组织机构树
	 */
	@RequestMapping(value = "/queryAllOrgTreeForSelect")
	public Object queryAllOrgTreeForSelect() {
		try {
			// 01是唐山市的
			List<SysTempGrid> list = new ArrayList<SysTempGrid>();
			list.addAll(sysSeatGridService.queryAllOrgTreeForSelect());
			return list;
		} catch (Exception e) {
			return new ActionMessage(false);
		}
	}

	/**
	 * 新增页面的加载
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView gridAddLoad(String parentCode, HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("url", "/sys/seatgird/add");
		SysSeatGrid grid = new SysSeatGrid();
		grid.setParentCode(parentCode);
		map.put("seat", grid);
		return new ModelAndView("sys/seatgrid/gridinfo", "map", map);
	}

	/**
	 * 新增
	 * 
	 * @param bSeatGrid
	 * @return @
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(SysSeatGrid seatGrid, BindingResult result, HttpServletRequest request) {
		SessionModel session = MySession.getInfo();
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				SysSeatFour sysSeatFour = sysSeatGridService.queryByparentCode(seatGrid.getParentCode());
				seatGrid.setFourName(sysSeatFour.getName());
				seatGrid.setCreateBy(session.getCode());
				seatGrid.setCreateBy(session.getCode());
				seatGrid.setGridTotalName(sysSeatFour.getGridTotalName() + "-" + seatGrid.getName());
				if (sysSeatGridService.insert(seatGrid) != 0) {
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
	 * 修改页面的加载
	 */
	@RequestMapping(value = "/queryByCode")
	public Object queryByCode(@RequestParam String code, HttpServletResponse response, HttpServletRequest request) {
		try {
			return sysSeatGridService.queryByKey(code);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ActionMessage(false);
	}

	/**
	 * 修改页面的加载
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView gridModifyLoad(String code, HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatGrid sysSeatGrid = sysSeatGridService.queryByKey(code);
			map.put("url", "/sys/seatgird/modify");
			map.put("seat", sysSeatGrid);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/seatgrid/gridinfo", "map", map);
	}

	/**
	 * 修改
	 * 
	 * @param bSeatGrid
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(SysSeatGrid bSeatGrid) {
		try {
			SysSeatFour sysSeatFour = sysSeatGridService.queryByparentCode(bSeatGrid.getParentCode());
			bSeatGrid.setFourName(sysSeatFour.getName());
			bSeatGrid.setGridTotalName(sysSeatFour.getGridTotalName() + "-" + bSeatGrid.getName());
			bSeatGrid.setCreateBy(MySession.getInfo().getCode());
			if (sysSeatGridService.update(bSeatGrid) != 0) {
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
	 * 修改
	 * 
	 * @param bSeatGrid
	 * @return @
	 */
	@RequestMapping(value = "/deleteGrid")
	public ActionMessage deleteGrid(String gridCode) {
		try {
			int i = sysSeatGridService.deleteGrid(gridCode);
			if (i != 0) {
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
	 * 通过自身权限获取树状机构组织管理菜单，这里获得的是辖区和部门的全部内容
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryOrgnizationTree")
	public Object queryOrgnizationTree() {
		try {
			return sysSeatGridService.queryGridTreeByUserGridCode("01", null, null);
		} catch (Exception e) {
			logger.error(e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 通过自身权限获取树状机构组织管理菜单，获取部门和街道的树状菜单，供用户进行部门选择
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/queryOrgnizationTreeForSelect")
	public Object queryOrgnizationTreeForSelect() {
		try {
			SessionModel session = MySession.getInfo();
			return sysSeatGridService.queryDepartmentAndStreetTreeByUserGridCode(session.getGridCode());
		} catch (Exception e) {
			logger.error(e);
			return new ActionMessage(false);
		}

	}

	@RequestMapping(value = "/orgManageLoad")
	public ModelAndView orgManageLoad(HttpServletResponse response) {
		return new ModelAndView("sys/org/organizationManage");
	}

	/**
	 * 新增组织机构页面的加载
	 */
	@RequestMapping(value = "/addOrgLoad")
	public ModelAndView addOrgLoad(String parentCode) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("parentCode", parentCode);
		map.put("url", "/sys/seatgird/add");
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}

	/**
	 * 修改页面的加载
	 */
	@RequestMapping(value = "/modifyOrgLoad")
	public ModelAndView modifyOrgLoad(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatGrid sysSeatGrid = sysSeatGridService.queryByKey(code);
			map.put("url", "/sys/seatgird/modifyOrg");
			map.put("seat", sysSeatGrid);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/org/orgInfo", "map", map);
	}

	/**
	 * 修改
	 * 
	 * @param bSeatGrid
	 * @return @
	 */
	@RequestMapping(value = "/modifyOrg")
	public ActionMessage modifyOrg(SysSeatGrid bSeatGrid) {
		try {
			SysSeatFour sysSeatFour = sysSeatGridService.queryByparentCode(bSeatGrid.getParentCode());
			bSeatGrid.setFourName(sysSeatFour.getName());
			bSeatGrid.setGridTotalName(sysSeatFour.getGridTotalName() + "-" + bSeatGrid.getName());
			if (sysSeatGridService.update(bSeatGrid) != 0) {
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
