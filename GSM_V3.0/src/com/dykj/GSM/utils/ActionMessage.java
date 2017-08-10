package com.dykj.GSM.utils;

public class ActionMessage {
	private boolean status;
	private Object info;
	private Object attachMes;
	private Object error;

	public ActionMessage() {
	}

	public boolean getstatus() {
		return this.status;
	}

	/**
	 * 构造函数
	 * 
	 * @param _status
	 *            成功 或 失败
	 */
	public ActionMessage(boolean _status) {
		this.status = _status;
		if (_status) {
			this.info = "操作成功！";
		} else {
			this.info = "系统异常，请稍后再试！";
		}
	}
	
	public ActionMessage(int _statusss) {
		if (_statusss == 200) {
			this.info = "200";
		} else {
			this.info = "500";
		}
	}

	public Object getinfo() {
		return this.info;
	}

	public ActionMessage setinfo(Object _info) {
		this.info = _info;
		return this;
	}

	public ActionMessage setNullInfo() {
		this.info = "必填项不能为空！";
		return this;
	}

	public Object getAttachMes() {
		return attachMes;
	}

	public ActionMessage setAttachMes(Object attachMes) {
		this.attachMes = attachMes;
		return this;
	}

	public ActionMessage setPageError(String error) {
		this.status = false;
		this.error = error;
		return this;
	}

	public ActionMessage defaultPageError() {
		this.status = false;
		this.error = "系统异常，请稍后再试！";
		return this;
	}

	public Object getError() {
		return error;
	}
}
