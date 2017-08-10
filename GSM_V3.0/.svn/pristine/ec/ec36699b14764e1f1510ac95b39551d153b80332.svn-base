package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.base.impl.BPerFuShuMapperImpl;
import com.dykj.GSM.mapper.base.impl.BPerTSXingShiMapperImpl;
import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.model.base.BPerFuShu;
import com.dykj.GSM.model.base.BPerTSXingShi;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.base.BPerTSXingShiService;
import com.dykj.GSM.utils.DateFormatUtil;

@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BPerTSXingShiServiceImpl implements BPerTSXingShiService {
	@Autowired
	private BPerTSXingShiMapperImpl bPerTSXingShiMapperImpl;
	@Autowired
	private BPerFuShuMapperImpl bPerFuShuMapperImpl;
	@Autowired
	private DicValueInputService dicValueInputService;

	@Override
	public int insert(BPerTSXingShi entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		// 插入之前先删除，以免由于程序错误插入导致问题
		bPerTSXingShiMapperImpl.deleteByPersonCode(entity.getPersonCode());
		int i = bPerTSXingShiMapperImpl.insert(entity);
		if (i > 0) {
			// 更新一下附属表
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsXingShi(true);
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
	public int update(BPerTSXingShi entity) throws Exception {
		entity.setCreateDate(DateFormatUtil.getStringDate());
		int i = bPerTSXingShiMapperImpl.update(entity);
		if (i <= 0) {
			throw new Exception("没有更新成功");
		}
		return i;
	}

	@Override
	public int deletePk(String primaryKey) throws Exception {
		String personCode = bPerTSXingShiMapperImpl.queryByKey(primaryKey).getPersonCode();
		int i = bPerTSXingShiMapperImpl.deletePk(primaryKey);
		// 更新一下附属表
		if (i > 0) {
			BPerFuShu fushu = new BPerFuShu();
			fushu.setTsXingShi(false);
			fushu.setPersonCode(personCode);
			i = bPerFuShuMapperImpl.update(fushu);
		} else if (i <= 0) {
			throw new Exception("没有删除成功");
		}
		return i;
	}

	@Override
	public BPerTSXingShi queryByKey(String primaryKey) {
		return bPerTSXingShiMapperImpl.queryByKey(primaryKey);
	}

	@Override
	public List<BPerTSXingShi> queryList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSXingShi> queryListParam(Map param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BPerTSXingShi> queryTListParam(BPerTSXingShi param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<BPerTSXingShi> queryByParamPage(int pageNum, int size, String sidx, String sord, BPerTSXingShi param) {
		return null;
	}

	@Override
	public int deleteBatch(List<String> list) {
		return bPerTSXingShiMapperImpl.deleteBatch(list);
	}

	/**
	 * 根据基本信息code查询流动人员的信息
	 * 
	 * @param personCode
	 * @return
	 * @throws Exception 
	 */
	@Override
	public BPerTSXingShi queryByPersonCode(String personCode) throws Exception {
		BPerTSXingShi xingshi = bPerTSXingShiMapperImpl.queryByPersonCode(personCode);
		dicValueInputService.inputDicValueForOne(xingshi, BPerTSXingShi.class, "codeZuiMing,codeBangJiaoType,codeXianJieRemark,codeAnZhiRemark");
		return xingshi;
	}

	public Page<BPerTSXingShi> queryByMapParamPage(int pageNum, int size, String sidx, String sord,
			Map<String, Object> param) throws Exception {
		Page<BPerTSXingShi> page = bPerTSXingShiMapperImpl.queryMapParamPage(pageNum, size, sidx, sord, param);
		dicValueInputService.inputDicValue(page, BPerTSXingShi.class, "codeZuiMing,codeBangJiaoType");
		return page;
	}
}
