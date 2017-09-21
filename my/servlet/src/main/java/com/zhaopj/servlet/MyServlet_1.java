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
 * 通过转发实现跳转
 * 	转发：
 * 		request.getRequestDispatcher("/MyServlet_2").forward(request, response);
 * 		RequestDispatcher对象封装了转发操作
 * 			获取方式：
 * 				1.通过HttpServletRequest的getRequestDispatcher()方法获得
 * 				2.通过ServletContext的getRequestDispatcher()方法获得
 * 		特点：
 * 			转发前request范围中存放的变量不会失效
 * 			浏览器URL的地址栏不发生改变
 * 			转发只能在同一个应用的组件之间进行，不可以转发给其他应用的地址
 * 			在一个组件转发给另外一个组件之前，通过response输出的响应内容是没有意义的
 * 				转发之前的通过out对象输出的内容最终不会输出到浏览器，这是由于RequestDispatcher在转发之前清空了输出缓冲区
 * 				但如果在转发之前输出的信息超出了缓冲区，或者调用了out对象的flush()方法，此响应内容已经输出到了客户端(称之为响应信息已提交)，此时如果实施转发操作会抛出运行时异常：java.lang.IllegalStateException
 * 
 * 
 * 转发与重定向区别：
 * 	转发
 * 		是服务器行为
 * 		浏览器URL的地址栏不变
 * 		整个过程一次请求，一次响应
 * 		只能将请求转发给同一Web应用的组件
 * 	重定向：
 * 		是客户端行为
 * 		浏览器URL的地址栏改变
 * 		整个过程两次请求，两次响应
 * 		sendRedirect()方法不但可以在位于同一个主机上的不同Web应用程序之间进行重定向，而且可以将客户端重定向到其他服务器上的Web应用程序资源
 */
@WebServlet("/MyServlet_1")
public class MyServlet_1 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet forward");
		Cookie cookie = new Cookie("username", "zhaopj");
		resp.addCookie(cookie);
		//resp.sendRedirect("index.jsp");
		//转发（在servlet容器内进行跳转，因此浏览器地址栏不发生变化）
		req.getRequestDispatcher("/MyServlet_2").forward(req, resp);
	}
	
}
