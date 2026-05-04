<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
		<%
			String msg =(String)request.getAttribute("msg");
				if(msg!=null){
					out.print(msg);
				}
			%>
	
		<form action="user" method="post">
		<table>
		
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"></td>
			</tr>
			
			<tr>
				<td>Phono:</td>
				<td><input type="number" name="phno"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Save"></td>
			</tr>
		
			</table>
		</form>
		
		<a href ="user">View Users</a>
	
</body>
</html>