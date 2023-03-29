package com.custom.todo.list.app.service;

import com.custom.todo.list.app.model.Task;
import com.custom.todo.list.app.repository.TaskRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ListTasksService {

  private final TaskRepository taskRepository;

  public ListTasksService(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  public List<Task> execute() {
    return this.taskRepository.list();
  }
}
