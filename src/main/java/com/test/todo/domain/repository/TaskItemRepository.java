package com.test.todo.domain.repository;

import java.util.Optional;

import com.test.todo.infrastructure.repository.mariadb.entity.TaskEntity;
import com.test.todo.infrastructure.repository.mariadb.entity.TaskItemEntity;

public interface TaskItemRepository {

	Iterable<TaskItemEntity> findByTask(TaskEntity taskItem);
	
	Optional<TaskItemEntity> findById(Integer id);
	
	TaskItemEntity save(TaskItemEntity entity);
	
	void deleteById(Integer id);
}
