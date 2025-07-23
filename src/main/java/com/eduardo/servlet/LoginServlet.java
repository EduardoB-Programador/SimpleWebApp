package com.eduardo.servlet;

import static com.eduardo.model.util.ModelMethods.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardo.model.User;
import com.eduardo.repository.Repository;
import com.eduardo.repository.util.RepositoryMethods;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			Repository<User> repo = RepositoryMethods.getRepository(request, getServletContext());
		} catch (Exception e) {System.out.println(e);}
		
		User u = createUser(request);
		//repo.add(u);
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			Repository<User> repo = RepositoryMethods.getRepository(request, getServletContext());
		} catch (Exception e) {System.out.println(e);}
		
		
		try {
			
		} catch (RuntimeException e) {
			
		}
	}
}
