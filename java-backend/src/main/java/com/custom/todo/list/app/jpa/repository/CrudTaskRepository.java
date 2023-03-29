package com.custom.todo.list.app.jpa.repository;

import com.custom.todo.list.app.jpa.model.TaskJpa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudTaskRepository extends CrudRepository<TaskJpa, Long> {
}
