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

import com.test.todo.domain.TaskItem;
import com.test.todo.service.TaskItemService;

@RestController
@RequestMapping("/todo")
public class TaskItemController {

	@Autowired
	private TaskItemService taskItemService;

//	@GetMapping("/taskItems/{taskId}")
//	public List<TaskItem> allTasks(@PathVariable Integer taskId) {
//		return taskItemService.findAllTaskItems(taskId);
//	}
//
//	@GetMapping("/taskItems/{id}")
//	TaskItem taskItemById(@PathVariable Integer id) {
//		return taskItemService.findById(id);
//	}
//
//	@PostMapping("/taskItems")
//	TaskItem createTaskItem(@RequestBody TaskItem taskItem) {
//		return taskItemService.create(taskItem);
//	}
//
//	@PutMapping("/taskItems/{id}")
//	TaskItem editTaskItem(@RequestBody TaskItem taskItem, @PathVariable Integer id) {
//		return taskItemService.edit(id, taskItem);
//	}
//
//	@DeleteMapping("/taskItems/{id}")
//	void deleteTaskItem(@PathVariable Integer id) {
//		taskItemService.delete(id);
//	}
}
