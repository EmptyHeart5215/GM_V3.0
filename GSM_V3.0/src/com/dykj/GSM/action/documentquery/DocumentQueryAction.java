package com.dykj.GSM.action.documentquery;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
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
import com.dykj.GSM.model.documentquery.DocumentQuery;
import com.dykj.GSM.service.documentquery.DocumentQueryService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

/**
 * @author wangmingyuan
 */

@RestController
@RequestMapping(value = "/documentquery/document")
public class DocumentQueryAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DocumentQueryAction.class);
	@Autowired
	private DocumentQueryService documentQueryService;

	/**
	 * 新增页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad(HttpServletRequest request) {
		return new ModelAndView("documentquery/manage");
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
		vdata.put("url", "documentquery/document/add");
		return new ModelAndView("/documentquery/info", "vdata", vdata);
	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code, HttpServletRequest request) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			request.getSession().setAttribute("loginCode", MySession.getInfo().getCode());
			DocumentQuery doc = documentQueryService.queryByKey(code);
			vdata.put("url", "documentquery/document/modify");
			vdata.put("DocumentQuery", doc);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("documentquery/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param activities
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid DocumentQuery documentQuery, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				documentQuery.setCreateBy(MySession.getInfo().getCode());
				if (documentQueryService.insert(documentQuery) != 0) {
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
	 * 修改
	 * 
	 * @param activities
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid DocumentQuery documentQuery, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				documentQuery.setCreateBy(MySession.getInfo().getCode());
				if (documentQueryService.update(documentQuery) != 0) {
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
	 * @param codes
	 * @return
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {
		try {
			if (documentQueryService.deleteBatch(codes) != 0) {
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
	public Object queryManage(int page, int rows, String sidx, String sord, DocumentQuery param) throws ParseException {
		try {
			return documentQueryService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false).defaultPageError();
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
		DocumentQuery doc = documentQueryService.queryByKey(code);
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("doc", doc);
		return new ModelAndView("documentquery/infoSee", "vdata", vdata);
	}
}
