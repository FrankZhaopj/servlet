package com.zhaopj.servlet;

import java.io.IOException;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用注解方式创建servlet
 * 通过重定向实现跳转
 * 	重定向：
 * 		概念：浏览器向某组件发出请求信息，组件向浏览器发回一个重定向响应信息，该响应信息不包含具体的数据内容，
 * 			只是在响应头信息中包含了需要重定向到的地址信息，该地址可以是任何有效的URL。
 * 			浏览器收到该重定向响应后会自动的向响应信息头中所指示的地址发出请求。
 * 			整个重定向的过程涉及两次“请求-响应”.
 * 		重定向响应格式：
 * 			HTTP/1.1 302 Moved Temporarily
 * 			Server: Apache-Coyote/1.1
 * 			Location:http://192.168.5.100:8080/tst/jsp/somewhere.jsp
 * 			Content-Length: 0
 * 			Date: Mon, 30 Jun 2008 03:52:54 GMT
 * 		
 * 转发与重定向区别：转发是服务器行为，重定向是客户端行为
 */
@WebServlet("/MyServlet_2")
public class MyServlet_2 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet redirect");
		Cookie cookie = new Cookie("password", "123456");
		resp.addCookie(cookie);
		//重定向，由response给浏览器返回302，在由浏览器重新发送请求
		resp.sendRedirect("index.jsp");
	}
	
}
