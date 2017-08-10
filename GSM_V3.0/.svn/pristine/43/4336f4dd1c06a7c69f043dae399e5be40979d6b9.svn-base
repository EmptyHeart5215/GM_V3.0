package com.dykj.GSM.mapper.imessage.impl;

import java.util.List;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.imessage.mapperinterf.MessageStackMapper;
import com.dykj.GSM.model.imessage.MessageStack;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-07-19 15:56:32
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class MessageStackMapperImpl extends BaseMapperImpl<MessageStack,String> implements MessageStackMapper{

	/* (non-Javadoc)
	 * @see com.dykj.GSM.mapper.imessage.mapperinterf.MessageStackMapper#queryStatisticalTotal(com.dykj.GSM.model.imessage.MessageStack)
	 */
	@Override
	public List<MessageStack> queryStatisticalTotal(MessageStack param) {
		return this.getSqlSession().selectList(getSqlName("queryStatisticalTotal"), param);
	}

}