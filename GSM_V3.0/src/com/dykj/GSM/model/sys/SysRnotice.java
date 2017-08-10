package com.dykj.GSM.model.sys;

import javax.persistence.Transient;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysRnoticeMapper")
public class SysRnotice extends BaseModel {
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容
	 */
	private String content;
	@Transient
	private SysUser sysUser;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public SysUser getSysUser() {
		return sysUser;
	}
	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}
}
