<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@page import = "static com.eduardo.util.StandardTags.*" %>
		<%= HEAD_TAGS()%>
		<link rel="stylesheet" href="./styles/login.css"/>
		<title>Sign in</title>
	</head>
	<body>
		<%= LOGIN_CONTAINER("Sign In", "POST", "register", (String) request.getSession().getAttribute("message")) %>
		<%  request.getSession().removeAttribute("message"); %>
	</body>
</html>