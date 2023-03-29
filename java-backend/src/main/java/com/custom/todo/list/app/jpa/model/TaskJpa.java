package com.custom.todo.list.app.jpa.model;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.model.Task;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "todos", schema = "public")
public class TaskJpa {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_local_seq")
  @SequenceGenerator(name = "task_local_seq", sequenceName = "todos_id_seq", allocationSize = 1)
  private Integer id;
  @Column(name = "text")
  private String text;
  @Column(name = "completed")
  private boolean completed;

  public static TaskJpa fromAddRequest(AddTaskRequest request) {
    return TaskJpa.builder()
      .text(request.getText())
      .completed(false)
      .build();
  }

  public Task toModel() {
    return Task.builder()
      .id(this.id)
      .text(this.text)
      .completed(this.completed)
      .build();
  }

  public static List<Task> toListModel(List<TaskJpa> tasks) {
    return tasks.stream().map(TaskJpa::toModel).toList();
  }
}
