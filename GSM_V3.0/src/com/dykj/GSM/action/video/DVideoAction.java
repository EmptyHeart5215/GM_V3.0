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
import com.dykj.GSM.model.video.DVideo;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.DateFormatUtil;

@RestController
@RequestMapping(value = "/video/dvideo")
public class DVideoAction extends BaseAction {
	private static Logger logger = Logger.getLogger(DVideoAction.class);
	private List<DVideo> tempList;
	private int tempI;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/video/dvideo/manage");
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
	public List<DVideo> queryManage(int page, int rows, String sort, String order, DVideo args) throws ParseException {
		if (tempList == null) {
			tempI = 4;
			tempList = new ArrayList<DVideo>();
			for (int i = 0; i < 5; i++) {
				DVideo DVideo = new DVideo();
				DVideo.setCode(i + "");
				DVideo.setVideoName("视频名称" + i);
				DVideo.setVideoAddress("视频地址" + i);
				DVideo.setGridName("所属辖区或部门" + i);
				DVideo.setCodeVideonet("编码" + i);
				DVideo.setTypeVideoname("类型" + i);
				DVideo.setCodeChannel("通道" + i);
				DVideo.setPosition("地图坐标" + i);
				tempList.add(DVideo);
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
		vdata.put("url", "video/dvideo/add");
		return new ModelAndView("/video/dvideo/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid DVideo sysgrid, BindingResult result) {
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
		DVideo vid = null;
		for (DVideo tempDic : tempList) {
			if (tempDic.getCode().equals(code)) {
				vid = tempDic;
			}
		}
		vdata.put("url", "video/dvideo/modify");
		vdata.put("vid", vid);
		return new ModelAndView("video/dvideo/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param sysgrid
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid DVideo dv) {

		for (int i = 0; i < tempList.size(); i++) {
			DVideo dvi = tempList.get(i);
			if (dvi.getCode().equals(dv.getCode())) {
				dv.setCreateDate(DateFormatUtil.getStringDate());
				tempList.set(i, dv);

			}
		}
		return new ActionMessage(true);
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(String[] codes) {
		for (int i = 0; i < tempList.size(); i++) {
			DVideo tempDic = tempList.get(i);
			List codesList = Arrays.asList(codes);
			if (codesList.contains(tempDic.getCode())) {
				tempList.remove(i);
				i--;
			}
		}
		return new ActionMessage(true);
	}
}
