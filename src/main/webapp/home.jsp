<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import = "static com.eduardo.util.StandardTags.*" %>
<%@page import = "static com.eduardo.model.util.ModelMethods.*" %>
<%@page import = "com.eduardo.model.SimpleUser" %>
<%@page import = "com.eduardo.servlet.RuntimeDB" %>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html>
<html>
	<head>
		<%= HEAD_TAGS()%>
		<%
		SimpleUser user = (SimpleUser) request.getSession().getAttribute("currentUser");
		request.setAttribute("email", user.getEmail().toString());
		request.setAttribute("items", user.getItems());
		String message = (String) request.getSession().getAttribute("message");
		%>
		<link rel="stylesheet" href="./styles/home.css"/>
		<title>Home</title>
	</head>
	<body>
		<h1><c:out value="Welcome ${email}" /></h1>
		<div class="box">
			<c:forEach items="${items}" var="item">
				<div class="item">
					<div class="item-attribute">${item.name}</div>
					<div class="item-attribute">${item.value}</div>
					<form action="itemManager" method="DELETE">
						<input type="submit" class="submit" value="Delete" name="${item}" />
					</form>
				</div>
			</c:forEach>
		</div>
		<div id="put-items">
			<h1>Create your Items!</h1>
			<form action="./item" method="POST">
				<label>Item name</label><br/>
				<input placeholder="name" type="text" class="inputs" name="name"/><br/>
				<label>Item value</label><br/>
				<input placeholder="value" type="text" class="inputs" name="value"/>
				<input type="submit" value="Add" class="submit"/>
				<%
					if (message != null)
						out.println(message);
					request.getSession().removeAttribute("message");
				%>
			</form>
		</div>
	</body>
</html>