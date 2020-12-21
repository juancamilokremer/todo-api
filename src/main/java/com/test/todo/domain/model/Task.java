package com.test.todo.domain.model;

import java.util.Date;
import java.util.List;

public class Task {
	private Integer id;
	private String name;
	private Date createDate;
	private List<TaskItem> items;

	public Task() {
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public List<TaskItem> getItems() {
		return items;
	}

	public void setItems(List<TaskItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", createDate=" + createDate + ", items=" + items + "]";
	}

}
