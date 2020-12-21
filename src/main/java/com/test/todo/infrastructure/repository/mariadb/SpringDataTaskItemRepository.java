package com.test.todo.infrastructure.repository.mariadb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.todo.infrastructure.repository.mariadb.entity.TaskEntity;
import com.test.todo.infrastructure.repository.mariadb.entity.TaskItemEntity;

@Repository
public interface SpringDataTaskItemRepository extends CrudRepository<TaskItemEntity, Integer> {
	Iterable<TaskItemEntity> findByTask(TaskEntity taskItem);
}
