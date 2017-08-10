package com.dykj.GSM.action.waringset;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.warningset.WarningSet;
import com.dykj.GSM.service.warningset.WarningSetService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/waringset")
public class WWaringSetAction extends BaseAction {
	private static Logger logger = Logger.getLogger(WWaringSetAction.class);
	@Autowired
	private WarningSetService warningserv;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			WarningSet WarSet = warningserv.queryOne();
			vdata.put("url", "/waringset/modify");
			vdata.put("WarSet", WarSet);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("/waringset/manage", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param WarningSet
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid WarningSet warSet) throws Exception {
		try {
			warSet.setCreateBy(MySession.getInfo().getCode());
			if (warningserv.insert(warSet) != 0) {
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
