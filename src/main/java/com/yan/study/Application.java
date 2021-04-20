package com.yan.study;

import com.yan.study.biz.common.BaseResult;
import com.yan.study.biz.manager.point.UserPointAccountManager;
import com.yan.study.biz.manager.point.UserPointBizManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("com.yan.study.biz.dao.point")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		UserPointBizManager bean = run.getBean(UserPointBizManager.class);
		BaseResult<String> result = bean.preGivePoint("12345", "FISH", 10L, "12345-child", "init send");
		System.out.println(result);
	}

}
