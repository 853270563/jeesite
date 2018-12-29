/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test2.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.test2.entity.Test2;
import com.thinkgem.jeesite.modules.test2.service.Test2Service;

/**
 * 测试2Controller
 * @author luanyu
 * @version 2017-10-12
 */
@Controller
@RequestMapping(value = "${adminPath}/test2/test2")
public class Test2Controller extends BaseController {

	@Autowired
	private Test2Service test2Service;
	
	@ModelAttribute
	public Test2 get(@RequestParam(required=false) String id) {
		Test2 entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = test2Service.get(id);
		}
		if (entity == null){
			entity = new Test2();
		}
		return entity;
	}
	
	@RequiresPermissions("test2:test2:view")
	@RequestMapping(value = {"list", ""})
	public String list(Test2 test2, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<Test2> page = test2Service.findPage(new Page<Test2>(request, response), test2); 
		model.addAttribute("page", page);
		return "modules/test2/test2List";
	}

	@RequiresPermissions("test2:test2:view")
	@RequestMapping(value = "form")
	public String form(Test2 test2, Model model) {
		model.addAttribute("test2", test2);
		return "modules/test2/test2Form";
	}

	@RequiresPermissions("test2:test2:edit")
	@RequestMapping(value = "save")
	public String save(Test2 test2, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, test2)){
			return form(test2, model);
		}
		test2Service.save(test2);
		addMessage(redirectAttributes, "保存测试2成功");
		return "redirect:"+Global.getAdminPath()+"/test2/test2/?repage";
	}
	
	@RequiresPermissions("test2:test2:edit")
	@RequestMapping(value = "delete")
	public String delete(Test2 test2, RedirectAttributes redirectAttributes) {
		test2Service.delete(test2);
		addMessage(redirectAttributes, "删除测试2成功");
		return "redirect:"+Global.getAdminPath()+"/test2/test2/?repage";
	}

}