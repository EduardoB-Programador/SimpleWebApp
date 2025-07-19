package com.eduardo.repository;

import java.util.ArrayList;
import java.util.List;

import com.eduardo.model.User;
import com.eduardo.repository.db.GenericDB;

@SuppressWarnings("all")
public class Repository {
	private static Repository repo = null;
	private List<User> data;
	private GenericDB db;
	
	public static Repository getInstance(GenericDB db) {
		if (repo == null)
			repo = new Repository(db);
		return repo;
	}
	
	private Repository(GenericDB db) {
		this.data = new ArrayList<>();
		this.db = db;
	}
	
	public void add(User value) {
		
	}
	
	public void delete(User value) {
		
	}
	
}
