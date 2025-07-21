package com.eduardo.repository.db;

import java.util.List;

import org.bson.Document;

/**All databases within this project must extend this class, this is the only way that the broken Dependency Injection I made works, otherwise I'll cry.
 * 
 */
public abstract class GenericDB {
	
	/**One of the CRUD methods, creates a new entry in the database.
	 * 
	 * @param values - the object to be added to the database
	 * @return true if the operation was successful or false if it wasn't
	 */
	public abstract boolean create(Object values);
	
	/**One of the CRUD methods, fetches entries from the database.
	 * 
	 * @param condition - a filter to be applied on entries on the database
	 * @return a list of entries (or only an entry)
	 */
	public abstract List<Document> read(Object condition);
	
	
	/**One of the CRUD methods, updates an entry's data.
	 * 
	 * @param condition - a filter to be applied on entries on the database.
	 * @param values - the values to be altered in the database
	 * @return true if the operation was successful or false if it wasn't
	 */
	public abstract boolean update(Object condition, Object values);
	
	/**One of the CRUD methods, deletes an entry.
	 * 
	 * @param condition - a filter to delete the entry, <strong>PREFERABLY</strong> the condition will yield an id-like condition.
	 * @return true if the operation was successful or false if it wasn't
	 */
	public abstract boolean delete(Object condition);
}
