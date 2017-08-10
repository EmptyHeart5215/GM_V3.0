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
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.base.BPerTSXingShi;
import com.dykj.GSM.service.base.BPerTSXingShiService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.Utils;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月5日 上午9:31:05
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:刑满释放的人员
 */
@RestController
@RequestMapping(value = "/base/pertsxingshi")
public class BPerTSXingShiAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BPerTSXingShiAction.class);
	@Autowired
	private BPerTSXingShiService bPerTSXingShiService;

	/**
	 * 新增
	 * 
	 * @param bbuilding
	 * @return @
	 */
	@ResponseBody
	@RequestMapping(value = "/person/addOrModify")
	public ActionMessage add(@Valid BPerTSXingShi person, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			SessionModel session = MySession.getInfo();
			person.setCreateBy(session.getCode());
			int i = -1;
			if (person.getCode() != null && !person.getCode().trim().isEmpty()) {
				i = bPerTSXingShiService.update(person);
			} else {
				i = bPerTSXingShiService.insert(person);
			}
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

	@RequestMapping(value = "/person/delete")
	public ActionMessage delete(@RequestParam String code) {
		try {
			int i = bPerTSXingShiService.deletePk(code);
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

	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, String args) {
		try {
			Map<String, Object> m = new HashMap<String, Object>();
			m = Utils.transformMap(args, m);
			m = Utils.handleDateValue(m, "shiFangDate,xianJieDate");
//			m.put("gridCode", MySession.getInfo().getGridCode());
			return bPerTSXingShiService.queryByMapParamPage(page, rows, sidx, sord, m);
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
		return new ModelAndView("/base/teshuperson/xingshimanage");
	}
}
