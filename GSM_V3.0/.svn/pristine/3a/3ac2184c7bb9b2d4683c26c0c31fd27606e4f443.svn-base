package com.dykj.GSM.service.imessage.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.imessage.impl.IMessageMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.imessage.IMessage;
import com.dykj.GSM.service.imessage.IMessageService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-06-29 13:57:24 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class IMessageServiceImpl implements IMessageService {
	@Autowired
	private IMessageMapperImpl iMessageMapperImpl;

	@Override
	public int insert(IMessage entity) {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		return iMessageMapperImpl.insert(entity);
	}

	@Override
	public int update(IMessage entity) {
		return iMessageMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return iMessageMapperImpl.deletePk(primaryKey);
	}

	@Override
	public IMessage queryByKey(String primaryKey) {
		return iMessageMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<IMessage> queryList() {
		return iMessageMapperImpl.queryList();
	}

	@Override
	public List<IMessage> queryListParam(Map param) {
		return iMessageMapperImpl.queryListParam(param);
	}

	@Override
	public List<IMessage> queryTListParam(IMessage param) {
		return iMessageMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<IMessage> queryByParamPage(int page, int size, String sidx, String sord, IMessage param) {
		return iMessageMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return iMessageMapperImpl.deleteBatch(list);
	}

	/* (non-Javadoc)
	 * @see com.dykj.GSM.service.imessage.IMessageService#queryMessageTenMini(com.dykj.GSM.imessage.IMessage)
	 */
	@Override
	public List<IMessage> queryMessageTenMini(IMessage message) {
		return iMessageMapperImpl.queryMessageTenMini(message);
	}
}