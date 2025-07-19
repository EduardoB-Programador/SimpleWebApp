<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@page import = "static com.eduardo.util.StandardTags.*" %>
		<%= HEAD_TAGS()%>
		<link rel="stylesheet" href="./styles/login.css"/>
		<title>Log in</title>
	</head>
	<body>
		<%= LOGIN_CONTAINER("Log In", "GET", "auth", null) %>
	</body>
</html>