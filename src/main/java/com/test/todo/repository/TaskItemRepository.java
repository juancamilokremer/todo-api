package com.test.todo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.todo.domain.Task;
import com.test.todo.domain.TaskItem;

@Repository
public interface TaskItemRepository extends CrudRepository<TaskItem, Integer>{
	List<TaskItem> findByTask(Task task);
}
