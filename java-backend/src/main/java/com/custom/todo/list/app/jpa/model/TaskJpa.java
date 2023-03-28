package com.custom.todo.list.app.jpa.model;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.model.Task;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task", schema = "todo_list_db")
public class TaskJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  @Column
  private String description;

  public static TaskJpa fromAddRequest(AddTaskRequest request) {
    return TaskJpa.builder()
      .description(request.getDescription())
      .build();
  }

  public Task toModel() {
    return Task.builder()
      .id(this.id)
      .description(this.description)
      .build();
  }
}
