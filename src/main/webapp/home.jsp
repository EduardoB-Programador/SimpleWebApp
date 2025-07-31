<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<%@page import = "static com.eduardo.util.StandardTags.*" %>
		<%= HEAD_TAGS()%>
		<% 
			if (request.getAttribute("email") == null)
				response.sendRedirect("./login.jsp");
		%>
		<link rel="stylesheet" href="./styles/home.css"/>
		<title>Home</title>
	</head>
	<body>
		<h1>Welcome ${email}</h1>
		<div class="box">
			
		</div>
	</body>
</html>