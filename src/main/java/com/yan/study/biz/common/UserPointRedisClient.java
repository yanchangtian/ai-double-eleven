package com.yan.study.biz.common;

import org.springframework.stereotype.Service;

@Service
public class UserPointRedisClient {

    public boolean preGivePointIdem(String idempotentId) {
        String key = "";
        return false;
    }

}
