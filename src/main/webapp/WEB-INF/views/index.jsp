<%@page import="org.springframework.web.servlet.config.MvcNamespaceHandler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<title>Librarian Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");
if(session.getAttribute("username")!=null){
   response.sendRedirect("dashboard.jsp");
	
}
%>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #f0f3f5;
}

.login-box {
	width: 360px;
	margin: 60px auto;
	padding: 30px;
	background-color: #fff;
	border-radius: 10px;
	box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
}

h1 {
	margin: 0 0 30px;
	text-align: center;
	font-size: 30px;
	color: #333;
}

label {
	display: block;
	margin-bottom: 8px;
	font-size: 14px;
	font-weight: bold;
	color: #333;
}

input[type="text"], input[type="password"] {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #f7f7f7;
	margin-bottom: 20px;
}

button[type="submit"] {
	display: block;
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 5px;
	background-color: #007bff;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
}

button[type="submit"]:hover {
	background-color: #0069d9;
}
</style>
<body>
	<div class="login-box">
		<h1>Librarian Login</h1>
		<form action="Login" method="POST">
			<label for="username">Username</label> <input type="text"
				id="username" name="username" placeholder="Enter Username">
			<label for="password">Password</label> <input type="password"
				id="password" name="password" placeholder="Enter Password">
			<button type="submit">Login</button>
		</form>
	</div>
</body>
</html>
