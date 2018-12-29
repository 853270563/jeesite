/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test2.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test2.entity.Test2;

/**
 * 测试2DAO接口
 * @author luanyu
 * @version 2017-10-12
 */
@MyBatisDao
public interface Test2Dao extends CrudDao<Test2> {
	
}