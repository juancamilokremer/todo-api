package com.test.todo.domain.service;

import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.test.todo.domain.model.Task;
import com.test.todo.domain.model.TaskItem;

@Service
public interface TaskItemService {

	Stream<TaskItem> findByTaskId(Task task);
	
	TaskItem findById(Integer id);

	TaskItem create(Task task, TaskItem taskItem);
	
	TaskItem updateName(Integer id, TaskItem taskItem);
	
	TaskItem updateStatus(Integer id);
	
	void delete(Integer id);
}
