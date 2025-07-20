package com.eduardo.repository.db;

import java.util.List;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("all")
public final class MongoDB extends GenericDB {
	private static MongoDB mongo;
	private MongoClient client;
	private MongoDatabase db;
	//TODO: Import BSON library
	private MongoCollection<Document> currentColletion;
	
	private MongoDB(String url, String db, String colletionName) {
		if (url != null)
			client = MongoClients.create(url);
		
		if (db != null)
			this.db = client.getDatabase(db);
		
		if (collectionName != null)
			this.currentColletion = this.db.getCollection(colletionName);
	}
	
	private MongoDB(String url, String db) {
		this(url, db, null)
	}
	
	private MongoDB(String url) {
		this(url, null);
		
	}
	
	public static MongoDB getInstance(String url, String db, String collectionName) {
		if (mongo == null)
			mongo = new MongoDB(url, db, collectionName);
		return mongo;
	}
	
	public static MongoDB getInstance(String url, String db) {
		getInstance(url, db, null);
	}
	
	public static MongoDB getInstance(String url) {
		getInstance(url, null, null);
	}
	
	public void setUrl(String url) {
		if (url != null)
			this.client = MongoClients.create(url);
	}
	
	public void setDatabase(String db) {
		if (this.client != null && db != null)
			this.db = this.client.getDatabase(db);
	}
	
	public void setCollection(String collectionName) {
		if (this.db != null && collectionName != null)
			this.currentColletion = this.db.getCollection(collectionName);
	}
	
	public static class MongoMethods {
		
	}



	@Override
	public void create(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Object> read(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String condition) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String condition) throws RuntimeException {
		// TODO Auto-generated method stub
		
	}
	
}
