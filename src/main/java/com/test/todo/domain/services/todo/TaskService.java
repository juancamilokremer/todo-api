package com.test.todo.domain.services.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.todo.adapters.mariadb.todo.entities.TaskEntity;
import com.test.todo.adapters.mariadb.todo.repository.TaskRepository;
import com.test.todo.domain.exceptions.NotFoundException;
import com.test.todo.domain.models.todo.Task;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Stream<Task> findAll() {
		List<Task> tasks = new ArrayList<Task>();
		
		taskRepository.findAll().forEach(taskEntity -> tasks.add(taskEntity.toTask()));

		return tasks.stream();
	}

	public Task findById(Integer taskId) {
		TaskEntity taskEntity = taskRepository.findById(taskId)
				.orElseThrow(() -> new NotFoundException("Could not fine the task: " + taskId));

		return taskEntity.toTask();
	}

	public Task create(Task task) {
		task.setCreateDate(new Date());

		return taskRepository.save(new TaskEntity(task)).toTask();
	}
	
	public Task update(Integer id, Task task) {
		TaskEntity taskEntity = taskRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Could not fine the task: " + id));

		taskEntity.setName(task.getName());

		return taskRepository.save(taskEntity).toTask();
	}
	
	public void delete(Integer id) {
		taskRepository.deleteById(id);
	}
}
