package com.test.todo.domain.ports.todo;

import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.test.todo.domain.models.todo.Task;
import com.test.todo.domain.models.todo.TaskItem;

@Repository
public interface TaskItemPersistence {

	Stream<TaskItem> findAllByTaskId(Task task);

	TaskItem findById(Integer id);

	TaskItem create(Task task, TaskItem taskItem);

	TaskItem updateName(Integer id, TaskItem taskItem);

	TaskItem updateStatus(Integer id);

	void delete(Integer id);
}
