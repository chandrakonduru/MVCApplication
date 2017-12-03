<%@page import="java.util.List"%>
<%@page import="com.javawebtutor.service.AdminLoginService"%>
<%@page import="com.javawebtutor.service.PatientRegistrationService"%>
<%@page import="java.util.Date"%>
<%@page import="com.javawebtutor.model.User"%>
<%@page import="com.javawebtutor.model.Admin"%>
<%@page import="com.javawebtutor.model.AdminUser"%>
<%@page import="com.javawebtutor.model.DoctorUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <link rel="stylesheet" type="text/css" href="css/style.css"/>
	 <title>Result Page</title>	
</head>
<body>
<center>
	 <div id="container">
		 <h1>Result Page</h1>
			 <b>This is Sample Result Page</b><br/>
			 <%=new Date()%></br>
			 <%
				 Admin user = (Admin)session.getAttribute("adminuser");
			     DoctorUser user1=(DoctorUser)session.getAttribute("doctoruser");
			 %>		
				
			 <br/>
			 

		 <table>
			 <thead>
				 <tr>
					 <th>Patient ID</th>
					 <th>Patient Name</th>
					 <th>Doctor Name</th>
						
				 </tr>
			 </thead>
			 <tbody>
				 <%
				 PatientRegistrationService loginService = new PatientRegistrationService();
					 List<Admin> list = loginService.getListOfUsers();
					 for (Admin u : list) {
				 %>
				 <tr>
					 <td><%=u.getId()%></td>
					 <td><%=u.getP_name()%></td>
					 <td><%=u.getD_name()%></td>
					 
				 </tr>
				 <%}%>
			 <tbody>
		 </table>		
		 <br/>
	 </div>
	</center>	
</body>
</html>