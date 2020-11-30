package com.test.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.todo.controller.exceptions.NotFoundException;
import com.test.todo.domain.Task;
import com.test.todo.domain.TaskItem;
import com.test.todo.repository.TaskItemRepository;

@Service
public class TaskItemService {

	@Autowired
	private TaskItemRepository taskItemRepository;
	
	public List<TaskItem> findByTaskId(Task task) {
		Iterable<TaskItem> it = taskItemRepository.findByTask(task);

        List<TaskItem> taskItems = new ArrayList<TaskItem>();
        it.forEach(taskItem -> taskItems.add(taskItem));

        return taskItems;
	}
	
	public TaskItem findById(Integer id) {
		Optional<TaskItem> task = taskItemRepository.findById(id);

		return task.orElseThrow(() -> new NotFoundException("Could not fine the task item: " + id));
	}

	public TaskItem create(Task task, TaskItem taskItem) {
		taskItem.setCreateDate(new Date());
		taskItem.setTask(task);
		return taskItemRepository.save(taskItem);
	}
	
	public TaskItem editName(Integer id, TaskItem taskItem) {
		return taskItemRepository.findById(id).map((TaskItem currentTaskItem) -> {
			currentTaskItem.setName(taskItem.getName());
			return taskItemRepository.save(currentTaskItem);
		}).orElseThrow(() -> new NotFoundException("Could not fine the task item: " + id));
	}
	
	public TaskItem editStatus(Integer id) {
		return taskItemRepository.findById(id).map((TaskItem currentTaskItem) -> {
			currentTaskItem.setFinish(!currentTaskItem.isFinish());
			if(currentTaskItem.isFinish()) {
				currentTaskItem.setFinishDate(new Date());
			} else {
				currentTaskItem.setFinishDate(null);
			}
			
			return taskItemRepository.save(currentTaskItem);
		}).orElseThrow(() -> new NotFoundException("Could not fine the task item: " + id));
	}
	
	public void delete(Integer id) {
		taskItemRepository.deleteById(id);
	}
}
