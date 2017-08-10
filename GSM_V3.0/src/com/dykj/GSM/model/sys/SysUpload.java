package com.dykj.GSM.model.sys;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 上午8:37:31
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:文件上传类
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.sys.mapperinterf.SysUploadMapper")
public class SysUpload extends BaseModel {
	/**
	 * 文件原名称
	 */
	private String name;
	/**
	 * 文件路径
	 */
	private String path;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
