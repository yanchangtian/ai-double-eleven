package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.UserPointFreezeRecordDetailDO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

public interface UserPointFreezeRecordDetailDAO {

    String ALL_COLUMN = "id, user_id as userId, point_type as pointType, freeze_code as freezeCode, " +
        "detail_code as detailCode, freeze_points as freezePoints, version";

    String INSERT_STATEMENT = "(" +
        "<if test='freezeCode != null'> freeze_code, </if>" +
        "<if test='detailCode != null'> detail_code, </if>" +
        "<if test='freezePoints != null'> freeze_points, </if>" +
        "<if test='version != null'> version, </if>" +
        "user_id, point_type" +
        ") VALUES(" +
        "<if test='freezeCode != null'> #{freezeCode}, </if>" +
        "<if test='detailCode != null'> #{detailCode}, </if>" +
        "<if test='freezePoints != null'> #{freezePoints}, </if>" +
        "<if test='version != null'> #{version}, </if>" +
        "#{userId}, #{pointType})";

    String TABLE_NAME = "user_point_freeze_record_detail";

    @Insert({
        "<script>",
        "INSERT INTO " + TABLE_NAME + INSERT_STATEMENT,
        "</script>"
    })
    int insert(UserPointFreezeRecordDetailDO userPointFreezeRecordDetailDO);

    @Update({
        "<script>",
        "UPDATE",
        TABLE_NAME,
        "SET",
        "<if test='freezeRecordStatus != null'> freeze_record_status = #{freezeRecordStatus}, </if>",
        "version = version + 1",
        "WHERE user_id = #{userId} AND point_type = #{pointType} AND version = #{version}",
        "</script>"
    })
    int update(UserPointFreezeRecordDetailDO userPointFreezeRecordDetailDO);

}
