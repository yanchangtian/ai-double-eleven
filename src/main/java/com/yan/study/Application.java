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
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
@MapperScan("com.yan.study.biz.dao")
@ImportResource
public class Application {

	//public static void main(String[] args) {
		//ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
		//UserPointBizManager bean = run.getBean(UserPointBizManager.class);
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

		//BaseResult<Void> result = bean.unfreezePoint("12345", "FISH", "e395747257fa4a52a9980e354c3f8243");
		//System.out.println(result);

	//}

	public static class Node {
		Integer value;
		Node next;
		public Node(Integer value) {
			this.value = value;
		}
	}

	public static Node process(Node head) {
		Node pre = null;
		Node cur = head;
		Node nex = head.next;

		while (nex != null) {
			cur.next = pre;

			pre = cur;
			cur = nex;
			nex = cur.next;
		}
		cur.next = pre;

		return cur;

	}

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;

		print(n1);
		System.out.println();
		Node process = process(n1);
		print(process);

	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.value + " -> ");
			head = head.next;
		}
	}

}
