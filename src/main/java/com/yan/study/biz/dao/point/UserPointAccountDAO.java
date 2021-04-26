package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.UserPointAccountDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserPointAccountDAO {

    String ALL_COLUMN = "id, user_id as userId, point_type as pointType, available_point as availablePoint, " +
        "received_point as receivedPoint, freeze_point as freezePoint, consumed_point as consumedPoint, " +
        "expired_point as expiredPoint, last_calc_expire_time as lastCalcExpireTime, version";

    String INSERT_STATEMENT = "(" +
        "user_id, point_type" +
        "<if test = 'availablePoint != null'>, available_point</if>" +
        "<if test = 'receivedPoint != null'>, received_point</if>" +
        "<if test = 'freezePoint != null'>, freeze_point</if>" +
        "<if test = 'consumedPoint != null'>, consumed_point</if>" +
        "<if test = 'expiredPoint != null'>, expired_point</if>" +
        "<if test = 'lastCalcExpireTime != null'>, last_calc_expire_time</if>" +
        "<if test = 'version != null'>, version</if>" +
        ")VALUES (" +
        "#{userId}, #{pointType}" +
        "<if test = 'availablePoint != null'>, #{availablePoint}</if>" +
        "<if test = 'receivedPoint != null'>, #{receivedPoint}</if>" +
        "<if test = 'freezePoint != null'>, #{freezePoint}</if>" +
        "<if test = 'consumedPoint != null'>, #{consumedPoint}</if>" +
        "<if test = 'expiredPoint != null'>, #{expiredPoint}</if>" +
        "<if test = 'lastCalcExpireTime != null'>, #{lastCalcExpireTime}</if>" +
        "<if test = 'version != null'>, #{version}</if>" +
        ")";

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

    @Select({
        "SELECT",
        ALL_COLUMN,
        "FROM",
        TABLE_NAME,
        "WHERE user_id = #{userId} AND point_type = #{pointType}"
    })
    UserPointAccountDO query(@Param("userId") String userId, @Param("pointType") String pointType);

    @Insert({
        "<script>",
        "INSERT INTO", TABLE_NAME, INSERT_STATEMENT,
        "</script>"
    })
    void insert(UserPointAccountDO userPointAccountDO);

    @Update({
        "<script>",
        "UPDATE",
        TABLE_NAME,
        "SET",
        "<if test='availablePoint != null'> available_point = #{availablePoint}, </if>",
        "<if test='receivedPoint != null'> received_point = #{receivedPoint}, </if>",
        "<if test='freezePoint != null'> freeze_point = #{freezePoint}, </if>",
        "<if test='consumedPoint != null'> consumed_point = #{consumedPoint}, </if>",
        "<if test='expiredPoint != null'> expired_point = #{expiredPoint}, </if>",
        "<if test='lastCalcExpireTime != null'> lastCalc_expire_time = #{lastCalcExpireTime}, </if>",
        "version = version + 1",
        "WHERE user_id = #{userId} AND point_type = #{pointType} AND version = #{version}",
        "</script>"
    })
    int update(UserPointAccountDO userPointAccountDO);

}
