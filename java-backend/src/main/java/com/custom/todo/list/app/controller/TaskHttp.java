package com.custom.todo.list.app.controller;

import com.custom.todo.list.app.dto.AddTaskRequest;
import com.custom.todo.list.app.service.AddTaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(path = "/v1.0/api/task")
public class TaskHttp {

  private final AddTaskService addTaskService;

  public TaskHttp(AddTaskService addTaskService) {
    this.addTaskService = addTaskService;
  }

  @PostMapping(
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE
  )
  public ResponseEntity<Object> add(@RequestBody AddTaskRequest request) {
    var task = this.addTaskService.execute(request);
    return new ResponseEntity<>(task, HttpStatus.OK);
  }

}
