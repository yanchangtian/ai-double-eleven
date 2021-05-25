package com.yan.study.biz.manager.point.impl;

import com.yan.study.biz.dao.point.UserPointFreezeRecordDetailDAO;
import com.yan.study.biz.dao.point.entity.UserPointFreezeRecordDetailDO;
import com.yan.study.biz.manager.point.UserPointFreezeRecordDetailManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserPointFreezeRecordDetailManagerImpl implements UserPointFreezeRecordDetailManager {

    @Resource
    private UserPointFreezeRecordDetailDAO userPointFreezeRecordDetailDAO;

    @Override
    public void insert(UserPointFreezeRecordDetailDO userPointFreezeRecordDetail) {
        userPointFreezeRecordDetailDAO.insert(userPointFreezeRecordDetail);
    }

    @Override
    public List<UserPointFreezeRecordDetailDO> queryByFreezeCode(String freezeCode) {
        return userPointFreezeRecordDetailDAO.queryByFreezeCode(freezeCode);
    }

}
