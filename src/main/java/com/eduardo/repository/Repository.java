package com.eduardo.repository;

import java.util.ArrayList;
import java.util.List;

import com.eduardo.repository.db.GenericDB;

public class Repository<T> {
	private List<T> data;
	private GenericDB db;
	
	public Repository(GenericDB db) {
		this.data = new ArrayList<>();
		this.db = db;
	}
	
	public void add(T value) {
		
	}
	
	public void delete(T value) {
		
	}
	
}
