package com.test.todo.domain.repository;

import java.util.Optional;

import com.test.todo.infrastructure.repository.mariadb.entity.TaskEntity;

public interface TaskRepository {

	Iterable<TaskEntity> findAll();
	
	Optional<TaskEntity> findById(Integer id);
	
	TaskEntity save(TaskEntity entity);
	
	void deleteById(Integer id);
}
