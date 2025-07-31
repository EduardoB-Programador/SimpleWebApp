package com.eduardo.model;

import static com.eduardo.model.util.AuthMethods.isNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.eduardo.model.util.Mappifier;

public final class SimpleItem implements Mappifier {
	private String name;
	private double value;
	
	public SimpleItem(String name, double value) {
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
	
	@SuppressWarnings("unchecked")
	@Override
	public Object fromMap(Map<String, Object> map) {
		boolean containsItems = map.containsKey("items");
		boolean containsItem = map.containsKey("item");
		
		if (!(containsItems || containsItem))
			return null;
		
		if (containsItems) 
			return (List<SimpleItem>) map.get("Items");
		return (SimpleItem) map.get("item");
	}
}
