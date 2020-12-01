package com.test.todo.domain.services.todo;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.todo.domain.models.todo.Task;
import com.test.todo.domain.models.todo.TaskItem;
import com.test.todo.domain.ports.todo.TaskItemPersistence;

@Service
public class TaskItemService {

	@Autowired
	private TaskItemPersistence taskItemPersistence;
	
	public Stream<TaskItem> findByTaskId(Task task) {        
        return taskItemPersistence.findAllByTaskId(task);
	}
	
	public TaskItem findById(Integer id) {		
		return taskItemPersistence.findById(id);
	}

	public TaskItem create(Task task, TaskItem taskItem) {
		return taskItemPersistence.create(task, taskItem);
	}
	
	public TaskItem updateName(Integer id, TaskItem taskItem) {
		return taskItemPersistence.updateName(id, taskItem);
	}
	
	public TaskItem updateStatus(Integer id) {
		return taskItemPersistence.updateStatus(id);
	}
	
	public void delete(Integer id) {
		taskItemPersistence.delete(id);
	}
}
