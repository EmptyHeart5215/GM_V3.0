package com.dykj.GSM.action.sys;

import java.util.Calendar;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.sys.SysLegalDate;
import com.dykj.GSM.service.sys.SysLegalDateService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/legaldate")
public class SysLegalDateAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysLegalDateAction.class);
	@Autowired
	private SysLegalDateService legalDateService;

	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/legaldate/info");
	}

	@RequestMapping(value = "/queryManage")
	public SysLegalDate queryManage(@RequestParam Integer year, @RequestParam Integer month) {
		try {
			return legalDateService.queryByYearAndMonth(year, month);
		} catch (Exception e) {
			logger.error("error", e);
			return null;
		}
	}

	/**
	 * 新增
	 * 
	 * @param rnotice
	 * @return @
	 */
	@RequestMapping(value = "/update")
	public ActionMessage update(@Valid SysLegalDate legalDate, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}

			Calendar now = Calendar.getInstance();
			Integer currentYear = now.get(Calendar.YEAR);
			Integer currentMonth = now.get(Calendar.MONTH) + 1;
			if (legalDate.getYear() < currentYear || legalDate.getYear() == currentYear
					&& legalDate.getMonth() < currentMonth) {
				return new ActionMessage(false).setinfo("不能修改" + legalDate.getYear() + "年" + legalDate.getMonth()
						+ "月的数据");
			}
			legalDate.setCreateBy(MySession.getInfo().getCode());
			if (legalDateService.insertOrUpdate(legalDate) > 0) {
				return new ActionMessage(true);
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false).setinfo(e.getMessage());
		}
		return new ActionMessage(false);
	}
}
