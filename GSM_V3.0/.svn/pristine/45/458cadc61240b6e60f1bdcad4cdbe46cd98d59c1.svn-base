package com.dykj.GSM.service.imessage.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.imessage.impl.MessageStackMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.imessage.MessageStack;
import com.dykj.GSM.service.imessage.MessageStackService;
import com.dykj.GSM.utils.DateFormatUtil;
import com.dykj.GSM.utils.MySession;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-07-19 15:56:32 修改人： 修改日期： 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class MessageStackServiceImpl implements MessageStackService {
	@Autowired
	private MessageStackMapperImpl messageStackMapperImpl;

	@Override
	public int insert(MessageStack entity) {
		    SessionModel sessionModel = MySession.getInfo();
		    entity.setCreateDate(DateFormatUtil.getStringDate());
	        entity.setCreateBy(sessionModel.getCode());
	        return messageStackMapperImpl.insert(entity);
	}

	@Override
	public int update(MessageStack entity) {
		return messageStackMapperImpl.update(entity);
	}

	@Override
	public int deletePk(String primaryKey) {
		return messageStackMapperImpl.deletePk(primaryKey);
	}

	@Override
	public MessageStack queryByKey(String primaryKey) {
		return messageStackMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<MessageStack> queryList() {
		return messageStackMapperImpl.queryList();
	}

	@Override
	public List<MessageStack> queryListParam(Map param) {
		return messageStackMapperImpl.queryListParam(param);
	}

	@Override
	public List<MessageStack> queryTListParam(MessageStack param) {
		return messageStackMapperImpl.queryTListParam(param);
	}

	@Override
	public Page<MessageStack> queryByParamPage(int page, int size, String sidx, String sord, MessageStack param) {
		return messageStackMapperImpl.queryByParamPage(page, size, sidx, sord, param);
	}

	@Override
	public int deleteBatch(List<String> list) {
		return messageStackMapperImpl.deleteBatch(list);
	}
	@Override
	public List<MessageStack> queryStatisticalTotal(MessageStack param) {
		// TODO Auto-generated method stub
		return messageStackMapperImpl.queryStatisticalTotal(param);
	}
}