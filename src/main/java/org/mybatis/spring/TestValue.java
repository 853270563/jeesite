package org.mybatis.spring;

import org.springframework.beans.factory.annotation.Value;

/**
 *@author luanyu
 *@date 2017年11月10日
 */
public abstract class TestValue {
	@Value("${jdbc.driver}") // 需要被spring管理的类才能注入值
	private String test;
	@Value("${jdbc.driver}") // 需要被spring管理的类才能注入值
	private String test2;
	public String getTest() {
		return test;
	}
}
