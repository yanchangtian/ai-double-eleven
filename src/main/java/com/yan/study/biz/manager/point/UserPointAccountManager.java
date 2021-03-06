package com.yan.study.biz.manager.point;

import com.yan.study.biz.dao.point.entity.UserPointAccountDO;
import org.springframework.stereotype.Service;

@Service
public interface UserPointAccountManager {

    void insert(UserPointAccountDO userPointAccount);

    UserPointAccountDO query(String userId, String pointType);

    UserPointAccountDO initAndGet(String userId, String pointType);

    int update(UserPointAccountDO userPointAccount);

    /**
     * 增加可用积分
     *
     * @param userId
     * @param pointType
     * @param availablePoints
     */
    void increasePoints(String userId, String pointType, Long availablePoints);

    Long queryAvailablePoint(String userId, String pointType);

}
