<%@page import="java.util.List"%>
<%@page import="com.javawebtutor.service.LoginService"%>
<%@page import="java.util.Date"%>
<%@page import="com.javawebtutor.model.AdminUser"%>
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
				 AdminUser user = (AdminUser) session.getAttribute("user");
			 %>		
			 <b>Welcome </b>		
			 <br/>
			 <a href="logout.jsp">Logout</a>
		 </p>

		 <table>
			 <thead>
				 <tr>
					 <th>User ID</th>
					 <th>First Name</th>
					 <th>Middle Name</th>
					 <th>Last Name</th>
					 <th>email</th>					
				 </tr>
			 </thead>
			 
		 <br/>
	 </div>
	</center>	
</body>
</html>
