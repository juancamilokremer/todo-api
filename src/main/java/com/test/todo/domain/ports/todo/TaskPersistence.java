package com.test.todo.domain.ports.todo;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.test.todo.domain.models.todo.Task;

@Repository
public interface TaskPersistence {
	Stream<Task> findAll();

	Task findById(Integer Id);

	Task create(Task task);

	Task update(Integer id, Task task);

	void delete(Integer id);
}
