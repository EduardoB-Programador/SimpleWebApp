package com.eduardo.model;

import static com.eduardo.util.AuthMethods.isNull;

public final class Password implements Mappifier {
	private int hashpass;
	
	public Password(String password) {
		isNull(password);
		this.hashpass = password.hashCode();
	}

	@Override
	public int hashCode() {
		return this.hashpass;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		return obj.hashCode() == this.hashCode();
	}
	
	
	public int getHashPass() {
		return this.hashpass;
	}
}