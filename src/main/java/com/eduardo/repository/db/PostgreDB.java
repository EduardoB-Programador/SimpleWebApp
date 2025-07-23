package com.eduardo.repository.db;

import java.util.List;

import java.sql.*;

import org.postgresql.*;

public class PostgreDB extends GenericDB {
	private static PostgreDB psql = null;
	private String url;
	private String username;
	private Connection con;
	
	private PostgreDB(String url, String username, String password){
		try {
			Class.forName("org.postgresql.Driver");
			
			if (!(url == null || username == null || password == null)) {
				con = DriverManager.getConnection(url, username, password);
				this.url = url;
				this.username = username;
			}
				
		} catch (Exception e) {
			throw new RuntimeException("Couldn't either load class or establish connection.");
		}
	}
	
	
	public static PostgreDB getInstance(String url, String username, String password) {
		if (psql == null)
			psql = new PostgreDB(url, username, password);
		
		if (!(psql.url.equals(url)) || !(psql.username.equals(username)))
			psql = new PostgreDB(url, username, password);
		
		return psql;
	}
	

	@Override
	public boolean create(Object values) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Object> read(Object condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Object condition, Object values) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object condition) {
		// TODO Auto-generated method stub
		return false;
	}

}
