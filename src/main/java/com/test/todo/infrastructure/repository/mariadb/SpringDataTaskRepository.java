package com.test.todo.infrastructure.repository.mariadb;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.todo.infrastructure.repository.mariadb.entity.TaskEntity;

@Repository
public interface SpringDataTaskRepository extends CrudRepository<TaskEntity, Integer> {

}
