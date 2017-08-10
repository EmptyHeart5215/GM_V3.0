package com.dykj.GSM.service.zongzhitraining.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dykj.GSM.mapper.support.Page;
import com.dykj.GSM.mapper.zongzhitraining.impl.ZongzhiMaterialMapperImpl;
import com.dykj.GSM.model.SessionModel;
import com.dykj.GSM.model.zongzhitraining.ZongzhiMaterial;
import com.dykj.GSM.service.DicValueInputService;
import com.dykj.GSM.service.zongzhitraining.ZongzhiMaterialService;
import com.dykj.GSM.utils.DateFormatUtil;
import com.dykj.GSM.utils.MySession;

/**
 * @author 作者 :wangmingyuan
 * @version 创建时间：2016-04-27 15:52:59
 * 修改人：
 * 修改日期：
 * 类说明:
 */
@Service
@Transactional(noRollbackFor = RuntimeException.class)
public class ZongzhiMaterialServiceImpl implements ZongzhiMaterialService {
	
    @Autowired
    private ZongzhiMaterialMapperImpl zongzhiMaterialMapperImpl;
    @Autowired
    private DicValueInputService dicValueInputService;

    @Override
    public int insert(ZongzhiMaterial entity) {
        entity.setCreateDate(DateFormatUtil.getStringDate());
        SessionModel sessionModel = MySession.getInfo();
        entity.setCreateBy(sessionModel.getCode());
        entity.setDownloadCount("0");
        return zongzhiMaterialMapperImpl.insert(entity);
    }

    @Override
    public int update(ZongzhiMaterial entity) {
        return zongzhiMaterialMapperImpl.update(entity);
    }

    @Override
    public int deletePk(String primaryKey) {
        return zongzhiMaterialMapperImpl.deletePk(primaryKey);
    }

    @Override
    public ZongzhiMaterial queryByKey(String primaryKey) {
        return zongzhiMaterialMapperImpl.queryByKey(primaryKey);
    }

    @Override
    public List<ZongzhiMaterial> queryList() {
        return zongzhiMaterialMapperImpl.queryList();
    }

    @Override
    public List<ZongzhiMaterial> queryListParam(Map param) {
        return zongzhiMaterialMapperImpl.queryListParam(param);
    }

    @Override
    public List<ZongzhiMaterial> queryTListParam(ZongzhiMaterial  param) {
        return zongzhiMaterialMapperImpl.queryTListParam(param);
    }

    @Override
    public Page<ZongzhiMaterial> queryByParamPage(int page, int size, String sidx, String sord, ZongzhiMaterial  param) throws Exception {
        Page<ZongzhiMaterial> pages = zongzhiMaterialMapperImpl.queryByParamPage(page, size, sidx, sord, param);
		dicValueInputService.inputDicValue(pages, ZongzhiMaterial.class, "codeUploadMaterialType");
		return pages;
    }

    @Override
    public int deleteBatch(List<String> list) {
        return zongzhiMaterialMapperImpl.deleteBatch(list);
    }
}