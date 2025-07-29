package com.eduardo.model;

import static com.eduardo.model.util.AuthMethods.isNull;

import java.util.Map;
import java.util.Objects;

import com.eduardo.model.util.Mappifier;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class Password implements Mappifier {
	private String hashpass;
	
	
	public Password(String password) {
		isNull(password);
		this.hashpass = hash(password);
	}
	
	private static String hash(String value) {
		try {
			byte[] bytes = MessageDigest.getInstance("SHA-256").digest(value.getBytes());
			
			StringBuilder sb = new StringBuilder();
			for (byte b : bytes) {
				String hex = Integer.toHexString(0xff & b);
				if (hex.length() == 1) sb.append('0');
                sb.append(hex);
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Internal Error");
		}
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(hashpass);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || this.getClass() != obj.getClass())
			return false;
		return obj.hashCode() == this.hashCode();
	}
	
	public String toString() {
		return this.hashpass;
	}
	
	public String getHashPass() {
		return this.hashpass;
	}
	
	public Object fromMap(Map<String, Object> map) {
		if (!map.containsKey("password"))
			return null;
		return new Password((String) map.get("password"));
	}
}