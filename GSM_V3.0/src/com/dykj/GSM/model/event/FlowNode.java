package com.dykj.GSM.model.event;


/**
 * 流程显示时使用的node
 * 
 * @author admin
 * 
 */
public class FlowNode {
	// 用于计数
	private String name;
	private Integer left;
	private Integer top;
	private Integer width = 90;
	private Integer height = 24;
	private String type = "task weiban";
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLeft() {
		return left;
	}
	public void setLeft(Integer left) {
		this.left = left;
	}
	public Integer getTop() {
		return top;
	}
	public void setTop(Integer top) {
		this.top = top;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


}
