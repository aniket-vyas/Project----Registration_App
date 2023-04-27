<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="menu.jsp" %> <!-- it will include all members of "menu.jsp" -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Update</title>

</head>
<body>
	<h2>Update Registration...</h2>
	
	<form action="update" method="post">
	<!-- 
		it call UpdateController.java OR @WebServlet("/update")
	 -->
		<pre>
			Which email data you want to update :
			<input type="text" name="email" value="<%=request.getAttribute("email") %>" />
		
			Enter new mobile no. :
			<input type="text" name="mobile" value="<%=request.getAttribute("mobile") %>" />
		
			<input type="submit" value="update" />
		</pre>
	</form>
	
	<%
			// it shows the msg on the web page when you click on update button
			if(request.getAttribute("msg")!=null){
				out.println(request.getAttribute("msg"));
			}
	%>
</body>
</html>
