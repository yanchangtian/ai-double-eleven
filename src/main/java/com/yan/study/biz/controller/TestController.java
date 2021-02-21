package com.yan.study.biz.controller;

import com.yan.study.biz.common.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/test")
public class TestController {

    @RequestMapping("/01")
    public BaseResult<String> test01() {
        try {

            return BaseResult.success(null);
        } catch (Exception e) {
            return BaseResult.fail("失败");
        }
    }

}
