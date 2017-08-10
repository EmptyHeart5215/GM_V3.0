package com.dykj.GSM.action.im;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.dykj.GSM.action.BaseAction;
import com.dykj.GSM.imessage.JPush;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.imessage.IMessage;
import com.dykj.GSM.model.imessage.MessageStack;
import com.dykj.GSM.model.sys.SysTempGrid;
import com.dykj.GSM.model.thinglog.ThingLog;
import com.dykj.GSM.service.imessage.IMessageService;
import com.dykj.GSM.service.imessage.MessageStackService;
import com.dykj.GSM.service.sys.SysSeatGridService;
import com.dykj.GSM.utils.ActionMessage;
import com.dykj.GSM.utils.ChangeJsonUtil;
import com.dykj.GSM.utils.DateFormatUtil;
import com.dykj.GSM.utils.MySession;
import com.dykj.GSM.utils.SendPush;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016年6月15日 修改人： 修改日期： 类说明: 即时通讯
 */
@RestController
@RequestMapping(value = "/im/imessaging")
public class IMessagingAction extends BaseAction {

	private static Logger logger = Logger.getLogger(IMessagingAction.class);
	@Autowired
	private SysSeatGridService sysSeatGridService;

	@Autowired
	private IMessageService messageService;
	
	@Autowired
	private MessageStackService messageStackService;

	public static final SysTempGrid tangShanTempGrid = new SysTempGrid("01", "唐山市", "唐山市", "");

	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/indexLoad")
	public ModelAndView indexLoad() {
		return new ModelAndView("im/index");
	}
	
	/**
	 * 管理页面加载
	 * 
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/manageLoad")
	public ModelAndView manageLoad() {
		return new ModelAndView("im/manage");
	}

	/**
	 * 查询人员列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryImUserByGridCode")
	public Object queryImUserByGridCode() {
		try {
			List<SysTempGrid> list = new ArrayList<SysTempGrid>();
			list.add(tangShanTempGrid);
			list.addAll(sysSeatGridService.queryImUserByGridCode());
			return list;
		} catch (Exception e) {
			logger.error(e);
			return new ActionMessage(false);
		}
	}

	@RequestMapping(value = "/turnToIMSee", produces = "text/html;charset=UTF-8")
	public ModelAndView turnToIMSee(String userCode, String nameText) throws Exception {
		SessionModel session = MySession.getInfo();
		Map<String, Object> vdata = new HashMap<String, Object>();
		nameText = new String((nameText).getBytes("ISO-8859-1"), "utf-8");
		vdata.put("userCode", userCode);
		vdata.put("nameText", nameText);
		vdata.put("logName", session.getUsername());
		vdata.put("sendUserCode", session.getCode());
		return new ModelAndView("im/imSee", "vdata", vdata);
	}

	/**
	 * 服务器推送到手机调用方法
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/iMessagePush")
	public ActionMessage iMessagePush(IMessage message) throws Exception {
		JPush push = new JPush();
		int state = push.testSendPushs(message);
		if (state == 200) {
			SessionModel session = MySession.getInfo();
			// SendPush.sendMessageForService(session.getCode(),
			// ChangeJsonUtil.ObjToJson(message));
			message.setCreateBy(session.getCode());
			messageService.insert(message);
			return new ActionMessage(true);
		} else {
			return new ActionMessage(false);
		}
	}

	/**
	 * 查询技术支持树形人员列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryImTechnicalSupport")
	public Object queryImTechnicalSupport() {
		try {
			List<SysTempGrid> list = new ArrayList<SysTempGrid>();
			list.add(tangShanTempGrid);
			list.addAll(sysSeatGridService.queryImTechnicalSupport());
			return list;
		} catch (Exception e) {
			logger.error(e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 手机往回推送消息接口方法
	 * 
	 * @param message
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/iMessagePushForAndroidToService")
	public ActionMessage iMessagePushForAndroidToService(IMessage message) throws Exception {

		System.out.println(message.getText() + "===" + message.getUserCode() + "==" + message.getUserName() + "==="
				+ message.getSendUserCode()
				+ "------------------------------------------------------------------------");
		int state = SendPush.sendMessageForService(message.getUserCode(), ChangeJsonUtil.ObjToJson(message));
		if (state == 200) {
			message.setCreateBy(MySession.getInfo().getCode());
			messageService.insert(message);
			return new ActionMessage(200);
		} else {
			return new ActionMessage(500);
		}

	}

	/**
	 * 查询聊天窗口当前前十分钟聊天记录
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "/queryMessageTenMini")
	public Object queryMessageTenMini(IMessage message) {
		try {
			List<IMessage> list = new ArrayList<IMessage>();
			SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = new Date();
			Date date2 = new Date();
			String dates1 = SimpleDateFormat.format((date1.getTime() - 60 * 1000 * 10));
			String dates2 = SimpleDateFormat.format(date2.getTime());
			message.setCreateDate(dates1);
			message.setDate1(dates2);
			list = messageService.queryMessageTenMini(message);
			int rows = messageStackService.deletePk(message.getUserCode());
			return list ;
			
		} catch (Exception e) {
			logger.error(e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 查询历史记录
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping(value = "/queryMessageRecord")
	public Object queryMessageRecord(IMessage message) {
		try {
			List<IMessage> list = new ArrayList<IMessage>();
			SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date1 = new Date();
			Date date2 = new Date();
			String dates1 = SimpleDateFormat.format((date1.getTime() - 60 * 1000 * 60 * 24 * 7));
			System.out.println(dates1);
			String dates2 = SimpleDateFormat.format(date2.getTime());
			message.setCreateDate(dates1);
			message.setDate1(dates2);
			return list = messageService.queryMessageTenMini(message);
		} catch (Exception e) {
			logger.error(e);
			return new ActionMessage(false);
		}
	}
	
	@RequestMapping(value = "/queryStatisticalTotal")
	public Object queryStatisticalTotal(MessageStack param) {
		try {
			return messageStackService.queryStatisticalTotal(param);
		} catch (Exception e) {
			logger.error(e);
			return new ActionMessage(false);
		}
	}

	/**
	 * 添加消息记录数
	 * @param log
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/MessageStackNum")
	public ActionMessage MessageStackNum(MessageStack messageStack) {
		try {
				SessionModel session = new MySession().getInfo();
				messageStack.setCreateBy(session.getCode());
				messageStack.setCreateDate(DateFormatUtil.getStringDate());
				if(messageStackService.insert(messageStack)!=0){
					return new ActionMessage(true);
				}else {
					return new ActionMessage(false);
				}	
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return new ActionMessage(false).setinfo(e.getMessage());
		}
	}

}
