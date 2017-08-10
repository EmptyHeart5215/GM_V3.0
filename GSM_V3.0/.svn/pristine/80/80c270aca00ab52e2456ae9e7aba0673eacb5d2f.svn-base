package com.dykj.GSM.mapper.sys.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysSeatFourMapper;
import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatThird;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年4月21日 下午4:13:33
* 修改人：
* 修改日期：
* 类说明:
*/
public class SysSeatFourMapperImpl extends BaseMapperImpl<SysSeatFour, String> implements SysSeatFourMapper{

	@Override
	public SysSeatThird queryByparentCode(String parentCode) {
		return this.getSqlSession().selectOne(getSqlName("queryByparentCode"),parentCode);
	}

}
