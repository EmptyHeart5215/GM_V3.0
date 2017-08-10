package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerTSXieJiaoMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerTSXieJiao;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerTSXieJiaoService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerTSXieJiaoServiceImpl implements BPerTSXieJiaoService {
	@Autowired
	private BPerTSXieJiaoMapperImpl bPerTSXieJiaoMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BPerTSXieJiao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerTSXieJiaoMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerTSXieJiaoMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsXieJiao(true);
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
	public int update(BPerTSXieJiao entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerTSXieJiaoMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerTSXieJiaoMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerTSXieJiaoMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsXieJiao(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerTSXieJiao queryByKey(String primaryKey) {
		return bPerTSXieJiaoMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerTSXieJiao> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSXieJiao> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSXieJiao> queryTListParam(BPerTSXieJiao param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerTSXieJiao> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerTSXieJiao param) {
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
	 */
	@Override
	public BPerTSXieJiao queryByPersonCode(String personCode) {
		return bPerTSXieJiaoMapperImpl.queryByPersonCode(personCode);
	}

	public Page<BPerTSXieJiao> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerTSXieJiao> page = bPerTSXieJiaoMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
//		dicValueInputService.inputDicValue(page, BPerTSXieJiao.class, "codeRectifyType,codeAnJianType");
		return page;
	}
}
