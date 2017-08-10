package com.dykj.GSM.mapper.sys.mapperinterf;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.sys.SysEvaSet;

/**
 * @author 作者 :wanghaihong
 * @version 创建时间：2016年4月25日 下午10:35:09
 * @modify 修改人：
 * @modifyDate 修改日期：
 * @descript 类说明:
 */
public interface SysEvaSetMapper extends IBaseMapper<SysEvaSet, String> {

	SysEvaSet queryOne();

	int deleteAll();

}
