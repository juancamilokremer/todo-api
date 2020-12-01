package com.test.todo.adapters.rest.dto;

public class TaskDto {
	private Integer id;
	private String name;

	public TaskDto() {
		// empty for Spring
	}

	public TaskDto(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "TaskDto [id=" + id + ", name=" + name + "]";
	}
}
