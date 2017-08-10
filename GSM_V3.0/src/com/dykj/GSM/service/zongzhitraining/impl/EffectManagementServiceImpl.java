package com.dykj.GSM.service.zongzhitraining.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.zongzhitraining.impl.EffectManagementMapperImpl;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.zongzhitraining.EffectManagement;
import com.dykj.GSM.service.zongzhitraining.EffectManagementService;
import com.dykj.GSM.utils.DateFormatUtil;
import com.dykj.GSM.utils.MySession;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-05-06 10:06:07
 * 修改人：
 * 修改日期：
 * 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class EffectManagementServiceImpl implements EffectManagementService {
    @Autowired
    private EffectManagementMapperImpl effectManagementMapperImpl;

    @Override
    public int insert(EffectManagement entity) {
    	SessionModel session = MySession.getInfo();
        entity.setCreateDate(DateFormatUtil.getStringDate());
        System.out.println("====================="+session.getCode());
        entity.setCreateBy(session.getCode());
        entity.setDownLoadUserCode(session.getCode());
        return effectManagementMapperImpl.insert(entity);
    }

    @Override
    public int update(EffectManagement entity) {
        return effectManagementMapperImpl.update(entity);
    }

    @Override
    public int deletePk(String primaryKey) {
        return effectManagementMapperImpl.deletePk(primaryKey);
    }

    @Override
    public EffectManagement queryByKey(String primaryKey) {
        return effectManagementMapperImpl.queryByKey(primaryKey);
    }

    @Override
    public List<EffectManagement> queryList() {
        return effectManagementMapperImpl.queryList();
    }

    @Override
    public List<EffectManagement> queryListParam(Map param) {
        return effectManagementMapperImpl.queryListParam(param);
    }

    @Override
    public List<EffectManagement> queryTListParam(EffectManagement  param) {
        return effectManagementMapperImpl.queryTListParam(param);
    }

    @Override
    public Page<EffectManagement> queryByParamPage(int page, int size, String sidx, String sord, EffectManagement  param) {
        return effectManagementMapperImpl.queryByParamPage(page, size, sidx, sord, param);
    }

    @Override
    public int deleteBatch(List<String> list) {
        return effectManagementMapperImpl.deleteBatch(list);
    }
}