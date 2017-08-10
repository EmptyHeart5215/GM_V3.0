package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerBfKunNanZhiGongMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerBfKunNanZhiGong;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.service.base.BPerBfKunNanZhiGongService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = Exception.class)
public class BPerBfKunNanZhiGongServiceImpl implements BPerBfKunNanZhiGongService {
	@Autowired
	private BPerBfKunNanZhiGongMapperImpl bPerBfKunNanZhiGongMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerBfKunNanZhiGong entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerBfKunNanZhiGongMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerBfKunNanZhiGongMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfKunNanZhiGong(true);
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
	public int update(BPerBfKunNanZhiGong entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerBfKunNanZhiGongMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerBfKunNanZhiGongMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerBfKunNanZhiGongMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setBfKunNanZhiGong(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerBfKunNanZhiGong queryByKey(String primaryKey) {
		return bPerBfKunNanZhiGongMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerBfKunNanZhiGong> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfKunNanZhiGong> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerBfKunNanZhiGong> queryTListParam(BPerBfKunNanZhiGong param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerBfKunNanZhiGong> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerBfKunNanZhiGong param) {
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
	public BPerBfKunNanZhiGong queryByPersonCode(String personCode) {
		return bPerBfKunNanZhiGongMapperImpl.queryByPersonCode(personCode);
	}
}
