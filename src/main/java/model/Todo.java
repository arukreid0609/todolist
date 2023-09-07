package model;

import java.io.Serializable;

public class Todo implements Serializable {
	private int id;
	private String todo;
	private String category;
	
	public Todo() { }
	public Todo(String todo, String category) {
		this.todo = todo;
		this.category = category;
	}
	public Todo(int id,String todo,String category) {
		this(todo,category);
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
