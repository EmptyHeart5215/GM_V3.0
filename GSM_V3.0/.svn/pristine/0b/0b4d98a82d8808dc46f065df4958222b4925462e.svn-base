package com.dykj.GSM.action.base;

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
import com.dykj.GSM.model.base.BShiYouPerson;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/base/qingnianperson")
public class BQingNianPersonAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BQingNianPersonAction.class);
	private List<BShiYouPerson> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/qingnianperson/manage");
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
	public List<BShiYouPerson> queryManage(int page, int rows, String sort, String order, BShiYouPerson args)
			throws ParseException {
		if (tempList == null) {
			tempI = 4;
			tempList = new ArrayList<BShiYouPerson>();
			for (int i = 0; i < 5; i++) {
				BShiYouPerson SysCommunityMem = new BShiYouPerson();
				SysCommunityMem.setName("张" + i + "");
				SysCommunityMem.setCodeSex("男");
				SysCommunityMem.setCid("13020619523022541" + i);
				SysCommunityMem.setAge("1" + i);
				SysCommunityMem.setCodeNation("民族");
				SysCommunityMem.setPhone(i + "联系电话");
				SysCommunityMem.setCodeHouseHoldType(i + "人户状态");
				SysCommunityMem.setCodeManageType(i + "管理类型");
				SysCommunityMem.setNameMarriage(i + "婚姻情况");
				SysCommunityMem.setResidenceAddress(i + "户籍地");
				SysCommunityMem.setNameHealth(i + "现住址");
				SysCommunityMem.setWorkAddress(i + "工作单位");
				SysCommunityMem.setInflowDate(i + "流入时间");

				SysCommunityMem.setCreateDate(DateFormatUtil.getStringDate());
				tempList.add(SysCommunityMem);
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
		vdata.put("url", "sys/BShiYouPerson/add");
		return new ModelAndView("/sys/BShiYouPerson/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BShiYouPerson
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BShiYouPerson BShiYouPerson, BindingResult result) {
		tempI++;
		BShiYouPerson.setCode(tempI + "");
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			ObjectError oe = list.get(0);
			return new ActionMessage(false).setinfo(oe.getDefaultMessage());
		}
		BShiYouPerson.setCreateDate(DateFormatUtil.getStringDate());
		tempList.add(BShiYouPerson);
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
		BShiYouPerson dic = null;
		for (BShiYouPerson tempDic : tempList) {
			if (tempDic.getCode().equals(code)) {
				dic = tempDic;
			}
		}
		vdata.put("url", "sys/BShiYouPerson/modify");
		vdata.put("BShiYouPerson", dic);
		return new ModelAndView("sys/BShiYouPerson/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param BShiYouPerson
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(BShiYouPerson BShiYouPerson) throws Exception {
		for (int i = 0; i < tempList.size(); i++) {
			BShiYouPerson tempDic = tempList.get(i);
			if (tempDic.getCode().equals(BShiYouPerson.getCode())) {
				BShiYouPerson.setCreateDate(DateFormatUtil.getStringDate());
				tempList.set(i, BShiYouPerson);
			}
		}
		return new ActionMessage(true);
	}

	@RequestMapping(value = "/person/delete")
	public ActionMessage delete(String[] codes) {
		for (int i = 0; i < tempList.size(); i++) {
			BShiYouPerson tempDic = tempList.get(i);
			List codesList = Arrays.asList(codes);
			if (codesList.contains(tempDic.getCode())) {
				tempList.remove(i);
				i--;
			}
		}
		return new ActionMessage(true);
	}
}
