package com.dykj.GSM.action.yanpanfenxi;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.service.base.BBuildingService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/yanpanfenxi/buildingchaxun")
public class BuildingQueryAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BuildingQueryAction.class);
	@Autowired
	private BBuildingService bBuildingService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/yanpanfenxi/buildingchaxun/manage");
	}

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/mapmanageLoad")
	public ModelAndView mapmanageLoad() {
		return new ModelAndView("/base/building/mapmanage");
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
	public Object queryManage(int page, int rows, String sidx, String sord, String args) {
		try {
			SessionModel model = MySession.getInfo();
			Map<String, Object> m = new HashMap<String, Object>();
			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			return bBuildingService.queryByMapParamPage(page, rows, sidx, sord, m);
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false).defaultPageError();
		}
	}

}
