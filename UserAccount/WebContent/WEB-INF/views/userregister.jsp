<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/registerstyle.css"%></style>
<title>Registration</title>
</head>
<body>
	<div align = "center">
		<h1>Create an Account</h1>
		
		<form action="<%= request.getContextPath() %>/register" method="post">
			<div class="error">${errorMessage}</div>
			<br>
			<table style="text-align: center">
				<tr>
					<td>First Name </td>
					<td><input type="text" name="firstname" required
					pattern="[A-Z][a-z]{1,30}|[A-Z][a-z]{1,30}[ ][A-Z][a-z]{1,30}|[A-Z][a-z]{0,30}[ ]['][A-Z]{0,1}[a-z]{1,30}|[A-Z][a-z]{1,30}[-][A-Z][a-z]{1,30}"
					title="Must contain at least two letters and be a valid first name"/></td>
				</tr>
				<tr>
					<td>Last Name </td>
					<td><input type="text" name="lastname" required 
					pattern="[A-Z][a-z]{1,30}|[d]{0,1}[O]{0,1}['][A-Z][a-z]{1,30}|[A-Z][a-z]{1,30}[-][A-Z][a-z]{1,30}"
					title="Must contain at least two letters and be a valid last name"/></td>
				</tr>
				<tr>
					<td>Username </td>
					<td><input type="text" name="username" required/></td>
				</tr>
				<tr>
					<td>Password </td>
					<td><input type="password" name="password" required 
					pattern="(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}" 
					title="Must contain at least one number, one uppercase, one lowercase letter, and at least 8 or more characters"/></td>
				</tr>
				<tr>
					<td>Email </td>
					<td><input type="text" name="email" required 
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register"/></td>
				</tr>
				<tr>
					<td></td>
					<td><p>Already have an account?</p><a href="login">Login here</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
