package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.UserPointDetailDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserPointDetailDAO {

    String ALL_COLUMN = "id, user_id as userId, point_type as pointType, detail_code as detailCode, " +
        "give_reason as giveReason, idempotent_id as idempotentId, give_points as givePoints, " +
        "available_points as availablePoints, consumed_points as consumedPoints, freeze_points as freezePoints, " +
        "expired_points as expiredPoints, merged_points as mergedPoints, pre_give_time as preGiveTime, " +
        "effect_time as effectTime, invalid_time as invalidTime, expire_time as expireTime, merged_time as mergedTime, " +
        "detail_status as detailStatus, version";

    String TABLE_NAME = "user_point_detail";

    @Select(
        "SELECT " + ALL_COLUMN + " FROM " + TABLE_NAME + " WHERE id = #{id}"
    )
    UserPointDetailDO selectById(@Param("id") Long id);

    @Select(
        "SELECT " + ALL_COLUMN + " FROM " + TABLE_NAME + " WHERE point_type = #{pointType}"
    )
    UserPointDetailDO selectByPointType(@Param("pointType") String pointType);

    @Insert(
        "INSERT INTO " + TABLE_NAME + "(user_id, point_type, detail_code, give_reason, idempotent_id, give_points, " +
        "available_points, consumed_points)" + " VALUES " + "()"
    )
    int insert(UserPointDetailDO userPointDetailDO);

}
