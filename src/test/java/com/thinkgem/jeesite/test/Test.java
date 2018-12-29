package com.thinkgem.jeesite.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	protected static final Logger logger = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) {
		// 创建容器对象
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ac.start();
	}
}
