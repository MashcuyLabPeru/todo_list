package com.custom.todo.list.app.jpa.repository;

import com.custom.todo.list.app.jpa.model.TaskJpa;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudTaskRepository extends CrudRepository<TaskJpa, Long> {
  Optional<List<TaskJpa>> findAllByCompleted(boolean completed);
}
