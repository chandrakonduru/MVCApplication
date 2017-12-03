package com.javawebtutor.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebtutor.model.DoctorUser;
import com.javawebtutor.model.User;
import com.javawebtutor.service.DoctorLoginService;
import com.javawebtutor.service.LoginService;


public class DoctorLoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
	 String userId = request.getParameter("username");	
	 String password = request.getParameter("password");
	DoctorLoginService loginService = new DoctorLoginService();
	 boolean result = loginService.authenticateUser(userId, password);
	 DoctorUser user = loginService.getUserByUserId(userId);
	
	 if(result == true){
		 request.getSession().setAttribute("doctoruser", user);		
		 response.sendRedirect("Doctor_Page.jsp");
	 }
	 else{
		 response.sendRedirect("error.jsp");
	 }
}

}

