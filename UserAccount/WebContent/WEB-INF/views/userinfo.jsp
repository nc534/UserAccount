<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style><%@include file="/WEB-INF/css/userstyle.css"%></style>
<title>Account</title>
</head>
<header></header>
<body>
	
	<h1>Welcome ${user}!</h1>
	
	<!-- Logout button -->
	<form action="logout" style="text-align: center">
    	<input type="submit" value="Logout" />
	</form>
</body>
<footer></footer>
</html>