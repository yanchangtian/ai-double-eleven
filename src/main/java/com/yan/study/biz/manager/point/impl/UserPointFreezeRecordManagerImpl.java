package com.yan.study.biz.manager.point.impl;

import com.yan.study.biz.common.UserPointFreezeRecordStatus;
import com.yan.study.biz.dao.point.entity.UserPointFreezeRecordDO;
import com.yan.study.biz.manager.point.UserPointFreezeRecordManager;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UserPointFreezeRecordManagerImpl implements UserPointFreezeRecordManager {

    @Override
    public void insert(UserPointFreezeRecordDO userPointFreezeRecord) {

    }

    @Override
    public UserPointFreezeRecordDO createFreezeRecord(String userId, String pointType, String idempotentId,
                                                      String reason, Long freezePoints, Date freezeTime,
                                                      UserPointFreezeRecordStatus status) {
        UserPointFreezeRecordDO userPointFreezeRecord = new UserPointFreezeRecordDO();
        userPointFreezeRecord.setUserId(userId);
        userPointFreezeRecord.setPointType(pointType);
        userPointFreezeRecord.setFreezeCode(UUID.randomUUID().toString().replaceAll("-", ""));
        userPointFreezeRecord.setIdempotentId(idempotentId);
        userPointFreezeRecord.setFreezeReason(reason);
        userPointFreezeRecord.setFreezePoints(freezePoints);
        userPointFreezeRecord.setFreezeTime(freezeTime);
        userPointFreezeRecord.setFreezeRecordStatus(status.getStatus());
        insert(userPointFreezeRecord);
        return userPointFreezeRecord;
    }

    @Override
    public UserPointFreezeRecordDO queryByCode(String userId, String freezeRecordCode) {
        return null;
    }

    @Override
    public int update(UserPointFreezeRecordDO userPointFreezeRecord) {
        return 0;
    }

}
