package com.eduardo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eduardo.model.User;
import com.eduardo.repository.Repository;
import com.eduardo.repository.UserRepository;
import com.sun.net.httpserver.Request;

public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		Repository<User> repo = UserRepository.getInstance(null);
		try {
			
		} catch (RuntimeException e) {
			
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
		} catch (RuntimeException e) {
			
		}
	}
}
