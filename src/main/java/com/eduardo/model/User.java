package com.eduardo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.eduardo.model.util.Mappifier;
import com.eduardo.model.util.Table;

public final class User implements Mappifier, Table {
	private Password password;
	private Email email;
	private List<Item> items;
	
	public User(Email email, Password password) {
		this.email = email;
		this.password = password;
		this.items = new ArrayList<>();
	}
	
	public User(String email, String password) {
		this(new Email(email), new Password(password));
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

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public void setList(List<Item> items) {
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
		List<Item> items = (List<Item>) (new Item("", 0)).fromMap(tempMap);
		
		User u = new User(e, p); u.setList(items);
		return u;
	}
}
