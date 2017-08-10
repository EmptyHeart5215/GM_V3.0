package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerLaoDongMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerLaoDong;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerLaoDongService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerLaoDongServiceImpl implements BPerLaoDongService {
	@Autowired
	private BPerLaoDongMapperImpl bPerLaoDongMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerLaoDong entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerLaoDongMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerLaoDongMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setLaoDong(true);
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
	public int update(BPerLaoDong entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerLaoDongMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerLaoDongMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerLaoDongMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setLaoDong(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerLaoDong queryByKey(String primaryKey) {
		return bPerLaoDongMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerLaoDong> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerLaoDong> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerLaoDong> queryTListParam(BPerLaoDong param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerLaoDong> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerLaoDong param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerLaoDongMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerLaoDong queryByPersonCode(String personCode) throws Exception {
		BPerLaoDong laodong = bPerLaoDongMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(laodong, BPerLaoDong.class, "codeJiuYeType");
		return laodong;
	}

	public Page<BPerLaoDong> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) {
		Page<BPerLaoDong> page = bPerLaoDongMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		try {
			dicValueInputService.inputDicValue(page, BPerLaoDong.class, "codeInflowReason");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return page;
	}
}
