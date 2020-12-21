package com.test.todo.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.todo.domain.model.TaskItem;
import com.test.todo.domain.service.DomainTaskItemService;

@RestController
@RequestMapping(TaskItemResource.TODO)
public class TaskItemResource {
	static final String TODO = "/todo";
	static final String TASK_ITEMS = "/taskItems";
	static final String CHANGE_STATUS = "/changeStatus";
	
	@Autowired
	private DomainTaskItemService taskItemService;

	@GetMapping(TASK_ITEMS + "/{id}")
	TaskItem taskItemById(@PathVariable Integer id) {
		return taskItemService.findById(id);
	}

	@PutMapping(TASK_ITEMS + "/{id}")
	TaskItem editTaskItemName(@RequestBody TaskItem taskItem, @PathVariable Integer id) {
		return taskItemService.updateName(id, taskItem);
	}
	
	@PutMapping(TASK_ITEMS + "/{id}" + CHANGE_STATUS)
	TaskItem changeStatusTaskItem(@PathVariable Integer id) {
		return taskItemService.updateStatus(id);
	}

	@DeleteMapping(TASK_ITEMS + "/{id}")
	void deleteTaskItem(@PathVariable Integer id) {
		taskItemService.delete(id);
	}
}
