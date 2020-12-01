package com.test.todo.adapters.mariadb.todo.persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.todo.adapters.mariadb.todo.entities.TaskEntity;
import com.test.todo.adapters.mariadb.todo.repository.TaskRepository;
import com.test.todo.domain.exceptions.NotFoundException;
import com.test.todo.domain.models.todo.Task;
import com.test.todo.domain.ports.todo.TaskPersistence;

@Repository("taskPersistence")
public class TaskPersistenceMariadb implements TaskPersistence {

	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Stream<Task> findAll() {
		List<Task> tasks = new ArrayList<Task>();
		
		taskRepository.findAll().forEach(taskEntity -> tasks.add(taskEntity.toTask()));

		return tasks.stream();
	}

	@Override
	public Task findById(Integer id) {
		TaskEntity taskEntity = taskRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Could not fine the task: " + id));

		return taskEntity.toTask();
	}

	@Override
	public Task create(Task task) {
		task.setCreateDate(new Date());

		return taskRepository.save(new TaskEntity(task)).toTask();
	}

	@Override
	public Task update(Integer id, Task task) {
		TaskEntity taskEntity = taskRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Could not fine the task: " + id));

		taskEntity.setName(task.getName());

		return taskRepository.save(taskEntity).toTask();
	}

	@Override
	public void delete(Integer id) {
		taskRepository.deleteById(id);
	}

}
