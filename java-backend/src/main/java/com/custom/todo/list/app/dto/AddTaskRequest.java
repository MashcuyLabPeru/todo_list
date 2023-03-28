package com.custom.todo.list.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AddTaskRequest {
  @NotBlank(message = "Task description cannot be empty.")
  private String description;
}
