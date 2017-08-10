package com.dykj.GSM.action.base;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.base.BPerBfCanJi;
import com.dykj.GSM.service.base.BPerBfCanJiService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

/**
 * @author 王海红
 * @description 特殊人群中的刑释解教人员
 * 
 */
@RestController
@RequestMapping(value = "/base/perbfcanji")
public class BPerBfCanJiAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BPerBfCanJiAction.class);
	@Autowired
	private BPerBfCanJiService bPerBfCanJiService;

	/**
	 * 新增
	 * 
	 * @param bbuilding
	 * @return @
	 */
	@ResponseBody
	@RequestMapping(value = "/person/addOrModify")
	public ActionMessage add(@Valid BPerBfCanJi person, BindingResult result) {
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
				i = bPerBfCanJiService.update(person);
			} else {
				i = bPerBfCanJiService.insert(person);
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
			int i = bPerBfCanJiService.deletePk(code);
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
}
