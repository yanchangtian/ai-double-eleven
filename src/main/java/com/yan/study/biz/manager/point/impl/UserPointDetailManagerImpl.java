package com.yan.study.biz.manager.point.impl;

import com.yan.study.biz.common.PointSystemException;
import com.yan.study.biz.common.UserPointDetailStatus;
import com.yan.study.biz.dao.point.UserPointDetailDAO;
import com.yan.study.biz.dao.point.entity.UserPointDetailDO;
import com.yan.study.biz.manager.point.UserPointDetailManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserPointDetailManagerImpl implements UserPointDetailManager {

    @Resource
    private UserPointDetailDAO userPointDetailDAO;

    @Override
    public void insert(UserPointDetailDO userPointDetailDO) {
        userPointDetailDAO.insert(userPointDetailDO);
    }

    @Override
    public UserPointDetailDO queryByDetailCode(String userId, String detailCode) {
        return userPointDetailDAO.queryByDetailCode(userId, detailCode);
    }

    @Override
    public int update(UserPointDetailDO userPointDetailDO) {
        return userPointDetailDAO.update(userPointDetailDO);
    }

    @Override
    public List<UserPointDetailDO> queryAvailablePointRecord(String userId, String pointType) {
        return userPointDetailDAO.queryAvailablePointRecord(userId, pointType);
    }

    @Override
    // @Transactional
    public void freezeDetailWithAll(List<UserPointDetailDO> allFreezeList) {
        // 必须保证全部成功, 否则抛出异常
        for (UserPointDetailDO userPointDetail : allFreezeList) {
            userPointDetail.setFreezePoints(userPointDetail.getFreezePoints() + userPointDetail.getAvailablePoints());
            userPointDetail.setAvailablePoints(0L);
            userPointDetail.setDetailStatus(UserPointDetailStatus.FROZEN.getStatus());
            int i = update(userPointDetail);
            if (i < 1) {
                throw new PointSystemException("并发更新积分详情");
            }
        }

    }

    @Override
    public void freezeDetailWithPortion(UserPointDetailDO userPointDetail, Long points) {
        userPointDetail.setFreezePoints(userPointDetail.getFreezePoints() + points);
        userPointDetail.setAvailablePoints(userPointDetail.getAvailablePoints() - points);
        userPointDetail.setDetailStatus(UserPointDetailStatus.PART_FROZEN.getStatus());
        int i = update(userPointDetail);
        if (i < 1) {
            throw new PointSystemException("并发更新积分详情");
        }
    }

    @Override
    public UserPointDetailDO queryByUserIdAndIdempotentId(String userId, String idempotentId) {
        return userPointDetailDAO.queryByUserIdAndIdempotentId(userId, idempotentId);
    }

}
