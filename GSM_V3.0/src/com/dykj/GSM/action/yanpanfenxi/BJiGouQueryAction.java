package com.dykj.GSM.action.yanpanfenxi;

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
//import com.dykj.GSM.model.base.BJiGouManage;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/yanpanfenxi/jigouquery")
public class BJiGouQueryAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BJiGouQueryAction.class);
//	private List<BJiGouManage> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/yanpanfenxi/jigouquery/manage");
	}

//	/**
//	 * 分页查询
//	 * 
//	 * @param page
//	 *            页码
//	 * @param rows
//	 *            每页条数
//	 * @param sort
//	 *            排序字段名称
//	 * @param order
//	 *            排序类型
//	 * @param args
//	 *            参数
//	 * @return json数据
//	 * @throws ParseException
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/queryManage")
//	public List<BJiGouManage> queryManage(int page, int rows, String sort, String order, BJiGouManage args)
//			throws ParseException {
//		if (tempList == null) {
//			tempI = 4;
//			tempList = new ArrayList<BJiGouManage>();
//			for (int i = 0; i < 5; i++) {
//				BJiGouManage BJiGouManage = new BJiGouManage();
//				BJiGouManage.setCode(i + "");
//				BJiGouManage.setJigouName("机构名称" + i + "");
//				BJiGouManage.setGridCode("所属网格");
//				BJiGouManage.setAddress("机构办公地址" + i);
//				BJiGouManage.setJigouManager("机构负责人" + i);
//
//				BJiGouManage.setGridName(i + "网格联系人");
//				BJiGouManage.setGridDuty(i + "网格联系人职务");
//				BJiGouManage.setGridPhone(i + "网格联系人电话");
//
//				BJiGouManage.setCreateDate(DateFormatUtil.getStringDate());
//				tempList.add(BJiGouManage);
//			}
//		}
//		return tempList;
//	}
//
//	/**
//	 * 新增页面加载
//	 * 
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/addLoad")
//	public ModelAndView addLoad() {
//		Map<String, Object> vdata = new HashMap<String, Object>();
//		vdata.put("url", "yanpanfenxi/jigouquery/add");
//		return new ModelAndView("/yanpanfenxi/jigouquery/info", "vdata", vdata);
//	}
//
//	/**
//	 * 新增
//	 * 
//	 * @param BJiGouManage
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/add")
//	public ActionMessage add(@Valid BJiGouManage BJiGouManage, BindingResult result) {
//		tempI++;
//		BJiGouManage.setCode(tempI + "");
//		if (result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			ObjectError oe = list.get(0);
//			return new ActionMessage(false).setinfo(oe.getDefaultMessage());
//		}
//		BJiGouManage.setCreateDate(DateFormatUtil.getStringDate());
//		tempList.add(BJiGouManage);
//		return new ActionMessage(true);
//	}
//
//	/**
//	 * 修改页面加载
//	 * 
//	 * @param code
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/modifyLoad")
//	public ModelAndView modifyLoad(String code) {
//		Map<String, Object> vdata = new HashMap<String, Object>();
//		BJiGouManage bjigou = null;
//		for (BJiGouManage tempDic : tempList) {
//			if (tempDic.getCode().equals(code)) {
//				bjigou = tempDic;
//			}
//		}
//		vdata.put("url", "yanpanfenxi/jigouquery/modify");
//		vdata.put("bjigou", bjigou);
//		return new ModelAndView("yanpanfenxi/jigouquery/info", "vdata", vdata);
//	}
//
//	/**
//	 * 修改
//	 * 
//	 * @param BJiGouManage
//	 * @return
//	 * @throws Exception
//	 */
//	@RequestMapping(value = "/modify")
//	public ActionMessage modify(BJiGouManage BJiGouManage) throws Exception {
//		for (int i = 0; i < tempList.size(); i++) {
//			BJiGouManage jigou = tempList.get(i);
//			if (jigou.getCode().equals(BJiGouManage.getCode())) {
//				BJiGouManage.setCreateDate(DateFormatUtil.getStringDate());
//				tempList.set(i, BJiGouManage);
//			}
//		}
//		return new ActionMessage(true);
//	}
//
//	@RequestMapping(value = "/delete")
//	public ActionMessage delete(String[] codes) {
//		for (int i = 0; i < tempList.size(); i++) {
//			BJiGouManage tempDic = tempList.get(i);
//			List codesList = Arrays.asList(codes);
//			if (codesList.contains(tempDic.getCode())) {
//				tempList.remove(i);
//				i--;
//			}
//		}
//		return new ActionMessage(true);
//	}
}
