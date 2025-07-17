package com.eduardo.repository.db;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;


public final class MongoDB extends GenericDB {
	private MongoDB mongo;
	private MongoClient client;
	private MongoDatabase db;
	
	private MongoDB(String url, String db) {
		client = MongoClients.create(url);
		this.db = client.getDatabase(db);
	}
	
	public MongoDB getInstance(String url, String db) {
		if (mongo == null)
			mongo = new MongoDB(url, db);
		return this.mongo;
	}
	
	public static class MongoMethods {
		
	}
	
}
