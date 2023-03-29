package com.custom.todo.list.app.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Task {
  private Integer id;
  private String text;
  private boolean completed;
}
