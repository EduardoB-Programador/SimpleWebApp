package com.eduardo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class User {
	private Password password;
	private Email email;
	private List<Item> items;
	
	public User(String email, String password) {
		this.email = new Email(email);
		this.password = new Password(password);
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

	public List<Item> getItems() {
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
}
