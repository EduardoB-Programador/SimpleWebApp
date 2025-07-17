package com.eduardo.repository.db;

public class InMemoryDB extends GenericDB {
	private InMemoryDB db = null;

	private InMemoryDB() {
		
	}
	
	@Override
	public GenericDB getInstance(String url, String db) {
		if (this.db == null)
			this.db = new InMemoryDB();
		return this.db;
	}
}
