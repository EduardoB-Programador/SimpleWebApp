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
		
		try {
			SimpleUser user = createSimpleUser(request);
			db.addUser(user);
		} catch (Exception e) {
			request.getSession().setAttribute("message", "<p color=\"red\">Invalid email credentials.</p>");
			response.sendRedirect("./signin.jsp");
			return ;
		}

		response.sendRedirect("./login.jsp");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		RuntimeDB db = RuntimeDB.getInstance();
		SimpleUser user;
		try {
			user = createSimpleUser(request);
		} catch (RuntimeException e) {
			request.getSession().setAttribute("message", "<p color=\"red\">Incorrect credentials, check if the password or email are correct.</p>");
			response.sendRedirect("./login.jsp");
			return ;
		}
		
		if (db.userExists(user) >= 0) {
			request.setAttribute("email", user.getEmail().toString());
			request.setAttribute("password", user.getPassword().toString());
			request.setAttribute("items", user.getItems());
			request.getRequestDispatcher("./home.jsp").forward(request, response);
			return ;
		}
		
		request.getSession().setAttribute("message", "<p color=\"red\">Incorrect credentials, check if the password or email are correct.</p>");
		response.sendRedirect("./login.jsp");
		
			
	}
}
