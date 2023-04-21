<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Login page</title>

</head>
<body>
	<h2>Login here....</h2>
	
	<div>
		<%
			// it shows the error on the web page
			if(request.getAttribute("error")!=null){
				out.println(request.getAttribute("error"));
			}
		%>
	</div>
	
	<form action="verifyLogin" method="post">
	<!-- 
		it call LoginController.java OR @WebServlet("/verifyLogin")
	 -->
	
		Username : <input type="text" name="email" />
		Password : <input type="password" name="password" />
		
		<input type="submit" value="login">
		<!-- "login" button -->
		
	</form>
</body>
</html>
