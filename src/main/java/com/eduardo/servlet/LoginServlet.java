package com.eduardo.servlet;

import static com.eduardo.model.util.ModelMethods.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardo.model.SimpleUser;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		RuntimeDB db = RuntimeDB.getInstance();
		SimpleUser user = createSimpleUser(request);
		db.addUser(user);

		response.sendRedirect("./login.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RuntimeDB db = RuntimeDB.getInstance();
		SimpleUser user = createSimpleUser(request);
		
		if (db.userExists(user) >= 0) {
			request.getSession().setAttribute("currentUser", user);
			response.sendRedirect("./home.jsp");
			return ;
		}
		
		request.getSession().setAttribute("message", "<p color=\"red\">Incorrect credentials, check if the password or email are correct.</p>");
		response.sendRedirect("./login.jsp");
		
			
	}
}
