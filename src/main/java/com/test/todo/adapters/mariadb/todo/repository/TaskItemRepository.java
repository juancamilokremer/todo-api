package com.test.todo.adapters.mariadb.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.todo.adapters.mariadb.todo.entities.TaskEntity;
import com.test.todo.adapters.mariadb.todo.entities.TaskItemEntity;

@Repository
public interface TaskItemRepository extends CrudRepository<TaskItemEntity, Integer> {
	Iterable<TaskItemEntity> findByTask(TaskEntity taskItem);
}
