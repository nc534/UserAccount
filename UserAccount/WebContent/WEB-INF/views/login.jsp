<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/loginstyle.css"%></style>
<title>Welcome</title>
</head>
<body>
	<div align = "center">
		<h1>Welcome!</h1>
		
		<form action="<%= request.getContextPath() %>/login" method="post">
			<div class="error">${errorMessage}</div>
			<div class="message">${Message}</div>
			<br>
			<table style="text-align: center">
				<tr>
					<td><input type="text" name="username" placeholder="username"/></td>
				</tr>
				<tr>
					<td><input type="password" name="password" placeholder="password"/></td>
				</tr>
				<tr>
					<td><input type="submit" value="LOGIN"/></td>
				</tr>
				<tr>
					<td><p>Don't have an account? </p><a href="register">Register here</a></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
