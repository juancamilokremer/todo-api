package com.test.todo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.todo.domain.Task;

@Repository
public interface TaskRepository extends CrudRepository<Task, Integer>{

}
