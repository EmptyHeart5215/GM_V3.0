package com.dykj.GSM.mapper.imessage.mapperinterf;

import java.util.List;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.imessage.MessageStack;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-07-19 15:56:32
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface MessageStackMapper extends IBaseMapper<MessageStack, String>{
	
	/**
	 * 查询通讯邮箱提醒条数
	 * @param param
	 * @return
	 */
	public List<MessageStack> queryStatisticalTotal(MessageStack param);

}