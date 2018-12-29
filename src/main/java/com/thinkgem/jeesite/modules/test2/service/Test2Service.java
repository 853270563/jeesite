/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test2.entity.Test2;
import com.thinkgem.jeesite.modules.test2.dao.Test2Dao;

/**
 * 测试2Service
 * @author luanyu
 * @version 2017-10-12
 */
@Service
@Transactional(readOnly = true)
public class Test2Service extends CrudService<Test2Dao, Test2> {

	public Test2 get(String id) {
		return super.get(id);
	}
	
	public List<Test2> findList(Test2 test2) {
		return super.findList(test2);
	}
	
	public Page<Test2> findPage(Page<Test2> page, Test2 test2) {
		return super.findPage(page, test2);
	}
	
	@Transactional(readOnly = false)
	public void save(Test2 test2) {
		super.save(test2);
	}
	
	@Transactional(readOnly = false)
	public void delete(Test2 test2) {
		super.delete(test2);
	}
	
}