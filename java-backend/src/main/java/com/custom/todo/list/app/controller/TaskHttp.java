package com.custom.todo.list.app.controller;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.dto.UpdateTaskRequest;
import com.custom.todo.list.app.service.AddTaskService;
import com.custom.todo.list.app.service.DeleteTaskService;
import com.custom.todo.list.app.service.ListTasksService;
import com.custom.todo.list.app.service.UpdateTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(path = "/v1.0/api/todo")
public class TaskHttp {

  private final AddTaskService addTaskService;
  private final ListTasksService listTasksService;
  private final UpdateTaskService updateTaskService;
  private final DeleteTaskService deleteTaskService;

  public TaskHttp(AddTaskService addTaskService, ListTasksService listTasksService, UpdateTaskService updateTaskService, DeleteTaskService deleteTaskService) {
    this.addTaskService = addTaskService;
    this.listTasksService = listTasksService;
    this.updateTaskService = updateTaskService;
    this.deleteTaskService = deleteTaskService;
  }

  @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> add(@RequestBody AddTaskRequest request) {
    var task = this.addTaskService.execute(request);
    return new ResponseEntity<>(task, HttpStatus.OK);
  }

  @GetMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> list() {
    var tasks = this.listTasksService.execute();
    return new ResponseEntity<>(tasks, HttpStatus.OK);
  }

  @PutMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> update(@RequestParam Long id, @RequestBody UpdateTaskRequest request) {
    var updatedTask = this.updateTaskService.execute(id, request);
    return new ResponseEntity<>(updatedTask, HttpStatus.OK);
  }

  @DeleteMapping(
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> delete(@RequestParam Long id) {
    this.deleteTaskService.execute(id);
    return ResponseEntity.ok("Task deleted successfully");
  }
}
