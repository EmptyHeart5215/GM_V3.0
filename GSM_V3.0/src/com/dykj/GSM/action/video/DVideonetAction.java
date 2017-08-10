package com.dykj.GSM.action.video;

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
import com.dykj.GSM.model.video.DVideonet;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/video/dvideonet")
public class DVideonetAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DVideonetAction.class);
	private List<DVideonet> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/video/dvideonet/manage");
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
	public List<DVideonet> queryManage(int page, int rows, String sort, String order, DVideonet args)
			throws ParseException {
		if (tempList == null) {
			tempI = 4;
			tempList = new ArrayList<DVideonet>();
			for (int i = 0; i < 5; i++) {
				DVideonet DVideonet = new DVideonet();
				DVideonet.setCode(i + "");
				DVideonet.setDevicePort("设备端口" + i);
				DVideonet.setIp("连接IP" + i);
				DVideonet.setName("视频名称" + i);
				DVideonet.setNetPort("网络端口" + i);
				DVideonet.setGridName("所属网格" + i);
				DVideonet.setUserName("用户名" + i);
				DVideonet.setUserPwd("密码" + i);
				tempList.add(DVideonet);
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
		vdata.put("url", "/video/dvideonet/add");
		return new ModelAndView("/video/dvideonet/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid DVideonet sysgrid, BindingResult result) {
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
		DVideonet video = null;
		for (DVideonet DVideonet : tempList) {
			if (DVideonet.getCode().equals(code)) {
				video = DVideonet;
			}
		}
		vdata.put("url", "video/dvideonet/modify");
		vdata.put("video", video);
		return new ModelAndView("video/dvideonet/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid DVideonet dvdiogrid) {
		for (int i = 0; i < tempList.size(); i++) {
			DVideonet DVideonet = tempList.get(i);
			if (DVideonet.getCode().equals(dvdiogrid.getCode())) {
				dvdiogrid.setCreateDate(DateFormatUtil.getStringDate());
				tempList.set(i, dvdiogrid);
			}
		}
		return new ActionMessage(true);
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(String[] codes) {
		for (int i = 0; i < tempList.size(); i++) {
			DVideonet DVideonet = tempList.get(i);
			List codesList = Arrays.asList(codes);
			if (codesList.contains(DVideonet.getCode())) {
				tempList.remove(i);
				i--;
			}
		}
		return new ActionMessage(true);
	}
}
