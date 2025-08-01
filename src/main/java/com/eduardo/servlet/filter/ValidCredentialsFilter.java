package com.eduardo.servlet.filter;

import static com.eduardo.model.util.ModelMethods.createSimpleUser;

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


@WebFilter(urlPatterns = {"/auth", "/register"})
public class ValidCredentialsFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	public void destroy() {
		
	}

	//for some reason this is not executing
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		try {
			SimpleUser user = createSimpleUser(httpReq);
			assert user != null;
		} catch (Exception | AssertionError e) {
			httpReq.getSession().setAttribute("message", "<p color=\"red\">Invalid credentials.</p>");
			httpRes.sendRedirect(httpReq.getContextPath());
			return ;
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
