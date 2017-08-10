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
import com.dykj.GSM.model.zhihuizhongxin.GridMessage;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/zhihuizhongxin/gridmessage")
public class GridMessageAction extends BaseAction {
	private static Logger logger = Logger.getLogger(GridMessageAction.class);
	private List<GridMessage> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/zhihuizhongxin/gridmessage/manage");
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
	public List<GridMessage> queryManage(int page, int rows, String sort, String order, GridMessage args)
			throws ParseException {
		if (tempList == null) {
			tempI = 4;
			tempList = new ArrayList<GridMessage>();
			for (int i = 0; i < 5; i++) {
				GridMessage GridMessage = new GridMessage();
				GridMessage.setCode(i + "");
				GridMessage.setGridUserName("网格员姓名" + i);
				GridMessage.setGridUserPhone("手机号" + i);
				GridMessage.setGridName("网格名称" + i);

				tempList.add(GridMessage);
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
		vdata.put("url", "/zhihuizhongxin/gridmessage/add");
		return new ModelAndView("/zhihuizhongxin/gridmessage/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid GridMessage sysgrid, BindingResult result) {
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
		GridMessage video = null;
		for (GridMessage GridMessage : tempList) {
			if (GridMessage.getCode().equals(code)) {
				video = GridMessage;
			}
		}
		vdata.put("url", "zhihuizhongxin/gridmessage/modify");
		vdata.put("video", video);
		return new ModelAndView("zhihuizhongxin/gridmessage/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid GridMessage dvdiogrid) {
		for (int i = 0; i < tempList.size(); i++) {
			GridMessage GridMessage = tempList.get(i);
			if (GridMessage.getCode().equals(dvdiogrid.getCode())) {
				dvdiogrid.setCreateDate(DateFormatUtil.getStringDate());
				tempList.set(i, dvdiogrid);
			}
		}
		return new ActionMessage(true);
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(String[] codes) {
		for (int i = 0; i < tempList.size(); i++) {
			GridMessage GridMessage = tempList.get(i);
			List codesList = Arrays.asList(codes);
			if (codesList.contains(GridMessage.getCode())) {
				tempList.remove(i);
				i--;
			}
		}
		return new ActionMessage(true);
	}
}
