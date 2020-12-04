package com.test.todo.domain.services.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.todo.adapters.mariadb.todo.entities.TaskEntity;
import com.test.todo.adapters.mariadb.todo.entities.TaskItemEntity;
import com.test.todo.adapters.mariadb.todo.repository.TaskItemRepository;
import com.test.todo.domain.exceptions.NotFoundException;
import com.test.todo.domain.models.todo.Task;
import com.test.todo.domain.models.todo.TaskItem;

@Service
public class TaskItemService {

	@Autowired
	private TaskItemRepository taskItemRepository;
	
	public Stream<TaskItem> findByTaskId(Task task) {        
List<TaskItem> taskItems = new ArrayList<TaskItem>();
		
		taskItemRepository.findByTask(new TaskEntity(task))
			.forEach(taskEntity -> taskItems.add(taskEntity.toTaskItem()));

		return taskItems.stream();
	}
	
	public TaskItem findById(Integer id) {		
		return taskItemRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Could not fine the task item: " + id))
				.toTaskItem();
	}

	public TaskItem create(Task task, TaskItem taskItem) {
		TaskItemEntity taskItemEntity = new TaskItemEntity(taskItem);
		taskItemEntity.setCreateDate(new Date());
		taskItemEntity.setTask(new TaskEntity(task));
		
		return taskItemRepository.save(taskItemEntity).toTaskItem();
	}
	
	public TaskItem updateName(Integer id, TaskItem taskItem) {
		return taskItemRepository.findById(id)
				.map(currentTaskItem -> {
					currentTaskItem.setName(taskItem.getName());
					return taskItemRepository.save(currentTaskItem);
				})
				.orElseThrow(() -> new NotFoundException("Could not fine the task item: " + id))
				.toTaskItem();
	}
	
	public TaskItem updateStatus(Integer id) {
		return taskItemRepository.findById(id)
				.map(currentTaskItem -> {
					currentTaskItem.setFinish(!currentTaskItem.isFinish());
					if(currentTaskItem.isFinish()) {
						currentTaskItem.setFinishDate(new Date());
					} else {
						currentTaskItem.setFinishDate(null);
					}
					return taskItemRepository.save(currentTaskItem);
				})
				.orElseThrow(() -> new NotFoundException("Could not fine the task item: " + id))
				.toTaskItem();
	}
	
	public void delete(Integer id) {
		taskItemRepository.deleteById(id);
	}
}
