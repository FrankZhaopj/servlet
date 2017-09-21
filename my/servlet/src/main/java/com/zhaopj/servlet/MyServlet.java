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
 * 一两种方式配置servlet
 * 	使用注解方式配置servlet mapping（/MyServlet/annotation）
 * 	使用配置方式配置servlet mapping（/MyServlet/web）
 * 	使用配置方式配置servlet mapping（/MyServlet/web2）
 * 结论:
 * 	同一个servlet可以配置不同的mapping
 * mapping配置说明
 * 	以/开始并且以 /* 结束的字符串用来映射路径(<url-pattern>/admin/*</url-pattern>)
 * 		如果没有精确匹配，那么对/admin/路径下的资源的所有请求将由映射了上述URL样式的Servlet来处理
 * 	以 *. 为前缀的字符串用来映射扩展名(<url-pattern>*.do</url-pattern>)
 * 		如果没有精确匹配和路径匹配，那么对具有.do扩展名的资源的请求将由映射了上述URL样式的Servlet来处理
 * 	以一个单独的/指示这个Web应用程序默认的Servlet(<url-pattern>/</url-pattern>)
 * 		如果对某个请求没有找到匹配的Servlet，那么将使用Web应用程序的默认Servlet来处理
 * 	所有其他的字符被用于精确匹配(<url-pattern>/login</url-pattern>)
 * 		如果请求/login，那么将由映射了URL样式/login的Servlet来处理
 * 结论：
 * 	精确路径匹配优先于任何匹配
 * 	最长路径匹配优先于模糊匹配
 */
@WebServlet("/MyServlet/annotation")
public class MyServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("my first servlet ... ");
		resp.getWriter().write("my servlet is create success ... ");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
	
}
