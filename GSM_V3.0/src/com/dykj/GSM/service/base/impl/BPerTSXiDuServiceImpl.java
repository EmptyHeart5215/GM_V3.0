package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerTSXiDuMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerTSXiDu;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerTSXiDuService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerTSXiDuServiceImpl implements BPerTSXiDuService {
	@Autowired
	private BPerTSXiDuMapperImpl bPerTSXiDuMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BPerTSXiDu entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerTSXiDuMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerTSXiDuMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsXiDu(true);
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
	public int update(BPerTSXiDu entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerTSXiDuMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerTSXiDuMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerTSXiDuMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsXiDu(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerTSXiDu queryByKey(String primaryKey) {
		return bPerTSXiDuMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerTSXiDu> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSXiDu> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSXiDu> queryTListParam(BPerTSXiDu param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerTSXiDu> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerTSXiDu param) {
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
	public BPerTSXiDu queryByPersonCode(String personCode) throws Exception {
		BPerTSXiDu xidu = bPerTSXiDuMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(xidu, BPerTSXiDu.class, "codeGuanKong,codeXiDuReason,codeXiDuEffect");
		return xidu;
	}

	public Page<BPerTSXiDu> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerTSXiDu> page = bPerTSXiDuMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerTSXiDu.class, "codeGuanKong");
		return page;
	}
}
