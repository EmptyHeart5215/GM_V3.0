package com.dykj.GSM.imessage;

import com.google.gson.annotations.Expose;

import cn.jpush.api.common.resp.BaseResult;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年6月21日 下午2:21:25
* 修改人：
* 修改日期：
* 类说明:
*/
public class SendMessageResult extends BaseResult{
	
	@Expose Long msg_id;

    public Long getMsg_id() {
        return msg_id;
    }

}
