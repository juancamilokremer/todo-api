package com.test.todo.domain.services.todo;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.todo.domain.models.todo.Task;
import com.test.todo.domain.ports.todo.TaskPersistence;

@Service
public class TaskService {

	@Autowired
	private TaskPersistence taskPersistence;

	public Stream<Task> findAll() {
		return taskPersistence.findAll();
	}

	public Task findById(Integer taskId) {
		return taskPersistence.findById(taskId);
	}

	public Task create(Task task) {
		return taskPersistence.create(task);
	}
	
	public Task update(Integer id, Task task) {
		return taskPersistence.update(id, task);
	}
	
	public void delete(Integer id) {
		taskPersistence.delete(id);
	}
}
