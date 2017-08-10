package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerTSJingShenMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerTSJingShen;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerTSJingShenService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerTSJingShenServiceImpl implements BPerTSJingShenService {
	@Autowired
	private BPerTSJingShenMapperImpl bPerTSJingShenMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BPerTSJingShen entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerTSJingShenMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerTSJingShenMapperImpl.insert(entity);
		if (i > 0) {
			// 更新一下附属表
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsJingShen(true);
			fushu.setPersonCode(entity.getPersonCode());
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有插入成功");
		}
		return i;
	}

	/*
	 * 新增或修改
	 */
	@Override
	public int update(BPerTSJingShen entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerTSJingShenMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerTSJingShenMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerTSJingShenMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		BPerFuShu fushu = new BPerFuShu();
		fushu.setTsJingShen(false);
		fushu.setPersonCode(personCode);
		i = bPerFuShuMapperImpl.update(fushu);
		if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerTSJingShen queryByKey(String primaryKey) {
		return bPerTSJingShenMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerTSJingShen> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSJingShen> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSJingShen> queryTListParam(BPerTSJingShen param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerTSJingShen> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerTSJingShen param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return 0;
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerTSJingShen queryByPersonCode(String personCode) throws Exception {
		BPerTSJingShen jingshen = bPerTSJingShenMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(jingshen, BPerTSJingShen.class, "codeJingJiSituation,codeZhenDuanType,codeWeiXianClasses,codeZhiLiaoSituation,codeZhuYuanReason,codeManagePeople,codeBangFuSituation");
		return jingshen;
	}

	public Page<BPerTSJingShen> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerTSJingShen> page = bPerTSJingShenMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerTSJingShen.class, "codeZhenDuanType,codeWeiXianClasses,codeZhiLiaoSituation");
		return page;
	}
}
