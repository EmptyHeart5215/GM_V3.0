package com.dykj.GSM.action.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.action.base.BPersonAction;
import com.dykj.GSM.model.base.BBuilding;
import com.dykj.GSM.model.base.BEnterpriseStores;
import com.dykj.GSM.model.base.BHouse;
import com.dykj.GSM.model.base.BPerJingWai;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysSeatThird;
import com.dykj.GSM.model.sys.SysTempGrid;
import com.dykj.GSM.service.base.BBuildingService;
import com.dykj.GSM.service.base.BEnterpriseStoresService;
import com.dykj.GSM.service.base.BHouseService;
import com.dykj.GSM.service.base.BPerJingWaiService;
import com.dykj.GSM.service.base.BPersonService;
import com.dykj.GSM.service.sys.SysSeatFourService;
import com.dykj.GSM.service.sys.SysSeatGridService;
import com.dykj.GSM.service.sys.SysSeatThirdService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/map/mapshow")
public class MapShowAction extends BaseAction {
	private static Logger logger = Logger.getLogger(MapShowAction.class);
	@Autowired
	private SysSeatGridService sysSeatGridService;
	@Autowired
	private SysSeatFourService sysSeatFourService;
	@Autowired
	private SysSeatThirdService sysSeatThirdService;
	@Autowired
	private BBuildingService bBuildingService;
	@Autowired
	private BPersonService bPersonService;
	@Autowired
	private BPerJingWaiService bPerJingWaiService;
	@Autowired
	private BHouseService houseService;
	@Autowired
	private BEnterpriseStoresService enterstorService;

	@RequestMapping(value = "/mapShowLoad")
	public ModelAndView mapShowLoad() {
		return new ModelAndView("/map/mapshow");
	}

	/**
	 * 得到网格数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getSeatGridData")
	public Object getSeatGridData() {
		try {
			List<SysTempGrid> list = sysSeatGridService.queryGridTreeByUserGridCode(MySession.getInfo().getGridCode(),
					SysSeatGridService.DEPARTMENTFLAG_GRID, 20);
			return list;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@RequestMapping(value = "/showGridDetail")
	public ModelAndView showGridDetail(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatGrid sysSeatGrid = sysSeatGridService.queryByKey(code);
			Map<String, Object> chartMap = bPersonService.queryPersonTypeStatistics(code);
			map.put("seat", sysSeatGrid);
			map.put("chartMap", chartMap);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/seatgrid/gridmap", "map", map);
	}

	/**
	 * 得到社区数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getCommunityData")
	public Object getCommunityData() {
		try {
			List<SysTempGrid> list = sysSeatGridService.queryGridTreeByUserGridCode(MySession.getInfo().getGridCode(),
					SysSeatGridService.DEPARTMENTFLAG_GRID, 12);

			return list;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@RequestMapping(value = "/showCommunityDetail")
	public ModelAndView showCommunityDetail(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatFour sysSeatGrid = sysSeatFourService.queryByKey(code);
			Map<String, Object> chartMap = bPersonService.queryPersonTypeStatistics(code);
			map.put("chartMap", chartMap);
			map.put("seat", sysSeatGrid);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/seatfour/fourmap", "map", map);
	}

	/**
	 * 得到街道数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getStreetData")
	public Object getStreetData() {
		try {
			List<SysTempGrid> list = sysSeatGridService.queryGridTreeByUserGridCode(MySession.getInfo().getGridCode(),
					SysSeatGridService.DEPARTMENTFLAG_GRID, 8);
			return list;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@RequestMapping(value = "/showStreetDetail")
	public ModelAndView showStreetDetail(String code) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			SysSeatThird sysSeatGrid = sysSeatThirdService.queryByKey(code);
			Map<String, Object> chartMap = bPersonService.queryPersonTypeStatistics(code);
			map.put("chartMap", chartMap);
			map.put("seat", sysSeatGrid);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/seatthird/thirdmap", "map", map);
	}

	/**
	 * 得到单位门店数据
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getStoreData")
	public Object getStoreData() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("gridCode", MySession.getInfo().getGridCode());
			List<BEnterpriseStores> list = enterstorService.queryListParam(map);
			return list;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	@RequestMapping(value = "/showStoreDetail")
	public ModelAndView showStoreDetail(String code) {
		BEnterpriseStores enterpriseStores = null;
		try {
			enterpriseStores = enterstorService.queryByKey(code);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("base/benterprisestores/storemap", "store", enterpriseStores);
	}

	@RequestMapping(value = "/bcommunityMapmanageLoad")
	public ModelAndView draftmapManageLoad1() {
		return new ModelAndView("/map/bcommunitymapmanage");
	}

	@RequestMapping(value = "/bfeigongjingjiMapmanageLoad")
	public ModelAndView draftmapManageLoad2() {
		return new ModelAndView("/map/bfeigongjingjimapmanage");
	}

	@RequestMapping(value = "/fieldsMapmanageLoad")
	public ModelAndView mapmanageLoad1() {
		return new ModelAndView("/map/fieldsmapmanage");
	}

	@RequestMapping(value = "/houseMapmanageLoad")
	public ModelAndView mapmanageLoad2() {
		return new ModelAndView("/map/housemapmanage");
	}

	@RequestMapping(value = "/bjigouMapmanageLoad")
	public ModelAndView draftmapManageLoad3() {
		return new ModelAndView("/map/bjigoumapmanage");
	}

	@RequestMapping(value = "/bjigouserviceMapmanageLoad")
	public ModelAndView draftmapManageLoad4() {
		return new ModelAndView("/map/bjigouservicemapmanage");
	}

	@RequestMapping(value = "/bpartsMapmanageLoad")
	public ModelAndView draftmapManageLoad5() {
		return new ModelAndView("/map/bpartsmapmanage");
	}

	@RequestMapping(value = "/personMapmanageLoad")
	public ModelAndView draftmapManageLoad6() {
		return new ModelAndView("/map/personmapmanage");
	}

	/**
	 * 热点查询
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
	@RequestMapping(value = "/personmapqueryByParamPage")
	public Object mapqueryByParamPage(BPerson args) {
		try {
			return bPersonService.mapqueryByParamPage(args);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	@RequestMapping(value = "/broadconvenientMapmanageLoad")
	public ModelAndView draftmapManageLoad7() {
		return new ModelAndView("/map/broadconvenientmapmanage");
	}

	@RequestMapping(value = "/brouteeventsMapmanageLoad")
	public ModelAndView draftmapManageLoad8() {
		return new ModelAndView("/map/brouteeventsmapmanage");
	}

	@RequestMapping(value = "/econtradictMapdraftManageLoad")
	public ModelAndView mapdraftManageLoad9() {
		return new ModelAndView("/map/econtradictmapdraftManage");
	}

	@RequestMapping(value = "/eeventMapdraftManageLoad")
	public ModelAndView mapdraftManageLoad() {
		return new ModelAndView("/map/eeventmapmanage");
	}

	@RequestMapping(value = "/eeventMapwanJieManageLoad")
	public ModelAndView mapzhuxiaoManageLoad() {
		return new ModelAndView("/map/eeventmapzhuxiaoManage");
	}

	@RequestMapping(value = "/efactivitiesMapmanageLoad")
	public ModelAndView draftmapManageLoad10() {
		return new ModelAndView("/map/efactivitiesmapmanage");
	}

	@RequestMapping(value = "/efcontradictMapmanageLoad")
	public ModelAndView draftmapManageLoad11() {
		return new ModelAndView("/map/efcontradictmapmanage");
	}

	@RequestMapping(value = "/efharmsafeMapmanageLoad")
	public ModelAndView draftmapManageLoad12() {
		return new ModelAndView("/map/efharmsafemapmanage");
	}

	@RequestMapping(value = "/efinformationMapmanageLoad")
	public ModelAndView draftmapManageLoad13() {
		return new ModelAndView("/map/efinformationmapmanage");
	}

	@RequestMapping(value = "/efkeyplaceMapmanageLoad")
	public ModelAndView draftmapManageLoad14() {
		return new ModelAndView("/map/efkeyplacemapmanage");
	}

	@RequestMapping(value = "/efsignificantvisitsMapmanageLoad")
	public ModelAndView draftmapManageLoad15() {
		return new ModelAndView("/map/efsignificantvisitsmapmanage");
	}

	@RequestMapping(value = "/buildingMapmanageLoad")
	public ModelAndView mapmanageLoad() {
		return new ModelAndView("/map/buildingmapmanage");
	}

	/**
	 * 详细页面加载
	 * 
	 * @param code
	 *            主键
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/buildingmapinfoSee")
	public ModelAndView mapinfoSee(String code) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		BBuilding b = bBuildingService.queryByKey(code);
		vdata.put("building", b);
		return new ModelAndView("/map/buildingmapinfoSee", "vdata", vdata);
	}

	/**
	 * 详细页面加载
	 * 
	 * @param code
	 *            主键
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/housemapinfoSee")
	public ModelAndView housemapinfoSee(String code) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		BHouse b = houseService.queryByKey(code);
		vdata.put("house", b);
		return new ModelAndView("map/infosee/housemapinfosee", "vdata", vdata);
	}

	@RequestMapping(value = "/personmapinfoSee")
	public Object personmapinfoSee(@RequestParam String personCode, @RequestParam String personType,
			HttpServletRequest request) {
		Map<String, Object> vdata = new HashMap<String, Object>();

		ApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(request
				.getServletContext());
		BPersonAction personAction = ctx.getBean(BPersonAction.class);
		String url = "/base/person/jingwaiperinfosee";
		if ("jingNei".equals(personType) || "jingWai".equals(personType)) {
			vdata.put("personCode", personCode);
			try {
				if ("jingNei".equals(personType)) {
					url = "/map/infosee/personmapinfosee";
					BPerson b = bPersonService.queryByKeyForInfoSee(personCode);
					vdata.put("person", b);
					// 将附加的一些人员信息加入
					personAction.putMap(personCode, vdata, b);
				} else {
					BPerJingWai b = bPerJingWaiService.queryByKey(personCode);
					vdata.put("person", b);
				}
			} catch (Exception e) {
				logger.error("error", e);
			}
		} else if ("huji".equals(personType) || "liushou".equals(personType) || "liudong".equals(personType)) {
			url = "/map/infosee/personmapinfosee";
			BPerson b;
			try {
				b = bPersonService.queryByKeyForInfoSee(personCode);
				vdata.put("person", b);
				// 将附加的一些人员信息加入
				personAction.putMap(personCode, vdata, b, personType);
			} catch (Exception e) {
				logger.error("error", e);
			}

		} else {
			return new ActionMessage(false);
		}
		vdata.put("typeUrl", url);
		if (vdata instanceof java.util.Map) {
			Map<String, Object> v = vdata;
			return new ModelAndView(v.get("typeUrl").toString(), "vdata", vdata);
		}
		return new ModelAndView("map/infosee/personmapinfosee", "vdata", vdata);
	}
}
