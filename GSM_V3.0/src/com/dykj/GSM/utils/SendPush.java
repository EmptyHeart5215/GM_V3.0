package com.dykj.GSM.utils;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.directwebremoting.Browser;
import org.directwebremoting.ScriptBuffer;
import org.directwebremoting.ScriptSession;
import org.directwebremoting.ScriptSessionFilter;

import uk.ltd.getahead.dwr.WebContextFactory;

public class SendPush {

	static int state = 500;

	// 发送消息
	public String send(String msg) {
		return (msg);

	}

	public static void onPageLoad(String userCode, String departmentCode, String roleCode) {
		/*
		 * System.out.println(sessions2); if (sessions2 != null) {
		 * System.out.println("-----------------" + sessions2.size()); }
		 */
		HttpSession session = WebContextFactory.get().getSession();
		ScriptSession scriptSession = DWRScriptSessionListener.scriptSessionMap.get(session.getId());
		// 放code,roleCode,departmentCode,gridCode
		scriptSession.setAttribute("userCode", userCode);
		scriptSession.setAttribute("departmentCode", departmentCode);
		scriptSession.setAttribute("roleCode", roleCode);
	}

	public static void sendMessage(String message) {

		final String autoMessage = message;
		Browser.withAllSessionsFiltered(new ScriptSessionFilter() {
			@Override
			public boolean match(ScriptSession session) {

				return true;
			}
		}, new Runnable() {

			private final ScriptBuffer script = new ScriptBuffer();

			@Override
			public void run() {

				script.appendCall("showMessage", autoMessage);

				Collection<ScriptSession> sessions = Browser.getTargetSessions();

				for (ScriptSession scriptSession : sessions) {
					scriptSession.addScript(script);
				}
			}
		});
	}

	public static void sendGongGaoMessage(String message) {
		final String autoMessage = message;
		Browser.withAllSessions(new Runnable() {
			private final ScriptBuffer script = new ScriptBuffer();

			@Override
			public void run() {
				script.appendCall("showGongGaoMessage", autoMessage);
				// 获取所有的客户端
				Collection<ScriptSession> sessions = DWRScriptSessionListener.getScriptSessions();
				for (ScriptSession scriptSession : sessions) {
					scriptSession.addScript(script);
				}
			}
		});
	}

	public static int sendMessageForService(final String userid, String message) {
		final String autoMessage = message;
		Browser.withAllSessions(new Runnable() {
			private final ScriptBuffer script = new ScriptBuffer();

			@Override
			public void run() {
				script.appendCall("showMessage", autoMessage);
				// 获取所有的客户端
				Collection<ScriptSession> sessions = DWRScriptSessionListener.getScriptSessions();
				for (ScriptSession scriptSession : sessions) {
					String userCode = (String) scriptSession.getAttribute("userCode");
					if (userid.equals(userCode)) {
						scriptSession.addScript(script);
						state = 200;
					}
				}
			}
		});
		return state;
	}

	public static int sendMessageForServicess(final String userid, String message) {
		final String autoMessage = message;
		Browser.withAllSessions(new Runnable() {
			private final ScriptBuffer script = new ScriptBuffer();

			@Override
			public void run() {
				script.appendCall("showMessages", autoMessage);
				// 获取所有的客户端
				Collection<ScriptSession> sessions = DWRScriptSessionListener.getScriptSessions();
				for (ScriptSession scriptSession : sessions) {
					String userCode = (String) scriptSession.getAttribute("userCode");
					if (userid.equals(userCode)) {
						scriptSession.addScript(script);
						state = 200;
					}
				}
			}
		});
		return state;
	}

	public static int sendMessageForServiceAddMsg(final String userid, String message) {
		final String autoMessage = message;
		Browser.withAllSessions(new Runnable() {
			private final ScriptBuffer script = new ScriptBuffer();

			@Override
			public void run() {
				script.appendCall("showMessageAddMsg", autoMessage);
				// 获取所有的客户端
				Collection<ScriptSession> sessions = DWRScriptSessionListener.getScriptSessions();
				for (ScriptSession scriptSession : sessions) {
					String userCode = (String) scriptSession.getAttribute("userCode");
					if (userid.equals(userCode)) {
						scriptSession.addScript(script);
						state = 200;
					}
				}
			}
		});
		return state;
	}

	public static void sendEventMessageAuto(final String currentOwner, final String event) {
		Browser.withAllSessions(new Runnable() {
			private final ScriptBuffer script = new ScriptBuffer();

			@Override
			public void run() {
				script.appendCall("showEventMes", event);
				Collection<ScriptSession> sessions = DWRScriptSessionListener.getScriptSessions();
				for (ScriptSession scriptSession : sessions) {
					String userCode = (String) scriptSession.getAttribute("userCode");
					String departmentCode = (String) scriptSession.getAttribute("departmentCode");
					String roleCode = (String) scriptSession.getAttribute("roleCode");
					if (currentOwner.equals(userCode) || currentOwner.equals(departmentCode)
							|| currentOwner.equals(roleCode)) {
						scriptSession.addScript(script);
					}
				}
			}
		});

	}
}
