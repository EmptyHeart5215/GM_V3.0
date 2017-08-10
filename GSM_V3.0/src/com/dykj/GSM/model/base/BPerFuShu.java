package com.dykj.GSM.model.base;

import com.dykj.GSM.annotation.MapperUrlAnnotion;
import com.dykj.GSM.model.BaseModel;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年5月11日 下午2:07:57
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:附属表，即中间表
 */
@MapperUrlAnnotion(mapperUrl = "com.dykj.GSM.mapper.base.mapperinterf.BPerFuShuMapper")
public class BPerFuShu extends BaseModel {
	private String personCode;
	/**
	 * 特殊人群里的刑满释放
	 */
	private Boolean tsXingShi;
	/**
	 * 特殊人群里的
	 */
	private Boolean tsJiaoZheng;
	/**
	 * 特殊人群里的
	 */
	private Boolean tsXiDu;
	/**
	 * 特殊人群里的
	 */
	private Boolean tsAiZi;
	/**
	 * 特殊人群里的
	 */
	private Boolean tsJingShen;
	/**
	 * 特殊人群里的邪教
	 */
	private Boolean tsXieJiao;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfCanJi;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfDiBao;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfJiuZhu;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfKongChao;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfKunNanZhiGong;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfLiuShou;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfTeKunSheng;
	/**
	 * 帮扶人群里的
	 */
	private Boolean bfWuBao;
	/**
	 * 户籍人口
	 */
	private Boolean huJi;
	/**
	 * 流动
	 */
	private Boolean liuDong;
	/**
	 * 资源人群
	 */
	private Boolean ziYuan;
	/**
	 * 志愿者
	 */
	private Boolean zhiYuan;
	/**
	 * 拥军
	 */
	private Boolean yongJun;
	/**
	 * 青少年
	 */
	private Boolean qingShaoNian;
	/**
	 * 劳动保障
	 */
	private Boolean laoDong;

	public Boolean getTsXingShi() {
		return tsXingShi;
	}

	public void setTsXingShi(Boolean tsXingShi) {
		this.tsXingShi = tsXingShi;
	}

	public Boolean getTsJiaoZheng() {
		return tsJiaoZheng;
	}

	public void setTsJiaoZheng(Boolean tsJiaoZheng) {
		this.tsJiaoZheng = tsJiaoZheng;
	}

	public Boolean getTsXiDu() {
		return tsXiDu;
	}

	public void setTsXiDu(Boolean tsXiDu) {
		this.tsXiDu = tsXiDu;
	}

	public Boolean getTsAiZi() {
		return tsAiZi;
	}

	public void setTsAiZi(Boolean tsAiZi) {
		this.tsAiZi = tsAiZi;
	}

	public Boolean getTsJingShen() {
		return tsJingShen;
	}

	public void setTsJingShen(Boolean tsJingShen) {
		this.tsJingShen = tsJingShen;
	}

	public Boolean getTsXieJiao() {
		return tsXieJiao;
	}

	public void setTsXieJiao(Boolean tsXieJiao) {
		this.tsXieJiao = tsXieJiao;
	}

	public Boolean getBfCanJi() {
		return bfCanJi;
	}

	public void setBfCanJi(Boolean bfCanJi) {
		this.bfCanJi = bfCanJi;
	}

	public Boolean getBfDiBao() {
		return bfDiBao;
	}

	public void setBfDiBao(Boolean bfDiBao) {
		this.bfDiBao = bfDiBao;
	}

	public Boolean getBfJiuZhu() {
		return bfJiuZhu;
	}

	public void setBfJiuZhu(Boolean bfJiuZhu) {
		this.bfJiuZhu = bfJiuZhu;
	}

	public Boolean getBfKongChao() {
		return bfKongChao;
	}

	public void setBfKongChao(Boolean bfKongChao) {
		this.bfKongChao = bfKongChao;
	}

	public Boolean getBfKunNanZhiGong() {
		return bfKunNanZhiGong;
	}

	public void setBfKunNanZhiGong(Boolean bfKunNanZhiGong) {
		this.bfKunNanZhiGong = bfKunNanZhiGong;
	}

	public Boolean getBfLiuShou() {
		return bfLiuShou;
	}

	public void setBfLiuShou(Boolean bfLiuShou) {
		this.bfLiuShou = bfLiuShou;
	}

	public Boolean getBfTeKunSheng() {
		return bfTeKunSheng;
	}

	public void setBfTeKunSheng(Boolean bfTeKunSheng) {
		this.bfTeKunSheng = bfTeKunSheng;
	}

	public Boolean getBfWuBao() {
		return bfWuBao;
	}

	public void setBfWuBao(Boolean bfWuBao) {
		this.bfWuBao = bfWuBao;
	}

	public String getPersonCode() {
		return personCode;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	public Boolean getHuJi() {
		return huJi;
	}

	public void setHuJi(Boolean huJi) {
		this.huJi = huJi;
	}

	public Boolean getLiuDong() {
		return liuDong;
	}

	public void setLiuDong(Boolean liuDong) {
		this.liuDong = liuDong;
	}

	public Boolean getZiYuan() {
		return ziYuan;
	}

	public void setZiYuan(Boolean ziYuan) {
		this.ziYuan = ziYuan;
	}

	public Boolean getZhiYuan() {
		return zhiYuan;
	}

	public void setZhiYuan(Boolean zhiYuan) {
		this.zhiYuan = zhiYuan;
	}

	public Boolean getYongJun() {
		return yongJun;
	}

	public void setYongJun(Boolean yongJun) {
		this.yongJun = yongJun;
	}

	public Boolean getQingShaoNian() {
		return qingShaoNian;
	}

	public void setQingShaoNian(Boolean qingShaoNian) {
		this.qingShaoNian = qingShaoNian;
	}

	public Boolean getLaoDong() {
		return laoDong;
	}

	public void setLaoDong(Boolean laoDong) {
		this.laoDong = laoDong;
	}
}
