package com.dykj.GSM.action.base;

import java.text.ParseException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import net.sf.json.JSONArray;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BJiGouService;
import com.dykj.GSM.model.base.BJiGouServicePeople;
import com.dykj.GSM.service.base.BJiGouServicePeopleService;
import com.dykj.GSM.service.base.BJiGouServiceService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

@RestController
@RequestMapping(value = "/base/bjigouservice")
public class BJiGouServiceAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BJiGouServiceAction.class);
	@Autowired
	private BJiGouServiceService jigouservs;
	@Autowired
	private BJiGouServicePeopleService jiGouServicePeopleService;
	@Autowired
	private com.dykj.GSM.service.base.BJiGouService jigou;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/bjigouservice/manage");
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
	public Object queryByParamPage(int page, int rows, String sidx, String sord, String args) {
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			Page<BJiGouService> pages = jigouservs.queryByParamPage(page, rows, sidx, sord, m);
			return pages;
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	@RequestMapping(value = "/queryPeopleManage")
	public Object queryPeopleManage(int page, int rows, String sidx, String sord, String serviceId, String people) {
		try {
			int start = 0;
			int end = page * rows;
			Page<Object> pages = new Page<Object>(page, rows, sidx, sord);

			pages.setNowPage(page);
			pages.setPageSize(rows);
			pages.setStartRow(start);
			pages.setEndRow(end);

			if (people != null && people != "") {
				List<Object> l = Arrays.asList(JSONArray.toCollection(JSONArray.fromObject(people),
						BJiGouServicePeople.class).toArray());

				List<Object> row = l.subList(start, end);
				pages.setTotal((l.size() - 1) / rows + 1);
				pages.setRows(row);
				pages.setRecords(l.size());
			}
			return pages;
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	@RequestMapping(value = "/detailLoad")
	public ModelAndView detailLoad(String entryId, int stepId, String eventCode) {
		Map<String, Object> vdata = this.approvalData(entryId, stepId, eventCode);
		return new ModelAndView("/base/bjigouservice/approval", "vdata", vdata);
	}

	@RequestMapping(value = "/approvalData")
	public Map<String, Object> approvalData(String entryId, int stepId, String eventCode) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			BJiGouService jigouserv = jigouservs.queryByKey(eventCode);
			vdata.put("jigouserv", jigouserv);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return vdata;
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
		vdata.put("url", "base/bjigouservice/add");
		return new ModelAndView("/base/bjigouservice/info", "vdata", vdata);
	}

	@RequestMapping(value = "/addPeopleLoad")
	public ModelAndView addPeopleLoad(@RequestParam String serviceId) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "base/bjigouservice/addPeople");
		Map<String, Object> people = new HashMap<String, Object>();
		people.put("code", UUID.randomUUID().toString());
		vdata.put("jiGouServicePeople", people);
		vdata.put("serviceId", serviceId);
		return new ModelAndView("/base/bjigouservice/people/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BJiGouService jigouserv, String people, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if (people != null && people != "") {
					people = people.replaceAll("-", "");
					List<Object> l = Arrays.asList(JSONArray.toCollection(JSONArray.fromObject(people),
							BJiGouServicePeople.class).toArray());
					jigouserv.setPeoples(l);
				}
				jigouserv.setCreateBy(MySession.getInfo().getCode());
				if (0 != jigouservs.insert(jigouserv)) {
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

			BJiGouService jigouserv = jigouservs.queryByKey(code);
			vdata.put("url", "base/bjigouservice/modify");
			vdata.put("bjigouser", jigouserv);
			List<BJiGouServicePeople> old = jiGouServicePeopleService.queryAllByServiceId(jigouserv.getCode());

			vdata.put("people", JSONArray.fromObject(old).toString());
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("base/bjigouservice/info", "vdata", vdata);
	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyPeopleLoad")
	public ModelAndView modifyPeopleLoad(String code, String name, String phone, String address, String sex,
			HttpServletRequest request) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {

			sex = new String(request.getParameter("sex").getBytes("ISO-8859-1"), "UTF-8");
			name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			address = new String(request.getParameter("address").getBytes("ISO-8859-1"), "UTF-8");
			BJiGouServicePeople people = new BJiGouServicePeople();
			people.setCode(code);
			people.setName(name);
			people.setSex(sex);
			people.setPhone(phone);
			people.setAddress(address);
			vdata.put("url", "base/bjigouservice/modifyPeople");
			vdata.put("jiGouServicePeople", people);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("base/bjigouservice/people/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param BJiGou
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BJiGouService jigouserv, String people, BindingResult result) throws Exception {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				if (people != null && people != "") {
					people = people.replaceAll("-", "");
					List<Object> l = Arrays.asList(JSONArray.toCollection(JSONArray.fromObject(people),
							BJiGouServicePeople.class).toArray());
					jigouserv.setPeoples(l);
				}
				jigouserv.setCreateBy(MySession.getInfo().getCode());
				if (jigouservs.update(jigouserv) != 0) {
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
			if (jigouservs.deleteBatch(codes) != 0) {
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
		BJiGouService jigouserv = jigouservs.queryByKey(code);
		// BJiGou bjigou=jigou.queryByKey(jigouserv.getJigouName());
		// vdata.put("bjigou", bjigou);
		vdata.put("jigouserv", jigouserv);
		return new ModelAndView("base/bjigouservice/infoSee", "vdata", vdata);
	}
}
