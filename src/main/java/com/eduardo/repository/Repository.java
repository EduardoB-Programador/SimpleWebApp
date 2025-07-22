package com.eduardo.repository;

import java.util.ArrayList;
import java.util.List;

import com.eduardo.model.Mappifier;
import com.eduardo.repository.db.GenericDB;

public abstract class Repository<T extends Mappifier> {
	protected static Repository<?> repo = null;
	protected List<T> data;
	protected GenericDB db;
	protected List<MessageTypes> messages;
	
	protected Repository(GenericDB db) {
		this.data = new ArrayList<>();
		this.db = db;
	}

	public abstract void add(T value);
	
	public abstract List<?> fetch(String condition);
	
	public abstract void update(String condition, T value);
	
	public abstract void delete(String condition);
	
	public static enum MessageTypes {
		ADD_ERROR_MESSAGE("Couldn't insert data."),
		ADD_SUCCESSFUL_MESSAGE("Data was inserted successfully."),
		FETCH_ERROR_MESSAGE("Couldn't fetch data."),
		FETCH_SUCCESSFUL_MESSAGE("Data successfully fetched."),
		UPDATE_ERROR_MESSAGE("Couldn't update any entry."),
		UPDATE_SUCCESSFUL_MESSAGE("Data successfully updated."),
		DELETE_ERROR_MESSAGE("Couldn't delete data."),
		DELETE_SUCCESSFUL_MESSAGE("Data successfully deleted.");
		
		private String status;
		
		private MessageTypes(String status) {
			this.status = status;
		}
		
		public String getStatus() {return this.status;}
	}
}
