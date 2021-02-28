package com.yan.study.biz.common;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserPointRedisClient {

    private final Map<String, String> localRedis = new HashMap<>();

    @PostConstruct
    public void initLocalRedis() {
        localRedis.put("11111", "11111");
    }

    public boolean preGivePointIdem(String idempotentId) {
        return localRedis.containsKey(idempotentId);
    }

}
