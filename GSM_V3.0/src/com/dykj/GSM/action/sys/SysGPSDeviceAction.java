package com.dykj.GSM.action.sys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.model.sys.SysGpsDevice;
import com.dykj.GSM.service.sys.SysGpsDeviceService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/sys/gpsdevice")
public class SysGPSDeviceAction extends BaseAction {
	private static Logger logger = Logger.getLogger(SysGPSDeviceAction.class);
	@Autowired
	private SysGpsDeviceService gpsdeviceService;

	/**
	 * 管理页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/sys/gpsdevice/manage");
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页条数
	 * @param sidx
	 *            排序字段名称
	 * @param sord
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据
	 * @throws ParseException
	 *             @
	 */
	@RequestMapping(value = "/queryManage")
	public Object queryByParamPage(int page, int rows, String sidx, String sord, SysGpsDevice param) {
		try {

			return gpsdeviceService.queryByParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param rows
	 *            每页条数
	 * @param sidx
	 *            排序字段名称
	 * @param sord
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据
	 * @throws ParseException
	 *             @
	 */
	@RequestMapping(value = "/queryDeviceForUserParamPage")
	public Object queryDeviceForUserParamPage(int page, int rows, String sidx, String sord, SysGpsDevice param) {
		try {
			if (param.getGpsStateString() != null) {
				SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date = new Date(System.currentTimeMillis() - (1000 * 60 * 5));
				Date date2 = new Date();
				String date1 = SimpleDateFormat.format(date.getTime());
				String dates2 = SimpleDateFormat.format(date2.getTime());
				if (param.getGpsStateString().equals("1")) {
					param.setDate1(date1);
					param.setDate2(dates2);
				} else if (param.getGpsStateString().equals("0")) {
					param.setDate2(date1);
				}
			}
			return gpsdeviceService.queryDeviceForUserParamPage(page, rows, sidx, sord, param);
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).defaultPageError();
		}
	}

	/**
	 * 新增页面加载
	 * 
	 * @return @
	 */
	@RequestMapping(value = "/addLoad")
	public ModelAndView addLoad() {
		Map<String, Object> vdata = new HashMap<String, Object>();
		vdata.put("url", "sys/gpsdevice/add");
		return new ModelAndView("/sys/gpsdevice/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param gpsdevice
	 * @return @
	 */

	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid SysGpsDevice gpsdevice, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				gpsdevice.setCreateBy(MySession.getInfo().getCode());
				if (gpsdeviceService.insert(gpsdevice) != 0) {
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ActionMessage(false).setinfo(e.getMessage());
		}

	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return @
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			SysGpsDevice gpsdevice = gpsdeviceService.queryByKey(code);
			vdata.put("url", "sys/gpsdevice/modify");
			vdata.put("sysDevice", gpsdevice);
		} catch (Exception e) {
			logger.error("error", e);
		}
		return new ModelAndView("sys/gpsdevice/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param gpsdevice
	 * @return @
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid SysGpsDevice gpsdevice, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			} else {
				gpsdevice.setCreateBy(MySession.getInfo().getCode());
				if (gpsdeviceService.update(gpsdevice) != 0) {
					return new ActionMessage(true);
				} else {
					return new ActionMessage(false);
				}
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ActionMessage delete(@RequestParam List<String> codes) {

		try {
			if (gpsdeviceService.deleteBatch(codes) != 0) {
				return new ActionMessage(true);
			} else {
				return new ActionMessage(false);
			}
		} catch (Exception e) {
			logger.error("error", e);
			e.printStackTrace();
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}
}
