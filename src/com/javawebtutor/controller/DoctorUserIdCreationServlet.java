package com.javawebtutor.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebtutor.model.DoctorUser;
import com.javawebtutor.model.User;
import com.javawebtutor.service.DoctorRegisterService;
import com.javawebtutor.service.RegisterService;


public class DoctorUserIdCreationServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 String name = request.getParameter("name");
	 String username = request.getParameter("username");
	 String password = request.getParameter("password");
	 String confirmpassword = request.getParameter("confirmpassword");
	
	DoctorUser user = new DoctorUser(name,username, password);
	if(!(password.equals(confirmpassword)))
	{
		out.println("<h1>Password does not matches</h1>");
		 out.println("To try again<a href=DoctorAccountCreate.jsp>Click here</a>");		
	}
	else
	{
	 try {	
		DoctorRegisterService registerService = new DoctorRegisterService();
		 boolean result = registerService.register(user);		
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Registration Successful</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Thanks for Registering with us :</h1>");
			 out.println("To login with new UserId and Password<a href=EnterDoctorLogin.jsp>Click here</a>");
		 }else{
			 out.println("<h1>User Already Exists Please try with another User Name </h1>");
			 out.println("To try again<a href=DoctorAccountCreate.jsp>Click here</a>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 
	 } finally {		
		 out.close();
	 }
	}
}

}
