package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.UserPointDetailDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserPointDetailDAO {

    String ALL_COLUMN = "id, user_id as userId, point_type as pointType, detail_code as detailCode, " +
        "give_reason as giveReason, idempotent_id as idempotentId, give_points as givePoints, " +
        "available_points as availablePoints, consumed_points as consumedPoints, freeze_points as freezePoints, " +
        "expired_points as expiredPoints, merged_points as mergedPoints, pre_give_time as preGiveTime, " +
        "effect_time as effectTime, invalid_time as invalidTime, expire_time as expireTime, merged_time as mergedTime, " +
        "detail_status as detailStatus, version";

    String INSERT_STATEMENT = "(" +
        "<if test='detailCode != null'> detail_code, </if>" +
        "<if test='giveReason != null'> give_reason, </if>" +
        "<if test='idempotentId != null'> idempotent_id, </if>" +
        "<if test='givePoints != null'> give_points, </if>" +
        "<if test='availablePoints != null'> available_points, </if>" +
        "<if test='consumedPoints != null'> consumed_points, </if>" +
        "<if test='freezePoints != null'> freeze_points, </if>" +
        "<if test='expiredPoints != null'> expired_points, </if>" +
        "<if test='mergedPoints != null'> merged_points, </if>" +
        "<if test='preGiveTime != null'> pre_give_time, </if>" +
        "<if test='effectTime != null'> effect_time, </if>" +
        "<if test='invalidTime != null'> invalid_time, </if>" +
        "<if test='expireTime != null'> expire_time, </if>" +
        "<if test='mergedTime != null'> merged_time, </if>" +
        "<if test='detailStatus != null'> detail_status, </if>" +
        "<if test='version != null'> version, </if>" +
        "user_id, point_type" +
        ") VALUES(" +
        "<if test='detailCode != null'> #{detailCode}, </if>" +
        "<if test='giveReason != null'> #{giveReason}, </if>" +
        "<if test='idempotentId != null'> #{idempotentId}, </if>" +
        "<if test='givePoints != null'> #{givePoints}, </if>" +
        "<if test='availablePoints != null'> #{availablePoints}, </if>" +
        "<if test='consumedPoints != null'> #{consumedPoints}, </if>" +
        "<if test='freezePoints != null'> #{freezePoints}, </if>" +
        "<if test='expiredPoints != null'> #{expiredPoints}, </if>" +
        "<if test='mergedPoints != null'> #{mergedPoints}, </if>" +
        "<if test='preGiveTime != null'> #{preGiveTime}, </if>" +
        "<if test='effectTime != null'> #{effectTime}, </if>" +
        "<if test='invalidTime != null'> #{invalidTime}, </if>" +
        "<if test='expireTime != null'> #{expireTime}, </if>" +
        "<if test='mergedTime != null'> #{mergedTime}, </if>" +
        "<if test='detailStatus != null'> #{detailStatus}, </if>" +
        "<if test='version != null'> #{version}, </if>" +
        "#{userId}, #{pointType})";

    String TABLE_NAME = "user_point_detail";

    @Insert({
        "<script>",
        "INSERT INTO " + TABLE_NAME + INSERT_STATEMENT,
        "</script>"
    })
    int insert(UserPointDetailDO userPointDetailDO);

    @Update({
        "<script>",
        "UPDATE",
        TABLE_NAME,
        "SET",
        "<if test='detailCode != null'> detail_code = #{detailCode}, </if>",
        "<if test='giveReason != null'> give_reason = #{giveReason}, </if>",
        "<if test='idempotentId != null'> idempotent_id = #{idempotentId}, </if>",
        "<if test='givePoints != null'> give_points = #{givePoints}, </if>",
        "<if test='availablePoints != null'> available_points = #{availablePoints}, </if>",
        "<if test='consumedPoints != null'> consumed_points = #{consumedPoints}, </if>",
        "<if test='freezePoints != null'> freeze_points = #{freezePoints}, </if>",
        "<if test='expiredPoints != null'> expired_points = #{expiredPoints}, </if>",
        "<if test='mergedPoints != null'> merged_points = #{mergedPoints}, </if>",
        "<if test='preGiveTime != null'> pre_give_time = #{preGiveTime}, </if>",
        "<if test='effectTime != null'> effect_time = #{effectTime}, </if>",
        "<if test='invalidTime != null'> invalid_time = #{invalidTime}, </if>",
        "<if test='expireTime != null'> expire_time = #{expireTime}, </if>",
        "<if test='mergedTime != null'> merged_time = #{mergedTime}, </if>",
        "<if test='detailStatus != null'> detail_status = #{detailStatus}, </if>",
        "version = version + 1",
        "WHERE user_id = #{userId} AND point_type = #{pointType} AND version = #{version}",
        "</script>"
    })
    int update(UserPointDetailDO userPointDetailDO);

    @Select({
        "SELECT",
        ALL_COLUMN,
        "FROM",
        TABLE_NAME,
        "WHERE user_id = #{userId} AND detail_code = #{detailCode}"
    })
    UserPointDetailDO queryByDetailCode(@Param("userId") String userId, @Param("detailCode") String detailCode);
}
