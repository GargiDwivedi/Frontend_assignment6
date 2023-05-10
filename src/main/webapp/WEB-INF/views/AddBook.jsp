<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@page import="java.util.*"%>
<%@page import="java.io.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.Gargi.model.Author"%>

<!DOCTYPE html>
<html lang="en">
<head>
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "0");

if (session.getAttribute("username") == null)
	response.sendRedirect("/");
%>
<meta charset="UTF-8">
<title>Add Book Form</title>
<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f2f2f2;
}

form {
	background-color: #fff;
	width: 500px;
	margin: 50px auto;
	padding: 30px;
	box-shadow: 0px 0px 20px #ccc;
}

h1 {
	font-size: 28px;
	text-align: center;
	margin-top: 0;
}

label {
	display: block;
	font-size: 18px;
	margin-bottom: 10px;
	color: #666;
}

input[type="text"], select {
	width: 100%;
	padding: 10px;
	font-size: 16px;
	border: 2px solid #ccc;
	border-radius: 5px;
	margin-bottom: 20px;
}

select {
	height: 40px;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 10px 20px;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	margin-right: 10px;
}

button.cancel {
	background-color: #f44336;
}

button:hover {
	opacity: 0.8;
}

#title {
	text-align: right;
}

#title form {
	display: inline-block;
}

#title b {
	font-size: 18px;
}

@media screen and (max-width: 600px) {
	form {
		width: 90%;
	}

	input[type="text"], select {
		font-size: 14px;
	}

	h1 {
		font-size: 24px;
	}
}
</style>
</head>

<body>
	<div id="title">
		<form action="Logout" method="post">
			Welcome<b> ${username} <input type="submit" value="Logout"></b>
		</form>
	</div>
	<form action="Addbook" method="post">
		<h1>Add Book Form</h1>
		<label for="book-code">Book Code:</label>
		<input type="text" id="bookCode" name="bookCode">
		<label for="book-name">Book Name:</label>
		<input type="text" id="bookName" name="bookName">
		<label for="author">Author:</label>
		<select id="author" name="author">
			<c:forEach items="${Author}" var="Author">
				<option value="${Author.getAuthorid()}">${Author.getAuthorname()}</option>
			</c:forEach>
		</select>
		<label for="AddedOn" class="col-2 mx-4">Added On</label> <input type="text" id="addedOn"
class="col-4" value="${date}" name="addedOn" readonly>

		<div>
			<button type="submit">Save</button>
			<a href="/"><button type="button" class="cancel">Cancel</button></a>
		</div>
	</form>
</body>
<% session.removeAttribute("books"); %>
</html>
