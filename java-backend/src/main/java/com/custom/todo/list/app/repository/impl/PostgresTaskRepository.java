package com.custom.todo.list.app.repository.impl;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.dto.UpdateTaskRequest;
import com.custom.todo.list.app.jpa.model.TaskJpa;
import com.custom.todo.list.app.jpa.repository.CrudTaskRepository;
import com.custom.todo.list.app.model.Task;
import com.custom.todo.list.app.repository.TaskRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

  @Override
  public List<Task> list() {
    var tasksIterable = this.crudTaskRepository.findAll();
    List<Task> tasks = new ArrayList<>();
    tasksIterable.forEach(task -> tasks.add(task.toModel()));
    return tasks;
  }

  @Override
  public Task update(Long taskId, UpdateTaskRequest request) {
    var taskOpt = this.crudTaskRepository.findById(taskId);
    if (taskOpt.isEmpty()) {
      throw new RuntimeException("Task not found."); // TODO add custom exceptions
    }
    var task = taskOpt.get();
    task.setText(request.getText());
    task.setCompleted(request.getCompleted());

    var registeredTask = this.crudTaskRepository.save(task);
    return registeredTask.toModel();
  }

  @Override
  public void delete(Long taskId) {
    this.crudTaskRepository.deleteById(taskId);
  }
}
