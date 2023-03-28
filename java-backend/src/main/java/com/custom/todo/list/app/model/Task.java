package com.custom.todo.list.app.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Task {
  private Long id;
  private String description;
}
