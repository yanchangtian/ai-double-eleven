package com.yan.study;

import com.yan.study.biz.common.BaseResult;
import com.yan.study.biz.manager.point.UserPointAccountManager;
import com.yan.study.biz.manager.point.UserPointBizManager;
import com.yan.study.test.A;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@MapperScan("com.yan.study.biz.dao")
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		UserPointBizManager bean = run.getBean(UserPointBizManager.class);
//		BaseResult<String> result = bean.preGivePoint
//				("12345", "FISH", 10L, "12345-child", "init send");
//		System.out.println(result);
//
//		BaseResult<Void> fish = bean.receivePoint
//				("12345", "FISH", "0f38f03deb78479aadf6db9b1715f718");
//		System.out.println(fish);
//
//		BaseResult<Void> result = bean.givePoint
//				("12345", "FISH", 10L, "12345-child-01", "give points");
//		System.out.println(result);
//
//		BaseResult<String> result = bean.freezePoint
//				("12345", "FISH", 10L, "test-freeze", "test freeze");
//		System.out.println(result);

//		BaseResult<Void> result = bean.consumeFreezePoint("12345", "FISH", "37270c941e764e9da3426c4653fa40e4");
//		System.out.println(result);

		BaseResult<Void> result = bean.unfreezePoint("12345", "FISH", "e395747257fa4a52a9980e354c3f8243");
		System.out.println(result);

	}

}
