package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerLiuDongMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerHuJi;
import com.dykj.GSM.model.base.BPerLiuDong;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerLiuDongService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerLiuDongServiceImpl implements BPerLiuDongService {
	@Autowired
	private BPerLiuDongMapperImpl bPerLiuDongMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;

	@Override
	public int insert(BPerLiuDong entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerLiuDongMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerLiuDongMapperImpl.insert(entity);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setLiuDong(true);
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
	public int update(BPerLiuDong entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerLiuDongMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerLiuDongMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerLiuDongMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setLiuDong(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerLiuDong queryByKey(String primaryKey) {
		return bPerLiuDongMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerLiuDong> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerLiuDong> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerLiuDong> queryTListParam(BPerLiuDong param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerLiuDong> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerLiuDong param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerLiuDongMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerLiuDong queryByPersonCode(String personCode) throws Exception {
		BPerLiuDong liudong = bPerLiuDongMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(liudong, BPerLiuDong.class, "codeInflowReason,codeIdType,codeZhuSuoType");
		return liudong;
	}

	public Page<BPerLiuDong> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerLiuDong> page = bPerLiuDongMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerLiuDong.class, "codeInflowReason");
		return page;
	}
}
