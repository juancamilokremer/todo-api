package com.test.todo.domain.models.todo;

import java.util.Date;

public class TaskItem {
	private Integer id;
	private String name;
	private boolean finish;
	private Date createDate;
	private Date finishDate;

	public TaskItem() {

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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}

	@Override
	public String toString() {
		return "TaskItem [id=" + id + ", name=" + name + ", finish=" + finish + ", createDate=" + createDate
				+ ", finishDate=" + finishDate + "]";
	}

}
