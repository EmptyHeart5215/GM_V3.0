package com.dykj.GSM.action.zhihui;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.zhihuizhongxin.Message;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/zhihuizhongxin/message")
public class MessageAction extends BaseAction {
	private static Logger logger = Logger.getLogger(MessageAction.class);
	private List<Message> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/zhihuizhongxin/message/manage");
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
	public List<Message> queryManage(int page, int rows, String sort, String order, Message args) throws ParseException {
		if (tempList == null) {
			tempI = 4;
			tempList = new ArrayList<Message>();
			for (int i = 0; i < 5; i++) {
				Message Message = new Message();
				Message.setCode(i + "");
				Message.setUserName("姓名" + i);
				Message.setUserPhone("手机号" + i);
				Message.setMessage("短信内容" + i);
				Message.setSendTime("发送时间" + i);
				tempList.add(Message);
			}
		}
		return tempList;
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
		vdata.put("url", "/zhihuizhongxin/message/add");
		return new ModelAndView("/zhihuizhongxin/message/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid Message sysgrid, BindingResult result) {
		tempI++;
		sysgrid.setCode(tempI + "");
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			ObjectError oe = list.get(0);
			return new ActionMessage(false).setinfo(oe.getDefaultMessage());
		}
		sysgrid.setCreateDate(DateFormatUtil.getStringDate());
		tempList.add(sysgrid);
		return new ActionMessage(true);
	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		Message video = null;
		for (Message Message : tempList) {
			if (Message.getCode().equals(code)) {
				video = Message;
			}
		}
		vdata.put("url", "zhihuizhongxin/message/modify");
		vdata.put("video", video);
		return new ModelAndView("zhihuizhongxin/message/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid Message dvdiogrid) {
		for (int i = 0; i < tempList.size(); i++) {
			Message Message = tempList.get(i);
			if (Message.getCode().equals(dvdiogrid.getCode())) {
				dvdiogrid.setCreateDate(DateFormatUtil.getStringDate());
				tempList.set(i, dvdiogrid);
			}
		}
		return new ActionMessage(true);
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(String[] codes) {
		for (int i = 0; i < tempList.size(); i++) {
			Message Message = tempList.get(i);
			List codesList = Arrays.asList(codes);
			if (codesList.contains(Message.getCode())) {
				tempList.remove(i);
				i--;
			}
		}
		return new ActionMessage(true);
	}
}
