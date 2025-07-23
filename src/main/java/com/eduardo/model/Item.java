package com.eduardo.model;

import static com.eduardo.model.util.AuthMethods.isNull;

import java.util.Objects;

public final class Item implements Mappifier {
	private String name;
	private double value;
	
	public Item(String name, double value) {
		isNull(name);
		isNull(value);
		
		this.name = name;
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		return this.hashCode() == obj.hashCode();
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getValue() {
		return this.value;
	}
	
	
}
