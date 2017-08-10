package com.dykj.GSM.model;

import java.util.Map;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.validation.constraints.Max;

import com.dykj.GSM.model.sys.SysSeatGrid;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 项目名称：网格化升价改版<br/>
 * 类名称：BaseModel<br/>
 * 创建时间：2016-03-09<br/>
 * 创建人：wangmingyuan<br/>
 * 修改人：<br/>
 * 修改时间：<br/>
 * 修改备注：<br/>
 * 类描述：基础实体类，所有实体对象全部继承于该类<br/>
 * 基于代码复用和模型分离的思想，在项目开发中使用JPA的@MappedSuperclass<br>
 * 注解将实体类的多个属性分别封装到不同的非实体类中。<br>
 * 1.@MappedSuperclasz注解只能标准在类上<br>
 * 2.标注为@MappedSuperclass的类将不是一个完整的实体类，他将不会映射到数据库表，<br>
 * 但是他的属性都将映射到其子类的数据库字段中。<br>
 * 统一定义id 的entity的基类<br>
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略。<br>
 * JPA基类的标识符<br>
 * 
 * @author wangmingyuan<br/>
 * @version 1.0<br/>
 */
@MappedSuperclass
public class BaseModel {
	/**
	 * 主键
	 */
	private String code;
	/**
	 * 创建日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private String createDate;
	/**
	 * 创建人
	 */
	private String createBy;
	/**
	 * 删除标识符,0表示未删除，1表示删除
	 */
	private String flagDel = "0";
	/**
	 * 显示标识符，0表示显示，1表示不显示
	 */
	private String flagDisplay = "0";
	/**
	 * 排序
	 */
	@Max(5000)
	private Integer sort;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 如：路南区-**街道-社区-网格01 ,表示所属网格全名称 添加
	 * 
	 * @Transient表示此属性不与数据库表字段对应
	 * 
	 */
	@Transient
	private String gridTotalName;
	@Transient
	private Map dicValueMap;
	/**
	 * 网格code外键对应关联查询使用
	 */
	@Transient
	private SysSeatGrid seatGrid;
	@Transient
	private String searchStartTime;
	@Transient
	private String searchEndTime;

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getFlagDel() {
		return flagDel;
	}

	public void setFlagDel(String flagDel) {
		this.flagDel = flagDel;
	}

	public String getFlagDisplay() {
		return flagDisplay;
	}

	public void setFlagDisplay(String flagDisplay) {
		this.flagDisplay = flagDisplay;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getSort() {
		return sort;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGridTotalName() {
		return gridTotalName;
	}

	public void setGridTotalName(String gridTotalName) {
		this.gridTotalName = gridTotalName;
	}

	public void setDicValueMap(Map dicValueMap) {
		this.dicValueMap = dicValueMap;
	}

	public Map getDicValueMap() {
		return dicValueMap;
	}

	public SysSeatGrid getSeatGrid() {
		return seatGrid;
	}

	public void setSeatGrid(SysSeatGrid seatGrid) {
		this.seatGrid = seatGrid;
	}

	public String getSearchStartTime() {
		return searchStartTime;
	}

	public void setSearchStartTime(String searchStartTime) {
		this.searchStartTime = searchStartTime;
	}

	public String getSearchEndTime() {
		return searchEndTime;
	}

	public void setSearchEndTime(String searchEndTime) {
		this.searchEndTime = searchEndTime;
	}

}
