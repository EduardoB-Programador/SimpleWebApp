package com.eduardo.model.util;

import javax.servlet.http.HttpServletRequest;

import com.eduardo.model.Item;
import com.eduardo.model.User;

public final class ModelMethods {

	public static final User createUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		return new User(email, password);
	}
	
	public static final Item createItem(HttpServletRequest request) {
		String name = request.getParameter("name");
		double value = Double.parseDouble("value");
		
		return new Item(name, value);
	}
	
	public static final void addItemToUser(User user, Item item) {
		user.addItem(item);
	}
	
	public static final void removeItemFromUser(User user, Item item) {
		user.removeItem(item);
	}
}
