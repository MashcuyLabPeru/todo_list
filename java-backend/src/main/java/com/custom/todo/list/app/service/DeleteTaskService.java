package com.custom.todo.list.app.service;

import com.custom.todo.list.app.repository.TaskRepository;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeleteTaskService {
  private final TaskRepository repository;

  public DeleteTaskService(TaskRepository repository) {
    this.repository = repository;
  }

  public void execute(Long taskId) {
    try {
      this.repository.delete(taskId);
    } catch (Exception exception) {
      log.error(Arrays.toString(exception.getStackTrace()));
      throw new RuntimeException("Task cannot be deleted.");
    }
  }
}
