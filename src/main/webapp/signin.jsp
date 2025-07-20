<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<%@page import = "static com.eduardo.util.StandardTags.*" %>
		<%! String msg = null; %>
		<%= HEAD_TAGS()%>
		<link rel="stylesheet" href="./styles/login.css"/>
		<title>Sign in</title>
	</head>
	<body>
		<%= LOGIN_CONTAINER("Sign In", "POST", "register", msg) %>
	</body>
</html>