package com.thinkgem.jeesite.modules.websocket;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;

import com.thinkgem.jeesite.common.utils.SpringContextHolder;

/**
 *@author luanyu
 *@date 2018年3月27日
 */
//@Controller
@RequestMapping(value = "/websocket")
public class PageController {
	@Bean //这个注解会从Spring容器拿出Bean  
	public WebSocketHandler infoHandler() {
		return new WebSocketHandler();
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String username = request.getParameter("username");
		WebSocketConfig bean = SpringContextHolder.getBean(WebSocketConfig.class);
		System.out.println(bean);
		System.out.println(username + "登录");
		HttpSession session = request.getSession();
		session.setAttribute("SESSION_USERNAME", username);
		return "websocket";
	}

	@RequestMapping("/loginJsp")
	public String loginJsp(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return "login";
	}

	@RequestMapping("/send")
	@ResponseBody
	public String send(HttpServletRequest request) {
		String username = request.getParameter("username");
		infoHandler().sendMessageToUser(username, new TextMessage("你好，欢迎测试！！！！"));
		return null;
	}
}
