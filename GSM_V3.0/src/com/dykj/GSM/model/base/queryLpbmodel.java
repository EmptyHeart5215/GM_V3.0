package com.dykj.GSM.model.base;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016年5月9日 下午12:24:13
 * 修改人：
 * 修改日期：
 * 类说明:统计分析公用model
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BBuildingMapper")
public class queryLpbmodel {
	
	private String DY;
	
	private String DYPX;
	
	private String PX;
	
	private String LC;
	
	private String YC;
	
	private String YF;
	
	private String NAME;
	
	private String CODE_COLOR;
	
	private String HOUSECODE;
	
	private String REN;
	@JsonProperty("DY") 
	public String getDY() {
		return DY;
	}
	public void setDY(String dY) {
		DY = dY;
	}
	@JsonProperty("DYPX") 
	public String getDYPX() {
		return DYPX;
	}
	public void setDYPX(String dYPX) {
		DYPX = dYPX;
	}
	@JsonProperty("PX") 
	public String getPX() {
		return PX;
	}
	public void setPX(String pX) {
		PX = pX;
	}
	@JsonProperty("LC") 
	public String getLC() {
		return LC;
	}
	public void setLC(String lC) {
		LC = lC;
	}
	@JsonProperty("YC") 
	public String getYC() {
		return YC;
	}
	public void setYC(String yC) {
		YC = yC;
	}
	@JsonProperty("YF") 
	public String getYF() {
		return YF;
	}
	public void setYF(String yF) {
		YF = yF;
	}
	@JsonProperty("NAME") 
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	@JsonProperty("CODE_COLOR") 
	public String getCODE_COLOR() {
		return CODE_COLOR;
	}
	public void setCODE_COLOR(String cODE_COLOR) {
		CODE_COLOR = cODE_COLOR;
	}
	@JsonProperty("HOUSECODE") 
	public String getHOUSECODE() {
		return HOUSECODE;
	}
	public void setHOUSECODE(String hOUSECODE) {
		HOUSECODE = hOUSECODE;
	}
	@JsonProperty("REN") 
	public String getREN() {
		return REN;
	}
	public void setREN(String rEN) {
		REN = rEN;
	}
	
}

