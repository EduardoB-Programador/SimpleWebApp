package com.eduardo.model.util;

import java.lang.reflect.Field;

public interface Table {
	
	default String getTableName() {
		return this.getClass().getSimpleName().toLowerCase();
	}
	
	default String getTableColumns() {
		Field[] fields = this.getClass().getDeclaredFields();
		String[] fieldsname = new String[fields.length];
		
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			fieldsname[i] = f.getName();
		}
		
		StringBuilder columns = new StringBuilder().append("(");
		for (int i = 0; i < fieldsname.length; i++) {
			String temp = fieldsname[i];
			columns.append(temp);
			
			try {
				assert fieldsname[i+1] != null;
				columns.append(", ");
			} catch (ArrayIndexOutOfBoundsException | AssertionError e) {
				columns.append(")");
				break;
			}
		}
		
		return columns.toString();
	}
}
