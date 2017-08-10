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
import com.dykj.GSM.model.zhihuizhongxin.HuJiaoDengJi;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/zhihuizhongxin/hujiaochaxun")
public class HuJiaoChaXunAction extends BaseAction {
	private static Logger logger = Logger.getLogger(HuJiaoChaXunAction.class);
	private List<HuJiaoDengJi> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/zhihuizhongxin/hujiaochaxun/manage");
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
	public List<HuJiaoDengJi> queryManage(int page, int rows, String sort, String order, HuJiaoDengJi args)
			throws ParseException {
		if (tempList == null) {
			tempI = 4;
			tempList = new ArrayList<HuJiaoDengJi>();
			for (int i = 0; i < 5; i++) {
				HuJiaoDengJi HuJiaoDengJi = new HuJiaoDengJi();
				HuJiaoDengJi.setCode(i + "");
				HuJiaoDengJi.setCallName("登记人" + i);
				HuJiaoDengJi.setEventTitle("事件标题" + i);
				HuJiaoDengJi.setAddress("登记人住址" + i);
				HuJiaoDengJi.setAppealCard("登记人身份证" + i);

				tempList.add(HuJiaoDengJi);
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
		vdata.put("url", "/zhihuizhongxin/hujiaochaxun/add");
		return new ModelAndView("/zhihuizhongxin/hujiaochaxun/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid HuJiaoDengJi sysgrid, BindingResult result) {
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
		HuJiaoDengJi hj = null;
		for (HuJiaoDengJi HuJiaoDengJi : tempList) {
			if (HuJiaoDengJi.getCode().equals(code)) {
				hj = HuJiaoDengJi;
			}
		}
		vdata.put("url", "zhihuizhongxin/hujiaochaxun/modify");
		vdata.put("hj", hj);
		return new ModelAndView("/zhihuizhongxin/hujiaochaxun/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid HuJiaoDengJi dvdiogrid) {
		for (int i = 0; i < tempList.size(); i++) {
			HuJiaoDengJi HuJiaoDengJi = tempList.get(i);
			if (HuJiaoDengJi.getCode().equals(dvdiogrid.getCode())) {
				dvdiogrid.setCreateDate(DateFormatUtil.getStringDate());
				tempList.set(i, dvdiogrid);
			}
		}
		return new ActionMessage(true);
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(String[] codes) {
		for (int i = 0; i < tempList.size(); i++) {
			HuJiaoDengJi HuJiaoDengJi = tempList.get(i);
			List codesList = Arrays.asList(codes);
			if (codesList.contains(HuJiaoDengJi.getCode())) {
				tempList.remove(i);
				i--;
			}
		}
		return new ActionMessage(true);
	}
}
