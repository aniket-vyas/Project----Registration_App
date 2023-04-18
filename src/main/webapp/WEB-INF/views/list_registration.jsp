<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ include file="menu.jsp" %> <!-- it will include all members of "menu.jsp" -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>all registration</title>

</head>
<body>
	<h2>All Registrations...</h2>
	
	<!-- it will display the all data on webpage -->
	<table border='1'>
	
		<tr>
			<th>Name</th>
			<th>City</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		
		<%
			//return type of request.getAttribute is object we convert into result set
			ResultSet result = (ResultSet)request.getAttribute("result");
			while(result.next()){ 
		%>
		
			<tr>
				<td><%=result.getString(1) %></td>
				<td><%=result.getString(2) %></td>
				<td><%=result.getString(3) %></td>
				<td><%=result.getString(4) %></td>
				<td><a href="delete?email=<%=result.getString(3)%>">delete</a></td>
				<!-- 
					when click on delete link & it will call post method of DeleteController.java
				-->
				<td><a href="update?email=<%=result.getString(3)%>&mobile=<%=result.getString(4)%>">update</a></td>
				<!-- 
					when click on update link & it will call post method of UpdateController.java
				-->
			</tr>
			
		<%}%>
		
	</table>
</body>
</html>
