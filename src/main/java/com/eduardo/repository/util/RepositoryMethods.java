package com.eduardo.repository.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.eduardo.model.Mappifier;
import com.eduardo.model.User;
import com.eduardo.repository.Repository;
import com.eduardo.repository.UserRepository;
import com.eduardo.repository.db.GenericDB;
import com.eduardo.repository.db.PostgreDB;

public class RepositoryMethods {

	@SuppressWarnings("unchecked")
	public static <T extends Mappifier> Repository<T> getRepository(HttpServletRequest request, ServletContext ctx) {
		Repository<User> repo; 
		
		if (request.getSession().getAttribute("repository") == null) {
			String connection = ctx.getInitParameter("dbconnection");
			String user = ctx.getInitParameter("username");
			String password = ctx.getInitParameter("password");
			
			GenericDB db = PostgreDB.getInstance(connection, user, password);
			repo = UserRepository.getInstance(db);
			
			request.getSession().setAttribute("repository", repo);
			return (Repository<T>) repo;
		}
		
		return (Repository<T>) request.getSession().getAttribute("repository");
	}
}
