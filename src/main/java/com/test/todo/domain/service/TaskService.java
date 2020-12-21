package com.test.todo.domain.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.test.todo.domain.model.Task;

@Service
public interface TaskService {
	Stream<Task> findAll();

	Task findById(Integer taskId);

	Task create(Task task);
	
	Task update(Integer id, Task task);
	
	void delete(Integer id);
}
