package com.yan.study.biz.manager.point.impl;

import com.yan.study.biz.dao.point.PointConfigDAO;
import com.yan.study.biz.dao.point.entity.PointConfigDO;
import com.yan.study.biz.manager.point.PointConfigManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Component
public class PointConfigManagerImpl implements PointConfigManager {

    @Resource
    private PointConfigDAO pointConfigDAO;

    @Override
    public PointConfigDO getPointConfig(String pointType) {
        return pointConfigDAO.selectByPointType(pointType);
    }

}
