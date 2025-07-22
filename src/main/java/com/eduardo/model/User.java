package com.eduardo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User implements Mappifier {
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
	
}
