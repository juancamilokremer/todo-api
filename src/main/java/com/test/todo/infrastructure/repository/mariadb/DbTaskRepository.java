package com.test.todo.infrastructure.repository.mariadb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.todo.domain.repository.TaskRepository;
import com.test.todo.infrastructure.repository.mariadb.entity.TaskEntity;

@Component
public class DbTaskRepository implements TaskRepository {
	
	private final SpringDataTaskRepository taskRepository;
	
	@Autowired
	public DbTaskRepository(SpringDataTaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public Iterable<TaskEntity> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Optional<TaskEntity> findById(Integer id) {
		return taskRepository.findById(id);
	}

	@Override
	public TaskEntity save(TaskEntity entity) {
		return taskRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) {
		taskRepository.deleteById(id);
	}

}
