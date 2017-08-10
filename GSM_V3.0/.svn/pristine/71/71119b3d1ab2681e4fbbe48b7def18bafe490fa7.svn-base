package com.dykj.GSM.model.event;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 流程显示时使用的连线
 * 
 * @author admin
 * 
 */
public class FlowLine {
	private String type;
	private String from;
	private String to;
	private String name;
	private boolean marked;
	private boolean dash;
	@JsonProperty("M")
	private Integer M;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isMarked() {
		return marked;
	}

	public void setMarked(boolean marked) {
		this.marked = marked;
	}

	@JsonIgnore
	public Integer getM() {
		return M;
	}

	@JsonIgnore
	public void setM(Integer m) {
		M = m;
	}


	public boolean isDash() {
		return dash;
	}

	public void setDash(boolean dash) {
		this.dash = dash;
	}

}
