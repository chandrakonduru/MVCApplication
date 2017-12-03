package com.javawebtutor.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebtutor.model.AdminUser;
import com.javawebtutor.model.User;
import com.javawebtutor.service.AdminLoginService;
import com.javawebtutor.service.LoginService;


public class AdminLoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

	 String userId = request.getParameter("username");	
	 String password = request.getParameter("password");
	AdminLoginService loginService = new AdminLoginService();
	 boolean result = loginService.authenticateUser(userId, password);
	 AdminUser user = loginService.getUserByUserId(userId);
	 if(result == true){
		 request.getSession().setAttribute("user", user);		
		 response.sendRedirect("Admin_Page.jsp");
	 }
	 else{
		 response.sendRedirect("error.jsp");
	 }
	}
	 public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 String userId = request.getParameter("username");	
		 String password = request.getParameter("password");
		AdminLoginService loginService = new AdminLoginService();
		 boolean result = loginService.authenticateUser(userId, password);
		 AdminUser user = loginService.getUserByUserId(userId);
		 if(result == true){
			 request.getSession().setAttribute("adminuser", user);		
			 response.sendRedirect("home.jsp");
		 }
		 else{
			 response.sendRedirect("error.jsp");
		 }
}

}

