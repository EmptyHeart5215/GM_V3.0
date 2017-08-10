package com.dykj.GSM.mapper.base.mapperinterf;

import com.dykj.GSM.mapper.IBaseMapper;
import com.dykj.GSM.model.base.BPerBfCanJi;

public interface BPerBfCanJiMapper extends IBaseMapper<BPerBfCanJi, String> {
	public BPerBfCanJi queryByPersonCode(String personCode);

	public int deleteByPersonCode(String personCode);
}
