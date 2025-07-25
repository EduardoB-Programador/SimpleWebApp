package com.eduardo.repository.db;


//couldn't use MongoDB due to either dependency issues or IDE issues, I wasn't able to find out what happened and even less how to fix it, therefore this class was a waste of time, frustrating
/*@SuppressWarnings("all")
public final class MongoDB extends GenericDB {
	private static MongoDB mongo;
	private String urlStr;
	private String dbStr;
	private String collectionStr;
	private MongoClient client;
	private MongoDatabase db;
	private MongoCollection<Document> collection;
	
	private MongoDB(String url, String db, String collectionName) {
		
		if (url != null) {
			client = Methods.createClient(url);
			this.urlStr = url;
		}
			
		
		if (db != null) {
			this.db = client.getDatabase(db);
			this.dbStr = db;
		}
		
		if (collectionName != null) {
			this.collection = this.db.getCollection(collectionName);
			this.collectionStr = collectionName;
		}
	}
	
	private MongoDB(String url, String db) {
		this(url, db, null);
	}
	
	private MongoDB(String url) {
		this(url, null);
		
	}
	
	public static MongoDB getInstance(String url, String db, String collectionName) {
		if (mongo == null || !mongo.urlStr.equals(url) || !mongo.dbStr.equals(db) || !mongo.collectionStr.equals(collectionName))
			mongo = new MongoDB(url, db, collectionName);
		return mongo;
	}
	
	public static MongoDB getInstance(String url, String db) {
		return getInstance(url, db, null);
	}
	
	public static MongoDB getInstance(String url) {
		return getInstance(url, null, null);
	}
	
	public void setUrl(String url) {
		if (url != null)
			this.client = Methods.createClient(url);
	}
	
	public void setDatabase(String db) {
		if (this.client != null && db != null)
			this.db = this.client.getDatabase(db);
	}
	
	public void setCollection(String collectionName) {
		if (this.db != null && collectionName != null)
			this.collection = this.db.getCollection(collectionName);
	}
	
	static class Methods {
		private static Document doc = new Document();
		
		static MongoClient createClient(String url) {
			try {
				Class.forName("com.mongodb.MongoClient");
			} catch (Exception e) {System.out.println("exception happened");}
			
			return new MongoClient(url);
		}
		
		private static final void resetDoc() {doc = new Document();}
		
		static Document createDoc(Object o) {
			resetDoc();
			String result = null;
			
			if (o.getClass() == Map.class) {
				doc.putAll((Map) o);
				
				result = doc.toBsonDocument().toString();
			} else if (o.getClass() == Map.Entry.class) {
				String key = (String) ((Map.Entry) o).getKey();
				Object value = ((Map.Entry) o).getValue();
				
				result = doc.append(key, value).toBsonDocument().toString();
			}
			if (result == null)
				return null;
			
			return Document.parse(result);
		}
		
		static Bson createBSon(Object o) {
			resetDoc();
			Bson bson = createDoc(o).toBsonDocument();
			
			return bson;
		}
	}


	@Override
	public boolean create(Object values) {
		Document doc = Methods.createDoc(values);
		if (doc == null)
			return false;
		collection.insertOne(doc);
		return true;
	}

	@Override
	public List<Document> read(Object condition) {
		Bson bson = Methods.createBSon(condition);
		
		FindIterable<Document> fi = collection.find();
		if (bson != null)
			fi = fi.filter(bson);
		
		MongoCursor<Document> cursor = fi.cursor();
		
		List<Document> items = new ArrayList<>();
		while (cursor.hasNext())
			items.add(cursor.next());
		
		return items;
	}

	@Override
	public boolean update(Object condition, Object values) {
		Bson bson1 = Methods.createBSon(condition);
		Bson bson2 = Methods.createBSon(values);
		
		if (bson1 != null && bson2 != null) {
			collection.updateMany(bson1, bson2);
			return true;
		}
		
		return false;
	}

	@Override
	public boolean delete(Object condition) {
		Bson bson = Methods.createBSon(condition);
		
		if (bson != null) {
			collection.deleteMany(bson);
			return true;
		}
			
		return false;
	}
	
}
*/