package com.eduardo.servlet;

import static com.eduardo.model.util.ModelMethods.*;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardo.model.SimpleUser;
import com.eduardo.repository.Repository;
import static com.eduardo.repository.util.RepositoryMethods.*;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Repository<SimpleUser> repo = getRepository(request, getServletContext());
		
		try {
			SimpleUser u = createSimpleUser(request);
			System.out.println("passou da criação de usuário");
			
			repo.add(u);
		} catch (RuntimeException e) {e.printStackTrace();}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
