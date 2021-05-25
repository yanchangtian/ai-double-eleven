package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.UserPointFreezeRecordDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserPointFreezeRecordDAO {

    String ALL_COLUMN = "id, user_id as userId, point_type as pointType, freeze_code as freezeCode, " +
        "idempotent_id as idempotentId, freeze_reason as freezeReason, freeze_points as freezePoints, " +
        "freeze_time as freezeTime, freeze_record_status as freezeRecordStatus, version";

    String INSERT_STATEMENT = "(" +
        "<if test='freezeCode != null'> freeze_code, </if>" +
        "<if test='idempotentId != null'> idempotent_id, </if>" +
        "<if test='freezeReason != null'> freeze_reason, </if>" +
        "<if test='freezePoints != null'> freeze_points, </if>" +
        "<if test='freezeTime != null'> freeze_time, </if>" +
        "<if test='freezeRecordStatus != null'> freeze_record_status, </if>" +
        "<if test='version != null'> version, </if>" +
        "user_id, point_type" +
        ") VALUES(" +
        "<if test='freezeCode != null'> #{freezeCode}, </if>" +
        "<if test='idempotentId != null'> #{idempotentId}, </if>" +
        "<if test='freezeReason != null'> #{freezeReason}, </if>" +
        "<if test='freezePoints != null'> #{freezePoints}, </if>" +
        "<if test='freezeTime != null'> #{freezeTime}, </if>" +
        "<if test='freezeRecordStatus != null'> #{freezeRecordStatus}, </if>" +
        "<if test='version != null'> #{version}, </if>" +
        "#{userId}, #{pointType})";

    String TABLE_NAME = "user_point_freeze_record";

    @Insert({
        "<script>",
        "INSERT INTO " + TABLE_NAME + INSERT_STATEMENT,
        "</script>"
    })
    int insert(UserPointFreezeRecordDO userPointFreezeRecordDO);

    @Update({
        "<script>",
        "UPDATE",
        TABLE_NAME,
        "SET",
        "<if test='freezeRecordStatus != null'> freeze_record_status = #{freezeRecordStatus}, </if>",
        "version = version + 1",
        "WHERE user_id = #{userId} AND freeze_code = #{freezeCode} AND version = #{version}",
        "</script>"
    })
    int update(UserPointFreezeRecordDO userPointFreezeRecordDO);

    @Select({
        "SELECT",
        ALL_COLUMN,
        "FROM",
        TABLE_NAME,
        "WHERE freeze_code = #{freezeCode}"
    })
    UserPointFreezeRecordDO queryByFreezeCode(@Param("userId") String userId, @Param("freezeCode") String freezeCode);

}
