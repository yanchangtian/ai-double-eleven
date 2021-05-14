package com.yan.study.biz.manager.point.impl;

import com.yan.study.biz.dao.point.UserPointFreezeRecordDetailDAO;
import com.yan.study.biz.dao.point.entity.UserPointFreezeRecordDetailDO;
import com.yan.study.biz.manager.point.UserPointFreezeRecordDetailManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserPointFreezeRecordDetailManagerImpl implements UserPointFreezeRecordDetailManager {

    @Resource
    private UserPointFreezeRecordDetailDAO userPointFreezeRecordDetailDAO;

    @Override
    public void insert(UserPointFreezeRecordDetailDO userPointFreezeRecordDetail) {
        userPointFreezeRecordDetailDAO.insert(userPointFreezeRecordDetail);
    }

}
