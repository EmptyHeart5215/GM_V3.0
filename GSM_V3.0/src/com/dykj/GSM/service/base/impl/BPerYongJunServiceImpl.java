package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerYongJunMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerYongJun;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerYongJunService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerYongJunServiceImpl implements BPerYongJunService {
	@Autowired
	private BPerYongJunMapperImpl bPerYongJunMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerYongJun entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerYongJunMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerYongJunMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setYongJun(true);
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
	public int update(BPerYongJun entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerYongJunMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerYongJunMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerYongJunMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setYongJun(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerYongJun queryByKey(String primaryKey) {
		return bPerYongJunMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerYongJun> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerYongJun> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerYongJun> queryTListParam(BPerYongJun param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerYongJun> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerYongJun param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerYongJunMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerYongJun queryByPersonCode(String personCode) throws Exception {
		BPerYongJun yongjun = bPerYongJunMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(yongjun, BPerYongJun.class, "codeSamc");
		return yongjun;
	}

	public Page<BPerYongJun> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		Page<BPerYongJun> page = bPerYongJunMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		try {
			dicValueInputService.inputDicValue(page, BPerYongJun.class, "codeInflowReason");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
}
