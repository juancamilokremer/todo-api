package com.test.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.todo.controller.exceptions.NotFoundException;
import com.test.todo.domain.Task;
import com.test.todo.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public List<Task> findAll() {
		Iterable<Task> it = taskRepository.findAll();

		List<Task> tasks = new ArrayList<Task>();
		it.forEach(e -> tasks.add(e));

		return tasks;
	}

	public Task findById(Integer taskId) {
		Optional<Task> task = taskRepository.findById(taskId);

		return task.orElseThrow(() -> new NotFoundException("Could not fine the task: " + taskId));
	}

	public Task create(Task task) {
		task.setCreateDate(new Date());
		return taskRepository.save(task);
	}
	
	public Task edit(Integer id, Task task) {
		return taskRepository.findById(id).map((Task currentTask) -> {
			currentTask.setName(task.getName());
			return taskRepository.save(currentTask);
		}).orElseThrow(() -> new NotFoundException("Could not fine the task: " + id));
	}
	
	public void delete(Integer id) {
		taskRepository.deleteById(id);
	}
}
