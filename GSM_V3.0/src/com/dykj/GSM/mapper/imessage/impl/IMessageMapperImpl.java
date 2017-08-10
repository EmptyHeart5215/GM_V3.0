package com.dykj.GSM.mapper.imessage.impl;

import com.dykj.GSM.mapper.BaseMapperImpl;
import com.dykj.GSM.mapper.imessage.mapperinterf.IMessageMapper;
import com.dykj.GSM.model.imessage.IMessage;

import java.util.List;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-06-29 13:57:24
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public class IMessageMapperImpl extends BaseMapperImpl<IMessage,String> implements IMessageMapper{

	/* (non-Javadoc)
	 * @see com.dykj.GSM.mapper.imessage.mapperinterf.IMessageMapper#queryMessageTenMini(com.dykj.GSM.imessage.IMessage)
	 */
	@Override
	public List<IMessage> queryMessageTenMini(IMessage message) {
		return this.getSqlSession().selectList(getSqlName("queryMessageTenMini"), message);
	}

}