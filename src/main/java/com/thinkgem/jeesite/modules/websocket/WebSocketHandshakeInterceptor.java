package com.thinkgem.jeesite.modules.websocket;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**WebSocket握手拦截器 
 *@author luanyu
 *@date 2018年3月27日
 */
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {
	private final static Logger LOGGER = LoggerFactory.getLogger(WebSocketHandshakeInterceptor.class);

	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Map<String, Object> attributes) throws Exception {
		if (request instanceof ServletServerHttpRequest) {
			ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
			HttpSession session = servletRequest.getServletRequest().getSession(false);
			if (session != null) {
				//使用userName区分WebSocketHandler，以便定向发送消息  
				String userName = (String) session.getAttribute("SESSION_USERNAME");
				if (userName == null) {
					userName = "system-" + session.getId();
				}
				attributes.put("WEBSOCKET_USERNAME", userName);
			}
		}
		return true;
	}

	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		System.out.println("After Handshake");

	}


}
