package com.eduardo.model;

import static com.eduardo.model.util.AuthMethods.isNull;

import java.util.Objects;

public record Email(String email) implements Mappifier {

	public Email(String email) {
		isNull(email);
		if (!checkEmail(email))
			throw new RuntimeException("Invalid email.");
		this.email = email;
	}
	
	private boolean checkEmail(String email) {
		return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		return this.hashCode() == obj.hashCode();
	}
	
}
