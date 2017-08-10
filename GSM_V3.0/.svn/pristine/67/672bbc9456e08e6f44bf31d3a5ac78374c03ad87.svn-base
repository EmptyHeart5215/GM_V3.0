package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerZhiYuanMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerZhiYuan;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerZhiYuanService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerZhiYuanServiceImpl implements BPerZhiYuanService {
	@Autowired
	private BPerZhiYuanMapperImpl bPerZhiYuanMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerZhiYuan entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerZhiYuanMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerZhiYuanMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setZhiYuan(true);
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
	public int update(BPerZhiYuan entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerZhiYuanMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerZhiYuanMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerZhiYuanMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setZhiYuan(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerZhiYuan queryByKey(String primaryKey) {
		return bPerZhiYuanMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerZhiYuan> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerZhiYuan> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerZhiYuan> queryTListParam(BPerZhiYuan param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerZhiYuan> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerZhiYuan param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerZhiYuanMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerZhiYuan queryByPersonCode(String personCode) throws Exception {
		BPerZhiYuan zhiyuan = bPerZhiYuanMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(zhiyuan, BPerZhiYuan.class, "codeVolunteerType");
		return zhiyuan;
	}

	public Page<BPerZhiYuan> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		Page<BPerZhiYuan> page = bPerZhiYuanMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		try {
			dicValueInputService.inputDicValue(page, BPerZhiYuan.class, "codeInflowReason");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
}
