package com.yan.study.biz.manager.point;

import com.yan.study.biz.dao.point.entity.UserPointFreezeRecordDetailDO;

import java.util.List;

public interface UserPointFreezeRecordDetailManager {

    /**
     * 新增积分冻结记录明细
     *
     * @param userPointFreezeRecordDetail 积分冻结记录明细
     */
    void insert(UserPointFreezeRecordDetailDO userPointFreezeRecordDetail);

    List<UserPointFreezeRecordDetailDO> queryByFreezeCode(String freezeCode);

}
