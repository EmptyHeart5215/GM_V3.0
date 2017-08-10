package com.dykj.GSM.mapper.sys.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.sys.mapperinterf.SysSeatThirdMapper;
import com.dykj.GSM.model.sys.SysSeatSecond;
import com.dykj.GSM.model.sys.SysSeatThird;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年4月21日 下午4:11:19
* 修改人：
* 修改日期：
* 类说明:
*/
public class SysSeatThirdMapperImpl extends BaseMapperImpl<SysSeatThird, String> implements SysSeatThirdMapper{

	@Override
	public SysSeatSecond queryByparentCode(String parentCode) {
		return this.getSqlSession().selectOne(getSqlName("queryByparentCode"),parentCode);
	}

}
