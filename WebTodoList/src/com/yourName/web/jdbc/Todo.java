package com.yourName.web.jdbc;

public class Todo {

	private int id;
	private String description;
	
	public Todo(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	public Todo(String description) {
		super();
		this.description = description;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
