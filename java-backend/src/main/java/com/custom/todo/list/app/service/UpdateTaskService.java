package com.custom.todo.list.app.service;

import com.custom.todo.list.app.dto.UpdateTaskRequest;
import com.custom.todo.list.app.model.Task;
import com.custom.todo.list.app.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskService {
  private final TaskRepository repository;

  public UpdateTaskService(TaskRepository repository) {
    this.repository = repository;
  }

  public Task execute(Long idTask, UpdateTaskRequest request) {
    return this.repository.update(idTask, request);
  }
}
