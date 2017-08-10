package com.dykj.GSM.action.yanpanfenxi;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.service.event.EContradictService;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

@RestController
@RequestMapping(value = "/yanpanfenxi/contradictquery")
public class EContradictQueryAction extends BaseAction {
	private static Logger logger = Logger.getLogger(EContradictQueryAction.class);
	@Autowired
	private EContradictService contradictService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zongheManageLoad")
	public ModelAndView zongheManageLoad() {
		return new ModelAndView("/yanpanfenxi/contradictquery/zongheManage");
	}

	/**
	 * 事件综合查询分页查询
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
			return contradictService.queryZongHePage(sidx, rows, page, sord, m);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return null;
	}

}
