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

import com.eduardo.model.SimpleItem;

import static com.eduardo.model.util.ModelMethods.*;

@WebFilter("/item")
public class ValidItemFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;


	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		
		try {
			SimpleItem item = createSimpleItem(httpReq);
			assert item != null;
			chain.doFilter(request, response);
			return ;
		} catch (RuntimeException | AssertionError ignore) {}
		httpReq.getSession().setAttribute("message", "<p color=\"red\">Invalid item values.</p>");
		httpRes.sendRedirect("./home.jsp");
	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
