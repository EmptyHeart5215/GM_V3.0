package com.dykj.GSM.service.sys;

import com.dykj.GSM.model.sys.SysSeatFour;
import com.dykj.GSM.model.sys.SysSeatThird;
import com.dykj.GSM.service.IBaseService;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年4月21日 下午4:21:34
* 修改人：
* 修改日期：
* 类说明:
*/
public interface SysSeatFourService extends IBaseService<SysSeatFour, String>{
	
	/**
	 * 根据三级坐落的主键查询
	 * @author wangmingyuan
	 * @param parentCode
	 * @return
	 */
	public SysSeatThird queryByparentCode(String parentCode);


}
