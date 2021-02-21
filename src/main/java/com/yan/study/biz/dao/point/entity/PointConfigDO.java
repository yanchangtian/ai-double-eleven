package com.yan.study.biz.dao.point.entity;

import com.yan.study.biz.common.PointPreGiveInvalidType;
import lombok.Data;

import java.util.Date;

@Data
public class PointConfigDO {

    private Long id;

    private String pointType;

    private String pointName;

    private String pointDesc;

    /**
     * 积分预发放失效类型: 当日内领取/3日内领取
     */
    private String preGiveInvalidType;

    /**
     * 积分过期类型: 每月1号清除领取超一年未使用的积分
     */
    private String expireType;

    private final static long THREE_DAYS = 1000 * 3600 * 24 * 3;

    /**
     * 计算预发放积分失效时间
     *
     * @param preGiveTime 预发放积分时间
     * @return 积分失效时间
     */
    public Date calcPrePointInvalidTime(Date preGiveTime) {
        PointPreGiveInvalidType pointPreGiveInvalidType = PointPreGiveInvalidType.findByName(this.preGiveInvalidType);
        if (pointPreGiveInvalidType == null) {
            throw new RuntimeException("积分预发放失效类型无效");
        }
        switch (pointPreGiveInvalidType) {
            case THREE_DAYS:
                return new Date(preGiveTime.getTime() + THREE_DAYS);
            case CURRENT_DAY:
            default:
                return new Date();
        }
    }

    /**
     * 计算积分过期时间
     *
     * @param receiveTime 积分获取时间
     * @return 积分过期时间
     */
    public Date calcPointExpireTime(Date receiveTime) {
        return new Date();
    }

}
