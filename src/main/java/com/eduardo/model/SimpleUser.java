package com.eduardo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.eduardo.model.util.Mappifier;
import com.eduardo.model.util.Table;

public final class SimpleUser implements Mappifier, Table {
	@SuppressWarnings("unused")
	private int id;
	private Password password;
	private Email email;
	private List<SimpleItem> items;
	
	public SimpleUser(Email email, Password password) {
		this(-1, email, password);
	}
	
	public SimpleUser(String email, String password) {
		this(-1, new Email(email), new Password(password));
	}
	
	public SimpleUser(int id, String email, String password) {
		this(id, new Email(email), new Password(password));
	}
	
	public SimpleUser(int id, Email email, Password password) {
		if (id >= 0)
			this.id = id;
		this.email = email;
		this.password = password;
		this.items = new ArrayList<>();
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, items, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		return this.hashCode() == obj.hashCode();
	}

	public Password getPassword() {
		return password;
	}

	public Email getEmail() {
		return email;
	}

	public List<SimpleItem> getItems() {
		return items;
	}
	
	public void addItem(SimpleItem item) {
		items.add(item);
	}
	
	public void removeItem(SimpleItem item) {
		items.remove(item);
	}
	
	public void setList(List<SimpleItem> items) {
		this.items = items;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object fromMap(Map<String, Object> map) {
		boolean condition = !map.containsKey("password") && !map.containsKey("email") && !map.containsKey("items");
		if (condition)
			return null;
		
		Map<String, Object> tempMap = Map.of("password", map.get("password"));
		Password p = (Password) (new Password("")).fromMap(tempMap);
		
		tempMap = Map.of("email", map.get("email"));
		Email e = (Email) (new Email("example@gmail.com")).fromMap(tempMap);
		
		tempMap = Map.of("items", map.get("items"));
		List<SimpleItem> items = (List<SimpleItem>) (new SimpleItem("", 0, 0)).fromMap(tempMap);
		
		SimpleUser u = new SimpleUser(e, p); u.setList(items);
		return u;
	}
}
