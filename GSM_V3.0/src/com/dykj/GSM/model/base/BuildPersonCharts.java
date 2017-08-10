package com.dykj.GSM.model.base;

import com.dykj.GSM.annotation.MapperUrlAnnotion;

/**
 * @author 作者 :yangchao
 * @version 创建时间：2016年5月9日 下午12:24:13
 * 修改人：
 * 修改日期：
 * 类说明:统计分析公用model
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BBuildingMapper")
public class BuildPersonCharts {
	
	private String MAX;
	private String MAN;
	private String WOMEN;
	public String getMAX() {
		return MAX;
	}
	public void setMAX(String mAX) {
		MAX = mAX;
	}
	public String getMAN() {
		return MAN;
	}
	public void setMAN(String mAN) {
		MAN = mAN;
	}
	public String getWOMEN() {
		return WOMEN;
	}
	public void setWOMEN(String wOMEN) {
		WOMEN = wOMEN;
	}
	
}

