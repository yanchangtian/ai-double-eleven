package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.UserPointAccountDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserPointAccountDAO {

    String ALL_COLUMN = "id, user_id as userId, point_type as pointType, available_point as availablePoint, " +
        "received_point as receivedPoint, freeze_point as freezePoint, consumed_point as consumedPoint, " +
        "expired_point as expiredPoint, last_calc_expire_time as lastCalcExpireTime, version";

    String TABLE_NAME = "user_point_account";

    @Select(
        "SELECT " + ALL_COLUMN + " FROM " + TABLE_NAME + " WHERE id = #{id}"
    )
    UserPointAccountDO selectById(@Param("id") Long id);

    @Select({
        "SELECT available_point FROM" + TABLE_NAME + " WHERE user_id = #{userId} AND point_type = #{pointType}"
    })
    Long queryAvailablePoint(@Param("userId") String userId, @Param("pointType") String pointType);

    @Update({
        "UPDATE " + TABLE_NAME + " SET available_point = available_point + #{availablePoint} " +
        "WHERE user_id = #{userId} AND point_type = #{pointType}"
    })
    void increasePoints(@Param("userId") String userId,
                        @Param("pointType") String pointType,
                        @Param("availablePoint") Long availablePoints);

}
