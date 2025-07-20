package com.eduardo.repository.db;

import java.util.List;

/**All databases within this project must extend this class, this is the only way that the broken Dependency Injection I made works, otherwise I'll cry.
 * 
 */
public abstract class GenericDB {
	
	/**One of the CRUD methods, creates a new entry in the database.
	 * 
	 * @param o - the object to be added to the database
	 */
	public abstract void create(Object o);
	
	/**One of the CRUD methods, fetches entries from the database.
	 * 
	 * @param condition - a filter to be applied on entries on the database
	 * @return a list of entries (or only an entry)
	 */
	public abstract List<Object> read(String condition);
	
	
	/**One of the CRUD methods, updates an entry's data.
	 * 
	 * @param condition - a filter to be applied on entries on the database, it'll throw an <code>RuntimeException</code> if the condition turns out null.
	 */
	public abstract void update(String condition) throws RuntimeException;
	
	/**One of the CRUD methods, deletes an entry.
	 * 
	 * @param condition - a filter to delete the entry, <strong>PREFERABLY</strong> the condition will yield an id-like condition, moreover it'll throw an <code>RuntimeException</code> if the condition turns out null.
	 */
	public abstract void delete(String condition) throws RuntimeException;
}
