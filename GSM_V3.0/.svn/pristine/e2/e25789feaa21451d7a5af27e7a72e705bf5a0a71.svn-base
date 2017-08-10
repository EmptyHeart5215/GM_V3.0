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
import com.dykj.GSM.service.base.BHouseService;
import com.dykj.GSM.service.base.BUnitService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

@RestController
@RequestMapping(value = "/yanpanfenxi/housechaxun")
public class HouseQueryAction extends BaseAction {
	private static Logger logger = Logger.getLogger(HouseQueryAction.class);
	@Autowired
	private BHouseService houseService;
	@Autowired
	private BUnitService bUnitService;
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
		return new ModelAndView("/yanpanfenxi/housechaxun/manage");
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
	@RequestMapping(value = "/zongheManage")
	public Object zongheManage(int page, int rows, String sidx, String sord, String args) {
		SessionModel model = MySession.getInfo();
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m, "stepId");
			m = Utils.handleDateValue(m, "shouLiDate");
			if (m.get("gridCode") == null || m.get("gridCode").toString().isEmpty()) {
				m.put("gridCode", model.getGridCode());
			}
			return houseService.queryZongHePage(sidx, rows, page, sord, m);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}
}
