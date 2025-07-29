package com.eduardo.repository.db;

import java.sql.*;

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
	public boolean create(String table, String tableColumns, String values) {
		
		Run r = (con) -> {
			try {
				Statement st = con.createStatement();
				String query = StatementTypes.createInsert(table, tableColumns, values);
				return st.executeUpdate(query);
			} catch (SQLException e) {
				return null;
			}
		};
		
		Object result = r.run(con);
		
		if (result == null)
			return false;
		return true;
	}

	@Override
	public ResultSet read(String table, String condition) {
		Run r = (con) -> {
			try {
				Statement st = con.createStatement();
				String query = StatementTypes.createSelect(table, condition);
				return st.executeQuery(query);
			} catch (SQLException e) {
				return null;
			}
		};
		
		ResultSet set = (ResultSet) r.run(con);
		if (set == null)
			return null;
		return set;
	}

	@Override
	public boolean update(String table, String condition, String values) {
		Run r = (con) -> {
			try {
				Statement st = con.createStatement();
				String query = StatementTypes.createUpdate(table, values, condition);
				return st.executeUpdate(query);
			} catch (SQLException e) {
				return null;
			}
		};
		
		Object result = r.run(con);
		if (result == null)
			return false;
		return true;
	}

	@Override
	public boolean delete(String table, String condition) {
		Run r = (con) -> {
			try {
				Statement st = con.createStatement();
				String query = StatementTypes.createDelete(table, condition);
				return st.executeUpdate(query);
			} catch (SQLException e) {
				return null;
			}
		};
		
		Object result = r.run(con);
		
		if (result == null)
			return false;
		return true;
	}
	
	
	static enum StatementTypes {
		INSERT("INSERT INTO ? VALUES ?;"),
		SELECT("SELECT * FROM ? ?WHERE;"),
		UPDATE("UPDATE ? SET ? WHERE ?;"),
		DELETE("DELETE FROM ? WHERE ?;");
		
		private String statement;
		
		private StatementTypes(String statement) {this.statement = statement;}
		
		public static String createInsert(String table, String tableColumns, String values) {
			if (table == null || values == null)
				return null;
			
			return INSERT.statement.replaceFirst("\\?", table +""+ tableColumns).replaceFirst("\\?", values);
		}
		
		public static String createSelect(String table, String condition) {
			if (table == null)
				return null;
			String result = SELECT.statement.replaceFirst("\\?", table);
			if (condition != null)
				return result.replaceFirst("\\?WHERE", condition);
			return result.replaceFirst("\\?WHERE", "");
		}
		
		public static String createUpdate(String table, String values, String condition) {
			if (table == null || values == null || condition == null) 
				return null;
			return UPDATE.statement.replaceFirst("\\?", table).replaceFirst("\\?", values).replaceFirst("\\?", condition);
		}
		
		public static String createDelete(String table, String condition) {
			if (table == null || condition == null)
				return null;
			return DELETE.statement.replaceFirst("\\?", table).replaceFirst("\\?", condition);
		}
	}

	@FunctionalInterface
	static interface Run {
		
		Object run(Connection con);
	}
	
}
