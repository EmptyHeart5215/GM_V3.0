package com.dykj.GSM.model.zongzhitraining;

import javax.persistence.Transient;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;
import com.dykj.GSM.model.sys.SysSeatGrid;
import com.dykj.GSM.model.sys.SysUser;

/**
 * 效果管理
 * 
 * @author wangmingyuan
 *
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.zongzhitraining.mapperinterf.EffectManagementMapper")
public class EffectManagement extends BaseModel {

	/**
	 * 辖区或部门
	 */
	private String gridCode;
	/**
	 * 阅读或下载人员
	 */
	private String downLoadUserCode;
	/**
	 * 下载时间或阅读时间
	 */
	private String downLoadTime;
	/**
	 * 浏览次数
	 */
	private Integer browseSize;
	/**
	 * 下载材料code
	 */
	private String zongZhiMaterialCode;

	@Transient
	private SysUser sysUser;
	@Transient
	private ZongzhiMaterial zongzhiMaterial;

	public String getGridCode() {
		return gridCode;
	}

	public void setGridCode(String gridCode) {
		this.gridCode = gridCode;
	}

	public String getDownLoadUserCode() {
		return downLoadUserCode;
	}

	public void setDownLoadUserCode(String downLoadUserCode) {
		this.downLoadUserCode = downLoadUserCode;
	}

	public String getDownLoadTime() {
		return downLoadTime;
	}

	public void setDownLoadTime(String downLoadTime) {
		this.downLoadTime = downLoadTime;
	}

	public Integer getBrowseSize() {
		return browseSize;
	}

	public void setBrowseSize(Integer browseSize) {
		this.browseSize = browseSize;
	}

	public String getZongZhiMaterialCode() {
		return zongZhiMaterialCode;
	}

	public void setZongZhiMaterialCode(String zongZhiMaterialCode) {
		this.zongZhiMaterialCode = zongZhiMaterialCode;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public ZongzhiMaterial getZongzhiMaterial() {
		return zongzhiMaterial;
	}

	public void setZongzhiMaterial(ZongzhiMaterial zongzhiMaterial) {
		this.zongzhiMaterial = zongzhiMaterial;
	}

}
