package com.custom.todo.list.app.service;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.model.Task;
import com.custom.todo.list.app.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class AddTaskService {
  private final TaskRepository taskRepository;

  public AddTaskService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public Task execute(AddTaskRequest request) {
    return this.taskRepository.save(request);
  }
}
