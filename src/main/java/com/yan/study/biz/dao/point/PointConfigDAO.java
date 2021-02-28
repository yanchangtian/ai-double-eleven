package com.yan.study.biz.dao.point;

import com.yan.study.biz.dao.point.entity.PointConfigDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface PointConfigDAO {

    String ALL_COLUMN = "id, point_type as pointType, point_name as pointName, point_desc as pointDesc, " +
        "preGive_invalid_type as preGiveInvalidType, expire_type as expireType";

    String TABLE_NAME = "point_config";

    @Select(
        "SELECT " + ALL_COLUMN + " FROM " + TABLE_NAME + " WHERE id = #{id}"
    )
    PointConfigDO selectById(@Param("id") Long id);

    @Select(
        "SELECT " + ALL_COLUMN + " FROM " + TABLE_NAME + " WHERE point_type = #{pointType}"
    )
    PointConfigDO selectByPointType(@Param("pointType") String pointType);

}
