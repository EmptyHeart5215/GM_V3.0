package com.dykj.GSM.service.partybuilding;

import java.util.List;

import com.dykj.GSM.model.partybuilding.PartyMemberManager;
import com.dykj.GSM.service.IBaseService;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016年5月4日 下午3:24:22
 * 修改人：
 * 修改日期：
 * 类说明:
 */
public interface PartyRetiredService extends IBaseService<PartyMemberManager, String>{
	
	/**
	 * 比较是否添加相同用户如果相同这不允许添加
	 * @param personCode
	 * @return
	 */
	public List<PartyMemberManager> compareSameUser(String personCode);

}
