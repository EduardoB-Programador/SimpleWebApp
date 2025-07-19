package com.eduardo.repository.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@SuppressWarnings("all")
public final class MongoDB extends GenericDB {
	private static MongoDB mongo;
	private MongoClient client;
	private MongoDatabase db;
	
	private MongoDB(String url, String db) {
		client = MongoClients.create(url);
		this.db = client.getDatabase(db);
	}
	
	public static MongoDB getInstance(String url, String db) {
		if (mongo == null)
			mongo = new MongoDB(url, db);
		return mongo;
	}
	
	public static class MongoMethods {
		
	}
	
}
