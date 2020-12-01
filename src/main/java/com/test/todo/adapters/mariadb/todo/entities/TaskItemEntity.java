package com.test.todo.adapters.mariadb.todo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.test.todo.domain.models.todo.TaskItem;

@Entity
@Table(name = "task_items")
public class TaskItemEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private boolean finish;
	@Column(name = "create_date")
	private Date createDate;
	@Column(name = "finish_date")
	private Date finishDate;
	@ManyToOne
	@JoinColumn(name = "task_id")
	private TaskEntity task;

	public TaskItemEntity() {
		// empty from spring.
	}

	public TaskItemEntity(TaskItem taskItem) {
		this.id = taskItem.getId();
		this.name = taskItem.getName();
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

	public TaskEntity getTask() {
		return task;
	}

	public void setTask(TaskEntity task) {
		this.task = task;
	}

	public TaskItem toTaskItem() {
		TaskItem taskItem = new TaskItem();
		BeanUtils.copyProperties(this, taskItem);

		return taskItem;
	}
}
