package com.eduardo.model.util;

import javax.servlet.http.HttpServletRequest;

import com.eduardo.model.SimpleItem;
import com.eduardo.model.SimpleUser;

public final class ModelMethods {

	public static final SimpleUser createSimpleUser(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		return new SimpleUser(email, password);
	}
	
	public static final SimpleItem createSimpleItem(HttpServletRequest request) {
		String name = request.getParameter("name");
		double value = Double.parseDouble(request.getParameter("value"));
		
		return new SimpleItem(name, value);
	}
	
	public static final void addSimpleItemToSimpleUser(SimpleUser SimpleUser, SimpleItem SimpleItem) {
		SimpleUser.addItem(SimpleItem);
	}
	
	public static final void removeSimpleItemFromSimpleUser(SimpleUser SimpleUser, SimpleItem SimpleItem) {
		SimpleUser.removeItem(SimpleItem);
	}
}
