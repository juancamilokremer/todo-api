package com.test.todo.adapters.mariadb.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.todo.adapters.mariadb.todo.entities.TaskEntity;

@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Integer> {

}
