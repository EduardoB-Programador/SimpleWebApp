package com.eduardo.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardo.model.SimpleItem;
import com.eduardo.model.SimpleUser;

import static com.eduardo.model.util.ModelMethods.*;

import java.io.IOException;

public class ItemServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SimpleItem item = createSimpleItem(request);
		SimpleUser user = (SimpleUser) request.getSession().getAttribute("currentUser");
		
		System.out.println(item.toMap());
		System.out.println(user.toMap());
		
		RuntimeDB db = RuntimeDB.getInstance();
		db.removeItem(user, item);
		
		System.out.println(user.toMap());
		
		request.getSession().setAttribute("currentUser", user);
		response.sendRedirect("./home.jsp");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SimpleItem item = createSimpleItem(request);
		SimpleUser user = (SimpleUser) request.getSession().getAttribute("currentUser");
		
		System.out.println(item.toMap());
		System.out.println(user.toMap());
		
		RuntimeDB db = RuntimeDB.getInstance();
		db.addItem(user, item);
		
		System.out.println(user.toMap());
		
		request.getSession().setAttribute("currentUser", user);
		response.sendRedirect("./home.jsp");
		
	}

}
