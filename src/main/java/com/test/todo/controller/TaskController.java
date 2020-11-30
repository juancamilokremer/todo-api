package com.test.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.todo.domain.Task;
import com.test.todo.domain.TaskItem;
import com.test.todo.service.TaskItemService;
import com.test.todo.service.TaskService;

@RestController
@RequestMapping("/todo")
public class TaskController {

	@Autowired
	private TaskService taskService;
	@Autowired
	private TaskItemService taskItemService;

	@GetMapping("/tasks")
	public List<Task> allTasks() {

		return taskService.findAll();
	}
	
	@GetMapping("/tasks/{id}/items")
	public List<TaskItem> allTaskItems(@PathVariable Integer id) {
		Task task = taskService.findById(id);
		
		return taskItemService.findByTaskId(task);
	}

	@GetMapping("/tasks/{id}")
	Task taskById(@PathVariable Integer id) {
		return taskService.findById(id);
	}

	@PostMapping("/tasks")
	Task createTask(@RequestBody Task task) {
		return taskService.create(task);
	}

	@PutMapping("/tasks/{id}")
	Task editTask(@RequestBody Task task, @PathVariable Integer id) {
		return taskService.edit(id, task);
	}

	@DeleteMapping("/tasks/{id}")
	void deleteTask(@PathVariable Integer id) {
		taskService.delete(id);
	}
}
