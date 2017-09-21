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
 * servlet 生命周期
 * 	当多次访问时，servlet构造函数只被执行一次，说明servlet是单例
 * 生命周期：
 * 	1.tomcat加载web.xml
 * 	2.请求如果匹配mapping,会找到servlet配置
 * 	3.读取servlet配置，解析servlet-class（通过java反射机制调用class.from() clazz.newInstance()创建servlet对象）
 * 	4.首先执行servelet构造函数
 * 	5.执行init初始化servlet
 *  6.先走父类service()方法判断请求是get还是post，并调用对应的doGet()或doPost()
 *  	如果重写了service方法，则要调用父类的service()
 *  7.服务器停止时调用destroy()
 */
@WebServlet("/MyServlet_3")
public class MyServlet_3 extends HttpServlet {
	
	public MyServlet_3() {
		System.out.println("servlet constructor ");
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("servlet init ");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		super.service(arg0, arg1);
		System.out.println("servlet service ");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("servlet doPost");
	}
	
	@Override
	public void destroy() {
		System.out.println("servlet destroy");
	}
	
}
