package com.custom.todo.list.app.repository;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.model.Task;

public interface TaskRepository {
  Task save(AddTaskRequest request);
}
