<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>menu</title>

</head>
<body>

	<a href="saveReg">New Registration</a>
	<!-- 
	it will call the get method of NewRegistrationController()
	@WebServlet("/saveReg")
	 -->
	 
	<a href="listAll">All Registration</a>
	<!-- 
	it will call the get method of GetAllRegistrationController()
	@WebServlet("/listAll")
	 -->
	 
	 <form action="logout" method="post">
	 	<input type="submit" value="logout" />
	 	<!-- 
			 it will show logout button
	  	-->
	 </form>
	 
</body>
</html>
