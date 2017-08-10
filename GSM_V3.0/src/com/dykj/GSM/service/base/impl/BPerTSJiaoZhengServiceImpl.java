package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerTSJiaoZhengMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerTSJiaoZheng;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerTSJiaoZhengService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerTSJiaoZhengServiceImpl implements BPerTSJiaoZhengService {
	@Autowired
	private BPerTSJiaoZhengMapperImpl bPerTSJiaoZhengMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BPerTSJiaoZheng entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerTSJiaoZhengMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerTSJiaoZhengMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsJiaoZheng(true);
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
	public int update(BPerTSJiaoZheng entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerTSJiaoZhengMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerTSJiaoZhengMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerTSJiaoZhengMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsJiaoZheng(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerTSJiaoZheng queryByKey(String primaryKey) {
		return bPerTSJiaoZhengMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerTSJiaoZheng> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSJiaoZheng> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSJiaoZheng> queryTListParam(BPerTSJiaoZheng param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerTSJiaoZheng> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerTSJiaoZheng param) {
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
	public BPerTSJiaoZheng queryByPersonCode(String personCode) throws Exception {
		BPerTSJiaoZheng jiaozheng = bPerTSJiaoZhengMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(jiaozheng, BPerTSJiaoZheng.class, "codeRectifyType,codeAnJianType,codeJieShouType,codeSiShi,codeSanShe,codeGroupSituation,codeJieChuType");
		return jiaozheng;
	}

	public Page<BPerTSJiaoZheng> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerTSJiaoZheng> page = bPerTSJiaoZhengMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerTSJiaoZheng.class, "codeRectifyType,codeAnJianType");
		return page;
	}
}
