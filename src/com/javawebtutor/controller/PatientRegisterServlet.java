package com.javawebtutor.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javawebtutor.model.Admin;
import com.javawebtutor.model.DoctorUser;
import com.javawebtutor.model.User;
import com.javawebtutor.service.DoctorRegisterService;
import com.javawebtutor.service.PatientRegistrationService;
import com.javawebtutor.service.RegisterService;


public class PatientRegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	 response.setContentType("text/html;charset=UTF-8");
	 PrintWriter out = response.getWriter();
	 
	 String name = request.getParameter("name");
	 int age=Integer.parseInt(request.getParameter("age"));
	 int weight=Integer.parseInt(request.getParameter("weight"));
	 
	 String height = request.getParameter("height");
	 
	 String disease= request.getParameter("disease");

	 String doctorname = request.getParameter("doctorname");
	 String doctorspecialization = request.getParameter("doctorspecialization");
			 String tablets = request.getParameter("tablets");
	 Float fees=Float.parseFloat(request.getParameter("fees"));
	 
	 
	 
	Admin user = new Admin( name, age, weight,
			height, tablets, disease,
			  doctorname, doctorspecialization,
			fees);
	
	
	
	 try {	
		 PatientRegistrationService registerService = new PatientRegistrationService();
		 boolean result = registerService.register(user);		
		 out.println("<html>");
		 out.println("<head>");		
		 out.println("<title>Patient Registered</title>");		
		 out.println("</head>");
		 out.println("<body>");
		 out.println("<center>");
		 if(result){
			 out.println("<h1>Patient registered sucessfully :)</h1>");
			 out.println("To add another patient<a href=AddPatientDetails.jsp>Click here</a>");
		 }else{
			 out.println("<h1>  Patient Enrollment Failed</h1>");
			 out.println("To try again<a href=AddPatientDetails.jsp>Click here</a>");
		 }
		 out.println("</center>");
		 out.println("</body>");
		 out.println("</html>");
	 
	 } finally {		
		 out.close();
	 }
	}
}



