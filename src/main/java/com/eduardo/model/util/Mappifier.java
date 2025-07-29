package com.eduardo.model.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public interface Mappifier {
	
	public default Map<String, Object> toMap() throws IllegalArgumentException, IllegalAccessException {
		return toMap(this);
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> toMap(Object o) throws IllegalArgumentException, IllegalAccessException {
		Field[] fields = o.getClass().getDeclaredFields();
		List<Entry<String, Object>> list = new ArrayList<>();
		
		for (Field f : fields) {
			Entry<String, Object> e = createEntry(f, o);
			list.add(e);
		}
		
		Entry<String, Object>[] entries = new Entry[list.size()];
		for (int i = 0; i < list.size(); i++) {
			entries[i] = list.get(i);
		}
		
		return Map.ofEntries(entries);
	}
	
	private static Entry<String, Object> createEntry(Field f, Object o) throws IllegalArgumentException, IllegalAccessException {
		f.setAccessible(true);
		String name = f.getName();
		Object obj = f.get(o);
		
		return Map.entry(name, obj);
	}
	
	public Object fromMap(Map<String, Object> map);
}
