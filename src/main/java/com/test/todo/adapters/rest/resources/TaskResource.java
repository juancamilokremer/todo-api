package com.test.todo.adapters.rest.resources;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.todo.domain.models.todo.Task;
import com.test.todo.domain.models.todo.TaskItem;
import com.test.todo.domain.services.todo.TaskItemService;
import com.test.todo.domain.services.todo.TaskService;

@RestController
@RequestMapping(TaskResource.TODO)
public class TaskResource {
	static final String TODO = "/todo";
	static final String TASKS = "/tasks";
	static final String ITEMS = "/items";

	@Autowired
	private TaskService taskService;
	@Autowired
	private TaskItemService taskItemService;

	@GetMapping(TASKS)
	public Stream<Task> allTasks() {
		return taskService.findAll();
	}

	@GetMapping(TASKS + "/{id}" + ITEMS)
	public Stream<TaskItem> allTaskItems(@PathVariable Integer id) {
		Task task = taskService.findById(id);

		return taskItemService.findByTaskId(task);
	}

	@PostMapping(TASKS + "/{id}" + ITEMS)
	TaskItem addTaskItem(@RequestBody TaskItem taskItem, @PathVariable Integer id) {
		Task task = taskService.findById(id);

		return taskItemService.create(task, taskItem);
	}

	@GetMapping(TASKS + "/{id}")
	Task taskById(@PathVariable Integer id) {
		return taskService.findById(id);
	}

	@PostMapping(TASKS)
	Task createTask(@RequestBody Task task) {
		return taskService.create(task);
	}

	@PutMapping(TASKS + "/{id}")
	Task editTask(@RequestBody Task task, @PathVariable Integer id) {
		return taskService.update(id, task);
	}

	@DeleteMapping(TASKS + "/{id}")
	void deleteTask(@PathVariable Integer id) {
		taskService.delete(id);
	}
}
