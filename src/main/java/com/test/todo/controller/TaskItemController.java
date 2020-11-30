package com.test.todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("/taskItems/{id}")
	TaskItem taskItemById(@PathVariable Integer id) {
		return taskItemService.findById(id);
	}

	@PutMapping("/taskItems/{id}")
	TaskItem editTaskItemName(@RequestBody TaskItem taskItem, @PathVariable Integer id) {
		return taskItemService.editName(id, taskItem);
	}
	
	@PutMapping("/taskItems/{id}/changeStatus")
	TaskItem changeStatusTaskItem(@PathVariable Integer id) {
		return taskItemService.editStatus(id);
	}

	@DeleteMapping("/taskItems/{id}")
	void deleteTaskItem(@PathVariable Integer id) {
		taskItemService.delete(id);
	}
}
