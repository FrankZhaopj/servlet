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
 * servlet 是否线程安全
 * 	当多次访问时，servlet构造函数只被执行一次，说明servlet是单例
 * 	既然是单例，就说明servlet线程不安全
 * 	使用同步代码块解决servlet线程不安全的问题
 * 平时还会遇到类似线程不安全的问题：
 * 	1.servlet(线程不安全)
 * 	2.StringBuilder(线程不安全)，Stringbuffer(线程安全)
 * 	3.ArrayList(线程不安全)，Vector(线程安全)
 * 	4.HashMap(线程不安全)，HashTable(线程安全)
 */
@WebServlet("/MyServlet_4")
public class MyServlet_4 extends HttpServlet {
	
	int i;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet doGet");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
//		synchronized (MyServlet_4.class) {
//			try {
//				Thread.sleep(5000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			resp.getWriter().write("当前是第"+i+"次访问。");
//			i++;
//		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.getWriter().write("当前是第"+i+"次访问。");
		i++;
	}

}
