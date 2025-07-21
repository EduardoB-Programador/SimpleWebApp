package com.eduardo.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.eduardo.model.User;
import com.eduardo.repository.db.GenericDB;

@SuppressWarnings("all")
public class UserRepository<T> extends Repository<T> implements Methods<T> {
	
	public static UserRepository<User> getInstance(GenericDB db) {
		if (Repository.repo == null || Repository.repo.db != db)
			Repository.repo = new UserRepository(db);
		return (UserRepository<User>) Repository.repo;
	}
	
	private UserRepository(GenericDB db) {
		super(db);
	}

	@Override
	public void add(T value) {
		try {
			db.create(value);
		} catch (Exception e) {messages.add(MessageTypes.ADD_ERROR_MESSAGE);}
	}

	@Override
	public List<T> fetch(T condition) {
		
		return Methods.listFormatter(db.read(condition));
	}

	@Override
	public void update(String condition, T value) {
		try {
			db.update(condition, value);
		} catch (Exception e) {messages.add(MessageTypes.UPDATE_ERROR_MESSAGE);}
	}

	@Override
	public void delete(String condition) {
		try {
			db.delete(condition);
		} catch (Exception e) {messages.add(MessageTypes.DELETE_ERROR_MESSAGE);}
	}
	
}

interface Methods<T> {
	//TODO: create the method to format the type correctly the fetch
	public static <T> List<T> listFormatter(List<Document> documents) {
		return null;
	}
}
