package com.test.todo.application.rest.dto;

public class TaskItemDto {
	private Integer id;
	private String name;
	private boolean finish;

	public TaskItemDto() {
		// empty from spring.
	}

	public TaskItemDto(Integer id, String name, boolean finish) {
		this.id = id;
		this.name = name;
		this.finish = finish;
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

	public boolean isFinish() {
		return finish;
	}

	public void setFinish(boolean finish) {
		this.finish = finish;
	}

}
