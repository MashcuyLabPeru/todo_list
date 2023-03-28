package com.custom.todo.list.app.repository.impl;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.jpa.model.TaskJpa;
import com.custom.todo.list.app.jpa.repository.CrudTaskRepository;
import com.custom.todo.list.app.model.Task;
import com.custom.todo.list.app.repository.TaskRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresTaskRepository implements TaskRepository {

  private final CrudTaskRepository crudTaskRepository;

  public PostgresTaskRepository(CrudTaskRepository crudTaskRepository) {
    this.crudTaskRepository = crudTaskRepository;
  }

  @Override
  public Task save(AddTaskRequest request) {
    var task = TaskJpa.fromAddRequest(request);
    var registeredTask = this.crudTaskRepository.save(task);
    return registeredTask.toModel();
  }
}
