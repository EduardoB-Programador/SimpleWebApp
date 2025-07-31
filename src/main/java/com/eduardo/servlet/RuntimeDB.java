package com.eduardo.servlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.eduardo.model.SimpleItem;
import com.eduardo.model.SimpleUser;

public class RuntimeDB {
	private static RuntimeDB db;
	private static List<SimpleUser> users = new ArrayList<>();
	
	public static RuntimeDB getInstance() {
		if (db == null)
			db = new RuntimeDB();
		return db;
	}
	
	public void addUser(SimpleUser user) {
		if (user != null)
			users.add(user);
	}
	
	public void addItem(SimpleUser user, SimpleItem item) {
		int index;
		if ((index = userExists(user)) >= 0 && itemExists(user, item) == -1) {
			users.get(index).addItem(item);
		}
	}
	
	public void removeItem(SimpleUser user, SimpleItem item) {
		int index;
		if ((index = userExists(user)) >= 0 && itemExists(user, item) >= 0) {
			users.get(index).removeItem(item);
		}
	}
	
	public void updateItem(SimpleUser user, SimpleItem oldItem, SimpleItem newItem) {
		int index;
		if ((index = userExists(user)) >= 0 && itemExists(user, oldItem) >= 0) {
			SimpleUser u = users.get(index);
			u.removeItem(oldItem);
			u.addItem(newItem);
		}
	}
	
	/**
	 * @param user - the user to be checked if it exists within the list
	 * @return the index in the list, if the user is not in it, returns -1
	*/
	public int userExists(SimpleUser user) {
		Map<String, Object> userMap2 = user.toMap();
		
		for (int i = 0; i < users.size(); i++) {
			Map<String, Object> userMap1 = users.get(i).toMap();
			
			Object password1 = userMap1.get("password");
			Object password2 = userMap2.get("password");
			Object email1 = userMap1.get("email");
			Object email2 = userMap2.get("email");
			
			if (password1.equals(password2) && email1.equals(email2))
				return i;
		}
		
		return -1;
	}
	
	/**
	 * @param user - that may or may not have the item assigned to it
	 * @param item - the item to be checked if it exists/is assigned to the user
	 * @return the index in the list, if the item is not in it, returns -1
	*/
	public int itemExists(SimpleUser user, SimpleItem item) {
		if (userExists(user) >= 0) {
			Map<String, Object> itemMap2 = item.toMap();
			List<SimpleItem> userItems = user.getItems();
			
			for (int i = 0; i < userItems.size(); i++) {
				Map<String, Object> itemMap1 = userItems.get(i).toMap();
				
				Object name1 = itemMap1.get("name");
				Object name2 = itemMap2.get("name");
				Object value1 = itemMap1.get("value");
				Object value2 = itemMap2.get("value");
				
				if (name1.equals(name2) && value1.equals(value2))
					return i;
			}
		}
		return -1;
	}
	
	public List<SimpleItem> fetchItems(SimpleUser user) {
		if (userExists(user) >= 0)
			return user.getItems();
		
		return null;
	}
}
