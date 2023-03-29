package com.custom.todo.list.app.repository;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.dto.UpdateTaskRequest;
import com.custom.todo.list.app.model.Task;
import java.util.List;

public interface TaskRepository {
  Task save(AddTaskRequest request);

  List<Task> list();

  Task update(Long taskId, UpdateTaskRequest request);

  void delete(Long taskId);
}
