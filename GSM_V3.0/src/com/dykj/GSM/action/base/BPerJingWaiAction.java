package com.dykj.GSM.action.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.service.base.BPerJingWaiService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月10日 上午10:26:51
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:境外人口
 */
@RestController
@RequestMapping(value = "/base/perjingwai")
public class BPerJingWaiAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BPerJingWaiAction.class);
	@Autowired
	private BPerJingWaiService bPerJingWaiService;

	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, String args) {
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
//			m.put("gridCode", MySession.getInfo().getGridCode());
			return bPerJingWaiService.queryByMapParamPage(page, rows, sidx, sord, m);
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/shiyouperson/jingwaimanage");
	}
}
