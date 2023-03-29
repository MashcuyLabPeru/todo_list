package com.custom.todo.list.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateTaskRequest {
  @NotBlank(message = "Task description cannot be empty.")
  private String text;
  @NotNull(message = "Task status cannot be empty.")
  private Boolean completed;
}
