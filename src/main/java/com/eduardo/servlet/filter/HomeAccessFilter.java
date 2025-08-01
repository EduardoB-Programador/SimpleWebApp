package com.eduardo.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardo.model.SimpleUser;

import com.eduardo.servlet.RuntimeDB;

@WebFilter("/home.jsp")
public class HomeAccessFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	//For some reason this is not executing
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		try {
			SimpleUser user = (SimpleUser) httpRequest.getSession().getAttribute("currentUser");
			RuntimeDB db = RuntimeDB.getInstance();
			if (db.userExists(user) >= 0) {
				chain.doFilter(request, response);
				return ;
			}
		} catch (NullPointerException e) {}
		httpResponse.sendRedirect("./login.jsp");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
