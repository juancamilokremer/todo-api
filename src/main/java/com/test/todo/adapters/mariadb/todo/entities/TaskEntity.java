package com.test.todo.adapters.mariadb.todo.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;

import com.test.todo.domain.models.todo.Task;

@Entity
@Table(name = "tasks")
public class TaskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@Column(name = "create_date")
	private Date createDate;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "task")
	private List<TaskItemEntity> items;

	public TaskEntity() {
		// empty from spring.
	}

	public TaskEntity(Task task) {
		this.id = task.getId();
		this.name = task.getName();
		this.createDate = task.getCreateDate();
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

	public Task toTask() {
        Task task = new Task();
        BeanUtils.copyProperties(this, task);
        
        return task;
    }
	
//	public List<TaskItem> getItems() {
//		return items;
//	}
}
