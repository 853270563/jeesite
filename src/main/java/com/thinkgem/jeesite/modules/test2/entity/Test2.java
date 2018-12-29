/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test2.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 测试2Entity
 * @author luanyu
 * @version 2017-10-12
 */
public class Test2 extends DataEntity<Test2> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String age;		// age
	
	public Test2() {
		super();
	}

	public Test2(String id){
		super(id);
	}

	@Length(min=0, max=255, message="name长度必须介于 0 和 255 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=11, message="age长度必须介于 0 和 11 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}