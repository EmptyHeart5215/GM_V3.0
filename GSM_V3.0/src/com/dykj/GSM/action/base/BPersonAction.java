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
import com.dykj.GSM.model.base.BPerBfCanJi;
import com.dykj.GSM.model.base.BPerBfDiBao;
import com.dykj.GSM.model.base.BPerBfJiuZhu;
import com.dykj.GSM.model.base.BPerBfKongChao;
import com.dykj.GSM.model.base.BPerBfKunNanZhiGong;
import com.dykj.GSM.model.base.BPerBfTeKunSheng;
import com.dykj.GSM.model.base.BPerBfWuBao;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerHuJi;
import com.dykj.GSM.model.base.BPerJingWai;
import com.dykj.GSM.model.base.BPerLaoDong;
import com.dykj.GSM.model.base.BPerLiuDong;
import com.dykj.GSM.model.base.BPerLiuShou;
import com.dykj.GSM.model.base.BPerQingShaoNian;
import com.dykj.GSM.model.base.BPerTSAiZi;
import com.dykj.GSM.model.base.BPerTSJiaoZheng;
import com.dykj.GSM.model.base.BPerTSJingShen;
import com.dykj.GSM.model.base.BPerTSXiDu;
import com.dykj.GSM.model.base.BPerTSXieJiao;
import com.dykj.GSM.model.base.BPerTSXingShi;
import com.dykj.GSM.model.base.BPerYongJun;
import com.dykj.GSM.model.base.BPerZhiYuan;
import com.dykj.GSM.model.base.BPerZiYuan;
import com.dykj.GSM.model.base.BPerson;
import com.dykj.GSM.service.base.BBuildingService;
import com.dykj.GSM.service.base.BHouseService;
import com.dykj.GSM.service.base.BPerBfCanJiService;
import com.dykj.GSM.service.base.BPerBfDiBaoService;
import com.dykj.GSM.service.base.BPerBfJiuZhuService;
import com.dykj.GSM.service.base.BPerBfKongChaoService;
import com.dykj.GSM.service.base.BPerBfKunNanZhiGongService;
import com.dykj.GSM.service.base.BPerBfTeKunShengService;
import com.dykj.GSM.service.base.BPerBfWuBaoService;
import com.dykj.GSM.service.base.BPerHuJiService;
import com.dykj.GSM.service.base.BPerJingWaiService;
import com.dykj.GSM.service.base.BPerLaoDongService;
import com.dykj.GSM.service.base.BPerLiuDongService;
import com.dykj.GSM.service.base.BPerLiuShouService;
import com.dykj.GSM.service.base.BPerQingShaoNianService;
import com.dykj.GSM.service.base.BPerTSAiZiService;
import com.dykj.GSM.service.base.BPerTSJiaoZhengService;
import com.dykj.GSM.service.base.BPerTSJingShenService;
import com.dykj.GSM.service.base.BPerTSXiDuService;
import com.dykj.GSM.service.base.BPerTSXieJiaoService;
import com.dykj.GSM.service.base.BPerTSXingShiService;
import com.dykj.GSM.service.base.BPerYongJunService;
import com.dykj.GSM.service.base.BPerZhiYuanService;
import com.dykj.GSM.service.base.BPerZiYuanService;
import com.dykj.GSM.service.base.BPersonService;
import com.dykj.GSM.service.base.BUnitService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/base/person")
public class BPersonAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BPersonAction.class);
	@Autowired
	private BUnitService bUnitService;
	@Autowired
	private BBuildingService bBuildingService;
	@Autowired
	private BHouseService houseService;
	@Autowired
	private BPersonService bPersonService;
	@Autowired
	private BPerJingWaiService bPerJingWaiService;
	@Autowired
	private BPerHuJiService bPerHuJiService;
	@Autowired
	private BPerLiuDongService bPerLiuDongService;
	@Autowired
	private BPerLiuShouService bPerLiuShouService;
	@Autowired
	private BPerTSXingShiService bPerTSXingShiService;
	@Autowired
	private BPerTSJiaoZhengService bPerTSJiaoZhengService;
	@Autowired
	private BPerTSJingShenService bPerTSJingShenService;
	@Autowired
	private BPerTSXiDuService bPerTSXiDuService;
	@Autowired
	private BPerTSAiZiService bPerTSAiZiService;
	@Autowired
	private BPerQingShaoNianService bPerQingShaoNianService;
	@Autowired
	private BPerTSXieJiaoService bPerTSXieJiaoService;
	@Autowired
	private BPerBfCanJiService bPerBfCanJiService;
	@Autowired
	private BPerBfDiBaoService bPerBfDiBaoService;
	@Autowired
	private BPerBfJiuZhuService bPerBfJiuZhuService;
	@Autowired
	private BPerBfKongChaoService bPerBfKongChaoService;
	@Autowired
	private BPerBfKunNanZhiGongService bPerBfKunNanZhiGongService;
	@Autowired
	private BPerBfTeKunShengService bPerBfTeKunShengService;
	@Autowired
	private BPerBfWuBaoService bPerBfWuBaoService;
	@Autowired
	private BPerYongJunService bPerYongJunService;
	@Autowired
	private BPerZiYuanService bPerZiYuanService;
	@Autowired
	private BPerZhiYuanService bPerZhiYuanService;
	@Autowired
	private BPerLaoDongService bPerLaoDongService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/person/manage");
	}

	/**
	 * 加载通过基础党建调用人口相关信息的人口管理界面
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/partyByPersonManage")
	public ModelAndView partyByPersonManage(String gridCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("gridCode", gridCode);
		return new ModelAndView("/base/person/partybypersonmanage", "vdata", vdata);
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
	public Object queryManage(int page, int rows, String sidx, String sord, BPerson args, Boolean realQuery) {
		try {
			if (realQuery) {
				return bPersonService.queryParamPageMap(page, rows, sidx, sord, args);
			} else {
				return new Page(page, rows, sidx, sord);
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false).defaultPageError();
		}
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
	@RequestMapping(value = "/queryByParamPage")
	public Object queryByParamPage(int page, int rows, String sidx, String sord, BPerson param) {
		try {
			return bPersonService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad(@RequestParam String houseCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		Map<String, Object> person = new HashMap<String, Object>();
		vdata.put("url", "base/person/add");
		person.put("houseCode", houseCode);
		try {
			BHouse h = houseService.queryByKey(houseCode);
			person.put("buildName", h.getBuildName());
			person.put("gridTotalName", h.getGridTotalName());
			putUrlIntoMap(vdata);
		} catch (Exception e) {
			logger.error("error", e);
		}
		vdata.put("person", person);
		return new ModelAndView("/base/person/info", "vdata", vdata);
	}

	/**
	 * 新增境外页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/addJingWaiLoad")
	public ModelAndView addJingWaiLoad(@RequestParam String houseCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		Map<String, Object> person = new HashMap<String, Object>();
		vdata.put("url", "base/person/addJingWai");
		person.put("houseCode", houseCode);
		try {
			BHouse h = houseService.queryByKey(houseCode);
			person.put("buildName", h.getBuildName());
			person.put("gridTotalName", h.getGridTotalName());
		} catch (Exception e) {
			logger.error("error", e);
		}
		vdata.put("person", person);
		return new ModelAndView("/base/person/jingwaiperinfo", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param bbuilding
	 * @return @
	 */
	@ResponseBody
	@RequestMapping(value = "/addJingWai")
	public ActionMessage addJingWai(@Valid BPerJingWai person, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			person.setCreateBy(session.getCode());
			int i = bPerJingWaiService.insert(person);
			if (i > 0) {
				return new ActionMessage(true).setinfo(person);
			} else {
				throw new Exception("没有成功插入数据!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 新增
	 * 
	 * @param bbuilding
	 * @return @
	 */
	@ResponseBody
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BPerson person, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				System.out.println(oe);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			if (person.getCode() == null || "".equals(person.getCode().trim())) {
				SessionModel session = MySession.getInfo();
				person.setCreateBy(session.getCode());
				int i = bPersonService.insert(person);
				if (i > 0) {
					return new ActionMessage(true).setinfo(person);
				} else {
					throw new Exception("没有成功插入数据!");
				}
			} else {
				return this.modify(person, result);
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String personCode, @RequestParam String personType) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		String url = "/base/person/jingwaiperinfo";
		if ("jingNei".equals(personType) || "jingWai".equals(personType)) {
			vdata.put("personCode", personCode);
			try {
				if ("jingNei".equals(personType)) {
					url = "/base/person/info";
					vdata.put("url", "base/person/modify");
					BPerson b = bPersonService.queryByKey(personCode);
					vdata.put("person", b);
					// 将附加的一些人员信息加入
					putMap(personCode, vdata, b);
				} else {
					vdata.put("url", "base/person/modifyJingWai");
					BPerJingWai b = bPerJingWaiService.queryByKey(personCode);
					vdata.put("person", b);
				}
			} catch (Exception e) {
				logger.error("error", e);
			}
		} else {
			return null;
		}
		return new ModelAndView(url, "vdata", vdata);
	}

	private void putUrlIntoMap(Map<String, Object> vdata) {
		// 户籍人口
		vdata.put("huJiUrl", "/base/perhuji/person/addOrModify");
		vdata.put("huJiDelUrl", "/base/perhuji/person/delete");
		// 流动人口
		vdata.put("liuDongUrl", "/base/perliudong/person/addOrModify");
		vdata.put("liuDongDelUrl", "/base/perliudong/person/delete");
		// 留守人员
		vdata.put("liuShouUrl", "/base/perliushou/person/addOrModify");
		vdata.put("liuShouDelUrl", "/base/perliushou/person/delete");
		// 刑满释放
		vdata.put("tSXingShiUrl", "/base/pertsxingshi/person/addOrModify");
		vdata.put("tSXingShiDelUrl", "/base/pertsxingshi/person/delete");
		// 社区矫正
		vdata.put("tSJiaoZhengUrl", "/base/pertsjiaozheng/person/addOrModify");
		vdata.put("tSJiaoZhengDelUrl", "/base/pertsjiaozheng/person/delete");
		// 精神病
		vdata.put("tSJingShenUrl", "/base/pertsjingshen/person/addOrModify");
		vdata.put("tSJingShenDelUrl", "/base/pertsjingshen/person/delete");
		// 吸毒
		vdata.put("tSXiDuUrl", "/base/pertsxidu/person/addOrModify");
		vdata.put("tSXiDuDelUrl", "/base/pertsxidu/person/delete");
		// 邪教
		vdata.put("tSXieJiaoUrl", "/base/pertsxiejiao/person/addOrModify");
		vdata.put("tSXieJiaoDelUrl", "/base/pertsxiejiao/person/delete");
		// 重点青少年
		vdata.put("qingShaoNianUrl", "/base/perqingshaonian/person/addOrModify");
		vdata.put("qingShaoNianDelUrl", "/base/perqingshaonian/person/delete");
		// 残疾
		vdata.put("bfCanJiUrl", "/base/perbfcanji/person/addOrModify");
		vdata.put("bfCanJiDelUrl", "/base/perbfcanji/person/delete");
		// 低保户
		vdata.put("bfDiBaoUrl", "/base/perbfdibao/person/addOrModify");
		vdata.put("bfDiBaoDelUrl", "/base/perbfdibao/person/delete");
		// 五保户
		vdata.put("bfWuBaoUrl", "/base/perbfwubao/person/addOrModify");
		vdata.put("bfWuBaoDelUrl", "/base/perbfwubao/person/delete");
		// 社区救助
		vdata.put("bfJiuZhuUrl", "/base/perbfjiuzhu/person/addOrModify");
		vdata.put("bfJiuZhuDelUrl", "/base/perbfjiuzhu/person/delete");
		// 空巢老人
		vdata.put("bfKongChaoUrl", "/base/perbfkongchao/person/addOrModify");
		vdata.put("bfKongChaoDelUrl", "/base/perbfkongchao/person/delete");
		// 困难职工
		vdata.put("bfKunNanZhiGongUrl", "/base/perbfkunnanzhigong/person/addOrModify");
		vdata.put("bfKunNanZhiGongDelUrl", "/base/perbfkunNanZhiGong/person/delete");
		// 特困生
		vdata.put("bfTeKunShengUrl", "/base/perbftekunsheng/person/addOrModify");
		vdata.put("bfTeKunShengDelUrl", "/base/perbftekunsheng/person/delete");
		// 拥军
		vdata.put("yongJunUrl", "/base/peryongjun/person/addOrModify");
		vdata.put("yongJunDelUrl", "/base/peryongjun/person/delete");
		// 资源人群
		vdata.put("ziYuanUrl", "/base/perziyuan/person/addOrModify");
		vdata.put("ziYuanDelUrl", "/base/perziyuan/person/delete");
		// 志愿者
		vdata.put("zhiYuanUrl", "/base/perzhiyuan/person/addOrModify");
		vdata.put("zhiYuanDelUrl", "/base/perzhiyuan/person/delete");
		// 劳动保障
		vdata.put("laoDongUrl", "/base/perlaodong/person/addOrModify");
		vdata.put("laoDongDelUrl", "/base/perlaodong/person/delete");
		// 艾滋
		vdata.put("tSAiZiUrl", "/base/pertsaizi/person/addOrModify");
		vdata.put("tSAiZiDelUrl", "/base/pertsaizi/person/delete");

	}

	public void putMap(String personCode, Map<String, Object> vdata, BPerson b) throws Exception {
		putUrlIntoMap(vdata);
		BPerFuShu fuShu = b.getFuShu();
		if (fuShu.getBfCanJi()) {
			// 残疾
			BPerBfCanJi can = bPerBfCanJiService.queryByPersonCode(personCode);
			vdata.put("bfCanJiPerson", can);
		}
		if (fuShu.getBfDiBao()) {
			// 低保户
			BPerBfDiBao diBao = bPerBfDiBaoService.queryByPersonCode(personCode);
			vdata.put("bfDiBaoPerson", diBao);
		}
		if (fuShu.getBfJiuZhu()) {
			// 社区救助
			BPerBfJiuZhu jiu = bPerBfJiuZhuService.queryByPersonCode(personCode);
			vdata.put("bfJiuZhuPerson", jiu);
		}
		if (fuShu.getBfKongChao()) {
			// 空巢老人
			BPerBfKongChao kong = bPerBfKongChaoService.queryByPersonCode(personCode);
			vdata.put("bfKongChaoPerson", kong);
		}
		if (fuShu.getBfKunNanZhiGong()) {
			// 困难职工
			BPerBfKunNanZhiGong kunNanZhiGong = bPerBfKunNanZhiGongService.queryByPersonCode(personCode);
			vdata.put("bfKunNanZhiGongPerson", kunNanZhiGong);
		}
		if (fuShu.getBfLiuShou()) {
			// 留守人员
			BPerLiuShou l = bPerLiuShouService.queryByPersonCode(personCode);
			vdata.put("liuShouPerson", l);
		}
		if (fuShu.getBfTeKunSheng()) {
			// 特困生
			BPerBfTeKunSheng teKunSheng = bPerBfTeKunShengService.queryByPersonCode(personCode);
			vdata.put("bfTeKunShengPerson", teKunSheng);
		}
		if (fuShu.getBfWuBao()) {
			// 五保户
			BPerBfWuBao wuBao = bPerBfWuBaoService.queryByPersonCode(personCode);
			vdata.put("bfWuBaoPerson", wuBao);
		}
		if (fuShu.getTsAiZi()) {
			// 艾滋病
			BPerTSAiZi ai = bPerTSAiZiService.queryByPersonCode(personCode);
			vdata.put("tSAiZiPerson", ai);
		}
		if (fuShu.getTsJiaoZheng()) {
			// 社区矫正
			BPerTSJiaoZheng j = bPerTSJiaoZhengService.queryByPersonCode(personCode);
			vdata.put("tSJiaoZhengPerson", j);
		}
		if (fuShu.getTsJingShen()) {
			// 精神病
			BPerTSJingShen ji = bPerTSJingShenService.queryByPersonCode(personCode);
			vdata.put("tSJingShenPerson", ji);
		}
		if (fuShu.getTsXiDu()) {
			// 吸毒
			BPerTSXiDu xi = bPerTSXiDuService.queryByPersonCode(personCode);
			vdata.put("tSXiDuPerson", xi);
		}
		if (fuShu.getTsXieJiao()) {
			// 邪教
			BPerTSXieJiao xie = bPerTSXieJiaoService.queryByPersonCode(personCode);
			vdata.put("tSXieJiaoPerson", xie);
		}
		if (fuShu.getTsXingShi()) {
			// 刑满释放
			BPerTSXingShi x = bPerTSXingShiService.queryByPersonCode(personCode);
			vdata.put("tSXingShiPerson", x);
		}
		if (fuShu.getHuJi()) {
			// 户籍人口
			BPerHuJi perHuji = bPerHuJiService.queryByPersonCode(personCode);
			vdata.put("huJiPerson", perHuji);
		}
		if (fuShu.getLiuDong()) {
			// 流动人口
			BPerLiuDong liu = bPerLiuDongService.queryByPersonCode(personCode);
			vdata.put("liuDongPerson", liu);
		}
		if (fuShu.getQingShaoNian()) {
			// 重点青少年
			BPerQingShaoNian qing = bPerQingShaoNianService.queryByPersonCode(personCode);
			vdata.put("qingShaoNian", qing);
		}
		if (fuShu.getYongJun()) {
			// 拥军
			BPerYongJun yongjun = bPerYongJunService.queryByPersonCode(personCode);
			vdata.put("yongJunPerson", yongjun);
		}
		if (fuShu.getZiYuan()) {
			// 资源人群
			BPerZiYuan ziyuan = bPerZiYuanService.queryByPersonCode(personCode);
			vdata.put("ziYuanPerson", ziyuan);
		}
		if (fuShu.getZhiYuan()) {
			// 志愿者
			BPerZhiYuan zhiyuan = bPerZhiYuanService.queryByPersonCode(personCode);
			vdata.put("zhiYuanPerson", zhiyuan);
		}
		if (fuShu.getLaoDong()) {
			BPerLaoDong laodong = bPerLaoDongService.queryByPersonCode(personCode);
			vdata.put("laoDongPerson", laodong);
		}
	}

	public void putMap(String personCode, Map<String, Object> vdata, BPerson b, String personType) throws Exception {
		putUrlIntoMap(vdata);
		switch (personType) {
		case "canji":
			// 残疾
			BPerBfCanJi can = bPerBfCanJiService.queryByPersonCode(personCode);
			vdata.put("bfCanJiPerson", can);
			break;
		case "dibao":
			// 低保户
			BPerBfDiBao diBao = bPerBfDiBaoService.queryByPersonCode(personCode);
			vdata.put("bfDiBaoPerson", diBao);
			break;
		case "jiuzhu":
			// 社区救助
			BPerBfJiuZhu jiu = bPerBfJiuZhuService.queryByPersonCode(personCode);
			vdata.put("bfJiuZhuPerson", jiu);
			break;
		case "kongchao":
			// 空巢老人
			BPerBfKongChao kong = bPerBfKongChaoService.queryByPersonCode(personCode);
			vdata.put("bfKongChaoPerson", kong);
			break;
		case "kunnan":
			// 困难职工
			BPerBfKunNanZhiGong kunNanZhiGong = bPerBfKunNanZhiGongService.queryByPersonCode(personCode);
			vdata.put("bfKunNanZhiGongPerson", kunNanZhiGong);
			break;
		case "liushou":
			// 留守人员
			BPerLiuShou l = bPerLiuShouService.queryByPersonCode(personCode);
			vdata.put("liuShouPerson", l);
			break;
		case "tekun":
			// 特困生
			BPerBfTeKunSheng teKunSheng = bPerBfTeKunShengService.queryByPersonCode(personCode);
			vdata.put("bfTeKunShengPerson", teKunSheng);
			break;
		case "wubao":
			// 五保户
			BPerBfWuBao wuBao = bPerBfWuBaoService.queryByPersonCode(personCode);
			vdata.put("bfWuBaoPerson", wuBao);
			break;
		case "aizi":
			// 艾滋病
			BPerTSAiZi ai = bPerTSAiZiService.queryByPersonCode(personCode);
			vdata.put("tSAiZiPerson", ai);
			break;
		case "jiaozheng":
			// 社区矫正
			BPerTSJiaoZheng j = bPerTSJiaoZhengService.queryByPersonCode(personCode);
			vdata.put("tSJiaoZhengPerson", j);
			break;
		case "jingshen":
			// 精神病
			BPerTSJingShen ji = bPerTSJingShenService.queryByPersonCode(personCode);
			vdata.put("tSJingShenPerson", ji);
			break;
		case "xidu":
			// 吸毒
			BPerTSXiDu xi = bPerTSXiDuService.queryByPersonCode(personCode);
			vdata.put("tSXiDuPerson", xi);
			break;
		case "xiejiao":
			// 邪教
			BPerTSXieJiao xie = bPerTSXieJiaoService.queryByPersonCode(personCode);
			vdata.put("tSXieJiaoPerson", xie);
			break;
		case "shifang":
			// 刑满释放
			BPerTSXingShi x = bPerTSXingShiService.queryByPersonCode(personCode);
			vdata.put("tSXingShiPerson", x);
			break;
		case "huji":
			// 户籍人口
			BPerHuJi perHuji = bPerHuJiService.queryByPersonCode(personCode);
			vdata.put("huJiPerson", perHuji);
			break;
		case "liudong":
			// 流动人口
			BPerLiuDong liu = bPerLiuDongService.queryByPersonCode(personCode);
			vdata.put("liuDongPerson", liu);
			break;
		case "qingshaonian":
			// 重点青少年
			BPerQingShaoNian qing = bPerQingShaoNianService.queryByPersonCode(personCode);
			vdata.put("qingShaoNian", qing);
			break;
		case "yongjin":
			// 拥军
			BPerYongJun yongjun = bPerYongJunService.queryByPersonCode(personCode);
			vdata.put("yongJunPerson", yongjun);
			break;
		case "ziyuan":
			// 资源人群
			BPerZiYuan ziyuan = bPerZiYuanService.queryByPersonCode(personCode);
			vdata.put("ziYuanPerson", ziyuan);
			break;
		case "zhiyuan":
			// 志愿者
			BPerZhiYuan zhiyuan = bPerZhiYuanService.queryByPersonCode(personCode);
			vdata.put("zhiYuanPerson", zhiyuan);
			break;
		case "laodong":
			BPerLaoDong laodong = bPerLaoDongService.queryByPersonCode(personCode);
			vdata.put("laoDongPerson", laodong);
			break;
		}
	}

	/**
	 * 新增
	 * 
	 * @param bbuilding
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BPerson person, BindingResult result) {
		try {
			if (person.getCode() == null || "".equals(person.getCode().trim())) {
				return new ActionMessage(false);
			}
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			person.setCreateBy(session.getCode());
			int i = bPersonService.update(person);
			if (i > 0) {
				return new ActionMessage(true).setinfo(person);
			} else {
				throw new Exception("更新数据没有成功!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/modifyJingWai")
	public ActionMessage modifyJingWai(@Valid BPerJingWai person, BindingResult result) {
		try {
			if (person.getCode() == null || "".equals(person.getCode().trim())) {
				return new ActionMessage(false);
			}
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			person.setCreateBy(session.getCode());
			int i = bPerJingWaiService.update(person);
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

	@RequestMapping(value = "/deleteJingWai")
	public ActionMessage deleteJingWai(@RequestParam String code) {
		try {
			int i = bPerJingWaiService.deletePk(code);
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

	@RequestMapping(value = "/person/delete")
	public ActionMessage delete(@RequestParam String code) {
		try {
			int i = bPersonService.deletePk(code);
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
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/infoSee")
	public ModelAndView infoSee(@RequestParam String personCode, @RequestParam String personType) {
		Object vdata = this.infoSeeData(personCode, personType);
		if (vdata instanceof java.util.Map) {
			Map<String, Object> v = (Map<String, Object>) vdata;
			return new ModelAndView(v.get("typeUrl").toString(), "vdata", vdata);
		}
		return null;
	}

	@RequestMapping(value = "/infoSeeData")
	public Object infoSeeData(@RequestParam String personCode, @RequestParam String personType) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		String url = "/base/person/jingwaiperinfosee";
		if ("jingNei".equals(personType) || "jingWai".equals(personType)) {
			vdata.put("personCode", personCode);
			try {
				if ("jingNei".equals(personType)) {
					url = "/base/person/infoSee";
					BPerson b = bPersonService.queryByKeyForInfoSee(personCode);
					vdata.put("person", b);
					// 将附加的一些人员信息加入
					putMap(personCode, vdata, b);
				} else {
					BPerJingWai b = bPerJingWaiService.queryByKey(personCode);
					vdata.put("person", b);
				}
			} catch (Exception e) {
				logger.error("error", e);
			}
		} else if ("huji".equals(personType) || "liushou".equals(personType) || "liudong".equals(personType)) {
			url = "/base/person/infoSee";
			BPerson b;
			try {
				b = bPersonService.queryByKeyForInfoSee(personCode);
				vdata.put("person", b);
				// 将附加的一些人员信息加入
				putMap(personCode, vdata, b, personType);
			} catch (Exception e) {
				logger.error("error", e);
			}

		} else {
			return new ActionMessage(false);
		}
		vdata.put("typeUrl", url);
		return vdata;
	}
}
