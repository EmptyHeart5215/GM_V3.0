package com.dykj.GSM.mapper.sys.mapperinterf;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysSeatSecond;
import com.dykj.GSM.model.sys.SysSeatThird;

/**
* @author 作者 :wangmingyuan
* @version 创建时间：2016年4月21日 下午1:56:59
* 修改人：
* 修改日期：
* 类说明:
*/
public interface SysSeatThirdMapper extends IBaseMapper<SysSeatThird, String>{
	
	/**
	 * 根据二级坐落的主键查询
	 * @author wangmingyuan
	 * @param parentCode
	 * @return
	 */
	public SysSeatSecond queryByparentCode(String parentCode);

}
