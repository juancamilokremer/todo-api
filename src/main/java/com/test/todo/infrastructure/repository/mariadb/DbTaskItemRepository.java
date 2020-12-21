package com.test.todo.infrastructure.repository.mariadb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.todo.domain.repository.TaskItemRepository;
import com.test.todo.infrastructure.repository.mariadb.entity.TaskEntity;
import com.test.todo.infrastructure.repository.mariadb.entity.TaskItemEntity;

@Component
public class DbTaskItemRepository implements TaskItemRepository {
	
	private final SpringDataTaskItemRepository taskItemRepository;
	
	@Autowired
	public DbTaskItemRepository(SpringDataTaskItemRepository taskItemRepository) {
		super();
		this.taskItemRepository = taskItemRepository;
	}

	@Override
	public Iterable<TaskItemEntity> findByTask(TaskEntity taskItem) {
		return taskItemRepository.findByTask(taskItem);
	}

	@Override
	public Optional<TaskItemEntity> findById(Integer id) {
		return taskItemRepository.findById(id);
	}

	@Override
	public TaskItemEntity save(TaskItemEntity entity) {
		return taskItemRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) {
		taskItemRepository.deleteById(id);

	}

}
