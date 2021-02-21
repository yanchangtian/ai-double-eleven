package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.UserPointAccountDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserPointAccountDAO {

    String ALL_COLUMN = "id, user_id as userId, point_type as pointType, available_point as availablePoint, " +
        "received_point as receivedPoint, freeze_point as freezePoint, consumed_point as consumedPoint, " +
        "expired_point as expiredPoint, last_calc_expire_time as lastCalcExpireTime, version";

    String TABLE_NAME = "user_point_account";

    @Select(
        "SELECT " + ALL_COLUMN + " FROM " + TABLE_NAME + " WHERE id = #{id}"
    )
    UserPointAccountDO selectById(@Param("id") Long id);

}
