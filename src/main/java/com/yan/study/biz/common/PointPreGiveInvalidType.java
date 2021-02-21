package com.yan.study.biz.common;

public enum PointPreGiveInvalidType {

    /**
     * 当天领取
     */
    CURRENT_DAY,
    /**
     * 三日内领取
     */
    THREE_DAYS;

    public static PointPreGiveInvalidType findByName(String name) {
        for (PointPreGiveInvalidType value : PointPreGiveInvalidType.values()) {
            if (value.name().equals(name)) {
                return value;
            }
        }
        return null;
    }

}
