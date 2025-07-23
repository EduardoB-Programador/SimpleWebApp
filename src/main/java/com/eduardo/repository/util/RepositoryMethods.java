package com.eduardo.repository.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.eduardo.model.Mappifier;
import com.eduardo.model.User;
import com.eduardo.repository.Repository;
import com.eduardo.repository.UserRepository;
import com.eduardo.repository.db.GenericDB;

public class RepositoryMethods {

	@SuppressWarnings("unchecked")
	public static <T extends Mappifier> Repository<T> getRepository(HttpServletRequest request, ServletContext ctx) {
		Repository<User> repo; 
		
		if (request.getSession().getAttribute("repository") == null) {
			String connection = ctx.getInitParameter("dbconnection");
			String db = ctx.getInitParameter("db");
			String collection = ctx.getInitParameter("collection");
			
			GenericDB mongo = MongoDB.getInstance(connection, db, collection);
			repo = UserRepository.getInstance(mongo);
			
			request.getSession().setAttribute("repository", repo);
			return (Repository<T>) repo;
		}
		
		return (Repository<T>) request.getSession().getAttribute("repository");
	}
}
