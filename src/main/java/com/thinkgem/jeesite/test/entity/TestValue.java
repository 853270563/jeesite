package com.thinkgem.jeesite.test.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 *@author luanyu
 *@date 2017年7月8日
 */
@Controller
public class TestValue {// 需要被spring管理的类才能注入value值
	@Value("${jdbc.driver}")
	private String teString;

	public void test() {
		System.out.println("nsuan");
	}
}
