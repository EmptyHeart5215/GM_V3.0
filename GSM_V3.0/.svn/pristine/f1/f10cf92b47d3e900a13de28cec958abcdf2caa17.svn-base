package com.dykj.GSM.action.base;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.dykj.GSM.model.base.BParts;
import com.dykj.GSM.model.sys.SysUpload;
import com.dykj.GSM.service.base.BPartsService;
import com.dykj.GSM.service.sys.SysUploadService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.MySession;

@RestController
@RequestMapping(value = "/base/bparts")
public class BPartsAction extends BaseAction {
	private static Logger logger = Logger.getLogger(BPartsAction.class);
	@Autowired
	private BPartsService bPartsService;
	@Autowired
	private SysUploadService sysUploadService;

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("/base/bparts/manage");
	}

	/**
	 * 分页查询
	 * 
	 * @param page
	 *            页码
	 * @param size
	 *            每页条数
	 * @param sidx
	 *            排序字段名称
	 * @param sord
	 *            排序类型
	 * @param args
	 *            参数
	 * @return json数据
	 * @throws ParseException
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryManage")
	public Object queryManage(int page, int rows, String sidx, String sord, BParts args) throws ParseException {
		try {
			return bPartsService.queryByParamPage(page, rows, sidx, sord, args);
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false).defaultPageError();
		}
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
		vdata.put("url", "base/bparts/add");
		return new ModelAndView("/base/bparts/info", "vdata", vdata);
	}

	/**
	 * 新增
	 * 
	 * @param BParts
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public ActionMessage add(@Valid BParts bParts, BindingResult result) {
		try {
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			bParts.setCreateBy(MySession.getInfo().getCode());
			int i = bPartsService.insert(bParts);
			if (i > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("插入数据没有成功!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 修改页面加载
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modifyLoad")
	public ModelAndView modifyLoad(@RequestParam String code) {
		Map<String, Object> vdata = new HashMap<String, Object>();
		try {
			BParts bpart = bPartsService.queryByKey(code);
			vdata.put("url", "base/bparts/modify");
			vdata.put("bpart", bpart);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return new ModelAndView("/base/bparts/info", "vdata", vdata);
	}

	/**
	 * 修改
	 * 
	 * @param BParts
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/modify")
	public ActionMessage modify(@Valid BParts bParts, BindingResult result) throws Exception {
		try {
			if (bParts.getCode() == null || "".equals(bParts.getCode().trim())) {
				return new ActionMessage(false);
			}
			if (result.hasErrors()) {
				List<ObjectError> list = result.getAllErrors();
				ObjectError oe = list.get(0);
				return new ActionMessage(false).setinfo(oe.getDefaultMessage());
			}
			bParts.setCreateBy(MySession.getInfo().getCode());
			int i = bPartsService.update(bParts);
			if (i > 0) {
				return new ActionMessage(true);
			} else {
				throw new Exception("更新数据没有成功!");
			}
		} catch (Exception e) {
			logger.error("error", e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/delete")
	public ActionMessage delete(@RequestParam List codes) {
		try {
			int i = bPartsService.deleteBatch(codes);
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

	/**
	 * 详细页面加载
	 * 
	 * @param code
	 *            主键
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/infoSee")
	public ModelAndView infoSee(String code) throws Exception {
		Map<String, Object> vdata = new HashMap<String, Object>();
		BParts bpart = bPartsService.queryByKey(code);
		String ids = bpart.getPicture();
		int i = 0;
		String[] idsrcs = new String[10];
		if (ids != null && ids != "") {
			if (ids.indexOf(";") > 0) {
				String[] idlist = ids.split(";");
				for (String myid : idlist) {
					SysUpload sys = sysUploadService.queryByKey(myid);
					String idsrc = sys.getPath();
					idsrcs[i] = idsrc;
					i++;
				}
				vdata.put("sys", idsrcs);
			}
		}
		vdata.put("bpart", bpart);

		return new ModelAndView("/base/bparts/infoSee", "vdata", vdata);

	}
}
