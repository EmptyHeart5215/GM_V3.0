package com.dykj.GSM.service.base.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.base.impl.BJiGouPeopleMapperImpl;
import com.dykj.GSM.model.base.BJiGouPeople;
import com.dykj.GSM.service.base.BJiGouPeopleService;
import com.dykj.GSM.utils.DateFormatUtil;

/**
 * @author 作者 :guoyunkang
 * @version 创建时间：2016-08-05 09:34:47
 * 修改人：
 * 修改日期：
 * 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class BJiGouPeopleServiceImpl implements BJiGouPeopleService {
    @Autowired
    private BJiGouPeopleMapperImpl bJiGouPeopleMapperImpl;

    @Override
    public int insert(BJiGouPeople entity) {
        entity.setCreateDate(DateFormatUtil.getStringDate());
        entity.setCreateBy("000001");
        return bJiGouPeopleMapperImpl.insert(entity);
    }

    @Override
    public int update(BJiGouPeople entity) {
        return bJiGouPeopleMapperImpl.update(entity);
    }

    @Override
    public int deletePk(String primaryKey) {
        return bJiGouPeopleMapperImpl.deletePk(primaryKey);
    }

    @Override
    public BJiGouPeople queryByKey(String primaryKey) {
        return bJiGouPeopleMapperImpl.queryByKey(primaryKey);
    }

    @Override
    public List<BJiGouPeople> queryList() {
        return bJiGouPeopleMapperImpl.queryList();
    }

    @Override
    public List<BJiGouPeople> queryListParam(Map param) {
        return bJiGouPeopleMapperImpl.queryListParam(param);
    }

    @Override
    public List<BJiGouPeople> queryTListParam(BJiGouPeople  param) {
        return bJiGouPeopleMapperImpl.queryTListParam(param);
    }

    @Override
    public Page<BJiGouPeople> queryByParamPage(int page, int size, String sidx, String sord, BJiGouPeople  param) {
        return bJiGouPeopleMapperImpl.queryByParamPage(page, size, sidx, sord, param);
    }

    @Override
    public int deleteBatch(List<String> list) {
        return bJiGouPeopleMapperImpl.deleteBatch(list);
    }

	@Override
	public int updateBatch(String primaryKey) {
		return bJiGouPeopleMapperImpl.updateBatch(primaryKey);
	}

	@Override
	public List<BJiGouPeople> queryParamPageByCode(String args) {
		return bJiGouPeopleMapperImpl.queryParamPageByCode(args);
	}
}