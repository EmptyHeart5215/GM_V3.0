package com.dykj.GSM.model.event;

public class OsXmlStep {
	private Long id;
	private String name;
	/**
	 * 只能是 EContradict 和EEvent
	 */
	private String entryName;
	/**
	 * 是否是结束
	 */
	private Boolean isEnd;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public Boolean getIsEnd() {
		return isEnd;
	}

	public void setIsEnd(Boolean isEnd) {
		this.isEnd = isEnd;
	}

}
